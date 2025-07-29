
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour OperationAdviceResp complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="OperationAdviceResp">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RespHeader" type="{urn:schemas-attijariwafa-com:transaction-data}ResponseHeader"/>
 *         <element name="AdviceResp" type="{urn:schemas-attijariwafa-com:transaction-data}StandardResp"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationAdviceResp", propOrder = {
    "respHeader",
    "adviceResp"
})
public class OperationAdviceResp {

    @XmlElement(name = "RespHeader", required = true)
    protected ResponseHeader respHeader;
    @XmlElement(name = "AdviceResp", required = true)
    protected StandardResp adviceResp;

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
     * Obtient la valeur de la propri�t� adviceResp.
     * 
     * @return
     *     possible object is
     *     {@link StandardResp }
     *     
     */
    public StandardResp getAdviceResp() {
        return adviceResp;
    }

    /**
     * D�finit la valeur de la propri�t� adviceResp.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardResp }
     *     
     */
    public void setAdviceResp(StandardResp value) {
        this.adviceResp = value;
    }

}
