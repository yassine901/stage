package Models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "operation_reference", length = 50, unique = true)
    private String operationReference;

    @Column(name = "account_number", length = 15)
    private String accountNumber;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "rule_code", length = 10)
    private String ruleCode;

    @Column(name = "operation_type", length = 10)
    private String operationType;

    @Column(name = "sens", length = 1)
    private String sens;

    @Column(name = "opv_reference", length = 50)
    private String opvReference;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "operation_lib", length = 100)
    private String operationLib;

    @Column(name = "lib_court", length = 20)
    private String libCourt;

    @Column(name = "error_message", length = 500)
    private String errorMessage;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ReservationEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public ReservationEntity(String operationReference, String accountNumber, Long amount,
                             String ruleCode, String operationType, String sens, String opvReference) {
        this();
        this.operationReference = operationReference;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.ruleCode = ruleCode;
        this.operationType = operationType;
        this.sens = sens;
        this.opvReference = opvReference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationReference() {
        return operationReference;
    }

    public void setOperationReference(String operationReference) {
        this.operationReference = operationReference;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }

    public String getOpvReference() {
        return opvReference;
    }

    public void setOpvReference(String opvReference) {
        this.opvReference = opvReference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public String getOperationLib() {
        return operationLib;
    }

    public void setOperationLib(String operationLib) {
        this.operationLib = operationLib;
    }

    public String getLibCourt() {
        return libCourt;
    }

    public void setLibCourt(String libCourt) {
        this.libCourt = libCourt;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}