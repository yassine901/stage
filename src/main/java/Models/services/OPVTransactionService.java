package Models.services;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import Models.entities.AccountEntity;
import Models.entities.CustomerEntity;
import Models.entities.ReservationEntity;
import Models.repositories.AccountRepository;
import Models.repositories.CustomerRepository;
import Models.repositories.ReservationRepository;

@Service
public class OPVTransactionService {

    private static final Logger logger = LoggerFactory.getLogger(OPVTransactionService.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String SEPARATOR = "+";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Value("${opv.signature.key:defaultkey}")
    private String signatureKey;

    @Value("${opv.canal:WEB}")
    private String canal;

    @Value("${opv.login:opvuser}")
    private String login;

    /**
     * Vérification et réservation de fonds
     */
    public String checkAndReserveFunds(String accountNumber, String amount, String reference, String opvReference) {
        try {
            logger.info(" Vérification fonds - Compte: {}, Montant: {}, Ref: {}", accountNumber, amount, reference);

            Optional<AccountEntity> accountOpt = accountRepository.findByAccountNumber(accountNumber);
            if (!accountOpt.isPresent()) {
                return "Compte introuvable: " + accountNumber;
            }

            AccountEntity account = accountOpt.get();

            if ("Y".equals(account.getIsDebitsBlocked())) {
                return "Compte bloqué en débit";
            }

            Long amountInCentimes = new BigDecimal(amount).multiply(new BigDecimal("100")).longValue();

            Long availableBalance = account.getAvailableBalance();
            if (availableBalance < amountInCentimes) {
                return String.format("Solde insuffisant. Disponible: %.2f DH, Demandé: %.2f DH",
                        availableBalance / 100.0, amountInCentimes / 100.0);
            }

            ReservationEntity reservation = new ReservationEntity();
            reservation.setOperationReference(reference);
            reservation.setAccountNumber(accountNumber);
            reservation.setAmount(amountInCentimes);
            reservation.setRuleCode("RESER");
            reservation.setOperationType("OPV");
            reservation.setSens("D");
            reservation.setOpvReference(opvReference);
            reservation.setStatus("RESERVED");
            reservation.setOperationLib("OPV RESERVATION");
            reservation.setLibCourt("OPVRES");

            reservationRepository.save(reservation);

            account.setAvailableBalance(availableBalance - amountInCentimes);
            accountRepository.save(account);

            logger.info(" Réservation créée avec succès - Ref: {}", reference);
            return "SUCCESS";

        } catch (Exception e) {
            logger.error(" Erreur lors de la réservation: {}", e.getMessage());
            return "Erreur technique: " + e.getMessage();
        }
    }

    /**
     * Annulation de réservation
     */
    public String cancelReservation(String accountNumber, String reference) {
        try {
            logger.info(" Annulation réservation - Compte: {}, Ref: {}", accountNumber, reference);

            Optional<ReservationEntity> reservationOpt = reservationRepository.findByOperationReference(reference);
            if (!reservationOpt.isPresent()) {
                return "Réservation introuvable: " + reference;
            }

            ReservationEntity reservation = reservationOpt.get();

            if (!"RESERVED".equals(reservation.getStatus())) {
                return "Réservation déjà traitée: " + reservation.getStatus();
            }

            Optional<AccountEntity> accountOpt = accountRepository.findByAccountNumber(accountNumber);
            if (!accountOpt.isPresent()) {
                return "Compte introuvable: " + accountNumber;
            }

            AccountEntity account = accountOpt.get();

            Long currentBalance = account.getAvailableBalance();
            Long reservedAmount = reservation.getAmount();
            account.setAvailableBalance(currentBalance + reservedAmount);

            reservation.setStatus("CANCELLED");
            reservation.setUpdatedAt(LocalDateTime.now());

            accountRepository.save(account);
            reservationRepository.save(reservation);

            logger.info(" Réservation annulée avec succès - Ref: {}", reference);
            return "SUCCESS";

        } catch (Exception e) {
            logger.error(" Erreur lors de l'annulation: {}", e.getMessage());
            return "Erreur technique: " + e.getMessage();
        }
    }

    /**
     * Consultation de compte
     */
    public AccountBalanceResult getAccountBalance(String accountNumber) {
        try {
            logger.info(" Consultation compte: {}", accountNumber);

            Optional<AccountEntity> accountOpt = accountRepository.findByAccountNumber(accountNumber);
            if (!accountOpt.isPresent()) {
                return new AccountBalanceResult(false, "Compte introuvable: " + accountNumber, null, null);
            }

            AccountEntity account = accountOpt.get();

            CustomerEntity customer = null;
            if (account.getCustomerId() != null) {
                Optional<CustomerEntity> customerOpt = customerRepository.findByCustomerId(account.getCustomerId());
                customer = customerOpt.orElse(null);
            }

            AccountBalanceResult result = new AccountBalanceResult(true, "Consultation réussie", account, customer);

            logger.info(" Consultation réussie - Compte: {}, Solde: {}", accountNumber, account.getAvailableBalance());
            return result;

        } catch (Exception e) {
            logger.error(" Erreur lors de la consultation: {}", e.getMessage());
            return new AccountBalanceResult(false, "Erreur technique: " + e.getMessage(), null, null);
        }
    }

    /**
     * Génération de signature SHA-1
     */
    public String generateSignature(String data) {
        String timestamp = LocalDateTime.now().format(formatter);
        String dataSeed = canal + SEPARATOR + login + SEPARATOR + timestamp.trim() + SEPARATOR + data;
        String signature = encode(dataSeed + SEPARATOR + signatureKey).toLowerCase();

        logger.debug(" Signature générée pour: {}", data);
        return signature;
    }

    /**
     * Encodage SHA-1
     */
    private static String encode(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = source.getBytes("iso-8859-1");
            md.update(bytes, 0, bytes.length);
            byte[] sha1Hash = md.digest();
            return convertToHex(sha1Hash);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Conversion en hexadécimal
     */
    private static String convertToHex(byte[] sha1Hash) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sha1Hash.length; i++) {
            byte c = sha1Hash[i];
            addHex(builder, (c >> 4) & 0xf);
            addHex(builder, c & 0xf);
        }
        return builder.toString();
    }

