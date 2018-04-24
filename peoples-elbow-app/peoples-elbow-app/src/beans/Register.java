package beans;

public class Register {
	private String registerId;
	private String operatorEId;
	private String lastServiceDate;
	private double balance;
	public Register() {
		
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public String getOperatorEId() {
		return operatorEId;
	}
	public void setOperatorEId(String operatorEId) {
		this.operatorEId = operatorEId;
	}
	public String getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
