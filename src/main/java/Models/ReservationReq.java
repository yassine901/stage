
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ReservationReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="ReservationReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="ReserveReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="OperationData" type="{urn:schemas-attijariwafa-com:transaction-data}Operation"/>
 *                   <element name="OperationContext" type="{urn:schemas-attijariwafa-com:transaction-data}NameValueList"/>
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
@XmlType(name = "ReservationReq", propOrder = {
    "reqHeader",
    "reserveReq"
})
public class ReservationReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "ReserveReq", required = true)
    protected ReservationReq.ReserveReq reserveReq;

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
     * Obtient la valeur de la propri�t� reserveReq.
     * 
     * @return
     *     possible object is
     *     {@link ReservationReq.ReserveReq }
     *     
     */
    public ReservationReq.ReserveReq getReserveReq() {
        return reserveReq;
    }

    /**
     * D�finit la valeur de la propri�t� reserveReq.
     * 
     * @param value
     *     allowed object is
     *     {@link ReservationReq.ReserveReq }
     *     
     */
    public void setReserveReq(ReservationReq.ReserveReq value) {
        this.reserveReq = value;
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
     *         <element name="OperationData" type="{urn:schemas-attijariwafa-com:transaction-data}Operation"/>
     *         <element name="OperationContext" type="{urn:schemas-attijariwafa-com:transaction-data}NameValueList"/>
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
        "operationData",
        "operationContext"
    })
    public static class ReserveReq {

        @XmlElement(name = "OperationData", required = true)
        protected Operation operationData;
        @XmlElement(name = "OperationContext", required = true)
        protected NameValueList operationContext;

        /**
         * Obtient la valeur de la propri�t� operationData.
         * 
         * @return
         *     possible object is
         *     {@link Operation }
         *     
         */
        public Operation getOperationData() {
            return operationData;
        }

        /**
         * D�finit la valeur de la propri�t� operationData.
         * 
         * @param value
         *     allowed object is
         *     {@link Operation }
         *     
         */
        public void setOperationData(Operation value) {
            this.operationData = value;
        }

        /**
         * Obtient la valeur de la propri�t� operationContext.
         * 
         * @return
         *     possible object is
         *     {@link NameValueList }
         *     
         */
        public NameValueList getOperationContext() {
            return operationContext;
        }

        /**
         * D�finit la valeur de la propri�t� operationContext.
         * 
         * @param value
         *     allowed object is
         *     {@link NameValueList }
         *     
         */
        public void setOperationContext(NameValueList value) {
            this.operationContext = value;
        }

    }

}
