package beans;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Receipt {
	private SimpleStringProperty receiptId;
	private SimpleStringProperty customerId;
	private IntegerProperty hour;
	private IntegerProperty minute;
	private IntegerProperty registerNo;
	private SimpleStringProperty employeeId;
	private SimpleStringProperty date;
	public Receipt () {
		
	}
	public SimpleStringProperty getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(SimpleStringProperty receiptId) {
		this.receiptId = receiptId;
	}
	public SimpleStringProperty getCustomerId() {
		return customerId;
	}
	public void setCustomerId(SimpleStringProperty customerId) {
		this.customerId = customerId;
	}
	public IntegerProperty getHour() {
		return hour;
	}
	public void setHour(IntegerProperty hour) {
		this.hour = hour;
	}
	public IntegerProperty getMinute() {
		return minute;
	}
	public void setMinute(IntegerProperty minute) {
		this.minute = minute;
	}
	public IntegerProperty getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(IntegerProperty registerNo) {
		this.registerNo = registerNo;
	}
	public SimpleStringProperty getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(SimpleStringProperty employeeId) {
		this.employeeId = employeeId;
	}
	public SimpleStringProperty getDate() {
		return date;
	}
	public void setDate(SimpleStringProperty date) {
		this.date = date;
	}
	
}
