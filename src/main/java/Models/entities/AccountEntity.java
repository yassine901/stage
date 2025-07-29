package Models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entité Account - Représente un compte bancaire
 */
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @Column(name = "account_number", length = 15)
    private String accountNumber;

    @Column(name = "account_status", length = 10)
    private String accountStatus;

    @Column(name = "is_debits_blocked", length = 1)
    private String isDebitsBlocked;

    @Column(name = "available_balance")
    private Long availableBalance; // En centimes

    @Column(name = "real_balance")
    private Long realBalance;

    @Column(name = "ledger_balance")
    private Long ledgerBalance;

    @Column(name = "facilities")
    private Long facilities;

    @Column(name = "holds")
    private Long holds;

    @Column(name = "customer_id", length = 8)
    private String customerId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public AccountEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public AccountEntity(String accountNumber, String accountStatus, String isDebitsBlocked,
                         Long availableBalance, Long realBalance, Long ledgerBalance,
                         Long facilities, Long holds, String customerId) {
        this();
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.isDebitsBlocked = isDebitsBlocked;
        this.availableBalance = availableBalance;
        this.realBalance = realBalance;
        this.ledgerBalance = ledgerBalance;
        this.facilities = facilities;
        this.holds = holds;
        this.customerId = customerId;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountStatus() { return accountStatus; }
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
        this.updatedAt = LocalDateTime.now();
    }

    public String getIsDebitsBlocked() { return isDebitsBlocked; }
    public void setIsDebitsBlocked(String isDebitsBlocked) {
        this.isDebitsBlocked = isDebitsBlocked;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getAvailableBalance() { return availableBalance; }
    public void setAvailableBalance(Long availableBalance) {
        this.availableBalance = availableBalance;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getRealBalance() { return realBalance; }
    public void setRealBalance(Long realBalance) {
        this.realBalance = realBalance;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getLedgerBalance() { return ledgerBalance; }
    public void setLedgerBalance(Long ledgerBalance) { this.ledgerBalance = ledgerBalance; }

    public Long getFacilities() { return facilities; }
    public void setFacilities(Long facilities) { this.facilities = facilities; }

    public Long getHolds() { return holds; }
    public void setHolds(Long holds) { this.holds = holds; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", availableBalance=" + availableBalance +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}