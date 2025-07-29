
package Models;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CustomerSummaryReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="CustomerSummaryReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="CustSumReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 </sequence>
 *                 <attribute name="customerId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="nbLastOperations" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
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
@XmlType(name = "CustomerSummaryReq", propOrder = {
    "reqHeader",
    "custSumReq"
})
public class CustomerSummaryReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "CustSumReq", required = true)
    protected CustomerSummaryReq.CustSumReq custSumReq;

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
     * Obtient la valeur de la propri�t� custSumReq.
     * 
     * @return
     *     possible object is
     *     {@link CustomerSummaryReq.CustSumReq }
     *     
     */
    public CustomerSummaryReq.CustSumReq getCustSumReq() {
        return custSumReq;
    }

    /**
     * D�finit la valeur de la propri�t� custSumReq.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerSummaryReq.CustSumReq }
     *     
     */
    public void setCustSumReq(CustomerSummaryReq.CustSumReq value) {
        this.custSumReq = value;
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
     *         <element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *       </sequence>
     *       <attribute name="customerId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="nbLastOperations" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
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
    public static class CustSumReq {

        @XmlElement(name = "Account", required = true)
        protected List<String> account;
        @XmlAttribute(name = "customerId", required = true)
        protected String customerId;
        @XmlAttribute(name = "nbLastOperations", required = true)
        protected int nbLastOperations;

        /**
         * Gets the value of the account property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the account property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getAccount().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * </p>
         * 
         * 
         * @return
         *     The value of the account property.
         */
        public List<String> getAccount() {
            if (account == null) {
                account = new ArrayList<>();
            }
            return this.account;
        }

        /**
         * Obtient la valeur de la propri�t� customerId.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustomerId() {
            return customerId;
        }

        /**
         * D�finit la valeur de la propri�t� customerId.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustomerId(String value) {
            this.customerId = value;
        }

        /**
         * Obtient la valeur de la propri�t� nbLastOperations.
         * 
         */
        public int getNbLastOperations() {
            return nbLastOperations;
        }

        /**
         * D�finit la valeur de la propri�t� nbLastOperations.
         * 
         */
        public void setNbLastOperations(int value) {
            this.nbLastOperations = value;
        }

    }

}
