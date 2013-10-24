package lab3.serialize;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import javax.xml.bind.*;
import javax.xml.validation.*;
import java.util.*;

import lab3.table.types.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */

public class Deserializer {
    private String[] xsds = new String[] {
        "xsds\\Consumer.xsd", "xsds\\Food.xsd", "xsds\\FoodContainer.xsd",
        "xsds\\Supplier.xsd", "xsds\\ComplexObject.xsd"
    };
    public Deserializer() {}
    public <T> T deserializeFromOneFile(Class<T> cl, String filename, String xsd) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(xsd));

        JAXBContext jc = JAXBContext.newInstance(cl);
        Unmarshaller unmarsh = jc.createUnmarshaller();
        unmarsh.setSchema(schema);
        unmarsh.setEventHandler(new MyValidationEventHandler());
        T res = (T)unmarsh.unmarshal(new FileInputStream(filename));
        return res;
    }
    public void deserializeFromFiles(List<String> filenames) throws Exception {
        try {
            Food objF = deserializeFromOneFile(Food.class, filenames.get(0), xsds[1]);
            System.out.println("Имя файла = " + filenames.get(0));
            System.out.println(objF);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Consumer objC = deserializeFromOneFile(Consumer.class, filenames.get(1), xsds[0]);
            System.out.println("Имя файла = " + filenames.get(1));
            System.out.println(objC);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Supplier objS = deserializeFromOneFile(Supplier.class, filenames.get(2), xsds[3]);
            System.out.println("Имя файла = " + filenames.get(2));
            System.out.println(objS);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void deserializeContainer(String filename) throws Exception {
        TableFood tableF = new TableFood();
        tableF = deserializeFromOneFile(TableFood.class, filename, xsds[2]);
        System.out.println("Имя файла = " + filename);
        for(Food meal : tableF.getMeals())
            System.out.println(meal);
    }
    public void deserializeComplexObject(String filename) throws Exception {
        ComplexObject compObj = deserializeFromOneFile(ComplexObject.class, filename, xsds[4]);
        System.out.println("Имя файла = " + filename);
        System.out.println(compObj);
    }
}
class MyValidationEventHandler implements ValidationEventHandler {

    public boolean handleEvent(ValidationEvent event) {
        System.out.println("\nEVENT");
        System.out.println("SEVERITY:  " + event.getSeverity());
        System.out.println("MESSAGE:  " + event.getMessage());
        System.out.println("LINKED EXCEPTION:  " + event.getLinkedException());
        System.out.println("LOCATOR");
        System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
        System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
        /*System.out.println("    OFFSET:  " + event.getLocator().getOffset());
        System.out.println("    OBJECT:  " + event.getLocator().getObject());
        System.out.println("    NODE:  " + event.getLocator().getNode());
        System.out.println("    URL:  " + event.getLocator().getURL());*/
        return true;
    }

}
