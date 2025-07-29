
package Models;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>Classe Java pour RuleEnum.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * <pre>{@code
 * <simpleType name="RuleEnum">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="RESER"/>
 *     <enumeration value="RESAD"/>
 *     <enumeration value="OPADV"/>
 *     <enumeration value="OPUPD"/>
 *     <enumeration value="OPCAN"/>
 *     <enumeration value="OPPAY"/>
 *     <enumeration value="OPCHK"/>
 *     <enumeration value="OPTRA"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "RuleEnum")
@XmlEnum
public enum RuleEnum {

    RESER,
    RESAD,
    OPADV,
    OPUPD,
    OPCAN,
    OPPAY,
    OPCHK,
    OPTRA;

    public String value() {
        return name();
    }

    public static RuleEnum fromValue(String v) {
        return valueOf(v);
    }

}
