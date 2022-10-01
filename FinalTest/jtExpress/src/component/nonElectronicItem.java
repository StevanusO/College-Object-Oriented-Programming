package component;

public class nonElectronicItem extends Item {

	private int fragile;
	
	
	public nonElectronicItem(String itemID, String itemName, double weight, int fragile) {
		super(itemID, itemName, weight);
		this.fragile = fragile;
	}


	public int getFragile() {
		return fragile;
	}


	public void setFragile(int fragile) {
		this.fragile = fragile;
	}


	@Override
	public void display() {
		System.out.println(getItemName() + " " + getItemID() + " Electronic " +  getWeight() + " " + " - " + getFragile());
	}

}
