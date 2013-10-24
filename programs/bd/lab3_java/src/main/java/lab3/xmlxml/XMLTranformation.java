package lab3.xmlxml;
import javax.xml.stream.*;
import java.io.FileReader;
import java.io.FileWriter;
import javax.xml.stream.events.*;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 22.10.13
 * Time: 3:50
 * To change this template use File | Settings | File Templates.
 */
public class XMLTranformation {
    private String input;
    private String location;
    public XMLTranformation(String input) {
        this.input = input;
    }
    private XMLStreamReader getXMLStreamReader(String input) throws Exception {
        XMLInputFactory fact = XMLInputFactory.newInstance();
        return fact.createXMLStreamReader(new FileReader(input));
    }
    private XMLStreamWriter getXMLStreamWriter(String output) throws Exception {
        XMLOutputFactory fact = XMLOutputFactory.newInstance();
        return fact.createXMLStreamWriter(new FileWriter(output));
    }
    private boolean isCityOrCountry(String name) {
        return name == "country" || name == "city";
    }
    private void writeElementWithEnd(XMLStreamWriter xmlw, String nameTag, String data) throws Exception {
        xmlw.writeStartElement(nameTag);
        xmlw.writeCharacters(data);
        xmlw.writeEndElement();
    }
    private void writeElementWithoutEnd(XMLStreamWriter xmlw, String nameTag, String data) throws Exception {
        xmlw.writeStartElement(nameTag);
        xmlw.writeCharacters(data);
    }
    private void writeElement(XMLStreamReader xmlr, XMLStreamWriter xmlw) throws Exception{
        if(xmlr.getEventType() == XMLEvent.START_ELEMENT) {
            String tagName = xmlr.getLocalName().trim();
            xmlr.next();
            if(tagName == "country") {
                location = xmlr.getText();
            } else if(tagName == "city") {
                location = xmlr.getText() + ", "+location;
                writeElementWithEnd(xmlw, "location", location);
            } else
                writeElementWithoutEnd(xmlw, tagName, xmlr.getText());
        }
        if(xmlr.getEventType() == XMLEvent.END_ELEMENT) {
            String tagName = xmlr.getLocalName().trim();
            if(!isCityOrCountry(tagName))
                xmlw.writeEndElement();
        }


    }
    public void transformToLocation(String output) throws Exception{
        XMLStreamReader xmlr = getXMLStreamReader(input);
        try {
            XMLStreamWriter xmlw = getXMLStreamWriter(output);

            try {
                xmlw.writeStartDocument("utf-8","1.0");
                while(xmlr.hasNext()) {
                    xmlr.next();
                    writeElement(xmlr, xmlw);
                }
                xmlw.writeEndDocument();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                xmlw.flush();
                xmlw.close();
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            xmlr.close();
        }




    }
}
