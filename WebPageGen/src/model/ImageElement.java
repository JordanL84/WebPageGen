package model;

public class ImageElement extends TagElement {
	
	private String imageURL;
	
	public ImageElement(String imageURL, int width, int height, String alt, String attributes) {
		super("img", false, new TextElement(""), attributes);
		if (attributes != null && !(attributes.isEmpty())) 
			setAttributes("src=\"" + imageURL + "\" width=\"" + width + 
					"\" height=\"" + height + "\" alt=\"" + alt + "\" " + attributes);
		else
			setAttributes("src=\"" + imageURL+ "\" width=\"" + width + "\" height=\"" + 
					height + "\" alt=\"" + alt + "\"");
		this.imageURL = imageURL;
	}
	
	public String getImageURL() {
		return imageURL;
	}
}
