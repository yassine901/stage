package Models.controllers;

import Models.services.OPVTransactionService;
import Models.services.OPVTransactionService.AccountBalanceResult;
import Models.entities.AccountEntity;
import Models.entities.ReservationEntity;
import Models.repositories.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur unifié REST + SOAP pour OPV (style simple)
 */
@RestController
@RequestMapping("/api/opv")
@WebService(
        targetNamespace = "urn:opv-service",
        serviceName = "OPVService",
        portName = "OPVPort"
)
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class OPVSimpleController {

    @Autowired
    private OPVTransactionService opvTransactionService;

    @Autowired
    private ReservationRepository reservationRepository;


    /**
     * Consultation de solde de compte
     */
    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<?> getBalance(@PathVariable String accountNumber) {
        try {
            AccountBalanceResult result = opvTransactionService.getAccountBalance(accountNumber);

            if (result.isSuccess()) {
                AccountEntity account = result.getAccount();
                return ResponseEntity.ok(new BalanceResponse(
                        account.getAccountNumber(),
                        account.getAvailableBalance(),
                        account.getAccountStatus(),
                        result.getCustomer() != null ? result.getCustomer().getDesignation() : "N/A"
                ));
            } else {
                return ResponseEntity.badRequest().body(new ErrorResponse(result.getMessage()));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorResponse("Erreur: " + e.getMessage()));
        }
    }

    /**
     * Réservation de fonds pour OPV
     */
    @PostMapping("/reserve")
    public ResponseEntity<?> reserveFunds(
            @RequestParam String accountNumber,
            @RequestParam String amount,
            @RequestParam String opvReference) {

        try {
            String operationReference = "OPV_" + System.currentTimeMillis();
            String result = opvTransactionService.checkAndReserveFunds(accountNumber, amount, operationReference, opvReference);

            if ("SUCCESS".equals(result)) {
                return ResponseEntity.ok(new ReservationResponse(
                        operationReference,
                        "Réservation créée avec succès",
                        accountNumber,
                        amount,
                        opvReference
                ));
            } else {
                return ResponseEntity.badRequest().body(new ErrorResponse(result));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorResponse("Erreur: " + e.getMessage()));
        }
    }

    /**
     * Annulation de réservation
     */
    @PostMapping("/cancel")
    public ResponseEntity<?> cancelReservation(
            @RequestParam String accountNumber,
            @RequestParam String operationReference) {

        try {
            String result = opvTransactionService.cancelReservation(accountNumber, operationReference);

            if ("SUCCESS".equals(result)) {
                return ResponseEntity.ok(new CancelResponse(
                        operationReference,
                        "Réservation annulée avec succès",
                        accountNumber
                ));
            } else {
                return ResponseEntity.badRequest().body(new ErrorResponse(result));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorResponse("Erreur: " + e.getMessage()));
        }
    }

    /**
     * Souscription OPV complète
     */
    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribeOPV(
            @RequestParam String accountNumber,
            @RequestParam String subscriptionAmount,
            @RequestParam String opvReference) {

        try {
            String result = opvTransactionService.processOPVSubscription(accountNumber, subscriptionAmount, opvReference);

            if (result.startsWith("Souscription OPV réussie")) {
                return ResponseEntity.ok(new SubscriptionResponse(
                        result.split(": ")[1], // Extract reference
                        "Souscription traitée avec succès",
                        accountNumber,
                        subscriptionAmount,
                        opvReference
                ));
            } else {
                return ResponseEntity.badRequest().body(new ErrorResponse(result));
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorResponse("Erreur: " + e.getMessage()));
        }
    }

    /**
     * Liste des réservations pour un compte
     */
    @GetMapping("/reservations/{accountNumber}")
    public ResponseEntity<?> getReservations(@PathVariable String accountNumber) {
        try {
            List<ReservationEntity> reservations = reservationRepository.findByAccountNumber(accountNumber);
            return ResponseEntity.ok(reservations);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorResponse("Erreur: " + e.getMessage()));
        }
    }


    /**
     * SOAP - Consultation de solde
     */
    @WebMethod(operationName = "getAccountBalance")
    public String getAccountBalanceSOAP(
            @WebParam(name = "accountNumber") String accountNumber) {

        AccountBalanceResult result = opvTransactionService.getAccountBalance(accountNumber);

        if (result.isSuccess()) {
            AccountEntity account = result.getAccount();
            return String.format("SUCCESS|%s|%d|%s",
                    account.getAccountNumber(),
                    account.getAvailableBalance(),
                    account.getAccountStatus()
            );
        } else {
            return "ERROR|" + result.getMessage();
        }
    }

    /**
     * SOAP - Réservation de fonds
     */
    @WebMethod(operationName = "reserveFunds")
    public String reserveFundsSOAP(
            @WebParam(name = "accountNumber") String accountNumber,
            @WebParam(name = "amount") String amount,
            @WebParam(name = "opvReference") String opvReference) {

        String operationReference = "SOAP_OPV_" + System.currentTimeMillis();
        String result = opvTransactionService.checkAndReserveFunds(accountNumber, amount, operationReference, opvReference);

        if ("SUCCESS".equals(result)) {
            return "SUCCESS|" + operationReference;
        } else {
            return "ERROR|" + result;
        }
    }

    /**
     * SOAP - Annulation de réservation
     */
    @WebMethod(operationName = "cancelReservation")
    public String cancelReservationSOAP(
            @WebParam(name = "accountNumber") String accountNumber,
            @WebParam(name = "operationReference") String operationReference) {

        String result = opvTransactionService.cancelReservation(accountNumber, operationReference);

        if ("SUCCESS".equals(result)) {
            return "SUCCESS|Réservation annulée";
        } else {
            return "ERROR|" + result;
        }
    }


    @GetMapping("/info")
    public ResponseEntity<?> getServiceInfo() {
        return ResponseEntity.ok(new ServiceInfo(
                " Service OPV Unifié (Style Encadrant)",
                "REST API: /api/opv/*",
                "SOAP WSDL: /api/opv?wsdl",
                "Status: Actif",
                "Version: 1.0 Minimal"
        ));
    }


    public static class BalanceResponse {
        public String accountNumber;
        public Long availableBalance;
        public String accountStatus;
        public String customerName;

        public BalanceResponse(String accountNumber, Long availableBalance, String accountStatus, String customerName) {
            this.accountNumber = accountNumber;
            this.availableBalance = availableBalance;
            this.accountStatus = accountStatus;
            this.customerName = customerName;
        }
    }

    public static class ReservationResponse {
        public String operationReference;
        public String message;
        public String accountNumber;
        public String amount;
        public String opvReference;

        public ReservationResponse(String operationReference, String message, String accountNumber, String amount, String opvReference) {
            this.operationReference = operationReference;
            this.message = message;
            this.accountNumber = accountNumber;
            this.amount = amount;
            this.opvReference = opvReference;
        }
    }

    public static class CancelResponse {
        public String operationReference;
        public String message;
        public String accountNumber;

        public CancelResponse(String operationReference, String message, String accountNumber) {
            this.operationReference = operationReference;
            this.message = message;
            this.accountNumber = accountNumber;
        }
    }

    public static class SubscriptionResponse {
        public String operationReference;
        public String message;
        public String accountNumber;
        public String subscriptionAmount;
        public String opvReference;

        public SubscriptionResponse(String operationReference, String message, String accountNumber, String subscriptionAmount, String opvReference) {
            this.operationReference = operationReference;
            this.message = message;
            this.accountNumber = accountNumber;
            this.subscriptionAmount = subscriptionAmount;
            this.opvReference = opvReference;
        }
    }

    public static class ErrorResponse {
        public String error;
        public String timestamp;

        public ErrorResponse(String error) {
            this.error = error;
            this.timestamp = java.time.LocalDateTime.now().toString();
        }
    }

    public static class ServiceInfo {
        public String description;
        public String restEndpoint;
        public String soapWsdl;
        public String status;
        public String version;

        public ServiceInfo(String description, String restEndpoint, String soapWsdl, String status, String version) {
            this.description = description;
            this.restEndpoint = restEndpoint;
            this.soapWsdl = soapWsdl;
            this.status = status;
            this.version = version;
        }
    }
}