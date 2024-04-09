package model;

public class TableElement extends TagElement {

	private Element[][] elements;
	
	public TableElement(int rows, int cols, String attributes) {
		super("table", true, new TextElement(""), attributes);
		elements = new Element[rows][cols];
	}
	
	public void addItem(int rowIndex, int colIndex, Element item) {
		elements[rowIndex][colIndex] = item;
	}
	
	public String genHTML(int indentation) {
		String result = Utilities.spaces(indentation) + getStartTag();
		for (int row = 0; row < elements.length; row++) {
			result += "\n" + Utilities.spaces(indentation+3) + "<tr>";
			for (int col = 0; col < elements[0].length; col++) {
				if (elements[row][col] != null)
					result += "<td>" + elements[row][col].genHTML(indentation) + "</td>";
				else 
					result += "<td></td>";
			}
			result += "</tr>";
		}
		result += "\n" + Utilities.spaces(indentation) + getEndTag();
		return result;
	}
	
	public double getTableUtilization() {
		int amount = 0;
		for (int row = 0; row < elements.length; row++) {
			for (int col = 0; col < elements[0].length; col++) {
				if (elements[row][col] != null)
					amount += 1;
			}
		}
		return (double)(amount) / (elements.length * elements[0].length) * 100;
	}
}

