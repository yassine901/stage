
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour FundsTransferCancelReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="FundsTransferCancelReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="FtCanReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="trxType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="trxRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "FundsTransferCancelReq", propOrder = {
    "reqHeader",
    "ftCanReq"
})
public class FundsTransferCancelReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "FtCanReq", required = true)
    protected FundsTransferCancelReq.FtCanReq ftCanReq;

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
     * Obtient la valeur de la propri�t� ftCanReq.
     * 
     * @return
     *     possible object is
     *     {@link FundsTransferCancelReq.FtCanReq }
     *     
     */
    public FundsTransferCancelReq.FtCanReq getFtCanReq() {
        return ftCanReq;
    }

    /**
     * D�finit la valeur de la propri�t� ftCanReq.
     * 
     * @param value
     *     allowed object is
     *     {@link FundsTransferCancelReq.FtCanReq }
     *     
     */
    public void setFtCanReq(FundsTransferCancelReq.FtCanReq value) {
        this.ftCanReq = value;
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
     *       <attribute name="trxType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="trxRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class FtCanReq {

        @XmlAttribute(name = "trxType", required = true)
        protected String trxType;
        @XmlAttribute(name = "trxRef", required = true)
        protected String trxRef;
        @XmlAttribute(name = "operRef", required = true)
        protected String operRef;
        @XmlAttribute(name = "operStatus", required = true)
        protected StatusEnum operStatus;
        @XmlAttribute(name = "account", required = true)
        protected String account;

        /**
         * Obtient la valeur de la propri�t� trxType.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTrxType() {
            return trxType;
        }

        /**
         * D�finit la valeur de la propri�t� trxType.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTrxType(String value) {
            this.trxType = value;
        }

        /**
         * Obtient la valeur de la propri�t� trxRef.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTrxRef() {
            return trxRef;
        }

        /**
         * D�finit la valeur de la propri�t� trxRef.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTrxRef(String value) {
            this.trxRef = value;
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

    }

}
