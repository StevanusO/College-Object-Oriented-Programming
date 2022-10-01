package component;

public class electronicItem extends Item {
	private int warranty;
	
	public electronicItem(String itemID, String itemName, double weight, int warranty) {
		super(itemID, itemName, weight);
		this.warranty = warranty;
	}
	
	
	
	@Override
	public void display() {
		System.out.println(getItemName() + " " + getItemID() + " Electronic " +  getWeight() + " " + getWarranty() + " -");
	}
	
	
	public int getWarranty() {
		return warranty;
	}



	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}




}
