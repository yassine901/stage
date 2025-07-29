
package Models;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Classe Java pour ReplyFormatEnum.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="ReplyFormatEnum">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="FULL"/>
 *     <enumeration value="NONE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "ReplyFormatEnum")
@XmlEnum
public enum ReplyFormatEnum {

    FULL,
    NONE;

    public String value() {
        return name();
    }

    public static ReplyFormatEnum fromValue(String v) {
        return valueOf(v);
    }

}