    private static void addHex(StringBuilder builder, int c) {
        if (c < 10)
            builder.append((char) (c + '0'));
        else
            builder.append((char) (c + 'a' - 10));
    }

    /**
     * Classe résultat pour les consultations de compte
     */
    public static class AccountBalanceResult {
        private boolean success;
        private String message;
        private AccountEntity account;
        private CustomerEntity customer;

        public AccountBalanceResult(boolean success, String message, AccountEntity account, CustomerEntity customer) {
            this.success = success;
            this.message = message;
            this.account = account;
            this.customer = customer;
        }

        // Getters
        public boolean isSuccess() { return success; }
        public String getMessage() { return message; }
        public AccountEntity getAccount() { return account; }
        public CustomerEntity getCustomer() { return customer; }
    }

    /**
     * Processus de souscription OPV complet
     */
    public String processOPVSubscription(String accountNumber, String subscriptionAmount, String opvReference) {
        String operationReference = "OPV_" + System.currentTimeMillis();

        String reservationResult = checkAndReserveFunds(accountNumber, subscriptionAmount, operationReference, opvReference);

        if (!"SUCCESS".equals(reservationResult)) {
            return "Échec de la réservation: " + reservationResult;
        }

        String signature = generateSignature(accountNumber + SEPARATOR + subscriptionAmount + SEPARATOR + operationReference);

        logger.info(" Souscription OPV traitée - Ref: {}, Signature: {}", operationReference, signature);

        return "Souscription OPV réussie. Référence: " + operationReference;
    }



}