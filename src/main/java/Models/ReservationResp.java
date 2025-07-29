
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ReservationResp complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="ReservationResp">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RespHeader" type="{urn:schemas-attijariwafa-com:transaction-data}ResponseHeader"/>
 *         <element name="ReserveResp" type="{urn:schemas-attijariwafa-com:transaction-data}StandardResp"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReservationResp", propOrder = {
    "respHeader",
    "reserveResp"
})
public class ReservationResp {

    @XmlElement(name = "RespHeader", required = true)
    protected ResponseHeader respHeader;
    @XmlElement(name = "ReserveResp", required = true)
    protected StandardResp reserveResp;

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
     * Obtient la valeur de la propri�t� reserveResp.
     * 
     * @return
     *     possible object is
     *     {@link StandardResp }
     *     
     */
    public StandardResp getReserveResp() {
        return reserveResp;
    }

    /**
     * D�finit la valeur de la propri�t� reserveResp.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardResp }
     *     
     */
    public void setReserveResp(StandardResp value) {
        this.reserveResp = value;
    }

}
