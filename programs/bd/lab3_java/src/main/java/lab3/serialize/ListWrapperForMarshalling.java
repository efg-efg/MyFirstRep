package lab3.serialize;

import javax.xml.bind.annotation.*;
import javax.xml.bind.*;
import java.util.*;

import lab3.table.types.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "listFood")
public class ListWrapperForMarshalling {
    @XmlElement(name = "food")
    private List<Food> listElem = new ArrayList<Food>();
    public ListWrapperForMarshalling() {}
    public ListWrapperForMarshalling(List<Food> listElem) {
        this.listElem = listElem;
    }
    public List<Food> getList() {
        return listElem;
    }
    public void setList(List<Food> listElem) {
        this.listElem = listElem;
    }
}
