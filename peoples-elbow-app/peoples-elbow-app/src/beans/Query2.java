package beans;

public class Query2 {
	private String itemName;
	private int totalQuantity;

	public Query2(String itemName, int totalQuantity) {
		this.itemName = itemName;
		this.totalQuantity = totalQuantity;
	}
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
}
