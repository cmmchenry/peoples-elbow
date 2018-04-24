package beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Purchase {	
	private SimpleStringProperty itemId;
	private IntegerProperty quantity;
	private SimpleStringProperty receiptId;
	public Purchase (){
		
	}
	public SimpleStringProperty getItemId() {
		return itemId;
	}
	public void setItemId(SimpleStringProperty itemId) {
		this.itemId = itemId;
	}
	public IntegerProperty getQuantity() {
		return quantity;
	}
	public void setQuantity(IntegerProperty quantity) {
		this.quantity = quantity;
	}
	public SimpleStringProperty getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(SimpleStringProperty receiptId) {
		this.receiptId = receiptId;
	}
	
}
