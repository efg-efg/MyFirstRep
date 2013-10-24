

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
@XmlRootElement (name = "food")
public class FoodWithoutInherit {
    @XmlAttribute
    public int id;
    @XmlElement
    public String name;
    @XmlElement
    public String country;
    @XmlElement
    public String city;
	@XmlElement(name = "price", required = true)
	public int price;
    public FoodWithoutInherit() {}
    public FoodWithoutInherit(int id, String name, String country, String city, int price) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
		this.price = price;
    }
    @Override
    public String toString() {
        return "id = " + id + ", name = " + name + ", country = " + country + ", city = " + city + ", price = " + price;
    }
}



