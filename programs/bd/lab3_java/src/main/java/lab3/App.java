package lab3;
import java.io.*;
import lab3.genxml.*;
public class App {
	private static final int EXIT = 0;
	private static final int GENXML = 1;
	private static final int SHOWNODES = 2;
	private static final int XMLXML = 3;
	private static void showMenu() {
		System.out.println("Меню");
		System.out.println("1-Считать документ и сгенерировать xml");
		System.out.println("2-Считать xml и вывести тип, имя, значение каждого узла");
		System.out.println("3-XML-XML преобразование");
		System.out.println(EXIT + "-Выйти");
	}
	private static int chooseMenu() throws Exception {
		showMenu();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> ");
		int result = Integer.parseInt(stdin.readLine());
		return result;
	}
	private static void drawLine() {
		System.out.println("--------------------------------------------");
	}
	private static void workWithChosen(int chosen) throws Exception {
		drawLine();
		switch(chosen) {
		case GENXML:
			XmlGenerator xmlgnr = new XmlGenerator("TableFood.txt", 5);
			xmlgnr.generateXML("outFoodTable.xml");
			break;
		case SHOWNODES:
			System.out.println(SHOWNODES);
			break;
		case XMLXML:
			System.out.println(XMLXML);
			break;
		default:
			break;
		}
		drawLine();
	}
	private static void workCycle() throws Exception {
		int chosen;
		while((chosen =chooseMenu()) != EXIT) {
			workWithChosen(chosen);
		}
	}
    public static void main( String[] args ) {
		try {
			workCycle();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
    }
}
