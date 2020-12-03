package com.ilp.DTO;

public class User {

	private String userID;
	private String password;
	
	public User () {
		userID = "1";
		password = "hi";
		
	}
	
	public User(String userID, String password) {
		this.userID = userID;
		this.password = password;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
