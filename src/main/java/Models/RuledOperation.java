
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour RuledOperation complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="RuledOperation">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <attribute name="ruleCode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="operRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="canal" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="operType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="operStatus" use="required" type="{urn:schemas-attijariwafa-com:transaction-data}StatusEnum" />
 *       <attribute name="account" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="amount" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       <attribute name="sens" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="operDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="valueDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="endDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="operLib" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="operLib2" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="operLib3" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="libCourt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RuledOperation")
public class RuledOperation {

    @XmlAttribute(name = "ruleCode", required = true)
    protected String ruleCode;
    @XmlAttribute(name = "operRef", required = true)
    protected String operRef;
    @XmlAttribute(name = "canal", required = true)
    protected String canal;
    @XmlAttribute(name = "operType", required = true)
    protected String operType;
    @XmlAttribute(name = "operStatus", required = true)
    protected StatusEnum operStatus;
    @XmlAttribute(name = "account", required = true)
    protected String account;
    @XmlAttribute(name = "amount", required = true)
    protected long amount;
    @XmlAttribute(name = "sens", required = true)
    protected String sens;
    @XmlAttribute(name = "operDate", required = true)
    protected String operDate;
    @XmlAttribute(name = "valueDate", required = true)
    protected String valueDate;
    @XmlAttribute(name = "endDate", required = true)
    protected String endDate;
    @XmlAttribute(name = "operLib", required = true)
    protected String operLib;
    @XmlAttribute(name = "operLib2", required = true)
    protected String operLib2;
    @XmlAttribute(name = "operLib3", required = true)
    protected String operLib3;
    @XmlAttribute(name = "libCourt", required = true)
    protected String libCourt;

    /**
     * Obtient la valeur de la propri�t� ruleCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleCode() {
        return ruleCode;
    }

    /**
     * D�finit la valeur de la propri�t� ruleCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleCode(String value) {
        this.ruleCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� operRef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperRef() {
        return operRef;
    }

    /**
     * D�finit la valeur de la propri�t� operRef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperRef(String value) {
        this.operRef = value;
    }

    /**
     * Obtient la valeur de la propri�t� canal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanal() {
        return canal;
    }

    /**
     * D�finit la valeur de la propri�t� canal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanal(String value) {
        this.canal = value;
    }

    /**
     * Obtient la valeur de la propri�t� operType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperType() {
        return operType;
    }

    /**
     * D�finit la valeur de la propri�t� operType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperType(String value) {
        this.operType = value;
    }

    /**
     * Obtient la valeur de la propri�t� operStatus.
     * 
     * @return
     *     possible object is
     *     {@link StatusEnum }
     *     
     */
    public StatusEnum getOperStatus() {
        return operStatus;
    }

    /**
     * D�finit la valeur de la propri�t� operStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusEnum }
     *     
     */
    public void setOperStatus(StatusEnum value) {
        this.operStatus = value;
    }

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
     * Obtient la valeur de la propri�t� amount.
     * 
     */
    public long getAmount() {
        return amount;
    }

    /**
     * D�finit la valeur de la propri�t� amount.
     * 
     */
    public void setAmount(long value) {
        this.amount = value;
    }

    /**
     * Obtient la valeur de la propri�t� sens.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSens() {
        return sens;
    }

    /**
     * D�finit la valeur de la propri�t� sens.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSens(String value) {
        this.sens = value;
    }

    /**
     * Obtient la valeur de la propri�t� operDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperDate() {
        return operDate;
    }

    /**
     * D�finit la valeur de la propri�t� operDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperDate(String value) {
        this.operDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� valueDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueDate() {
        return valueDate;
    }

    /**
     * D�finit la valeur de la propri�t� valueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueDate(String value) {
        this.valueDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� endDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * D�finit la valeur de la propri�t� endDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Obtient la valeur de la propri�t� operLib.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperLib() {
        return operLib;
    }

    /**
     * D�finit la valeur de la propri�t� operLib.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperLib(String value) {
        this.operLib = value;
    }

    /**
     * Obtient la valeur de la propri�t� operLib2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperLib2() {
        return operLib2;
    }

    /**
     * D�finit la valeur de la propri�t� operLib2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperLib2(String value) {
        this.operLib2 = value;
    }

    /**
     * Obtient la valeur de la propri�t� operLib3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperLib3() {
        return operLib3;
    }

    /**
     * D�finit la valeur de la propri�t� operLib3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperLib3(String value) {
        this.operLib3 = value;
    }

    /**
     * Obtient la valeur de la propri�t� libCourt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibCourt() {
        return libCourt;
    }

    /**
     * D�finit la valeur de la propri�t� libCourt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibCourt(String value) {
        this.libCourt = value;
    }

}
