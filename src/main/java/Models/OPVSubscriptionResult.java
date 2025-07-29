package Models;

public class OPVSubscriptionResult {
    private boolean success;
    private String message;
    private SubscriptionDetails details;

    public OPVSubscriptionResult(boolean success, String message, SubscriptionDetails details) {
        this.success = success;
        this.message = message;
        this.details = details;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public SubscriptionDetails getDetails() { return details; }
}