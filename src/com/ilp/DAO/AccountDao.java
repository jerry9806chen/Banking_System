package com.ilp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.ilp.DTO.Account;
import com.ilp.Helper.DBConnectionHelper;

public class AccountDao {

	// display all accounts for customer before deleting:
	public ArrayList<Account> viewCustomerAccounts(int customerID) {// get account through customerID

		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;

		ArrayList<Account> accountList = new ArrayList<>();
		{
			try {
				String sql = "SELECT * FROM account WHERE account.customer_id = customer." + customerID;
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);

				while (resultSet.next()) {

					Account currentAccount = new Account();

					int accountId = resultSet.getInt(1);
					int customerId = resultSet.getInt(2);
					String type = resultSet.getString(3);
					int amt = resultSet.getInt(4);

					currentAccount.setAccountId(accountId);
					currentAccount.setCustomerId(customerId);
					currentAccount.setAccountType(type);
					currentAccount.setDepositAmt(amt);

					accountList.add(currentAccount);

					// get account info, add all accounts to list
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

	public boolean deleteAccount(int accountID) {

		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		PreparedStatement pStmt = null;
		int status = 0;

		boolean result = false;
		{
			try {
				connection.setAutoCommit(false);
				String sql2 = "UPDATE account SET account_status = 'Inactive' WHERE account.account_id = ?";
				pStmt = connection.prepareStatement(sql2);

				pStmt.setInt(1, accountID);

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

	public boolean createAccount(Account account) {

		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		PreparedStatement pStmt = null;
		int status = 0;

		boolean result = false;
		{
			try {
				connection.setAutoCommit(false);
				String sql2 = "INSERT INTO account VALUES (account_id.nextval,?,?,?,?,?,?)";
				pStmt = connection.prepareStatement(sql2);

				pStmt.setInt(1, account.getCustomerId());
				pStmt.setString(2, account.getAccountType());
				pStmt.setInt(3, account.getDepositAmt());
				pStmt.setString(4, "Active");
				pStmt.setString(5, "");
				pStmt.setTimestamp(6, new Timestamp((new Date()).getTime()));

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

	public ArrayList<Account> viewAccountStatus() {// for all accounts

		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;

		ArrayList<Account> accountStatusList = new ArrayList<>();
		{
			try {
				String sql = "SELECT * FROM account";
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);

				while (resultSet.next()) {

					Account account = new Account();

					int accid = resultSet.getInt(1);
					int custid = resultSet.getInt(2);
					String type = resultSet.getString(3);
					String status = resultSet.getString(5);
					String msg = resultSet.getString(6);
					Timestamp last_updated_timestamp = resultSet.getTimestamp(7);
					// changing to java date:
					Date lastUpdated = new Date(last_updated_timestamp.getTime());

					account.setAccountId(accid);
					account.setAccountType(type);
					account.setCustomerId(custid);
					account.setMessage(msg);
					if(customerStatus(custid).contains("Inactive")) {
                        account.setAccountStatus("Inactive");
                    }
                    else {
                        account.setAccountStatus(status);
                    }
					account.setLastUpdated(lastUpdated);
					accountStatusList.add(account);// add to list for all accounts
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

	public boolean makeDeposit(int accountId, int amount) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		PreparedStatement pStmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		int status = 0;

		boolean result = false;
		{
			try {
				String sql = "SELECT * FROM account WHERE account_id = " + accountId;
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);

				if (!resultSet.next())
					throw new SQLException("Account not found");

				connection.setAutoCommit(false);
				String sql2 = "UPDATE account SET deposit_amount=deposit_amount + ? WHERE account_id=?";
				pStmt = connection.prepareStatement(sql2);

				pStmt.setInt(1, accountId);
				pStmt.setInt(2, amount);

				status = pStmt.executeUpdate();
				connection.commit();
				result = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
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

	public boolean makeWithdrawal(int accountId, int amount) {
		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		PreparedStatement pStmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		int status = 0;

		boolean result = false;
		{
			try {
				String sql = "SELECT deposit_amount FROM account WHERE account_id = " + accountId;
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);

				if (!resultSet.next())
					throw new SQLException("Account not found");

				do {
					int balance = resultSet.getInt(1);

					if (balance < amount)
						throw new Exception("Overdraft protection: Withdrawal amount exceeds account balance");
				} while (resultSet.next());

				connection.setAutoCommit(false);
				String sql2 = "UPDATE account SET balance=balance - ? WHERE account_id=?";
				pStmt = connection.prepareStatement(sql2);

				pStmt.setInt(1, accountId);
				pStmt.setInt(2, amount);

				status = pStmt.executeUpdate();
				connection.commit();
				result = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
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

	public Account viewCustomerAccountByAcctId(int accountID) {

		DBConnectionHelper helper = new DBConnectionHelper();
		Connection connection = helper.getOracleConnection();
		System.out.println(connection);
		Statement stmt = null;
		ResultSet resultSet = null;

		Account account = new Account();
		{
			try {
				String sql = "SELECT * FROM account WHERE account.account_id = " + accountID;
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(sql);

				while (resultSet.next()) {
					int accountId = resultSet.getInt(1);
					int customerId = resultSet.getInt(2);
					String type = resultSet.getString(3);
					int amt = resultSet.getInt(4);

					account.setAccountId(accountId);
					account.setCustomerId(customerId);
					account.setAccountType(type);
					account.setDepositAmt(amt);
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

		return account;
	}
    
	public String customerStatus(int id) {
	        DBConnectionHelper helper = new DBConnectionHelper();
	        Connection connection = helper.getOracleConnection();
	        System.out.println(connection);
	        PreparedStatement pStmt = null;
	        Statement stmt = null;
	        ResultSet resultSet = null;
	        int status = 0;


	        String result = "";
	        {
	            try {
	                
	                String sql = "select status from customer where customer_id = " + id;
	                stmt = connection.createStatement();
	                resultSet = stmt.executeQuery(sql);
	                
	                while (resultSet.next()) {
	                    result = resultSet.getString(1);
	                }
	                return result;
	                
	                
	                
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }


	        if (status == 1) {
	            System.out.println("Data deleted successfully");
	            //result = true;
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
}