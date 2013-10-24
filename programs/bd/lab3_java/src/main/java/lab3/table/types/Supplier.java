package lab3.table.types;
import javax.xml.bind.annotation.*;
/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 9:11
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "supplier")
public class Supplier extends TabelType {
    @XmlElement(name = "rating", required = true)
    public int rating;
    public Supplier(int rating, int id, String name, String city, String country) {
        super(id, name, country, city);
        this.rating = rating;
    }
    public Supplier() {
        super();
    }
    @Override
    public String toString() {
        return super.toString() + ", rating = " + rating;
    }
}
