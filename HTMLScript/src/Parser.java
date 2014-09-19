import org.jsoup.nodes.Node;


public class Parser {
	public static String parseFunction(Node n) {
		String name = n.attr("name");
		
		return String.format("function %s(){\n%s\n}\n", name, Main.parseChildren(n));
	}
	
	public static String parseIf(Node n) {
		String condition = n.attr("condition");

		return String.format("if(%s) {\n%s\n}\n", condition, Main.parseChildren(n));
	}
	
	public static String parseElseIf(Node n) {
		String condition = n.attr("condition");
		
		return String.format("else if(%s) {\n%s\n}\n", condition, Main.parseChildren(n));
	}
	
	public static String ParseVarDeclaration(Node n) {
		String name = n.attr("name");
		String value = n.attr("value");
		
		return String.format("var %s = %s;\n", name, value);
	}
	
	public static String ParseInvocation(Node n) {
		String name = n.attr("name");
		
		return String.format("%s();\n", name);
	}
	
	public static String ParsePrint(Node n) {
		String params = n.attr("params");
		return String.format("console.log(%s);", params);
	}
}
