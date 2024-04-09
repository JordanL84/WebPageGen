package model;

public class AnchorElement extends TagElement {
	
	private String linkText;
	private String url;
	
	public AnchorElement(String url, String linkText, String attributes) {
		super("a", true, new TextElement(linkText), attributes);
		if (attributes != null && !(attributes.isEmpty()))
			setAttributes("href=\"" + url + "\" " + attributes);
		else
			setAttributes("href=\"" + url + "\"");
		this.linkText = linkText;
		this.url = url;
	}
	
	public String getLinkText() {
		return linkText;
	}
	
	public String getUrlText() {
		return url;
	}
}
