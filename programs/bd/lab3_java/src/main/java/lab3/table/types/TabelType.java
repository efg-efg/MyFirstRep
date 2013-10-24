package lab3.table.types;

import javax.xml.bind.annotation.*;


/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 9:06
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class TabelType {
    @XmlAttribute
    public int id;
    @XmlElement
    public String name;
    @XmlElement
    public String country;
    @XmlElement
    public String city;
    public TabelType() {}
    public TabelType(int id, String name, String country, String city) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
    }
    @Override
    public String toString() {
        return "id = " + id + ", name = " + name + ", country = " + country + ", city = " + city;
    }
}
