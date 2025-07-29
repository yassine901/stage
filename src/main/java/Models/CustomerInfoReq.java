
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CustomerInfoReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="CustomerInfoReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="CustInfoReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Customer" type="{urn:schemas-attijariwafa-com:transaction-data}Customer"/>
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
@XmlType(name = "CustomerInfoReq", propOrder = {
    "reqHeader",
    "custInfoReq"
})
public class CustomerInfoReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "CustInfoReq", required = true)
    protected CustomerInfoReq.CustInfoReq custInfoReq;

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
     * Obtient la valeur de la propri�t� custInfoReq.
     * 
     * @return
     *     possible object is
     *     {@link CustomerInfoReq.CustInfoReq }
     *     
     */
    public CustomerInfoReq.CustInfoReq getCustInfoReq() {
        return custInfoReq;
    }

    /**
     * D�finit la valeur de la propri�t� custInfoReq.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerInfoReq.CustInfoReq }
     *     
     */
    public void setCustInfoReq(CustomerInfoReq.CustInfoReq value) {
        this.custInfoReq = value;
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
     *         <element name="Customer" type="{urn:schemas-attijariwafa-com:transaction-data}Customer"/>
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
        "customer"
    })
    public static class CustInfoReq {

        @XmlElement(name = "Customer", required = true)
        protected Customer customer;

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
