package model;

import java.util.*;

public class ParagraphElement extends TagElement {
	
	ArrayList<Element> elements;
	
	public ParagraphElement(String attributes) {
		super("p", true, new TextElement(""), attributes);
		elements = new ArrayList<Element>();
	}
	
	public void addItem(Element item) {
		elements.add(item);
	}
	
	public String genHTML(int indentation) {
		String paragraph = Utilities.spaces(indentation) + getStartTag();
		for (Element element : elements) {
			if (element instanceof TextElement)
				paragraph += "\n" + Utilities.spaces(indentation + 3) +
				element.genHTML(indentation);
			else
				paragraph += "\n" + element.genHTML(indentation + 3);
		}
		paragraph += "\n" + Utilities.spaces(indentation) + getEndTag();
		return paragraph;
	}
}
