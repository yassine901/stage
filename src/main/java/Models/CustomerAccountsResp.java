
package Models;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CustomerAccountsResp complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="CustomerAccountsResp">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RespHeader" type="{urn:schemas-attijariwafa-com:transaction-data}ResponseHeader"/>
 *         <element name="CustAcctsResp">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Account" type="{urn:schemas-attijariwafa-com:transaction-data}SimpleAccount" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *                 <attribute name="idtfcl" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="titre" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="designation" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="categorie" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="marche" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "CustomerAccountsResp", propOrder = {
    "respHeader",
    "custAcctsResp"
})
public class CustomerAccountsResp {

    @XmlElement(name = "RespHeader", required = true)
    protected ResponseHeader respHeader;
    @XmlElement(name = "CustAcctsResp", required = true)
    protected CustomerAccountsResp.CustAcctsResp custAcctsResp;

    /**
     * Obtient la valeur de la propri�t� respHeader.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeader }
     *     
     */
    public ResponseHeader getRespHeader() {
        return respHeader;
    }

    /**
     * D�finit la valeur de la propri�t� respHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeader }
     *     
     */
    public void setRespHeader(ResponseHeader value) {
        this.respHeader = value;
    }

    /**
     * Obtient la valeur de la propri�t� custAcctsResp.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAccountsResp.CustAcctsResp }
     *     
     */
    public CustomerAccountsResp.CustAcctsResp getCustAcctsResp() {
        return custAcctsResp;
    }

    /**
     * D�finit la valeur de la propri�t� custAcctsResp.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAccountsResp.CustAcctsResp }
     *     
     */
    public void setCustAcctsResp(CustomerAccountsResp.CustAcctsResp value) {
        this.custAcctsResp = value;
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
     *         <element name="Account" type="{urn:schemas-attijariwafa-com:transaction-data}SimpleAccount" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *       <attribute name="idtfcl" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="titre" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="designation" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="categorie" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="marche" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class CustAcctsResp {

        @XmlElement(name = "Account")
        protected List<SimpleAccount> account;
        @XmlAttribute(name = "idtfcl", required = true)
        protected String idtfcl;
        @XmlAttribute(name = "titre", required = true)
        protected String titre;
        @XmlAttribute(name = "designation", required = true)
        protected String designation;
        @XmlAttribute(name = "categorie", required = true)
        protected String categorie;
        @XmlAttribute(name = "marche", required = true)
        protected String marche;

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
         * {@link SimpleAccount }
         * </p>
         * 
         * 
         * @return
         *     The value of the account property.
         */
        public List<SimpleAccount> getAccount() {
            if (account == null) {
                account = new ArrayList<>();
            }
            return this.account;
        }

        /**
         * Obtient la valeur de la propri�t� idtfcl.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdtfcl() {
            return idtfcl;
        }

        /**
         * D�finit la valeur de la propri�t� idtfcl.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdtfcl(String value) {
            this.idtfcl = value;
        }

        /**
         * Obtient la valeur de la propri�t� titre.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitre() {
            return titre;
        }

        /**
         * D�finit la valeur de la propri�t� titre.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitre(String value) {
            this.titre = value;
        }

        /**
         * Obtient la valeur de la propri�t� designation.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDesignation() {
            return designation;
        }

        /**
         * D�finit la valeur de la propri�t� designation.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDesignation(String value) {
            this.designation = value;
        }

        /**
         * Obtient la valeur de la propri�t� categorie.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCategorie() {
            return categorie;
        }

        /**
         * D�finit la valeur de la propri�t� categorie.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCategorie(String value) {
            this.categorie = value;
        }

        /**
         * Obtient la valeur de la propri�t� marche.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMarche() {
            return marche;
        }

        /**
         * D�finit la valeur de la propri�t� marche.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMarche(String value) {
            this.marche = value;
        }

    }

}
