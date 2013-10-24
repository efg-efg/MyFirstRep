package lab3.serialize;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 9:03
 * To change this template use File | Settings | File Templates.
 */
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;

import lab3.table.types.*;

public class CollectionSerialization {
    private List<Food> listTable = new ArrayList<Food>();
    private Food objF = new Food(3139, 1, "Мука пшеничная", "Мюнхен", "Германия");
    private Consumer objC = new Consumer("Гипермаркет", 81, "Маэстро", "Лион", "Франция");
    private Supplier objS = new Supplier(78, 5, "Ашан", "Мадрид","Испания");
    /*private Food createFood() {
        Food res = new Food();
        res.id = 1; res.price = 500; res.name = "Консервы рыбные";
        res.city = "Краснодар"; res.country = "Россия";
        return res;
    }
    private Consumer createConsumer() {
        Consumer res = new Consumer();
        res.id = 2; res.name = "Маэстро"; res.type = "Гипермаркет";
        res.city = "Лион"; res.country = "Франция";
        return res;
    }
    private Supplier createSupplier() {
        Supplier res = new Supplier();
        res.id = 3; res.name = "Ашан"; res.city = "Мадрид";
        res.country = "Испания"; res.rating = 19;
        return res;
    }*/
    public CollectionSerialization() {
        listTable.add(objF);
        listTable.add(new Food(174, 2, "Консервы рыбные", "Краснодар", "Россия"));
        listTable.add(new Food(4950, 8, "Окорок свиной", "Париж", "Франция"));
    }
    private <T> void marshallElement(T obj, /*Class<T> cl,*/ String filename) throws Exception {
        Class<? extends Object> cl = obj.getClass();
        JAXBContext jc = JAXBContext.newInstance(obj.getClass()/*lab3.table.types*/);
        Marshaller marsh = jc.createMarshaller();
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marsh.marshal(obj, new FileOutputStream(filename));
    }
    public void serializeThreeObjects(String filename) throws Exception {
        marshallElement(objF, "ObjF" + filename);
        marshallElement(objC, "ObjC" + filename);
        marshallElement(objS, "ObjS" + filename);


    }
    public void serializeContaner(String filename) throws Exception {
        marshallElement(new TableFood(listTable), "ListTable" + filename);
    }
    public void serializeComplexObject(String filename) throws Exception {
        marshallElement(new ComplexObject(), filename);
    }
}
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tableFood")
class TableFood {
    @XmlElement(name = "food", type = Food.class)
    private List<Food> meals = new ArrayList<Food>();
    public TableFood() {}
    public TableFood(List<Food> meals) {
        this.meals = meals;
    }
    public List<Food> getMeals() {
        return meals;
    }
    public void setMeals(List<Food> meals) {
        this.meals = meals;
    }
}
