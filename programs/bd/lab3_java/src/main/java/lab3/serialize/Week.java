package lab3.serialize;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.*;


/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 23.10.13
 * Time: 1:37
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enumWeek")
@XmlEnum
enum Week {
    @XmlEnumValue("MONDAY")
    MONDAY("MONDAY"),
    @XmlEnumValue("TUESDAY")
    TUESDAY("TUESDAY"),
    @XmlEnumValue("WEDNESDAY")
    WEDNESDAY("TUESDAY"),
    @XmlEnumValue("THURSDAY")
    THURSDAY("THURSDAY"),
    @XmlEnumValue("FRIDAY")
    FRIDAY("FRIDAY"),
    @XmlEnumValue("SATURDAY")
    SATURDAY("SATURDAY"),
    @XmlEnumValue("SUNDAY")
    SUNDAY("SUNDAY");
    private final String value;

    Week(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Week fromValue(String v) {
        for (Week c: Week.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
