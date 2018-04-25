package beans;

public class Query3 {
	private String firstName;
	private String lastName;
	private int amountOfReceipts;
	private int averageReceiptPrice;
	private int averageAmountOfItems;
	public Query3(String firstName, String lastName, int amountOfReceipts, int averageReceiptPrice, int averageAmountOfItems) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.amountOfReceipts = amountOfReceipts;
		this.averageReceiptPrice = averageReceiptPrice;
		this.averageAmountOfItems = averageAmountOfItems;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAmountOfReceipts() {
		return amountOfReceipts;
	}
	public void setAmountOfReceipts(int amountOfreceipts) {
		this.amountOfReceipts = amountOfreceipts;
	}
	public int getAverageReceiptPrice() {
		return averageReceiptPrice;
	}
	public void setAverageReceiptPrice(int averageReceiptPrice) {
		this.averageReceiptPrice = averageReceiptPrice;
	}
	public int getAverageAmountOfItems() {
		return averageAmountOfItems;
	}
	public void setAverageAmountOfItems(int averageAmountOfItems) {
		this.averageAmountOfItems = averageAmountOfItems;
	}
}
