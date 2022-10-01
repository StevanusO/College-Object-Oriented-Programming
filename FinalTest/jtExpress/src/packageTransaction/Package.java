package packageTransaction;

public class Package {
	private String packageId, itemID, recipientName, recipientAddress, userEmail;

	public Package(String packageId, String itemID, String recipientName, String recipientAddress, String userEmail) {
		super();
		this.packageId = packageId;
		this.itemID = itemID;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
		this.userEmail = userEmail;
	}
	

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
