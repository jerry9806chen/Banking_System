package com.ilp.DTO;

import java.util.Date;

public class Customer {
	
	private int customerID;
	private int customerSSN;
	private String customerName;
	private int age;
	private String address1;
	private String city;
	private String state;
	private String status;
	private String message;
	private Date lastUpdated;
	
	public Customer() {
		this.customerID = 0;
		this.customerSSN = 0;
		this.customerName = "";
		this.age = 0;
		this.address1 = "";
		this.city = "";
		this.state = "";
		this.status = "";
		this.message = "";
		this.lastUpdated = new Date();
	}
	
	public Customer(int customerID, int customerSSN, String customerName, int age, String address1, String state, String city) {
		this.customerID = customerID;
		this.customerSSN = customerSSN;
		this.customerName = customerName;
		this.age = age;
		this.address1 = address1;
		this.state = state;
		this.city = city;
		this.status = "";
		this.message = "";
		this.lastUpdated = new Date();
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getCustomerSSN() {
		return customerSSN;
	}

	public void setCustomerSSN(int customerSSN) {
		this.customerSSN = customerSSN;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
}
