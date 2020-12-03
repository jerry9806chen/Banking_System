package com.ilp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp.DTO.Account;
import com.ilp.DTO.Customer;
import com.ilp.Helper.DBConnectionHelper;

public class SearchDAO {

	public ArrayList<Customer> getCustomerSearchResultsBySsnId(int customerSSN) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		
		ArrayList<Customer> accountStatusList = new ArrayList<>();
		{
			try {		
				String sql = "SELECT * FROM customer WHERE ssn_id='" + customerSSN + "'";
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				
				while (resultSet.next()) {
					
					int custId = resultSet.getInt(1);
					int ssnId = resultSet.getInt(2);
					String fullName = resultSet.getString(3);
					int age = resultSet.getInt(4);
					String address = resultSet.getString(5);
					String usCity = resultSet.getString(6);
					String usState = resultSet.getString(7);
					
					Customer currentCustomer = new Customer(custId, ssnId, fullName, age, address, usState, usCity);

					accountStatusList.add(currentCustomer);
					
					//get account info, add all accounts to list
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return accountStatusList;
	}
	
	public ArrayList<Customer> getCustomerSearchResultsByCustId(int customerId) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		
		ArrayList<Customer> accountStatusList = new ArrayList<>();
		{
			try {		
				String sql = "SELECT * FROM customer WHERE customer_id='" + customerId + "'";
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				
				while (resultSet.next()) {
					
					int custId = resultSet.getInt(1);
					int ssnId = resultSet.getInt(2);
					String fullName = resultSet.getString(3);
					int age = resultSet.getInt(4);
					String address = resultSet.getString(5);
					String usCity = resultSet.getString(6);
					String usState = resultSet.getString(7);
					
					Customer currentCustomer = new Customer(custId, ssnId, fullName, age, address, usState, usCity);

					accountStatusList.add(currentCustomer);
					
					//get account info, add all accounts to list
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return accountStatusList;
	}
	
	public ArrayList<Account> getAccountSearchResultsByAccountId(int accountId) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		
		ArrayList<Account> accountList = new ArrayList<>();
		{
			try {		
				String sql = "SELECT * FROM account WHERE account_id=" + accountId;
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				
				while (resultSet.next()) {
					
					int accId = resultSet.getInt(1);
					int cusId = resultSet.getInt(2);
					String type = resultSet.getString(3);
					int deposit = resultSet.getInt(4);
					
					Account currentAccount = new Account();
					currentAccount.setAccountId(accId);
					currentAccount.setCustomerId(cusId);
					currentAccount.setAccountType(type);
					currentAccount.setDepositAmt(deposit);

					accountList.add(currentAccount);
					
					//get account info, add all accounts to list
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return accountList;
	}
	
	public ArrayList<Account> getAccountSearchResultsByCustomerId(int customerId) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;
		
		ArrayList<Account> accountList = new ArrayList<>();
		{
			try {		
				String sql = "SELECT * FROM account WHERE customer_id=" + customerId;
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);
				
				while (resultSet.next()) {
					
					int accId = resultSet.getInt(1);
					int cusId = resultSet.getInt(2);
					String type = resultSet.getString(3);
					int deposit = resultSet.getInt(4);
					
					Account currentAccount = new Account();
					currentAccount.setAccountId(accId);
					currentAccount.setCustomerId(cusId);
					currentAccount.setAccountType(type);
					currentAccount.setDepositAmt(deposit);

					accountList.add(currentAccount);
					
					//get account info, add all accounts to list
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (stmt != null)
			try {
				stmt.close();
				System.out.println("Prepared STATEMENT SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (connection != null)
			try {
				connection.close();
				System.out.println("CONNECTION SUCCESSFULLY CLOSED");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return accountList;
	}
	
}