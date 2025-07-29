package Models;

/**
 * Résultat d'opération de réservation
 */
public class ReservationResult {
    private boolean success;
    private long newAvailableBalance;
    private String message;

    public ReservationResult(boolean success, long newAvailableBalance, String message) {
        this.success = success;
        this.newAvailableBalance = newAvailableBalance;
        this.message = message;
    }

    // Getters
    public boolean isSuccess() { return success; }
    public long getNewAvailableBalance() { return newAvailableBalance; }
    public String getMessage() { return message; }
}
