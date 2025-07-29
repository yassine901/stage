
package Models;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour AccountAndOperations complex type.</p>
 * 
 * <p>Le fragment de schema suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="AccountAndOperations">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="OperationData" type="{urn:schemas-attijariwafa-com:transaction-data}Operation" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="numero" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="acctStatus" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="isDebitsBlocked" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "AccountAndOperations", propOrder = {
    "operationData"
})
public class AccountAndOperations {

    @XmlElement(name = "OperationData")
    protected List<Operation> operationData;
    @XmlAttribute(name = "numero", required = true)
    protected String numero;
    @XmlAttribute(name = "acctStatus", required = true)
    protected String acctStatus;
    @XmlAttribute(name = "isDebitsBlocked", required = true)
    protected String isDebitsBlocked;
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
     * {@link Operation }
     * </p>
     * 
     * 
     * @return
     *     The value of the operationData property.
     */
    public List<Operation> getOperationData() {
        if (operationData == null) {
            operationData = new ArrayList<>();
        }
        return this.operationData;
    }

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
     * Definit la valeur de la propriete numero.
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
     * Definit la valeur de la propriete acctStatus.
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
     * Obtient la valeur de la propri�t� isDebitsBlocked.
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
     * D�finit la valeur de la propri�t� isDebitsBlocked.
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
     * Obtient la valeur de la propri�t� ledgerBalDate.
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
     * D�finit la valeur de la propri�t� ledgerBalDate.
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
     * Obtient la valeur de la propri�t� ledgerBal.
     * 
     */
    public long getLedgerBal() {
        return ledgerBal;
    }

    /**
     * D�finit la valeur de la propri�t� ledgerBal.
     * 
     */
    public void setLedgerBal(long value) {
        this.ledgerBal = value;
    }

    /**
     * Obtient la valeur de la propri�t� realBal.
     * 
     */
    public long getRealBal() {
        return realBal;
    }

    /**
     * D�finit la valeur de la propri�t� realBal.
     * 
     */
    public void setRealBal(long value) {
        this.realBal = value;
    }

    /**
     * Obtient la valeur de la propri�t� availBal.
     * 
     */
    public long getAvailBal() {
        return availBal;
    }

    /**
     * D�finit la valeur de la propri�t� availBal.
     * 
     */
    public void setAvailBal(long value) {
        this.availBal = value;
    }

    /**
     * Obtient la valeur de la propri�t� facilities.
     * 
     */
    public long getFacilities() {
        return facilities;
    }

    /**
     * D�finit la valeur de la propri�t� facilities.
     * 
     */
    public void setFacilities(long value) {
        this.facilities = value;
    }

    /**
     * Obtient la valeur de la propri�t� holds.
     * 
     */
    public long getHolds() {
        return holds;
    }

    /**
     * D�finit la valeur de la propri�t� holds.
     * 
     */
    public void setHolds(long value) {
        this.holds = value;
    }

}
