package component;

public abstract class Item {
	protected String itemID, itemName;
	protected double weight;
	
	public abstract void display();

	public Item(String itemID, String itemName, double weight) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.weight = weight;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
