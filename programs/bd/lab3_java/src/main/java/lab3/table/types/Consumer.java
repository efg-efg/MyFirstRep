package lab3.table.types;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 9:10
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "consumer")
public class Consumer extends TabelType {
    @XmlElement(name = "type", required = true)
    public String type;
    public Consumer(String type, int id, String name, String country, String city) {
        super(id, name, country, city);
        this.type = type;
    }
    public Consumer() {
        super();
    }
    @Override
    public String toString() {
        return super.toString() + ", type = " + type;
    }
}
