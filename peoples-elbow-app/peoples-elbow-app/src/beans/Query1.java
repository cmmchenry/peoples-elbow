package beans;

public class Query1 {
	private String receiptId;
	private String date;
	private String itemName;
	private String itemQuantity;
	
	public Query1(String receiptId, String date, String itemName, String itemQuantity) {
		this.receiptId = receiptId;
		this.date = date;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
	}
	public String getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
}
