
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CustomerAccountsReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="CustomerAccountsReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="CustAcctsReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="typeRestitution" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "CustomerAccountsReq", propOrder = {
    "reqHeader",
    "custAcctsReq"
})
public class CustomerAccountsReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "CustAcctsReq", required = true)
    protected CustomerAccountsReq.CustAcctsReq custAcctsReq;

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
     * Obtient la valeur de la propri�t� custAcctsReq.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAccountsReq.CustAcctsReq }
     *     
     */
    public CustomerAccountsReq.CustAcctsReq getCustAcctsReq() {
        return custAcctsReq;
    }

    /**
     * D�finit la valeur de la propri�t� custAcctsReq.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAccountsReq.CustAcctsReq }
     *     
     */
    public void setCustAcctsReq(CustomerAccountsReq.CustAcctsReq value) {
        this.custAcctsReq = value;
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
     *       <attribute name="typeRestitution" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CustAcctsReq {

        @XmlAttribute(name = "account", required = true)
        protected String account;
        @XmlAttribute(name = "typeRestitution", required = true)
        protected String typeRestitution;

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
         * Obtient la valeur de la propri�t� typeRestitution.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeRestitution() {
            return typeRestitution;
        }

        /**
         * D�finit la valeur de la propri�t� typeRestitution.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeRestitution(String value) {
            this.typeRestitution = value;
        }

    }

}
