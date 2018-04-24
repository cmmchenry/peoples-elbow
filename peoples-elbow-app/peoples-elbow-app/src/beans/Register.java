package beans;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Register {
	private SimpleStringProperty registerId;
	private SimpleStringProperty operatorEId;
	private SimpleStringProperty lastServiceDate;
	private DoubleProperty balance;
	public Register() {
		
	}
	public SimpleStringProperty getRegisterId() {
		return registerId;
	}
	public void setRegisterId(SimpleStringProperty registerId) {
		this.registerId = registerId;
	}
	public SimpleStringProperty getOperatorEId() {
		return operatorEId;
	}
	public void setOperatorEId(SimpleStringProperty operatorEId) {
		this.operatorEId = operatorEId;
	}
	public SimpleStringProperty getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(SimpleStringProperty lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public DoubleProperty getBalance() {
		return balance;
	}
	public void setBalance(DoubleProperty balance) {
		this.balance = balance;
	}
	
}
