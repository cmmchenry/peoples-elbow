package beans;

public class Query5 {
	private String firstName;
	private String lastName;
	private int registerBalance;
	
	public Query5 (String firstName, String lastName, int registerBalance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.registerBalance = registerBalance;
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

	public int getRegisterBalance() {
		return registerBalance;
	}

	public void setRegisterBalance(int registerBalance) {
		this.registerBalance = registerBalance;
	}
}
