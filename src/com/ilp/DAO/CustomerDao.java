package com.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.ilp.DTO.Customer;
import com.ilp.Helper.DBConnectionHelper;

public class CustomerDao {
	
	public CustomerDao() {}
	
	public Customer createCustomer(Customer customer) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		PreparedStatement pStmt = null;

		int status = 0;
		Customer newCustomer = null;
		
		{
			try {
				connection.setAutoCommit(false);
				String sql = "insert into customer "
						+ "values (customer_id.nextval,?,?,?,?,?,?,?,?,?)";
				pStmt = connection.prepareStatement(sql);
				pStmt.setInt(1, customer.getCustomerSSN());
				pStmt.setString(2, customer.getCustomerName());
				pStmt.setInt(3, customer.getAge());
				pStmt.setString(4, customer.getAddress1());
				pStmt.setString(5, customer.getCity());
				pStmt.setString(6, customer.getState());
				pStmt.setString(7, "Active");
				pStmt.setString(8, "");
				pStmt.setTimestamp(9, new Timestamp((new Date()).getTime()));
				status = pStmt.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		if (status == 1) {
			System.out.println("Data inserted successfully");
			newCustomer = customer;
		}

		if (pStmt != null)
			try {
				pStmt.close();
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

		return newCustomer;
	}
	
	public boolean deleteCustomer(Customer customer) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		PreparedStatement pStmt = null;
		int status = 0;
		boolean result = false;
		
		{
			try {
                connection.setAutoCommit(false);
                String sql = "update customer set status= ?, last_updated = ?"
                		+ " where ssn_id=? and customer_id=?" ;
                pStmt = connection.prepareStatement(sql);
                pStmt.setString(1, "Inactive");
                pStmt.setTimestamp(2, new Timestamp((new Date()).getTime()));
                pStmt.setInt(3, customer.getCustomerSSN());
                pStmt.setInt(4, customer.getCustomerID());
                status = pStmt.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

		}
		
		if (status == 1) {
			System.out.println("Data deleted successfully");
			result = true;
		}

		if (pStmt != null)
			try {
				pStmt.close();
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

		return result;
	}
	
	//display customer info before updating:
		public ArrayList<Customer> viewCustomer(int customerID) {//get customer through customerID
				
			DBConnectionHelper helper = new DBConnectionHelper();
			Connection connection = helper.getOracleConnection();
			System.out.println(connection);
			Statement stmt = null;
			ResultSet resultSet = null;
				
			ArrayList<Customer> customerInfo = new ArrayList<>();
			{
				try {		
					String sql = "SELECT * FROM customer WHERE customer_id = " + customerID;
					stmt = connection.createStatement();
					resultSet = stmt.executeQuery(sql);
					
					while (resultSet.next()) {
							
						Customer currentCustomer = new Customer();
							
						int id = resultSet.getInt(1);
						int ssn = resultSet.getInt(2);
						String name = resultSet.getString(3);
						int age = resultSet.getInt(4);
						String address1 = resultSet.getString(5);
						String city = resultSet.getString(6);
						String state = resultSet.getString(7);
							
						currentCustomer.setCustomerID(id);
						currentCustomer.setCustomerSSN(ssn);
						currentCustomer.setCustomerName(name);
						currentCustomer.setAge(age);
						currentCustomer.setAddress1(address1);
						currentCustomer.setCity(city);
						currentCustomer.setState(state);
							
						customerInfo.add(currentCustomer);
						
						//get customer info, add to customerInfo list
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
			
			return customerInfo;
		}

		public Customer updateCustomer(Customer customer)
		{
			DBConnectionHelper helper = new DBConnectionHelper();
			Connection connection = helper.getOracleConnection();
			System.out.println(connection);
			PreparedStatement pStmt = null;
			int status = 0;
			
			Customer updatedCustomer = null;
			{
				//update customer:
				
				try {
					connection.setAutoCommit(false);
					
					//update record of customer:
					String sql = "update customer set full_name= ?, age=?, address=?, city=?, state=?, "
							+ "last_updated = ?"
							+ " where ssn_id=? and customer_id=?";				
					pStmt = connection.prepareStatement(sql);
					
					pStmt.setString(1, customer.getCustomerName());
					pStmt.setInt(2, customer.getAge());
					pStmt.setString(3, customer.getAddress1());
					pStmt.setString(4, customer.getCity());
					pStmt.setString(5, customer.getState());
					pStmt.setTimestamp(6, new Timestamp((new Date()).getTime()));
					pStmt.setInt(7, customer.getCustomerSSN());
					pStmt.setInt(8, customer.getCustomerID());
					
					
					status = pStmt.executeUpdate();
					connection.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (status == 1) {
				System.out.println("Data updated successfully");
				
				updatedCustomer = customer;//updatedCustomer becomes customer
			}

			if (pStmt != null)
				try {
					pStmt.close();
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

			return updatedCustomer;
		}
		
		public Customer getCustomer(Customer customer) {
			
			DBConnectionHelper helper = new DBConnectionHelper();
			Connection connection = helper.getOracleConnection();
			System.out.println(connection);
			Statement stmt = null;
			ResultSet resultSet = null;
			
			Customer tempCustomer = null;
			{
				try {		
					String sql = "SELECT * FROM customer WHERE customer_Id = " + customer.getCustomerID() +
							" and ssn_id = " + customer.getCustomerSSN();
					stmt = connection.createStatement();
					resultSet = stmt.executeQuery(sql);
					
					while (resultSet.next()) {
						
						tempCustomer = new Customer();
						
						int id = resultSet.getInt(1);
						int ssn = resultSet.getInt(2);
						String name = resultSet.getString(3);
						int age = resultSet.getInt(4);
						String address1 = resultSet.getString(5);
						String city = resultSet.getString(6);
						String state = resultSet.getString(7);
						
						tempCustomer.setCustomerID(id);
						tempCustomer.setCustomerSSN(ssn);
						tempCustomer.setCustomerName(name);
						tempCustomer.setAge(age);
						tempCustomer.setAddress1(address1);
						tempCustomer.setCity(city);
						tempCustomer.setState(state);
						
						//get customer info, add to customerInfo list
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
			
			return tempCustomer;
		}
		
		public ArrayList<Customer> viewCustomerStatus() {//for all customers

			DBConnectionHelper helper = new DBConnectionHelper();
			Connection connection = helper.getOracleConnection();
			System.out.println(connection);
			Statement stmt = null;
			ResultSet resultSet = null;
			
			ArrayList<Customer> customerStatusList = new ArrayList<>();
			{
				try {		
					String sql = "SELECT * FROM customer";
					stmt = connection.createStatement();
					resultSet = stmt.executeQuery(sql);
					
					while (resultSet.next()) {
						
						Customer customer = new Customer();
						
						int id = resultSet.getInt(1);
						int ssn = resultSet.getInt(2);
						String status = resultSet.getString(8);
						String msg = resultSet.getString(9);
						Timestamp last_updated_timestamp = resultSet.getTimestamp(10);
						//changing to java date:
						Date lastUpdated = new Date(last_updated_timestamp.getTime());
						
						customer.setCustomerID(id);
						customer.setCustomerSSN(ssn);
						customer.setStatus(status);
						customer.setMessage(msg);
						customer.setLastUpdated(lastUpdated);

						customerStatusList.add(customer);//add to list for all customers
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

			return customerStatusList;
		}


}