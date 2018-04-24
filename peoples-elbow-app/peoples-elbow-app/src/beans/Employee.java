package beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;

public class Employee {
	private SimpleStringProperty employeeId;
	private SimpleStringProperty ssn;
	private SimpleStringProperty address;
	private SimpleStringProperty firstName;
	private SimpleStringProperty middleInit;
	private SimpleStringProperty lastName;
	private DoubleProperty hourlyRate;
	private DoubleProperty salary;
	public Employee() {
		
	}
	public SimpleStringProperty getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(SimpleStringProperty employeeId) {
		this.employeeId = employeeId;
	}
	public SimpleStringProperty getSsn() {
		return ssn;
	}
	public void setSsn(SimpleStringProperty ssn) {
		this.ssn = ssn;
	}
	public SimpleStringProperty getAddress() {
		return address;
	}
	public void setAddress(SimpleStringProperty address) {
		this.address = address;
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
	public DoubleProperty getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(DoubleProperty hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public DoubleProperty getSalary() {
		return salary;
	}
	public void setSalary(DoubleProperty salary) {
		this.salary = salary;
	}
}
