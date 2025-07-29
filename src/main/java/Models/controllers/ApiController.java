package Models.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Models.services.SignatureService;
import java.util.HashMap;
import java.util.Map;

/**
 * API REST pour les appels AJAX de l'interface
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    @Autowired
    private SignatureService signatureService;

    /**
     * Génération de signature via AJAX
     */
    @PostMapping("/generate-signature")
    public ResponseEntity<Map<String, Object>> generateSignature(
            @RequestParam String canal,
            @RequestParam String user,
            @RequestParam String timestamp,
            @RequestParam String account) {

        Map<String, Object> response = new HashMap<>();

        try {
            String signature = signatureService.generateOperationSignature(canal, user, timestamp, account);

            response.put("success", true);
            response.put("signature", signature);
            response.put("message", "Signature générée avec succès");
            response.put("algorithm", "SHA1(canal + user + timestamp + account + certificat)");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "Erreur lors de la génération");

            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * Validation des paramètres
     */
    @PostMapping("/validate-params")
    public ResponseEntity<Map<String, Object>> validateParams(
            @RequestParam String account,
            @RequestParam String amount,
            @RequestParam String user) {

        Map<String, Object> response = new HashMap<>();
        boolean isValid = true;

        // Validation account (15 chiffres)
        if (!account.matches("\\d{15}")) {
            response.put("accountError", "Le compte doit contenir exactement 15 chiffres");
            isValid = false;
        }

        // Validation amount (positif)
        try {
            long amountValue = Long.parseLong(amount);
            if (amountValue <= 0) {
                response.put("amountError", "Le montant doit être positif");
                isValid = false;
            }
        } catch (NumberFormatException e) {
            response.put("amountError", "Le montant doit être numérique");
            isValid = false;
        }

        // Validation user (non vide)
        if (user == null || user.trim().isEmpty()) {
            response.put("userError", "L'utilisateur est requis");
            isValid = false;
        }

        response.put("valid", isValid);
        response.put("message", isValid ? "Paramètres valides" : "Erreurs de validation");

        return ResponseEntity.ok(response);
    }

    /**
     * Informations système
     */
    @GetMapping("/system-info")
    public ResponseEntity<Map<String, Object>> getSystemInfo() {
        Map<String, Object> info = new HashMap<>();

        info.put("serverTime", System.currentTimeMillis());
        info.put("version", "2.0.0");
        info.put("environment", "DEVELOPMENT");
        info.put("endpoints", Map.of(
                "transaction", "/position/v2/transactionProcessor",
                "signature", "/position/v2/generate-test-signature",
                "info", "/position/v2/info"
        ));

        return ResponseEntity.ok(info);
    }
}