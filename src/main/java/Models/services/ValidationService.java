package Models.services;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Service de validation complète selon spécifications bancaires
 */
@Service
public class ValidationService {

    private static final List<String> SUPPORTED_CANALS = Arrays.asList("OPMS", "RIPPL", "WEB", "TEST");

    private static final List<String> SUPPORTED_STATUS = Arrays.asList("OCI", "VAL", "ANN");

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{8}$");

    private static final Pattern ACCOUNT_PATTERN = Pattern.compile("^\\d{15}$");

    /**
     * Validation complète d'une requête d'opération
     */
    public ValidationResult validateOperationRequest(String canal, String account, String operDate,
                                                     String valueDate, String endDate, String operRef,
                                                     String sens, String operStatus, String operLib,
                                                     String libCourt) {

        ValidationResult canalValidation = validateCanal(canal);
        if (!canalValidation.isValid()) {
            return canalValidation;
        }

        ValidationResult accountValidation = validateAccount(account);
        if (!accountValidation.isValid()) {
            return accountValidation;
        }

        ValidationResult datesValidation = validateDates(operDate, valueDate, endDate);
        if (!datesValidation.isValid()) {
            return datesValidation;
        }

        ValidationResult operRefValidation = validateOperationReference(operRef);
        if (!operRefValidation.isValid()) {
            return operRefValidation;
        }

        ValidationResult sensValidation = validateSens(sens);
        if (!sensValidation.isValid()) {
            return sensValidation;
        }

        ValidationResult statusValidation = validateOperationStatus(operStatus);
        if (!statusValidation.isValid()) {
            return statusValidation;
        }

        ValidationResult libellesValidation = validateLibelles(operLib, libCourt);
        if (!libellesValidation.isValid()) {
            return libellesValidation;
        }

        return ValidationResult.success();
    }

    /**
     * Validation du canal
     */
    private ValidationResult validateCanal(String canal) {
        if (isEmpty(canal)) {
            return ValidationResult.error("05", "Le code canal n'est pas renseigne");
        }

        if (!SUPPORTED_CANALS.contains(canal)) {
            return ValidationResult.error("06", "Le canal specifie n est pas supporté");
        }

        return ValidationResult.success();
    }

    /**
     * Validation du compte
     */
    private ValidationResult validateAccount(String account) {
        if (isEmpty(account)) {
            return ValidationResult.error("05", "Compte non renseigné");
        }

        String cleanAccount = account.replaceAll("[^0-9]", "");

        if (cleanAccount.length() != 15) {
            return ValidationResult.error("06", "Le compte doit contenir exactement 15 chiffres");
        }

        return ValidationResult.success();
    }

    /**
     * Validation des dates
     */
    private ValidationResult validateDates(String operDate, String valueDate, String endDate) {
        if (isEmpty(operDate)) {
            return ValidationResult.error("05", "Date operation non renseignee");
        }
        if (!isValidDateFormat(operDate)) {
            return ValidationResult.error("06", "Date operation doit etre au format YYYYMMDD");
        }

        if (isEmpty(valueDate)) {
            return ValidationResult.error("05", "Date valeur non renseignee");
        }
        if (!isValidDateFormat(valueDate)) {
            return ValidationResult.error("06", "Date valeur doit etre au format YYYYMMDD");
        }

        if (isEmpty(endDate)) {
            return ValidationResult.error("05", "Date fin non renseignee");
        }
        if (!isValidDateFormat(endDate)) {
            return ValidationResult.error("06", "Date fin doit etre au format YYYYMMDD");
        }

        return ValidationResult.success();
    }

    /**
     * Validation de la référence d'opération
     */
    private ValidationResult validateOperationReference(String operRef) {
        if (isEmpty(operRef)) {
            return ValidationResult.error("05", "La reference de l operation n'est pas renseignee");
        }

        if (operRef.length() < 4) {
            return ValidationResult.error("06", "La reference de l operation doit contenir au moins 4 digits");
        }

        return ValidationResult.success();
    }

    /**
     * Validation du sens de l'opération
     */
    private ValidationResult validateSens(String sens) {
        if (isEmpty(sens)) {
            return ValidationResult.error("05", "Le sens de l operation n est pas renseigne");
        }

        if (!"D".equals(sens) && !"C".equals(sens)) {
            return ValidationResult.error("06", "Le sens doit etre D ou C");
        }

        return ValidationResult.success();
    }

    /**
     * Validation du statut de l'opération
     */
    private ValidationResult validateOperationStatus(String operStatus) {
        if (isEmpty(operStatus)) {
            return ValidationResult.error("05", "Le statut de l operation n est pas renseigne");
        }

        if (!SUPPORTED_STATUS.contains(operStatus)) {
            return ValidationResult.error("06", "Le statut fourni n est pas supporte");
        }

        return ValidationResult.success();
    }

    /**
     * Validation des libellés
     */
    private ValidationResult validateLibelles(String operLib, String libCourt) {
        if (isEmpty(operLib)) {
            return ValidationResult.error("05", "Le libelle long n est pas fourni");
        }

        if (isEmpty(libCourt)) {
            return ValidationResult.error("05", "Le libelle court n est pas fourni");
        }

        return ValidationResult.success();
    }

    /**
     * Validation spécifique selon le type d'opération
     */
    public ValidationResult validateSpecificOperationType(String ruleCode, String sens) {
        if ("OBP".equals(ruleCode) && !"D".equals(sens)) {
            return ValidationResult.error("06", "Le sens pour une OBP est D");
        }

        if ("OSD".equals(ruleCode) && !"D".equals(sens)) {
            return ValidationResult.error("06", "Le sens pour une OSD est D");
        }

        return ValidationResult.success();
    }

    /**
     * Validation d'une date tardive
     */
    public ValidationResult validateOperationTiming(String operDate) {
        try {
            if (operDate.length() == 8) {
                int year = Integer.parseInt(operDate.substring(0, 4));
                int month = Integer.parseInt(operDate.substring(4, 6));
                int day = Integer.parseInt(operDate.substring(6, 8));

                if (year < 2024) {
                    return ValidationResult.error("18", "Operation tardive");
                }
            }
        } catch (NumberFormatException e) {
        }

        return ValidationResult.success();
    }


    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isValidDateFormat(String date) {
        if (date == null || date.length() != 8) {
            return false;
        }

        if (!DATE_PATTERN.matcher(date).matches()) {
            return false;
        }

        try {
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));

            return year >= 1900 && year <= 2099
                    && month >= 1 && month <= 12
                    && day >= 1 && day <= 31;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Classe de résultat de validation
     */
    public static class ValidationResult {
        private final boolean valid;
        private final String errorCode;
        private final String message;

        private ValidationResult(boolean valid, String errorCode, String message) {
            this.valid = valid;
            this.errorCode = errorCode;
            this.message = message;
        }

        public static ValidationResult success() {
            return new ValidationResult(true, "00", "Ok");
        }

        public static ValidationResult error(String errorCode, String message) {
            return new ValidationResult(false, errorCode, message);
        }

        public boolean isValid() { return valid; }
        public String getErrorCode() { return errorCode; }
        public String getMessage() { return message; }

        @Override
        public String toString() {
            return String.format("ValidationResult{valid=%s, errorCode='%s', message='%s'}",
                    valid, errorCode, message);
        }
    }
}