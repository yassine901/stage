
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AccountStatementReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="AccountStatementReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="AcctStmReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="typeRecherche" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="nbLastOperations" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 <attribute name="nbJoursHistorique" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
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
@XmlType(name = "AccountStatementReq", propOrder = {
    "reqHeader",
    "acctStmReq"
})
public class AccountStatementReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "AcctStmReq", required = true)
    protected AccountStatementReq.AcctStmReq acctStmReq;

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
     * Obtient la valeur de la propri�t� acctStmReq.
     * 
     * @return
     *     possible object is
     *     {@link AccountStatementReq.AcctStmReq }
     *     
     */
    public AccountStatementReq.AcctStmReq getAcctStmReq() {
        return acctStmReq;
    }

    /**
     * D�finit la valeur de la propri�t� acctStmReq.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountStatementReq.AcctStmReq }
     *     
     */
    public void setAcctStmReq(AccountStatementReq.AcctStmReq value) {
        this.acctStmReq = value;
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
     *       <attribute name="typeRecherche" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="nbLastOperations" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       <attribute name="nbJoursHistorique" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AcctStmReq {

        @XmlAttribute(name = "account", required = true)
        protected String account;
        @XmlAttribute(name = "typeRecherche", required = true)
        protected String typeRecherche;
        @XmlAttribute(name = "nbLastOperations", required = true)
        protected int nbLastOperations;
        @XmlAttribute(name = "nbJoursHistorique", required = true)
        protected int nbJoursHistorique;

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
         * Obtient la valeur de la propri�t� typeRecherche.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeRecherche() {
            return typeRecherche;
        }

        /**
         * D�finit la valeur de la propri�t� typeRecherche.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeRecherche(String value) {
            this.typeRecherche = value;
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

        /**
         * Obtient la valeur de la propri�t� nbJoursHistorique.
         * 
         */
        public int getNbJoursHistorique() {
            return nbJoursHistorique;
        }

        /**
         * D�finit la valeur de la propri�t� nbJoursHistorique.
         * 
         */
        public void setNbJoursHistorique(int value) {
            this.nbJoursHistorique = value;
        }

    }

}
