
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour QueryCustomerAccountResp complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="QueryCustomerAccountResp">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RespHeader" type="{urn:schemas-attijariwafa-com:transaction-data}ResponseHeader"/>
 *         <element name="QueryCustAcctResp">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Account" type="{urn:schemas-attijariwafa-com:transaction-data}Account"/>
 *                   <element name="Customer" type="{urn:schemas-attijariwafa-com:transaction-data}Customer" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryCustomerAccountResp", propOrder = {
    "respHeader",
    "queryCustAcctResp"
})
public class QueryCustomerAccountResp {

    @XmlElement(name = "RespHeader", required = true)
    protected ResponseHeader respHeader;
    @XmlElement(name = "QueryCustAcctResp", required = true)
    protected QueryCustomerAccountResp.QueryCustAcctResp queryCustAcctResp;

    /**
     * Obtient la valeur de la propri�t� respHeader.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeader }
     *     
     */
    public ResponseHeader getRespHeader() {
        return respHeader;
    }

    /**
     * D�finit la valeur de la propri�t� respHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeader }
     *     
     */
    public void setRespHeader(ResponseHeader value) {
        this.respHeader = value;
    }

    /**
     * Obtient la valeur de la propri�t� queryCustAcctResp.
     * 
     * @return
     *     possible object is
     *     {@link QueryCustomerAccountResp.QueryCustAcctResp }
     *     
     */
    public QueryCustomerAccountResp.QueryCustAcctResp getQueryCustAcctResp() {
        return queryCustAcctResp;
    }

    /**
     * D�finit la valeur de la propri�t� queryCustAcctResp.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryCustomerAccountResp.QueryCustAcctResp }
     *     
     */
    public void setQueryCustAcctResp(QueryCustomerAccountResp.QueryCustAcctResp value) {
        this.queryCustAcctResp = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Account" type="{urn:schemas-attijariwafa-com:transaction-data}Account"/>
     *         <element name="Customer" type="{urn:schemas-attijariwafa-com:transaction-data}Customer" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "account",
        "customer"
    })
    public static class QueryCustAcctResp {

        @XmlElement(name = "Account", required = true)
        protected Account account;
        @XmlElement(name = "Customer")
        protected Customer customer;

        /**
         * Obtient la valeur de la propri�t� account.
         * 
         * @return
         *     possible object is
         *     {@link Account }
         *     
         */
        public Account getAccount() {
            return account;
        }

        /**
         * D�finit la valeur de la propri�t� account.
         * 
         * @param value
         *     allowed object is
         *     {@link Account }
         *     
         */
        public void setAccount(Account value) {
            this.account = value;
        }

        /**
         * Obtient la valeur de la propri�t� customer.
         * 
         * @return
         *     possible object is
         *     {@link Customer }
         *     
         */
        public Customer getCustomer() {
            return customer;
        }

        /**
         * D�finit la valeur de la propri�t� customer.
         * 
         * @param value
         *     allowed object is
         *     {@link Customer }
         *     
         */
        public void setCustomer(Customer value) {
            this.customer = value;
        }

    }

}
