package Models;

public class AccountBalanceResult {
    private boolean success;
    private Account account;
    private Customer customer;
    private String message;

    public AccountBalanceResult(boolean success, Account account, Customer customer, String message) {
        this.success = success;
        this.account = account;
        this.customer = customer;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public Account getAccount() { return account; }
    public Customer getCustomer() { return customer; }
    public String getMessage() { return message; }
}