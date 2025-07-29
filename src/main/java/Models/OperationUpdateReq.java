
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour OperationUpdateReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="OperationUpdateReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="OperUpdReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="ruleCode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="operRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="operStatus" use="required" type="{urn:schemas-attijariwafa-com:transaction-data}StatusEnum" />
 *                 <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="amount" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
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
@XmlType(name = "OperationUpdateReq", propOrder = {
    "reqHeader",
    "operUpdReq"
})
public class OperationUpdateReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "OperUpdReq", required = true)
    protected OperationUpdateReq.OperUpdReq operUpdReq;

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
     * Obtient la valeur de la propri�t� operUpdReq.
     * 
     * @return
     *     possible object is
     *     {@link OperationUpdateReq.OperUpdReq }
     *     
     */
    public OperationUpdateReq.OperUpdReq getOperUpdReq() {
        return operUpdReq;
    }

    /**
     * D�finit la valeur de la propri�t� operUpdReq.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationUpdateReq.OperUpdReq }
     *     
     */
    public void setOperUpdReq(OperationUpdateReq.OperUpdReq value) {
        this.operUpdReq = value;
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
     *       <attribute name="ruleCode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="operRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="operStatus" use="required" type="{urn:schemas-attijariwafa-com:transaction-data}StatusEnum" />
     *       <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="amount" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OperUpdReq {

        @XmlAttribute(name = "ruleCode", required = true)
        protected String ruleCode;
        @XmlAttribute(name = "operRef", required = true)
        protected String operRef;
        @XmlAttribute(name = "operStatus", required = true)
        protected StatusEnum operStatus;
        @XmlAttribute(name = "account", required = true)
        protected String account;
        @XmlAttribute(name = "amount", required = true)
        protected long amount;

        /**
         * Obtient la valeur de la propri�t� ruleCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRuleCode() {
            return ruleCode;
        }

        /**
         * D�finit la valeur de la propri�t� ruleCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRuleCode(String value) {
            this.ruleCode = value;
        }

        /**
         * Obtient la valeur de la propri�t� operRef.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOperRef() {
            return operRef;
        }

        /**
         * D�finit la valeur de la propri�t� operRef.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOperRef(String value) {
            this.operRef = value;
        }

        /**
         * Obtient la valeur de la propri�t� operStatus.
         * 
         * @return
         *     possible object is
         *     {@link StatusEnum }
         *     
         */
        public StatusEnum getOperStatus() {
            return operStatus;
        }

        /**
         * D�finit la valeur de la propri�t� operStatus.
         * 
         * @param value
         *     allowed object is
         *     {@link StatusEnum }
         *     
         */
        public void setOperStatus(StatusEnum value) {
            this.operStatus = value;
        }

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
         * Obtient la valeur de la propri�t� amount.
         * 
         */
        public long getAmount() {
            return amount;
        }

        /**
         * D�finit la valeur de la propri�t� amount.
         * 
         */
        public void setAmount(long value) {
            this.amount = value;
        }

    }

}
