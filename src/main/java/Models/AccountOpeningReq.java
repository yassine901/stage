
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AccountOpeningReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="AccountOpeningReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="AcctOpenReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="customerIdtf" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="openingDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="bilan" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "AccountOpeningReq", propOrder = {
    "reqHeader",
    "acctOpenReq"
})
public class AccountOpeningReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "AcctOpenReq", required = true)
    protected AccountOpeningReq.AcctOpenReq acctOpenReq;

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
     * Obtient la valeur de la propri�t� acctOpenReq.
     * 
     * @return
     *     possible object is
     *     {@link AccountOpeningReq.AcctOpenReq }
     *     
     */
    public AccountOpeningReq.AcctOpenReq getAcctOpenReq() {
        return acctOpenReq;
    }

    /**
     * D�finit la valeur de la propri�t� acctOpenReq.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountOpeningReq.AcctOpenReq }
     *     
     */
    public void setAcctOpenReq(AccountOpeningReq.AcctOpenReq value) {
        this.acctOpenReq = value;
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
     *       <attribute name="customerIdtf" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="openingDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="bilan" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AcctOpenReq {

        @XmlAttribute(name = "account", required = true)
        protected String account;
        @XmlAttribute(name = "customerIdtf")
        protected String customerIdtf;
        @XmlAttribute(name = "openingDate", required = true)
        protected String openingDate;
        @XmlAttribute(name = "bilan", required = true)
        protected String bilan;

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
         * Obtient la valeur de la propri�t� customerIdtf.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustomerIdtf() {
            return customerIdtf;
        }

        /**
         * D�finit la valeur de la propri�t� customerIdtf.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustomerIdtf(String value) {
            this.customerIdtf = value;
        }

        /**
         * Obtient la valeur de la propri�t� openingDate.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpeningDate() {
            return openingDate;
        }

        /**
         * D�finit la valeur de la propri�t� openingDate.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpeningDate(String value) {
            this.openingDate = value;
        }

        /**
         * Obtient la valeur de la propri�t� bilan.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBilan() {
            return bilan;
        }

        /**
         * D�finit la valeur de la propri�t� bilan.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBilan(String value) {
            this.bilan = value;
        }

    }

}
