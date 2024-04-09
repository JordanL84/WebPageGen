package model;

public class TagElement implements Element {
	
	private String tagName;
	private boolean endTag;
	private Element content;
	private String attributes;
	private static int idNum = 0;
	private int id;
	private static boolean enableId = true;
	
	public TagElement(String tagName, boolean endTag, Element content, String attributes) {
		this.tagName = tagName;
		this.endTag = endTag;
		this.content = content;
		this.attributes = attributes;
		id = idNum + 1;
		idNum += 1;
	}
	
	public int getId() {
		return id;
	}
	
	public String getStringId() {
		return tagName + " id=\"" + tagName + id + "\"";
	}
	
	public String getStartTag() {
		if (enableId) {
			if (attributes != null && !(attributes.isEmpty())) 
				return "<" + getStringId() + " " + attributes + ">";
			else
				return "<" + getStringId() + ">";
		}
		else {
			if (attributes != null && !(attributes.isEmpty()))
				return "<" + tagName + " " + attributes + ">";
			else
				return "<" + tagName + ">";
		}
				
	}
	
	public String getEndTag() {
		if (endTag) 
			return "</" + tagName + ">";
		else 
			return "";
	}
	
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	
	public static void resetIds() {
		idNum = 0;
	}
	
	public static void enableId(boolean choice) {
		enableId = choice;
	}
	
	
	public static boolean getEnableId() {
		return enableId;
	}
	
	public String genHTML(int indentation) {
		String result = Utilities.spaces(indentation);
		result += getStartTag() + content.genHTML(indentation);
		if (endTag)
			result += getEndTag();
		return result;
	}
}
