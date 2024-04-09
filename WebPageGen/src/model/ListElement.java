package model;

import java.util.ArrayList;

public class ListElement extends TagElement {
	
	ArrayList<Element> elements;
	
	public ListElement(boolean ordered, String attributes) {
		super(ListElement.getOrdered(ordered), true, null, attributes);
		elements = new ArrayList<Element>();
	}
	
	public void addItem(Element item) {
		elements.add(item);
	}
	
	public static String getOrdered(boolean ordered) {
		if (ordered)
			return "ol";
		else
			return "ul";
	}
	
	public String genHTML(int indentation) {
		String result = Utilities.spaces(indentation) + getStartTag();
		for (Element element : elements) {
			result += "\n" + Utilities.spaces(indentation+3) + "<li>\n";
			if (element instanceof TextElement)
				result += Utilities.spaces(indentation+6);
			result += element.genHTML(indentation+6)+"\n"+Utilities.spaces(indentation+3)+"</li>";
		}
		result += "\n" + Utilities.spaces(indentation) + getEndTag();
		return result;
	}
}
