package com.ilp.DTO;

import java.util.Date;

public class Account {

	private int accountId;
	private int customerId;
	private String accountType;// savings or current
	private int depositAmt;
	private String accountStatus;
	private String message;
	private Date lastUpdated;

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Account() {
		this.accountId = 0;
		this.customerId = 0;
		this.accountType = "";
		this.depositAmt = 0;
		this.accountStatus = "Active";
		this.message = "";
		this.lastUpdated = new Date();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(int depositAmt) {
		this.depositAmt = depositAmt;
	}

	public static void main(String[] args) {
		Account acc = new Account();
		System.out.println(acc.getAccountId());
	}
}
