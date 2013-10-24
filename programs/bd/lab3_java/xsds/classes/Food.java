

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 9:05
 * To change this template use File | Settings | File Templates.
 */
import javax.xml.bind.annotation.*;


/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 9:06
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
class TabelType {
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



@XmlRootElement(name = "food")
public class Food extends TabelType {
    @XmlElement(name = "price", required = true)
    public int price;
    public Food(int price, int id, String name, String country, String city) {
        super(id, name, country, city);
        this.price = price;
    }
    public Food() {
        super();
    }
    @Override
    public String toString() {
        return super.toString() + ", price = " + price;
    }
}
