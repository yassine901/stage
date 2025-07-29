package Models.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

/**
 * Format: param1+param2+param3+certificat
 * Algorithme: SHA1
 */
@Service
public class SignatureService {

    private static final String SEPARATOR = "+";

    @Value("${opv.signature.certificat:AZERTYPUI2018AWB}")
    private String certificat;

    /**
     * Génération de signature
     */
    public String generateOperationSignature(String canal, String user, String timestamp,
                                             String account) {
        try {

            String cleanAccount = removeLeadingZeros(account);

            String dataChain = canal + SEPARATOR +
                    user + SEPARATOR +
                    timestamp + SEPARATOR +
                    cleanAccount + SEPARATOR +
                    certificat;

            System.out.println(" Chaîne de signature: " + dataChain);

            String signature = hashSHA1(dataChain);

            System.out.println(" Signature générée: " + signature);

            return signature;

        } catch (Exception e) {
            throw new RuntimeException("Erreur génération signature: " + e.getMessage(), e);
        }
    }

    /**
     * Validation de signature
     */
    public boolean validateSignature(String receivedSignature, String canal, String user,
                                     String timestamp, String account) {
        try {
            String expectedSignature = generateOperationSignature(canal, user, timestamp, account);
            boolean isValid = expectedSignature.equalsIgnoreCase(receivedSignature);

            System.out.println(" Validation signature:");
            System.out.println("  - Attendue: " + expectedSignature);
            System.out.println("  - Reçue: " + receivedSignature);
            System.out.println("  - Valide: " + isValid);

            return isValid;

        } catch (Exception e) {
            System.err.println(" Erreur validation signature: " + e.getMessage());
            return false;
        }
    }

    /**
     * Hachage SHA1
     */
    private String hashSHA1(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = data.getBytes("UTF-8");
            byte[] hash = md.digest(bytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString().toLowerCase();

        } catch (Exception e) {
            throw new RuntimeException("Erreur hachage SHA1", e);
        }
    }

    /**
     * Suppression des zéros à gauche
     */
    private String removeLeadingZeros(String value) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        if (value.matches("^0*\\d+$")) {
            return String.valueOf(Long.parseLong(value));
        }

        return value;
    }

    /**
     * Générateur de signature pour consultation de compte
     */
    public String generateAccountSignature(String canal, String user, String timestamp, String account) {
        try {
            String cleanAccount = removeLeadingZeros(account);

            String dataChain = canal + SEPARATOR +
                    user + SEPARATOR +
                    timestamp + SEPARATOR +
                    cleanAccount + SEPARATOR +
                    certificat;

            return hashSHA1(dataChain);

        } catch (Exception e) {
            throw new RuntimeException("Erreur génération signature compte: " + e.getMessage(), e);
        }
    }

    /**
     * Validation simple pour tests
     */
    public boolean isSignatureFormatValid(String signature) {
        return signature != null && signature.matches("^[a-fA-F0-9]{40}$");
    }
}