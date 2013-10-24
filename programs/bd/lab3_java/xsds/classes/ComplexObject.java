

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
                    new Food(613, 379, "�����", "�������", "�������"),
                    new Food(568, 380, "�����", "�������", "�����"),
                    new Food(369, 381, "�������� ������", "��������", "��������")));

    @XmlElement
    private Supplier supplier = new Supplier(36, 580, "����� ����", "���������", "������");
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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ComplexObject extends SuperClassComplexObject {
    @XmlElement
    private ArrWrapperForMarshall arrayConsumer =
            new ArrWrapperForMarshall(new Consumer[] {
                    new Consumer("�����", 819, "�������", "�������", "�����"),
                    new Consumer("�����������", 820, "��� ������", "���", "��������"),
                    new Consumer("��������", 821, "����������", "�������", "��������")
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

