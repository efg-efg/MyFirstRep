package lab3.table.types;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 9:05
 * To change this template use File | Settings | File Templates.
 */
import javax.xml.bind.annotation.*;
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
