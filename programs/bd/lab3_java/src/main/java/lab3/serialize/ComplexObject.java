package lab3.serialize;

import javax.xml.bind.annotation.*;
import java.util.*;

import lab3.table.types.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ComplexObject extends SuperClassComplexObject {
    @XmlElement
    private ArrWrapperForMarshall arrayConsumer =
            new ArrWrapperForMarshall(new Consumer[] {
                    new Consumer("Рынок", 819, "Казачок", "Франция", "Париж"),
                    new Consumer("Супермаркет", 820, "Три тополя", "США", "Портленд"),
                    new Consumer("Ресторан", 821, "Бургомистр", "Испания", "Сарагоса")
            });
    @XmlElement(name = "days", required = true)
    public Week days;
    public Consumer[] getArrConsumer() {
        return arrayConsumer.getArray();
    }
    public void setArrConsumer(Consumer[] arrConsumer) {
        this.arrayConsumer.setArray(arrConsumer);
    }
    @Override
    public String toString() {
        String str = Arrays.toString(arrayConsumer.getArray());
        return super.toString()+"\n"+str;
    }



}

