package Models;

public class SubscriptionDetails {
    private String operationReference;
    private long subscriptionAmount;
    private long newAvailableBalance;
    private String clientId;
    private String clientCategory;
    private String market;

    public SubscriptionDetails(String operationReference, long subscriptionAmount, long newAvailableBalance,
                               String clientId, String clientCategory, String market) {
        this.operationReference = operationReference;
        this.subscriptionAmount = subscriptionAmount;
        this.newAvailableBalance = newAvailableBalance;
        this.clientId = clientId;
        this.clientCategory = clientCategory;
        this.market = market;
    }

    public String getOperationReference() { return operationReference; }
    public long getSubscriptionAmount() { return subscriptionAmount; }
    public long getNewAvailableBalance() { return newAvailableBalance; }
    public String getClientId() { return clientId; }
    public String getClientCategory() { return clientCategory; }
    public String getMarket() { return market; }
}