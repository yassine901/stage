
package Models;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour TransactionExecReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="TransactionExecReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="TrxExeReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="OperationData" type="{urn:schemas-attijariwafa-com:transaction-data}RuledOperation" maxOccurs="unbounded"/>
 *                 </sequence>
 *                 <attribute name="trxType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="trxRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "TransactionExecReq", propOrder = {
    "reqHeader",
    "trxExeReq"
})
public class TransactionExecReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "TrxExeReq", required = true)
    protected TransactionExecReq.TrxExeReq trxExeReq;

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
     * Obtient la valeur de la propri�t� trxExeReq.
     * 
     * @return
     *     possible object is
     *     {@link TransactionExecReq.TrxExeReq }
     *     
     */
    public TransactionExecReq.TrxExeReq getTrxExeReq() {
        return trxExeReq;
    }

    /**
     * D�finit la valeur de la propri�t� trxExeReq.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionExecReq.TrxExeReq }
     *     
     */
    public void setTrxExeReq(TransactionExecReq.TrxExeReq value) {
        this.trxExeReq = value;
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
     *         <element name="OperationData" type="{urn:schemas-attijariwafa-com:transaction-data}RuledOperation" maxOccurs="unbounded"/>
     *       </sequence>
     *       <attribute name="trxType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="trxRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "operationData"
    })
    public static class TrxExeReq {

        @XmlElement(name = "OperationData", required = true)
        protected List<RuledOperation> operationData;
        @XmlAttribute(name = "trxType", required = true)
        protected String trxType;
        @XmlAttribute(name = "trxRef", required = true)
        protected String trxRef;

        /**
         * Gets the value of the operationData property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operationData property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getOperationData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RuledOperation }
         * </p>
         * 
         * 
         * @return
         *     The value of the operationData property.
         */
        public List<RuledOperation> getOperationData() {
            if (operationData == null) {
                operationData = new ArrayList<>();
            }
            return this.operationData;
        }

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

    }

}
