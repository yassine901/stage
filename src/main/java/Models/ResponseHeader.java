
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ResponseHeader complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="ResponseHeader">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReturnCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="ReturnMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *       <attribute name="canal" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="correlationId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseHeader", propOrder = {
    "returnCode",
    "errorCode",
    "returnMessage"
})
public class ResponseHeader {

    @XmlElement(name = "ReturnCode")
    protected int returnCode;
    @XmlElement(name = "ErrorCode", required = true)
    protected String errorCode;
    @XmlElement(name = "ReturnMessage", required = true)
    protected String returnMessage;
    @XmlAttribute(name = "canal", required = true)
    protected String canal;
    @XmlAttribute(name = "correlationId", required = true)
    protected String correlationId;

    /**
     * Obtient la valeur de la propri�t� returnCode.
     * 
     */
    public int getReturnCode() {
        return returnCode;
    }

    /**
     * D�finit la valeur de la propri�t� returnCode.
     * 
     */
    public void setReturnCode(int value) {
        this.returnCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� errorCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * D�finit la valeur de la propri�t� errorCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Obtient la valeur de la propri�t� returnMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnMessage() {
        return returnMessage;
    }

    /**
     * D�finit la valeur de la propri�t� returnMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnMessage(String value) {
        this.returnMessage = value;
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
     * Obtient la valeur de la propri�t� correlationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * D�finit la valeur de la propri�t� correlationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

}
