package beans;

import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleStringProperty customerId;
	private SimpleStringProperty firstName;
	private SimpleStringProperty middleInit;
	private SimpleStringProperty lastName;
	private SimpleStringProperty address;
	public Customer(){
		
	}
	public SimpleStringProperty getCustomerId() {
		return customerId;
	}
	public void setCustomerId(SimpleStringProperty customerId) {
		this.customerId = customerId;
	}
	public SimpleStringProperty getFirstName() {
		return firstName;
	}
	public void setFirstName(SimpleStringProperty firstName) {
		this.firstName = firstName;
	}
	public SimpleStringProperty getMiddleInit() {
		return middleInit;
	}
	public void setMiddleInit(SimpleStringProperty middleInit) {
		this.middleInit = middleInit;
	}
	public SimpleStringProperty getLastName() {
		return lastName;
	}
	public void setLastName(SimpleStringProperty lastName) {
		this.lastName = lastName;
	}
	public SimpleStringProperty getAddress() {
		return address;
	}
	public void setAddress(SimpleStringProperty address) {
		this.address = address;
	}
}
