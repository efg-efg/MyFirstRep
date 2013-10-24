package lab3.serialize;

import java.util.*;
import javax.xml.bind.annotation.*;

import lab3.table.types.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SuperClassComplexObject {
    @XmlElement
    private ListWrapperForMarshalling listFood =
            new ListWrapperForMarshalling(Arrays.asList(
                    new Food(613, 379, "Сахар", "Испания", "Севилья"),
                    new Food(568, 380, "Сахар", "Франция", "Париж"),
                    new Food(369, 381, "Консервы рыбные", "Германия", "Штутгарт")));

    @XmlElement
    private Supplier supplier = new Supplier(36, 580, "Белое море", "Петербург", "Россия");
    public SuperClassComplexObject() {}
    public List<Food> getListFood() {
        return listFood.getList();
    }
    public void setListFood(List<Food> listFood) {
        this.listFood.setList(listFood);
    }

    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    @Override
    public String toString() {
        return listFood.getList().toString() + "\n" + supplier.toString();
    }
}
