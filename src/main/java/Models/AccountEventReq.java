
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AccountEventReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="AccountEventReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="AcctEvtReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="sitexType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "AccountEventReq", propOrder = {
    "reqHeader",
    "acctEvtReq"
})
public class AccountEventReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "AcctEvtReq", required = true)
    protected AccountEventReq.AcctEvtReq acctEvtReq;

    /**
     * Obtient la valeur de la propri�t� reqHeader.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeader }
     *     
     */
    public RequestHeader getReqHeader() {
        return reqHeader;
    }

    /**
     * D�finit la valeur de la propri�t� reqHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeader }
     *     
     */
    public void setReqHeader(RequestHeader value) {
        this.reqHeader = value;
    }

    /**
     * Obtient la valeur de la propri�t� acctEvtReq.
     * 
     * @return
     *     possible object is
     *     {@link AccountEventReq.AcctEvtReq }
     *     
     */
    public AccountEventReq.AcctEvtReq getAcctEvtReq() {
        return acctEvtReq;
    }

    /**
     * D�finit la valeur de la propri�t� acctEvtReq.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountEventReq.AcctEvtReq }
     *     
     */
    public void setAcctEvtReq(AccountEventReq.AcctEvtReq value) {
        this.acctEvtReq = value;
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
     *       <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="sitexType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AcctEvtReq {

        @XmlAttribute(name = "account", required = true)
        protected String account;
        @XmlAttribute(name = "sitexType", required = true)
        protected String sitexType;
        @XmlAttribute(name = "action", required = true)
        protected String action;

        /**
         * Obtient la valeur de la propri�t� account.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccount() {
            return account;
        }

        /**
         * D�finit la valeur de la propri�t� account.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccount(String value) {
            this.account = value;
        }

        /**
         * Obtient la valeur de la propri�t� sitexType.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSitexType() {
            return sitexType;
        }

        /**
         * D�finit la valeur de la propri�t� sitexType.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSitexType(String value) {
            this.sitexType = value;
        }

        /**
         * Obtient la valeur de la propri�t� action.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAction() {
            return action;
        }

        /**
         * D�finit la valeur de la propri�t� action.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAction(String value) {
            this.action = value;
        }

    }

}
