
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Account complex type.</p>
 * 
 * <p>Le fragment de schema suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="Account">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <attribute name="numero" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="acctStatus" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="isDebitsBlocked" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="debitsBlkReason" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="bilanComptable" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="customerIdtf" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="ledgerBalDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="ledgerBal" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       <attribute name="realBal" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       <attribute name="availBal" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       <attribute name="facilities" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       <attribute name="holds" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account")
public class Account {

    @XmlAttribute(name = "numero", required = true)
    protected String numero;
    @XmlAttribute(name = "acctStatus", required = true)
    protected String acctStatus;
    @XmlAttribute(name = "isDebitsBlocked", required = true)
    protected String isDebitsBlocked;
    @XmlAttribute(name = "debitsBlkReason", required = true)
    protected String debitsBlkReason;
    @XmlAttribute(name = "bilanComptable", required = true)
    protected String bilanComptable;
    @XmlAttribute(name = "customerIdtf", required = true)
    protected String customerIdtf;
    @XmlAttribute(name = "ledgerBalDate", required = true)
    protected String ledgerBalDate;
    @XmlAttribute(name = "ledgerBal", required = true)
    protected long ledgerBal;
    @XmlAttribute(name = "realBal", required = true)
    protected long realBal;
    @XmlAttribute(name = "availBal", required = true)
    protected long availBal;
    @XmlAttribute(name = "facilities", required = true)
    protected long facilities;
    @XmlAttribute(name = "holds", required = true)
    protected long holds;

    /**
     * Obtient la valeur de la propriete numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * D�finit la valeur de la propriete numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtient la valeur de la propriete acctStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctStatus() {
        return acctStatus;
    }

    /**
     * D�finit la valeur de la propriete acctStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctStatus(String value) {
        this.acctStatus = value;
    }

    /**
     * Obtient la valeur de la propriete isDebitsBlocked.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDebitsBlocked() {
        return isDebitsBlocked;
    }

    /**
     * D�finit la valeur de la propriete isDebitsBlocked.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDebitsBlocked(String value) {
        this.isDebitsBlocked = value;
    }

    /**
     * Obtient la valeur de la propriete debitsBlkReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebitsBlkReason() {
        return debitsBlkReason;
    }

    /**
     * D�finit la valeur de la propriete debitsBlkReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebitsBlkReason(String value) {
        this.debitsBlkReason = value;
    }

    /**
     * Obtient la valeur de la propriete bilanComptable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBilanComptable() {
        return bilanComptable;
    }

    /**
     * Definit la valeur de la propriete bilanComptable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBilanComptable(String value) {
        this.bilanComptable = value;
    }

    /**
     * Obtient la valeur de la propriete customerIdtf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerIdtf() {
        return customerIdtf;
    }

    /**
     * D�finit la valeur de la propriete customerIdtf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerIdtf(String value) {
        this.customerIdtf = value;
    }

    /**
     * Obtient la valeur de la propriete ledgerBalDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLedgerBalDate() {
        return ledgerBalDate;
    }

    /**
     * Definit la valeur de la propriete ledgerBalDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLedgerBalDate(String value) {
        this.ledgerBalDate = value;
    }

    /**
     * Obtient la valeur de la propriete ledgerBal.
     * 
     */
    public long getLedgerBal() {
        return ledgerBal;
    }

    /**
     * Definit la valeur de la propriete ledgerBal.
     * 
     */
    public void setLedgerBal(long value) {
        this.ledgerBal = value;
    }

    /**
     * Obtient la valeur de la propriete realBal.
     * 
     */
    public long getRealBal() {
        return realBal;
    }

    /**
     * Definit la valeur de la propriete realBal.
     * 
     */
    public void setRealBal(long value) {
        this.realBal = value;
    }

    /**
     * Obtient la valeur de la propriete availBal.
     * 
     */
    public long getAvailBal() {
        return availBal;
    }

    /**
     * Definit la valeur de la propriete availBal.
     * 
     */
    public void setAvailBal(long value) {
        this.availBal = value;
    }

    /**
     * Obtient la valeur de la propriete facilities.
     * 
     */
    public long getFacilities() {
        return facilities;
    }

    /**
     * Definit la valeur de la propriete facilities.
     * 
     */
    public void setFacilities(long value) {
        this.facilities = value;
    }

    /**
     * Obtient la valeur de la propriete holds.
     * 
     */
    public long getHolds() {
        return holds;
    }

    /**
     * Definit la valeur de la propriete holds.
     * 
     */
    public void setHolds(long value) {
        this.holds = value;
    }

}
