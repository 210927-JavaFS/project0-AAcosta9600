package com.revature.models;

public class Account {
	private double cash;
	private String username;
	private boolean approval;
	private int accountNumber;
	
	public Account(double cash, String username, boolean approval, int accountNumber) {
		super();
		this.cash = cash;
		this.username = username;
		this.approval = approval;
		this.accountNumber = accountNumber+1;
	}

	public Account(double cash, String username, boolean approval) {
		super();
		this.cash = cash;
		this.username = username;
		this.approval = approval;
	}

	public Account() {
		super();
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + (approval ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (approval != other.approval)
			return false;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", accountNumber=" + accountNumber + ", cash=" + cash + ", approval="
				+ approval + "]";
	}
	
	

}
