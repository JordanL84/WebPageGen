package model;

import java.util.*;

public class WebPage implements Comparable<WebPage> {

	String title;
	ArrayList<Element> elements;
	
	public WebPage(String title) {
		this.title = title;
		elements = new ArrayList<Element>();
	}
	
	public int addElement(Element element) {
		if (element instanceof TagElement) {
			elements.add(element);
			return ((TagElement)element).getId();
		}
		else
			return -1;
	}
	
	public String getWebPageHTML(int indentation) {
		String result = "<!doctype html>\n" + "<html>\n";
		result += Utilities.spaces(indentation)+"<head>\n"+Utilities.spaces(indentation+3)+
				"<meta charset=\"utf-8\"/>\n"+Utilities.spaces(indentation+3)+"<title>"+
				title+"</title>\n"+Utilities.spaces(indentation)+"</head>\n" +
				Utilities.spaces(indentation)+"<body>";
		for (Element element : elements) {
			if (element instanceof TextElement)
				result += "\n"+Utilities.spaces(indentation)+
						((TextElement)element).genHTML(indentation);
			else
				result += "\n" + element.genHTML(indentation);
		}
		result += "\n" + Utilities.spaces(indentation) + "</body>\n" + "</html>";
		return result;
	}
	
	public void writeToFile(String filename, int indentation) {
		Utilities.writeToFile(filename, getWebPageHTML(indentation));
	}
	
	public Element findElem(int id) {
		for (Element element : elements) {
			if (((TagElement)element).getId() == id)
				return element;
		}
		return null;
	}
	
	public String stats() {
		int lists = 0;
		int paragraphs = 0;
		int tables = 0;
		double tableUtilization = 0;
		for (Element element : elements) {
			if (element instanceof ListElement)
				lists += 1;
			else if (element instanceof ParagraphElement)
				paragraphs += 1;
			else if (element instanceof TableElement) {
				tables += 1;
				tableUtilization += ((TableElement)element).getTableUtilization();
			}
		}
		return "List Count: " + lists + "\nParagraph Count: " + paragraphs + "\nTable Count: "+
				tables + "\nTableElement Utilization: " + tableUtilization/tables;
	}
	
	public int compareTo(WebPage webpage) {
		return this.title.compareTo(webpage.title);
	}
	
	public static void enableId(boolean choice) {
		TagElement.enableId(choice);
	}
}
