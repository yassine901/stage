
package Models;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sysexterne.reservation_system package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _ReservationReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "reservationReq");
    private static final QName _ReservationResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "reservationResp");
    private static final QName _OperationAdviceReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "operationAdviceReq");
    private static final QName _OperationAdviceResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "operationAdviceResp");
    private static final QName _OperationCancelReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "operationCancelReq");
    private static final QName _OperationCancelResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "operationCancelResp");
    private static final QName _OperationUpdateReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "operationUpdateReq");
    private static final QName _OperationUpdateResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "operationUpdateResp");
    private static final QName _OperationExecReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "operationExecReq");
    private static final QName _OperationExecResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "operationExecResp");
    private static final QName _TransactionExecReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "transactionExecReq");
    private static final QName _TransactionExecResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "transactionExecResp");
    private static final QName _FundsTransferValidateReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "fundsTransferValidateReq");
    private static final QName _FundsTransferValidateResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "fundsTransferValidateResp");
    private static final QName _FundsTransferExecuteReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "fundsTransferExecuteReq");
    private static final QName _FundsTransferExecuteResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "fundsTransferExecuteResp");
    private static final QName _FundsTransferCancelReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "fundsTransferCancelReq");
    private static final QName _FundsTransferCancelResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "fundsTransferCancelResp");
    private static final QName _AccountBalanceReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountBalanceReq");
    private static final QName _AccountBalanceResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountBalanceResp");
    private static final QName _QueryCustomerAccountReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "queryCustomerAccountReq");
    private static final QName _QueryCustomerAccountResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "queryCustomerAccountResp");
    private static final QName _CustomerInfoReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "customerInfoReq");
    private static final QName _CustomerInfoResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "customerInfoResp");
    private static final QName _AccountStatementReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountStatementReq");
    private static final QName _AccountStatementResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountStatementResp");
    private static final QName _CustomerSummaryReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "customerSummaryReq");
    private static final QName _CustomerSummaryResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "customerSummaryResp");
    private static final QName _CustomerAccountsReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "customerAccountsReq");
    private static final QName _CustomerAccountsResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "customerAccountsResp");
    private static final QName _AccountStatusReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountStatusReq");
    private static final QName _AccountStatusResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountStatusResp");
    private static final QName _AccountEventReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountEventReq");
    private static final QName _AccountEventResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountEventResp");
    private static final QName _AccountOpeningReq_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountOpeningReq");
    private static final QName _AccountOpeningResp_QNAME = new QName("urn:schemas-attijariwafa-com:transaction-data", "accountOpeningResp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sysexterne.reservation_system
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountOpeningReq }
     * 
     * @return
     *     the new instance of {@link AccountOpeningReq }
     */
    public AccountOpeningReq createAccountOpeningReq() {
        return new AccountOpeningReq();
    }

    /**
     * Create an instance of {@link AccountEventReq }
     * 
     * @return
     *     the new instance of {@link AccountEventReq }
     */
    public AccountEventReq createAccountEventReq() {
        return new AccountEventReq();
    }

    /**
     * Create an instance of {@link AccountStatusResp }
     * 
     * @return
     *     the new instance of {@link AccountStatusResp }
     */
    public AccountStatusResp createAccountStatusResp() {
        return new AccountStatusResp();
    }

    /**
     * Create an instance of {@link AccountStatusReq }
     * 
     * @return
     *     the new instance of {@link AccountStatusReq }
     */
    public AccountStatusReq createAccountStatusReq() {
        return new AccountStatusReq();
    }

    /**
     * Create an instance of {@link CustomerAccountsResp }
     * 
     * @return
     *     the new instance of {@link CustomerAccountsResp }
     */
    public CustomerAccountsResp createCustomerAccountsResp() {
        return new CustomerAccountsResp();
    }

    /**
     * Create an instance of {@link CustomerAccountsReq }
     * 
     * @return
     *     the new instance of {@link CustomerAccountsReq }
     */
    public CustomerAccountsReq createCustomerAccountsReq() {
        return new CustomerAccountsReq();
    }

    /**
     * Create an instance of {@link CustomerSummaryResp }
     * 
     * @return
     *     the new instance of {@link CustomerSummaryResp }
     */
    public CustomerSummaryResp createCustomerSummaryResp() {
        return new CustomerSummaryResp();
    }

    /**
     * Create an instance of {@link CustomerSummaryReq }
     * 
     * @return
     *     the new instance of {@link CustomerSummaryReq }
     */
    public CustomerSummaryReq createCustomerSummaryReq() {
        return new CustomerSummaryReq();
    }

    /**
     * Create an instance of {@link AccountStatementResp }
     * 
     * @return
     *     the new instance of {@link AccountStatementResp }
     */
    public AccountStatementResp createAccountStatementResp() {
        return new AccountStatementResp();
    }

    /**
     * Create an instance of {@link AccountStatementReq }
     * 
     * @return
     *     the new instance of {@link AccountStatementReq }
     */
    public AccountStatementReq createAccountStatementReq() {
        return new AccountStatementReq();
    }

    /**
     * Create an instance of {@link CustomerInfoReq }
     * 
     * @return
     *     the new instance of {@link CustomerInfoReq }
     */
    public CustomerInfoReq createCustomerInfoReq() {
        return new CustomerInfoReq();
    }

    /**
     * Create an instance of {@link QueryCustomerAccountResp }
     * 
     * @return
     *     the new instance of {@link QueryCustomerAccountResp }
     */
    public QueryCustomerAccountResp createQueryCustomerAccountResp() {
        return new QueryCustomerAccountResp();
    }

    /**
     * Create an instance of {@link QueryCustomerAccountReq }
     * 
     * @return
     *     the new instance of {@link QueryCustomerAccountReq }
     */
    public QueryCustomerAccountReq createQueryCustomerAccountReq() {
        return new QueryCustomerAccountReq();
    }

    /**
     * Create an instance of {@link AccountBalanceResp }
     * 
     * @return
     *     the new instance of {@link AccountBalanceResp }
     */
    public AccountBalanceResp createAccountBalanceResp() {
        return new AccountBalanceResp();
    }

    /**
     * Create an instance of {@link AccountBalanceReq }
     * 
     * @return
     *     the new instance of {@link AccountBalanceReq }
     */
    public AccountBalanceReq createAccountBalanceReq() {
        return new AccountBalanceReq();
    }

    /**
     * Create an instance of {@link FundsTransferCancelReq }
     * 
     * @return
     *     the new instance of {@link FundsTransferCancelReq }
     */
    public FundsTransferCancelReq createFundsTransferCancelReq() {
        return new FundsTransferCancelReq();
    }

    /**
     * Create an instance of {@link FundsTransferExecuteReq }
     * 
     * @return
     *     the new instance of {@link FundsTransferExecuteReq }
     */
    public FundsTransferExecuteReq createFundsTransferExecuteReq() {
        return new FundsTransferExecuteReq();
    }

    /**
     * Create an instance of {@link FundsTransferValidateReq }
     * 
     * @return
     *     the new instance of {@link FundsTransferValidateReq }
     */
    public FundsTransferValidateReq createFundsTransferValidateReq() {
        return new FundsTransferValidateReq();
    }

    /**
     * Create an instance of {@link FundsTransferValidateReq.FtValReq }
     * 
     * @return
     *     the new instance of {@link FundsTransferValidateReq.FtValReq }
     */
    public FundsTransferValidateReq.FtValReq createFundsTransferValidateReqFtValReq() {
        return new FundsTransferValidateReq.FtValReq();
    }

    /**
     * Create an instance of {@link TransactionExecReq }
     * 
     * @return
     *     the new instance of {@link TransactionExecReq }
     */
    public TransactionExecReq createTransactionExecReq() {
        return new TransactionExecReq();
    }

    /**
     * Create an instance of {@link OperationExecReq }
     * 
     * @return
     *     the new instance of {@link OperationExecReq }
     */
    public OperationExecReq createOperationExecReq() {
        return new OperationExecReq();
    }

    /**
     * Create an instance of {@link OperationUpdateReq }
     * 
     * @return
     *     the new instance of {@link OperationUpdateReq }
     */
    public OperationUpdateReq createOperationUpdateReq() {
        return new OperationUpdateReq();
    }

    /**
     * Create an instance of {@link OperationCancelReq }
     * 
     * @return
     *     the new instance of {@link OperationCancelReq }
     */
    public OperationCancelReq createOperationCancelReq() {
        return new OperationCancelReq();
    }

    /**
     * Create an instance of {@link OperationAdviceReq }
     * 
     * @return
     *     the new instance of {@link OperationAdviceReq }
     */
    public OperationAdviceReq createOperationAdviceReq() {
        return new OperationAdviceReq();
    }

    /**
     * Create an instance of {@link ReservationReq }
     * 
     * @return
     *     the new instance of {@link ReservationReq }
     */
    public ReservationReq createReservationReq() {
        return new ReservationReq();
    }

    /**
     * Create an instance of {@link ReservationResp }
     * 
     * @return
     *     the new instance of {@link ReservationResp }
     */
    public ReservationResp createReservationResp() {
        return new ReservationResp();
    }

    /**
     * Create an instance of {@link OperationAdviceResp }
     * 
     * @return
     *     the new instance of {@link OperationAdviceResp }
     */
    public OperationAdviceResp createOperationAdviceResp() {
        return new OperationAdviceResp();
    }

    /**
     * Create an instance of {@link OperationCancelResp }
     * 
     * @return
     *     the new instance of {@link OperationCancelResp }
     */
    public OperationCancelResp createOperationCancelResp() {
        return new OperationCancelResp();
    }

    /**
     * Create an instance of {@link OperationUpdateResp }
     * 
     * @return
     *     the new instance of {@link OperationUpdateResp }
     */
    public OperationUpdateResp createOperationUpdateResp() {
        return new OperationUpdateResp();
    }

    /**
     * Create an instance of {@link OperationExecResp }
     * 
     * @return
     *     the new instance of {@link OperationExecResp }
     */
    public OperationExecResp createOperationExecResp() {
        return new OperationExecResp();
    }

    /**
     * Create an instance of {@link TransactionExecResp }
     * 
     * @return
     *     the new instance of {@link TransactionExecResp }
     */
    public TransactionExecResp createTransactionExecResp() {
        return new TransactionExecResp();
    }

    /**
     * Create an instance of {@link FundsTransferValidateResp }
     * 
     * @return
     *     the new instance of {@link FundsTransferValidateResp }
     */
    public FundsTransferValidateResp createFundsTransferValidateResp() {
        return new FundsTransferValidateResp();
    }

    /**
     * Create an instance of {@link FundsTransferExecuteResp }
     * 
     * @return
     *     the new instance of {@link FundsTransferExecuteResp }
     */
    public FundsTransferExecuteResp createFundsTransferExecuteResp() {
        return new FundsTransferExecuteResp();
    }

    /**
     * Create an instance of {@link FundsTransferCancelResp }
     * 
     * @return
     *     the new instance of {@link FundsTransferCancelResp }
     */
    public FundsTransferCancelResp createFundsTransferCancelResp() {
        return new FundsTransferCancelResp();
    }

    /**
     * Create an instance of {@link CustomerInfoResp }
     * 
     * @return
     *     the new instance of {@link CustomerInfoResp }
     */
    public CustomerInfoResp createCustomerInfoResp() {
        return new CustomerInfoResp();
    }

    /**
     * Create an instance of {@link AccountEventResp }
     * 
     * @return
     *     the new instance of {@link AccountEventResp }
     */
    public AccountEventResp createAccountEventResp() {
        return new AccountEventResp();
    }

    /**
     * Create an instance of {@link AccountOpeningResp }
     * 
     * @return
     *     the new instance of {@link AccountOpeningResp }
     */
    public AccountOpeningResp createAccountOpeningResp() {
        return new AccountOpeningResp();
    }

    /**
     * Create an instance of {@link RequestHeader }
     * 
     * @return
     *     the new instance of {@link RequestHeader }
     */
    public RequestHeader createRequestHeader() {
        return new RequestHeader();
    }

    /**
     * Create an instance of {@link ResponseHeader }
     * 
     * @return
     *     the new instance of {@link ResponseHeader }
     */
    public ResponseHeader createResponseHeader() {
        return new ResponseHeader();
    }

    /**
     * Create an instance of {@link StandardResp }
     * 
     * @return
     *     the new instance of {@link StandardResp }
     */
    public StandardResp createStandardResp() {
        return new StandardResp();
    }

    /**
     * Create an instance of {@link NameValueList }
     * 
     * @return
     *     the new instance of {@link NameValueList }
     */
    public NameValueList createNameValueList() {
        return new NameValueList();
    }

    /**
     * Create an instance of {@link Detail }
     * 
     * @return
     *     the new instance of {@link Detail }
     */
    public Detail createDetail() {
        return new Detail();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     * @return
     *     the new instance of {@link Operation }
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link RuledOperation }
     * 
     * @return
     *     the new instance of {@link RuledOperation }
     */
    public RuledOperation createRuledOperation() {
        return new RuledOperation();
    }

    /**
     * Create an instance of {@link AccountAndOperations }
     * 
     * @return
     *     the new instance of {@link AccountAndOperations }
     */
    public AccountAndOperations createAccountAndOperations() {
        return new AccountAndOperations();
    }

    /**
     * Create an instance of {@link Account }
     * 
     * @return
     *     the new instance of {@link Account }
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     * @return
     *     the new instance of {@link Customer }
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link SimpleAccount }
     * 
     * @return
     *     the new instance of {@link SimpleAccount }
     */
    public SimpleAccount createSimpleAccount() {
        return new SimpleAccount();
    }

    /**
     * Create an instance of {@link AccountOpeningReq.AcctOpenReq }
     * 
     * @return
     *     the new instance of {@link AccountOpeningReq.AcctOpenReq }
     */
    public AccountOpeningReq.AcctOpenReq createAccountOpeningReqAcctOpenReq() {
        return new AccountOpeningReq.AcctOpenReq();
    }

    /**
     * Create an instance of {@link AccountEventReq.AcctEvtReq }
     * 
     * @return
     *     the new instance of {@link AccountEventReq.AcctEvtReq }
     */
    public AccountEventReq.AcctEvtReq createAccountEventReqAcctEvtReq() {
        return new AccountEventReq.AcctEvtReq();
    }

    /**
     * Create an instance of {@link AccountStatusResp.AcctStaResp }
     * 
     * @return
     *     the new instance of {@link AccountStatusResp.AcctStaResp }
     */
    public AccountStatusResp.AcctStaResp createAccountStatusRespAcctStaResp() {
        return new AccountStatusResp.AcctStaResp();
    }

    /**
     * Create an instance of {@link AccountStatusReq.AcctStaReq }
     * 
     * @return
     *     the new instance of {@link AccountStatusReq.AcctStaReq }
     */
    public AccountStatusReq.AcctStaReq createAccountStatusReqAcctStaReq() {
        return new AccountStatusReq.AcctStaReq();
    }

    /**
     * Create an instance of {@link CustomerAccountsResp.CustAcctsResp }
     * 
     * @return
     *     the new instance of {@link CustomerAccountsResp.CustAcctsResp }
     */
    public CustomerAccountsResp.CustAcctsResp createCustomerAccountsRespCustAcctsResp() {
        return new CustomerAccountsResp.CustAcctsResp();
    }

    /**
     * Create an instance of {@link CustomerAccountsReq.CustAcctsReq }
     * 
     * @return
     *     the new instance of {@link CustomerAccountsReq.CustAcctsReq }
     */
    public CustomerAccountsReq.CustAcctsReq createCustomerAccountsReqCustAcctsReq() {
        return new CustomerAccountsReq.CustAcctsReq();
    }

    /**
     * Create an instance of {@link CustomerSummaryResp.CustSumResp }
     * 
     * @return
     *     the new instance of {@link CustomerSummaryResp.CustSumResp }
     */
    public CustomerSummaryResp.CustSumResp createCustomerSummaryRespCustSumResp() {
        return new CustomerSummaryResp.CustSumResp();
    }

    /**
     * Create an instance of {@link CustomerSummaryReq.CustSumReq }
     * 
     * @return
     *     the new instance of {@link CustomerSummaryReq.CustSumReq }
     */
    public CustomerSummaryReq.CustSumReq createCustomerSummaryReqCustSumReq() {
        return new CustomerSummaryReq.CustSumReq();
    }

    /**
     * Create an instance of {@link AccountStatementResp.AcctStmResp }
     * 
     * @return
     *     the new instance of {@link AccountStatementResp.AcctStmResp }
     */
    public AccountStatementResp.AcctStmResp createAccountStatementRespAcctStmResp() {
        return new AccountStatementResp.AcctStmResp();
    }

    /**
     * Create an instance of {@link AccountStatementReq.AcctStmReq }
     * 
     * @return
     *     the new instance of {@link AccountStatementReq.AcctStmReq }
     */
    public AccountStatementReq.AcctStmReq createAccountStatementReqAcctStmReq() {
        return new AccountStatementReq.AcctStmReq();
    }

    /**
     * Create an instance of {@link CustomerInfoReq.CustInfoReq }
     * 
     * @return
     *     the new instance of {@link CustomerInfoReq.CustInfoReq }
     */
    public CustomerInfoReq.CustInfoReq createCustomerInfoReqCustInfoReq() {
        return new CustomerInfoReq.CustInfoReq();
    }

    /**
     * Create an instance of {@link QueryCustomerAccountResp.QueryCustAcctResp }
     * 
     * @return
     *     the new instance of {@link QueryCustomerAccountResp.QueryCustAcctResp }
     */
    public QueryCustomerAccountResp.QueryCustAcctResp createQueryCustomerAccountRespQueryCustAcctResp() {
        return new QueryCustomerAccountResp.QueryCustAcctResp();
    }

    /**
     * Create an instance of {@link QueryCustomerAccountReq.QueryCustAcctReq }
     * 
     * @return
     *     the new instance of {@link QueryCustomerAccountReq.QueryCustAcctReq }
     */
    public QueryCustomerAccountReq.QueryCustAcctReq createQueryCustomerAccountReqQueryCustAcctReq() {
        return new QueryCustomerAccountReq.QueryCustAcctReq();
    }

    /**
     * Create an instance of {@link AccountBalanceResp.AcctBalResp }
     * 
     * @return
     *     the new instance of {@link AccountBalanceResp.AcctBalResp }
     */
    public AccountBalanceResp.AcctBalResp createAccountBalanceRespAcctBalResp() {
        return new AccountBalanceResp.AcctBalResp();
    }

    /**
     * Create an instance of {@link AccountBalanceReq.AcctBalReq }
     * 
     * @return
     *     the new instance of {@link AccountBalanceReq.AcctBalReq }
     */
    public AccountBalanceReq.AcctBalReq createAccountBalanceReqAcctBalReq() {
        return new AccountBalanceReq.AcctBalReq();
    }

    /**
     * Create an instance of {@link FundsTransferCancelReq.FtCanReq }
     * 
     * @return
     *     the new instance of {@link FundsTransferCancelReq.FtCanReq }
     */
    public FundsTransferCancelReq.FtCanReq createFundsTransferCancelReqFtCanReq() {
        return new FundsTransferCancelReq.FtCanReq();
    }

    /**
     * Create an instance of {@link FundsTransferExecuteReq.FtExeReq }
     * 
     * @return
     *     the new instance of {@link FundsTransferExecuteReq.FtExeReq }
     */
    public FundsTransferExecuteReq.FtExeReq createFundsTransferExecuteReqFtExeReq() {
        return new FundsTransferExecuteReq.FtExeReq();
    }

    /**
     * Create an instance of {@link FundsTransferValidateReq.FtValReq.Credits }
     * 
     * @return
     *     the new instance of {@link FundsTransferValidateReq.FtValReq.Credits }
     */
    public FundsTransferValidateReq.FtValReq.Credits createFundsTransferValidateReqFtValReqCredits() {
        return new FundsTransferValidateReq.FtValReq.Credits();
    }

    /**
     * Create an instance of {@link TransactionExecReq.TrxExeReq }
     * 
     * @return
     *     the new instance of {@link TransactionExecReq.TrxExeReq }
     */
    public TransactionExecReq.TrxExeReq createTransactionExecReqTrxExeReq() {
        return new TransactionExecReq.TrxExeReq();
    }

    /**
     * Create an instance of {@link OperationExecReq.OperExeReq }
     * 
     * @return
     *     the new instance of {@link OperationExecReq.OperExeReq }
     */
    public OperationExecReq.OperExeReq createOperationExecReqOperExeReq() {
        return new OperationExecReq.OperExeReq();
    }

    /**
     * Create an instance of {@link OperationUpdateReq.OperUpdReq }
     * 
     * @return
     *     the new instance of {@link OperationUpdateReq.OperUpdReq }
     */
    public OperationUpdateReq.OperUpdReq createOperationUpdateReqOperUpdReq() {
        return new OperationUpdateReq.OperUpdReq();
    }

    /**
     * Create an instance of {@link OperationCancelReq.CancelReq }
     * 
     * @return
     *     the new instance of {@link OperationCancelReq.CancelReq }
     */
    public OperationCancelReq.CancelReq createOperationCancelReqCancelReq() {
        return new OperationCancelReq.CancelReq();
    }

    /**
     * Create an instance of {@link OperationAdviceReq.AdviceReq }
     * 
     * @return
     *     the new instance of {@link OperationAdviceReq.AdviceReq }
     */
    public OperationAdviceReq.AdviceReq createOperationAdviceReqAdviceReq() {
        return new OperationAdviceReq.AdviceReq();
    }

    /**
     * Create an instance of {@link ReservationReq.ReserveReq }
     * 
     * @return
     *     the new instance of {@link ReservationReq.ReserveReq }
     */
    public ReservationReq.ReserveReq createReservationReqReserveReq() {
        return new ReservationReq.ReserveReq();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservationReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReservationReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "reservationReq")
    public JAXBElement<ReservationReq> createReservationReq(ReservationReq value) {
        return new JAXBElement<>(_ReservationReq_QNAME, ReservationReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservationResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReservationResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "reservationResp")
    public JAXBElement<ReservationResp> createReservationResp(ReservationResp value) {
        return new JAXBElement<>(_ReservationResp_QNAME, ReservationResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationAdviceReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationAdviceReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "operationAdviceReq")
    public JAXBElement<OperationAdviceReq> createOperationAdviceReq(OperationAdviceReq value) {
        return new JAXBElement<>(_OperationAdviceReq_QNAME, OperationAdviceReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationAdviceResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationAdviceResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "operationAdviceResp")
    public JAXBElement<OperationAdviceResp> createOperationAdviceResp(OperationAdviceResp value) {
        return new JAXBElement<>(_OperationAdviceResp_QNAME, OperationAdviceResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationCancelReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationCancelReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "operationCancelReq")
    public JAXBElement<OperationCancelReq> createOperationCancelReq(OperationCancelReq value) {
        return new JAXBElement<>(_OperationCancelReq_QNAME, OperationCancelReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationCancelResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationCancelResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "operationCancelResp")
    public JAXBElement<OperationCancelResp> createOperationCancelResp(OperationCancelResp value) {
        return new JAXBElement<>(_OperationCancelResp_QNAME, OperationCancelResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationUpdateReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationUpdateReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "operationUpdateReq")
    public JAXBElement<OperationUpdateReq> createOperationUpdateReq(OperationUpdateReq value) {
        return new JAXBElement<>(_OperationUpdateReq_QNAME, OperationUpdateReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationUpdateResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationUpdateResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "operationUpdateResp")
    public JAXBElement<OperationUpdateResp> createOperationUpdateResp(OperationUpdateResp value) {
        return new JAXBElement<>(_OperationUpdateResp_QNAME, OperationUpdateResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationExecReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationExecReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "operationExecReq")
    public JAXBElement<OperationExecReq> createOperationExecReq(OperationExecReq value) {
        return new JAXBElement<>(_OperationExecReq_QNAME, OperationExecReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationExecResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationExecResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "operationExecResp")
    public JAXBElement<OperationExecResp> createOperationExecResp(OperationExecResp value) {
        return new JAXBElement<>(_OperationExecResp_QNAME, OperationExecResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionExecReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TransactionExecReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "transactionExecReq")
    public JAXBElement<TransactionExecReq> createTransactionExecReq(TransactionExecReq value) {
        return new JAXBElement<>(_TransactionExecReq_QNAME, TransactionExecReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionExecResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TransactionExecResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "transactionExecResp")
    public JAXBElement<TransactionExecResp> createTransactionExecResp(TransactionExecResp value) {
        return new JAXBElement<>(_TransactionExecResp_QNAME, TransactionExecResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FundsTransferValidateReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FundsTransferValidateReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "fundsTransferValidateReq")
    public JAXBElement<FundsTransferValidateReq> createFundsTransferValidateReq(FundsTransferValidateReq value) {
        return new JAXBElement<>(_FundsTransferValidateReq_QNAME, FundsTransferValidateReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FundsTransferValidateResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FundsTransferValidateResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "fundsTransferValidateResp")
    public JAXBElement<FundsTransferValidateResp> createFundsTransferValidateResp(FundsTransferValidateResp value) {
        return new JAXBElement<>(_FundsTransferValidateResp_QNAME, FundsTransferValidateResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FundsTransferExecuteReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FundsTransferExecuteReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "fundsTransferExecuteReq")
    public JAXBElement<FundsTransferExecuteReq> createFundsTransferExecuteReq(FundsTransferExecuteReq value) {
        return new JAXBElement<>(_FundsTransferExecuteReq_QNAME, FundsTransferExecuteReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FundsTransferExecuteResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FundsTransferExecuteResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "fundsTransferExecuteResp")
    public JAXBElement<FundsTransferExecuteResp> createFundsTransferExecuteResp(FundsTransferExecuteResp value) {
        return new JAXBElement<>(_FundsTransferExecuteResp_QNAME, FundsTransferExecuteResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FundsTransferCancelReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FundsTransferCancelReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "fundsTransferCancelReq")
    public JAXBElement<FundsTransferCancelReq> createFundsTransferCancelReq(FundsTransferCancelReq value) {
        return new JAXBElement<>(_FundsTransferCancelReq_QNAME, FundsTransferCancelReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FundsTransferCancelResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FundsTransferCancelResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "fundsTransferCancelResp")
    public JAXBElement<FundsTransferCancelResp> createFundsTransferCancelResp(FundsTransferCancelResp value) {
        return new JAXBElement<>(_FundsTransferCancelResp_QNAME, FundsTransferCancelResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountBalanceReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountBalanceReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountBalanceReq")
    public JAXBElement<AccountBalanceReq> createAccountBalanceReq(AccountBalanceReq value) {
        return new JAXBElement<>(_AccountBalanceReq_QNAME, AccountBalanceReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountBalanceResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountBalanceResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountBalanceResp")
    public JAXBElement<AccountBalanceResp> createAccountBalanceResp(AccountBalanceResp value) {
        return new JAXBElement<>(_AccountBalanceResp_QNAME, AccountBalanceResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryCustomerAccountReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryCustomerAccountReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "queryCustomerAccountReq")
    public JAXBElement<QueryCustomerAccountReq> createQueryCustomerAccountReq(QueryCustomerAccountReq value) {
        return new JAXBElement<>(_QueryCustomerAccountReq_QNAME, QueryCustomerAccountReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryCustomerAccountResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryCustomerAccountResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "queryCustomerAccountResp")
    public JAXBElement<QueryCustomerAccountResp> createQueryCustomerAccountResp(QueryCustomerAccountResp value) {
        return new JAXBElement<>(_QueryCustomerAccountResp_QNAME, QueryCustomerAccountResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerInfoReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerInfoReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "customerInfoReq")
    public JAXBElement<CustomerInfoReq> createCustomerInfoReq(CustomerInfoReq value) {
        return new JAXBElement<>(_CustomerInfoReq_QNAME, CustomerInfoReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerInfoResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerInfoResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "customerInfoResp")
    public JAXBElement<CustomerInfoResp> createCustomerInfoResp(CustomerInfoResp value) {
        return new JAXBElement<>(_CustomerInfoResp_QNAME, CustomerInfoResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountStatementReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountStatementReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountStatementReq")
    public JAXBElement<AccountStatementReq> createAccountStatementReq(AccountStatementReq value) {
        return new JAXBElement<>(_AccountStatementReq_QNAME, AccountStatementReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountStatementResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountStatementResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountStatementResp")
    public JAXBElement<AccountStatementResp> createAccountStatementResp(AccountStatementResp value) {
        return new JAXBElement<>(_AccountStatementResp_QNAME, AccountStatementResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerSummaryReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerSummaryReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "customerSummaryReq")
    public JAXBElement<CustomerSummaryReq> createCustomerSummaryReq(CustomerSummaryReq value) {
        return new JAXBElement<>(_CustomerSummaryReq_QNAME, CustomerSummaryReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerSummaryResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerSummaryResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "customerSummaryResp")
    public JAXBElement<CustomerSummaryResp> createCustomerSummaryResp(CustomerSummaryResp value) {
        return new JAXBElement<>(_CustomerSummaryResp_QNAME, CustomerSummaryResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerAccountsReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerAccountsReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "customerAccountsReq")
    public JAXBElement<CustomerAccountsReq> createCustomerAccountsReq(CustomerAccountsReq value) {
        return new JAXBElement<>(_CustomerAccountsReq_QNAME, CustomerAccountsReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerAccountsResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CustomerAccountsResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "customerAccountsResp")
    public JAXBElement<CustomerAccountsResp> createCustomerAccountsResp(CustomerAccountsResp value) {
        return new JAXBElement<>(_CustomerAccountsResp_QNAME, CustomerAccountsResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountStatusReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountStatusReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountStatusReq")
    public JAXBElement<AccountStatusReq> createAccountStatusReq(AccountStatusReq value) {
        return new JAXBElement<>(_AccountStatusReq_QNAME, AccountStatusReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountStatusResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountStatusResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountStatusResp")
    public JAXBElement<AccountStatusResp> createAccountStatusResp(AccountStatusResp value) {
        return new JAXBElement<>(_AccountStatusResp_QNAME, AccountStatusResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountEventReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountEventReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountEventReq")
    public JAXBElement<AccountEventReq> createAccountEventReq(AccountEventReq value) {
        return new JAXBElement<>(_AccountEventReq_QNAME, AccountEventReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountEventResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountEventResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountEventResp")
    public JAXBElement<AccountEventResp> createAccountEventResp(AccountEventResp value) {
        return new JAXBElement<>(_AccountEventResp_QNAME, AccountEventResp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountOpeningReq }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountOpeningReq }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountOpeningReq")
    public JAXBElement<AccountOpeningReq> createAccountOpeningReq(AccountOpeningReq value) {
        return new JAXBElement<>(_AccountOpeningReq_QNAME, AccountOpeningReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountOpeningResp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccountOpeningResp }{@code >}
     */
    @XmlElementDecl(namespace = "urn:schemas-attijariwafa-com:transaction-data", name = "accountOpeningResp")
    public JAXBElement<AccountOpeningResp> createAccountOpeningResp(AccountOpeningResp value) {
        return new JAXBElement<>(_AccountOpeningResp_QNAME, AccountOpeningResp.class, null, value);
    }

}
