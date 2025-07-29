
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour OperationCancelReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="OperationCancelReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="CancelReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="operRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="operStatus" use="required" type="{urn:schemas-attijariwafa-com:transaction-data}StatusEnum" />
 *                 <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "OperationCancelReq", propOrder = {
    "reqHeader",
    "cancelReq"
})
public class OperationCancelReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "CancelReq", required = true)
    protected OperationCancelReq.CancelReq cancelReq;

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
     * Obtient la valeur de la propri�t� cancelReq.
     * 
     * @return
     *     possible object is
     *     {@link OperationCancelReq.CancelReq }
     *     
     */
    public OperationCancelReq.CancelReq getCancelReq() {
        return cancelReq;
    }

    /**
     * D�finit la valeur de la propri�t� cancelReq.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationCancelReq.CancelReq }
     *     
     */
    public void setCancelReq(OperationCancelReq.CancelReq value) {
        this.cancelReq = value;
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
     *       <attribute name="operRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="operStatus" use="required" type="{urn:schemas-attijariwafa-com:transaction-data}StatusEnum" />
     *       <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CancelReq {

        @XmlAttribute(name = "operRef", required = true)
        protected String operRef;
        @XmlAttribute(name = "operStatus", required = true)
        protected StatusEnum operStatus;
        @XmlAttribute(name = "account", required = true)
        protected String account;

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

    }

}
