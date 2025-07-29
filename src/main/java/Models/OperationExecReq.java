
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour OperationExecReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="OperationExecReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="OperExeReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="OperationData" type="{urn:schemas-attijariwafa-com:transaction-data}RuledOperation"/>
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
@XmlType(name = "OperationExecReq", propOrder = {
    "reqHeader",
    "operExeReq"
})
public class OperationExecReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "OperExeReq", required = true)
    protected OperationExecReq.OperExeReq operExeReq;

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
     * Obtient la valeur de la propri�t� operExeReq.
     * 
     * @return
     *     possible object is
     *     {@link OperationExecReq.OperExeReq }
     *     
     */
    public OperationExecReq.OperExeReq getOperExeReq() {
        return operExeReq;
    }

    /**
     * D�finit la valeur de la propri�t� operExeReq.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationExecReq.OperExeReq }
     *     
     */
    public void setOperExeReq(OperationExecReq.OperExeReq value) {
        this.operExeReq = value;
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
     *         <element name="OperationData" type="{urn:schemas-attijariwafa-com:transaction-data}RuledOperation"/>
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
        "operationData"
    })
    public static class OperExeReq {

        @XmlElement(name = "OperationData", required = true)
        protected RuledOperation operationData;

        /**
         * Obtient la valeur de la propri�t� operationData.
         * 
         * @return
         *     possible object is
         *     {@link RuledOperation }
         *     
         */
        public RuledOperation getOperationData() {
            return operationData;
        }

        /**
         * D�finit la valeur de la propri�t� operationData.
         * 
         * @param value
         *     allowed object is
         *     {@link RuledOperation }
         *     
         */
        public void setOperationData(RuledOperation value) {
            this.operationData = value;
        }

    }

}
