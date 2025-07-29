
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour RequestHeader complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="RequestHeader">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <attribute name="canal" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="user" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="password" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="signature" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="correlationId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="ts" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="replyFormat" use="required" type="{urn:schemas-attijariwafa-com:transaction-data}ReplyFormatEnum" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestHeader")
public class RequestHeader {

    @XmlAttribute(name = "canal", required = true)
    protected String canal;
    @XmlAttribute(name = "user", required = true)
    protected String user;
    @XmlAttribute(name = "password", required = true)
    protected String password;
    @XmlAttribute(name = "signature", required = true)
    protected String signature;
    @XmlAttribute(name = "correlationId", required = true)
    protected String correlationId;
    @XmlAttribute(name = "ts", required = true)
    protected String ts;
    @XmlAttribute(name = "replyFormat", required = true)
    protected ReplyFormatEnum replyFormat;

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
     * Obtient la valeur de la propri�t� user.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * D�finit la valeur de la propri�t� user.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Obtient la valeur de la propri�t� password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * D�finit la valeur de la propri�t� password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtient la valeur de la propri�t� signature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * D�finit la valeur de la propri�t� signature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
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

    /**
     * Obtient la valeur de la propri�t� ts.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTs() {
        return ts;
    }

    /**
     * D�finit la valeur de la propri�t� ts.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTs(String value) {
        this.ts = value;
    }

    /**
     * Obtient la valeur de la propri�t� replyFormat.
     * 
     * @return
     *     possible object is
     *     {@link ReplyFormatEnum }
     *     
     */
    public ReplyFormatEnum getReplyFormat() {
        return replyFormat;
    }

    /**
     * D�finit la valeur de la propri�t� replyFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyFormatEnum }
     *     
     */
    public void setReplyFormat(ReplyFormatEnum value) {
        this.replyFormat = value;
    }

}
