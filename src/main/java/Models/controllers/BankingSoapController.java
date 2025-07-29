package Models.controllers;

import Models.entities.ReservationEntity;
import Models.entities.SystemUsers;
import Models.services.OPVTransactionService;
import Models.entities.AccountEntity;
import Models.repositories.AccountRepository;
import Models.repositories.SystemUserRepository;
import Models.services.SignatureService;
import Models.services.ValidationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import Models.repositories.ReservationRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/position/v2")
@CrossOrigin(origins = "*")
public class BankingSoapController {

    @Autowired
    private OPVTransactionService opvTransactionService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ValidationService validationService;


    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * POST /position/v2/transactionProcessor
     */
    @PostMapping(value = "/transactionProcessor",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> processTransaction(@RequestBody String soapRequest) {

        try {
            System.out.println(" Réception requête SOAP bancaire:");
            System.out.println(soapRequest);

            SoapRequestAnalysis analysis = analyzeSoapRequest(soapRequest);

            if (analysis == null) {
                return ResponseEntity.badRequest().body(buildErrorResponse("Format de requête invalide"));
            }

            if ("operationExecReq".equals(analysis.operationType)) {
                return handleOperationExec(analysis);
            } else if ("queryCustomerAccountReq".equals(analysis.operationType)) {
                return handleAccountQuery(analysis);
            } else {
                return ResponseEntity.badRequest().body(buildErrorResponse("Type d'opération non supporté: " + analysis.operationType));
            }

        } catch (Exception e) {
            System.err.println(" Erreur traitement SOAP: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(buildErrorResponse("Erreur interne: " + e.getMessage()));
        }
    }

    private ResponseEntity<String> handleOperationExec(SoapRequestAnalysis analysis) {

        if (!isValidSignature(analysis)) {
            System.err.println(" Signature invalide pour la requête");
            return ResponseEntity.ok(buildOperationResponse(
                    analysis.canal != null ? analysis.canal : "ERROR",
                    analysis.correlationId != null ? analysis.correlationId : "",
                    1, "99", "Signature requete invalide", "", 0
            ));
        }

        System.out.println(" Signature validée avec succès");

        String canal = analysis.canal;
        String account = extractValue(analysis.requestBody, "account=\"", "\"");
        String operDate = extractValue(analysis.requestBody, "operDate=\"", "\"");
        String valueDate = extractValue(analysis.requestBody, "valueDate=\"", "\"");
        String endDate = extractValue(analysis.requestBody, "endDate=\"", "\"");
        String operRef = extractValue(analysis.requestBody, "operRef=\"", "\"");
        String sens = extractValue(analysis.requestBody, "sens=\"", "\"");
        String operStatus = extractValue(analysis.requestBody, "operStatus=\"", "\"");
        String operLib = extractValue(analysis.requestBody, "operLib=\"", "\"");
        String libCourt = extractValue(analysis.requestBody, "libCourt=\"", "\"");
        String ruleCode = extractValue(analysis.requestBody, "ruleCode=\"", "\"");
        String amountStr = extractValue(analysis.requestBody, "amount=\"", "\"");

        System.out.println("  Paramètres extraits:");
        System.out.println("  - Canal: " + canal);
        System.out.println("  - Account: " + account);
        System.out.println("  - OperRef: " + operRef);
        System.out.println("  - Amount: " + amountStr);
        System.out.println("  - Sens: " + sens);
        System.out.println("  - RuleCode: " + ruleCode);

        ValidationService.ValidationResult validation = validationService.validateOperationRequest(
                canal, account, operDate, valueDate, endDate, operRef, sens, operStatus, operLib, libCourt
        );

        if (!validation.isValid()) {
            System.err.println(" Validation échouée: " + validation.getMessage());
            return ResponseEntity.ok(buildOperationResponse(
                    canal, analysis.correlationId, 1, validation.getErrorCode(), validation.getMessage(), account, 0
            ));
        }

        System.out.println(" Validation des paramètres réussie");

        ValidationService.ValidationResult typeValidation = validationService.validateSpecificOperationType(ruleCode, sens);
        if (!typeValidation.isValid()) {
            System.err.println(" Validation type opération échouée: " + typeValidation.getMessage());
            return ResponseEntity.ok(buildOperationResponse(
                    canal, analysis.correlationId, 1, typeValidation.getErrorCode(), typeValidation.getMessage(), account, 0
            ));
        }

        ValidationService.ValidationResult timingValidation = validationService.validateOperationTiming(operDate);
        if (!timingValidation.isValid()) {
            System.err.println(" Opération tardive détectée");
            return ResponseEntity.ok(buildOperationResponse(
                    canal, analysis.correlationId, 1, timingValidation.getErrorCode(), timingValidation.getMessage(), account, 0
            ));
        }

        Optional<AccountEntity> accountOpt = accountRepository.findByAccountNumber(account);
        if (!accountOpt.isPresent()) {
            System.err.println(" Compte inexistant: " + account);
            return ResponseEntity.ok(buildOperationResponse(
                    canal, analysis.correlationId, 1, "23", "Compte inexistant", account, 0
            ));
        }

        System.out.println(" Compte existe: " + account);



        if ("RESER".equals(ruleCode)) {
            if (isOperationReferenceExists(operRef)) {
                System.err.println(" Référence de réservation déjà existante: " + operRef);
                return ResponseEntity.ok(buildOperationResponse(
                        canal, analysis.correlationId, 1, "16", "Reference operation déjà existante", account, 0
                ));
            }
            System.out.println(" Référence de réservation disponible: " + operRef);

        } else if ("OPCAN".equals(ruleCode)) {
            if (!isOperationReferenceExists(operRef)) {
                System.err.println(" Référence d'annulation introuvable: " + operRef);
                return ResponseEntity.ok(buildOperationResponse(
                        canal, analysis.correlationId, 1, "17", "Reference operation introuvable pour annulation", account, 0
                ));
            }

            if (!isReservationActive(operRef)) {
                System.err.println(" Référence non active ou déjà annulée: " + operRef);
                return ResponseEntity.ok(buildOperationResponse(
                        canal, analysis.correlationId, 1, "18", "Reference operation non active ou déjà annulée", account, 0
                ));
            }
            System.out.println(" Référence d'annulation trouvée et active: " + operRef);
        }
        try {
            long amountInCentimes = Long.parseLong(amountStr);
            String amountInDH = String.valueOf(amountInCentimes / 100.0);

            String result;
            if ("RESER".equals(ruleCode)) {
                result = opvTransactionService.checkAndReserveFunds(account, amountInDH, operRef, "OPV_SIMULATION");
            } else if ("OPCAN".equals(ruleCode)) {
                result = opvTransactionService.cancelReservation(account, operRef);
            } else {
                System.err.println(" Code de règle non supporté: " + ruleCode);
                return ResponseEntity.ok(buildOperationResponse(canal, analysis.correlationId, 1, "06", "Code de règle non supporté: " + ruleCode, account, 0));
            }

            if ("SUCCESS".equals(result)) {
                long newBalance = getCurrentBalance(account);
                System.out.println(" Opération réussie - Nouveau solde: " + newBalance);
                return ResponseEntity.ok(buildOperationResponse(canal, analysis.correlationId, 0, "00", "Successful " + (ruleCode.equals("RESER") ? "reservation" : "cancellation"), account, newBalance));
            } else {
                System.err.println(" Erreur métier: " + result);
                return ResponseEntity.ok(buildOperationResponse(canal, analysis.correlationId, 1, "01", result, account, 0));
            }

        } catch (NumberFormatException e) {
            System.err.println(" Montant invalide: " + amountStr);
            return ResponseEntity.ok(buildOperationResponse(canal, analysis.correlationId, 1, "06", "Montant invalide: " + amountStr, account, 0));
        } catch (Exception e) {
            System.err.println(" Erreur base de données: " + e.getMessage());
            return ResponseEntity.ok(buildOperationResponse(canal, analysis.correlationId, 1, "97", "Erreur base de données", account, 0));
        }
    }


    private boolean isReservationActive(String operRef) {
        try {
            Optional<ReservationEntity> reservation = reservationRepository.findByOperationReference(operRef);
            return reservation.isPresent() && !"CANCELLED".equals(reservation.get().getStatus());
        } catch (Exception e) {
            System.err.println("Erreur vérification statut réservation: " + e.getMessage());
            return false;
        }
    }

    /**
     * Vérification de l'existence d'une référence d'opération
     */
    private boolean isOperationReferenceExists(String operRef) {
        try {
            return reservationRepository.existsByOperationReference(operRef);
        } catch (Exception e) {
            System.err.println("Erreur vérification référence: " + e.getMessage());
            return false;
        }
    }

    /**
     * Traitement des consultations de compte
     */
    private ResponseEntity<String> handleAccountQuery(SoapRequestAnalysis analysis) {
        String account = extractValue(analysis.requestBody, "account=\"", "\"");

        Optional<AccountEntity> accountOpt = accountRepository.findByAccountNumber(account);
        if (accountOpt.isPresent()) {
            AccountEntity accountEntity = accountOpt.get();
            return ResponseEntity.ok(buildAccountQueryResponse(analysis.canal, analysis.correlationId, accountEntity));
        } else {
            return ResponseEntity.ok(buildAccountQueryErrorResponse(analysis.canal, analysis.correlationId, "Compte introuvable: " + account));
        }
    }


    /**
     * Récupération du solde actuel
     */
    private long getCurrentBalance(String accountNumber) {
        Optional<AccountEntity> accountOpt = accountRepository.findByAccountNumber(accountNumber);
        return accountOpt.map(AccountEntity::getAvailableBalance).orElse(0L);
    }

    /**
     * Construction de la réponse d'opération (format bancaire exact)
     */
    private String buildOperationResponse(String canal, String correlationId, int returnCode, String errorCode, String message, String account, long newBalance) {
        return String.format("""
            <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            <operationExecResp xmlns="urn:schemas-attijariwafa-com:transaction-data">
                <RespHeader canal="%s" correlationId="%s">
                    <ReturnCode>%d</ReturnCode>
                    <ErrorCode>%s</ErrorCode>
                    <ReturnMessage>%s</ReturnMessage>
                </RespHeader>
                <OperExeResp>
                    <Account>%s</Account>
                    <NewAvailBal>%d</NewAvailBal>
                </OperExeResp>
            </operationExecResp>
            """, canal, correlationId, returnCode, errorCode, message, account, newBalance);
    }

    /**
     * Construction de la réponse de consultation de compte
     */
    private String buildAccountQueryResponse(String canal, String correlationId, AccountEntity account) {
        return String.format("""
            <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            <queryCustomerAccountResp xmlns="urn:schemas-attijariwafa-com:transaction-data">
                <RespHeader canal="%s" correlationId="%s">
                    <ReturnCode>0</ReturnCode>
                    <ErrorCode>00</ErrorCode>
                    <ReturnMessage>Consultation successful</ReturnMessage>
                </RespHeader>
                <QueryCustAcctResp>
                    <Account acctStatus="%s" isDebitsBlocked="%s" availBal="%d" realBal="%d" ledgerBal="%d" facilities="%d" holds="%d"/>
                    <Customer idtfcl="%s" titre="M" designation="Client Simulation" categorie="P" marche="RET"/>
                </QueryCustAcctResp>
            </queryCustomerAccountResp>
            """, canal, correlationId, account.getAccountStatus(), account.getIsDebitsBlocked(),
                account.getAvailableBalance(), account.getRealBalance(), account.getLedgerBalance(),
                account.getFacilities(), account.getHolds(), account.getCustomerId());
    }

    /**
     * Réponse d'erreur pour consultation de compte
     */
    private String buildAccountQueryErrorResponse(String canal, String correlationId, String errorMessage) {
        return String.format("""
            <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            <queryCustomerAccountResp xmlns="urn:schemas-attijariwafa-com:transaction-data">
                <RespHeader canal="%s" correlationId="%s">
                    <ReturnCode>1</ReturnCode>
                    <ErrorCode>01</ErrorCode>
                    <ReturnMessage>%s</ReturnMessage>
                </RespHeader>
            </queryCustomerAccountResp>
            """, canal, correlationId, errorMessage);
    }

    /**
     * Réponse d'erreur générique
     */
    private String buildErrorResponse(String errorMessage) {
        return String.format("""
            <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            <errorResp xmlns="urn:schemas-attijariwafa-com:transaction-data">
                <RespHeader canal="ERROR" correlationId="">
                    <ReturnCode>99</ReturnCode>
                    <ErrorCode>99</ErrorCode>
                    <ReturnMessage>%s</ReturnMessage>
                </RespHeader>
            </errorResp>
            """, errorMessage);
    }

    /**
     * Analyse de la requête SOAP
     */
    private SoapRequestAnalysis analyzeSoapRequest(String soapRequest) {
        try {
            SoapRequestAnalysis analysis = new SoapRequestAnalysis();
            analysis.requestBody = soapRequest;

            if (soapRequest.contains("operationExecReq")) {
                analysis.operationType = "operationExecReq";
            } else if (soapRequest.contains("queryCustomerAccountReq")) {
                analysis.operationType = "queryCustomerAccountReq";
            } else {
                return null;
            }

            analysis.canal = extractValue(soapRequest, "canal=\"", "\"");
            analysis.user = extractValue(soapRequest, "user=\"", "\"");
            analysis.password = extractValue(soapRequest, "password=\"", "\"");
            analysis.signature = extractValue(soapRequest, "signature=\"", "\"");
            analysis.correlationId = extractValue(soapRequest, "correlationId=\"", "\"");
            analysis.ts = extractValue(soapRequest, "ts=\"", "\"");

            return analysis;
        } catch (Exception e) {
            System.err.println("Erreur analyse requête SOAP: " + e.getMessage());
            return null;
        }
    }

    /**
     * Extraction de valeur XML
     */
    private String extractValue(String xml, String startPattern, String endPattern) {
        try {
            int start = xml.indexOf(startPattern);
            if (start == -1) return "";
            start += startPattern.length();
            int end = xml.indexOf(endPattern, start);
            if (end == -1) return "";
            return xml.substring(start, end);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Classe pour l'analyse des requêtes SOAP
     */
    private static class SoapRequestAnalysis {
        String operationType;
        String requestBody;
        String canal;
        String user;
        String password;
        String signature;
        String correlationId;
        String ts;
    }

    /**
     * Endpoint d'information pour les tests
     */
    @GetMapping("/info")
    public ResponseEntity<String> getInfo() {
        return ResponseEntity.ok("""
               Simulateur Position Minute - Attijariwafa Bank
            
               Endpoint SOAP: POST /position/v2/transactionProcessor
               Utilisateurs: opvuser, attiwmbjuser, testuser
               Opérations supportées:
               - RESER (Réservation de fonds)
               - OPCAN (Annulation de réservation)
               - Consultation de comptes
            
               Test avec Postman:
               URL: http://localhost:8080/position/v2/transactionProcessor
               Method: POST
               Headers: Content-Type: application/xml
               Body: Raw XML (voir exemples)
            """);
    }

    @Autowired
    private SignatureService signatureService;
    /**
     * Validation de signature selon spécification projet
     */
    private boolean isValidSignature(SoapRequestAnalysis analysis) {
        try {
            if (!isValidPassword(analysis)) {
                System.err.println(" TRANSACTION BLOQUÉE - Authentification échouée");
                return false;
            }

            System.out.println(" Authentification réussie - Vérification signature...");

            String account = extractValue(analysis.requestBody, "account=\"", "\"");

            boolean isValid = signatureService.validateSignature(
                    analysis.signature,
                    analysis.canal,
                    analysis.user,
                    analysis.ts,
                    account
            );

            if (isValid) {
                System.out.println(" Signature validée - Transaction autorisée");
            } else {
                System.err.println(" Signature cryptographique invalide");
            }

            return isValid;

        } catch (Exception e) {
            System.err.println(" Erreur validation signature: " + e.getMessage());
            return false;
        }
    }


    private boolean isValidPassword(SoapRequestAnalysis analysis) {
        try {
            System.out.println(" Validation password pour utilisateur: " + analysis.user);

            Optional<SystemUsers> userOpt = systemUserRepository.findByUserId(analysis.user);

            if (!userOpt.isPresent()) {
                System.err.println(" BLOCAGE SILENCIEUX - Utilisateur inexistant: " + analysis.user);
                return false;
            }

            SystemUsers user = userOpt.get();
            System.out.println(" Utilisateur trouvé: " + analysis.user);

            if (!"ACTIVE".equals(user.getStatus())) {
                System.err.println(" BLOCAGE SILENCIEUX - Utilisateur inactif: " + analysis.user + " (statut: " + user.getStatus() + ")");
                return false;
            }

            if (user.getFailedAttempts() != null && user.getFailedAttempts() >= 3) {
                System.err.println(" BLOCAGE SILENCIEUX - Trop de tentatives: " + analysis.user + " (" + user.getFailedAttempts() + " tentatives)");
                return false;
            }

            boolean passwordValid = user.getPassword().equals(analysis.password);

            if (!passwordValid) {
                System.err.println("   BLOCAGE SILENCIEUX - Mot de passe incorrect !");
                System.err.println("   Utilisateur: " + analysis.user);
                System.err.println("   Password reçu: '" + analysis.password + "'");
                System.err.println("   Password attendu: '" + user.getPassword() + "'");

                try {
                    systemUserRepository.incrementFailedAttempts(analysis.user);
                    System.err.println("   Tentatives échouées incrémentées: " + (user.getFailedAttempts() + 1));
                } catch (Exception e) {
                    System.err.println("   Erreur incrémentation tentatives: " + e.getMessage());
                }

                return false;
            }

            System.out.println(" Password correct pour: " + analysis.user);
            try {
                systemUserRepository.resetFailedAttemptsAndUpdateLogin(analysis.user, LocalDateTime.now());
                System.out.println(" Tentatives échouées réinitialisées et login mis à jour");
            } catch (Exception e) {
                System.err.println("Erreur réinitialisation tentatives: " + e.getMessage());
            }

            return true;

        } catch (Exception e) {
            System.err.println(" BLOCAGE SILENCIEUX - Erreur validation password: " + e.getMessage());
            return false;
        }
    }

    /**
     * ENDPOINT pour générer des signatures de test (selon spécification)
     */
    @GetMapping("/generate-test-signature")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Map<String, Object>> generateTestSignature(
                                                                      @RequestParam String canal,
                                                                      @RequestParam String user,
                                                                      @RequestParam String timestamp,
                                                                      @RequestParam String account) {

        try {
            String signature = signatureService.generateOperationSignature(
                    canal, user, timestamp, account);

            Map<String, Object> response = new HashMap<>();
            response.put("signature", signature);
            response.put("status", "success");
            response.put("timestamp", timestamp);
            response.put("canal", canal);
            response.put("user", user);
            response.put("account", account);

            response.put("debug", String.format("SHA1(%s+%s+%s+%s+[certificat])",
                    canal, user, timestamp, account));

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            errorResponse.put("status", "error");

            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    /**
     * Endpoint de validation de signature
     */
    @PostMapping("/validate-signature")
    public ResponseEntity<String> validateSignature(@RequestBody String testData) {

        return ResponseEntity.ok("Validation disponible via le flux principal");
    }

    @PostMapping(value = "/balanceInquiry", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> balanceInquiry(@RequestBody String soapRequest) {
        // Simple XML parsing to extract account number (for demonstration)
        String account = extractValue(soapRequest, "<AccountData account=\"", "\"");
        String balance = "100000"; // Dummy balance
        String response =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<soap:Body>" +
                "<balanceInquiryRes xmlns=\"urn:schemas-attijariwafa-com:balance-data\">" +
                "<ResHeader returnCode=\"0\" errorCode=\"00\" message=\"SUCCESS\"/>" +
                "<BalanceRes>" +
                "<AccountData account=\"" + account + "\" balance=\"" + balance + "\"/>" +
                "</BalanceRes>" +
                "</balanceInquiryRes>" +
                "</soap:Body>" +
                "</soap:Envelope>";
        return ResponseEntity.ok(response);
    }
}