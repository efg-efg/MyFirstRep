package lab3.genxml;
import java.io.*;
import nu.xom.*;

public class XmlGenerator {
	private static final String ENCODING = "Cp1251";
	private String filename;
	private int numElements;
	private class Food {
		private int id;
		private String name;
		private int price;
		private String country;
		private String city;
		public Food(String inData) throws Exception {
			String[] arrData = inData.split("\t");
			id = Integer.parseInt(arrData[0]);
			name = arrData[1];
			price = Integer.parseInt(arrData[2]);
			country = arrData[4];
			city = arrData[3];
		}
		public int getId() { return id;}
		public String getName() { return name;}
		public int getPrice() { return price;}
		public String getCountry() { return country;}
		public String getCity() { return city;}
		private Element getFieldXML(String name, String value) {
			Element field = new Element(name);
			field.appendChild(value);
			return field;
		}

		public Element getXML() {
			Element food = new Element("food");
			food.appendChild(getFieldXML("id", String.valueOf(id)));
			food.appendChild(getFieldXML("name", name));
			food.appendChild(getFieldXML("price", String.valueOf(price)));
			food.appendChild(getFieldXML("country", country));
			food.appendChild(getFieldXML("city", city));
			return food;
		}
	}
	public XmlGenerator(String filename, int numElements) {
		this.filename = filename;
		this.numElements = numElements;
	}
	private void format(OutputStream os, Document doc) throws Exception {
		Serializer serializer = new Serializer(os, "utf-8");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}
	public void generateXML(String output) throws Exception {
		try {
			BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(filename), ENCODING));
			try {
				String readString;
				Element root = new Element("tableFood");
				int i=0;
				while((readString = fin.readLine())!=null && i++ < numElements) {
					root.appendChild(new Food(readString).getXML());
				}
				format(new BufferedOutputStream(new FileOutputStream(output)), new Document(root));
			} catch(Exception ex) {
				throw ex;
			} finally {
				fin.close();
			}
		} catch(Exception ex) {
			throw ex;
		}

	}
}
