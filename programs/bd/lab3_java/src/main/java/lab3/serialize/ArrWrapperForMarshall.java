package lab3.serialize;

import javax.xml.bind.annotation.*;
import javax.xml.bind.*;

import lab3.table.types.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 23:02
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "arrayConsumer")
public class ArrWrapperForMarshall {
    @XmlElement(name = "consumer")
    private Consumer[] arrElem;
    public ArrWrapperForMarshall() {}
    public ArrWrapperForMarshall(Consumer[] arrElem) {
        this.arrElem = arrElem;
    }
    public Consumer[] getArray() {
        return arrElem;
    }
    public void setArray(Consumer[] arrElem) {
        this.arrElem = arrElem;
    }
}
