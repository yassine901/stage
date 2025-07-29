
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour SimpleAccount complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="SimpleAccount">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <attribute name="numero" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="acctStatus" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="codeBilan" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="bilanDescription" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="realBal" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       <attribute name="availBal" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleAccount")
public class SimpleAccount {

    @XmlAttribute(name = "numero", required = true)
    protected String numero;
    @XmlAttribute(name = "acctStatus", required = true)
    protected String acctStatus;
    @XmlAttribute(name = "codeBilan", required = true)
    protected String codeBilan;
    @XmlAttribute(name = "bilanDescription", required = true)
    protected String bilanDescription;
    @XmlAttribute(name = "realBal", required = true)
    protected long realBal;
    @XmlAttribute(name = "availBal", required = true)
    protected long availBal;

    /**
     * Obtient la valeur de la propri�t� numero.
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
     * D�finit la valeur de la propri�t� numero.
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
     * Obtient la valeur de la propri�t� acctStatus.
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
     * D�finit la valeur de la propri�t� acctStatus.
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
     * Obtient la valeur de la propri�t� codeBilan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeBilan() {
        return codeBilan;
    }

    /**
     * D�finit la valeur de la propri�t� codeBilan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeBilan(String value) {
        this.codeBilan = value;
    }

    /**
     * Obtient la valeur de la propri�t� bilanDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBilanDescription() {
        return bilanDescription;
    }

    /**
     * D�finit la valeur de la propri�t� bilanDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBilanDescription(String value) {
        this.bilanDescription = value;
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

}
