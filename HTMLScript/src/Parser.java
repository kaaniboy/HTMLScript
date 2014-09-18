import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;


public class Parser {
	private static final String FILE_LOCATION = "C://Users//Student//Desktop//HTMLScript//input.txt";
	private static String input = "";
	
	public static void main(String[] args) {
		loadInputCode();
		
		Document code = Jsoup.parse(input);
		
		Node main = code.select("code").get(0);
		for(Node n : main.childNodes()) {
			System.out.println(n.toString());
			System.out.println();
		}
		
		
	}
	
	public static void loadInputCode() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_LOCATION));
			
			String line = null;
			while((line = reader.readLine()) != null) {
				input += line;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
