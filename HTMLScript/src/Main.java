import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

public class Main {
	private static final String FILE_LOCATION = "C://Users//Student//Desktop//HTMLScript//input.txt";
	private static String input = "";

	public static void main(String[] args) {
		loadCode();
		Document code = Jsoup.parse(input);

		Node body = code.select("code").get(0);
		String output = parseChildren(body);

		System.out.println(output);
	}

	public static void loadCode() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					FILE_LOCATION));

			String line = null;
			while ((line = reader.readLine()) != null) {
				input += line;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String parseChildren(Node n) {
		String result = "";
		for (Node node : n.childNodes()) {
			result += parseStructure(node);
		}
		return result;
	}

	public static String parseStructure(Node n) {
		String structure = n.nodeName();

		if (structure.equals("function")) {
			return Parser.parseFunction(n);
		} else if (structure.equals("if")) {
			return Parser.parseIf(n);
		} else if(structure.equals("var")) {
			return Parser.ParseVarDeclaration(n);
		}

		return "";
	}
}
