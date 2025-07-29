
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AccountBalanceResp complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="AccountBalanceResp">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RespHeader" type="{urn:schemas-attijariwafa-com:transaction-data}ResponseHeader"/>
 *         <element name="AcctBalResp">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Account" type="{urn:schemas-attijariwafa-com:transaction-data}AccountAndOperations"/>
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
@XmlType(name = "AccountBalanceResp", propOrder = {
    "respHeader",
    "acctBalResp"
})
public class AccountBalanceResp {

    @XmlElement(name = "RespHeader", required = true)
    protected ResponseHeader respHeader;
    @XmlElement(name = "AcctBalResp", required = true)
    protected AccountBalanceResp.AcctBalResp acctBalResp;

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
     * Obtient la valeur de la propri�t� acctBalResp.
     * 
     * @return
     *     possible object is
     *     {@link AccountBalanceResp.AcctBalResp }
     *     
     */
    public AccountBalanceResp.AcctBalResp getAcctBalResp() {
        return acctBalResp;
    }

    /**
     * D�finit la valeur de la propri�t� acctBalResp.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountBalanceResp.AcctBalResp }
     *     
     */
    public void setAcctBalResp(AccountBalanceResp.AcctBalResp value) {
        this.acctBalResp = value;
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
     *         <element name="Account" type="{urn:schemas-attijariwafa-com:transaction-data}AccountAndOperations"/>
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
        "account"
    })
    public static class AcctBalResp {

        @XmlElement(name = "Account", required = true)
        protected AccountAndOperations account;

        /**
         * Obtient la valeur de la propri�t� account.
         * 
         * @return
         *     possible object is
         *     {@link AccountAndOperations }
         *     
         */
        public AccountAndOperations getAccount() {
            return account;
        }

        /**
         * D�finit la valeur de la propri�t� account.
         * 
         * @param value
         *     allowed object is
         *     {@link AccountAndOperations }
         *     
         */
        public void setAccount(AccountAndOperations value) {
            this.account = value;
        }

    }

}
