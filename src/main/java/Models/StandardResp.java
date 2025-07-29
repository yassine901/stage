
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour StandardResp complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="StandardResp">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="NewAvailBal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardResp", propOrder = {
    "account",
    "newAvailBal"
})
public class StandardResp {

    @XmlElement(name = "Account")
    protected String account;
    @XmlElement(name = "NewAvailBal")
    protected Long newAvailBal;

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
     * Obtient la valeur de la propri�t� newAvailBal.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNewAvailBal() {
        return newAvailBal;
    }

    /**
     * D�finit la valeur de la propri�t� newAvailBal.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNewAvailBal(Long value) {
        this.newAvailBal = value;
    }

}
