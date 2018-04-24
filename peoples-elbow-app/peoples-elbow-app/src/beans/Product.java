package beans;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;

public class Product {
	private SimpleStringProperty itemId;
	private SimpleStringProperty itemName;
	private IntegerProperty stock;
	private DoubleProperty price;
 	
 	public Product() {
 		
 	}
 	
	public SimpleStringProperty getItemId() {
		return itemId;
	}

	public void setItemId(SimpleStringProperty itemId) {
		this.itemId = itemId;
	}

	public SimpleStringProperty getItemName() {
		return itemName;
	}

	public void setItemName(SimpleStringProperty itemName) {
		this.itemName = itemName;
	}

	public IntegerProperty getStock() {
		return stock;
	}

	public void setStock(IntegerProperty stock) {
		this.stock = stock;
	}

	public DoubleProperty getPrice() {
		return price;
	}

	public void setPrice(DoubleProperty price) {
		this.price = price;
	}
}
