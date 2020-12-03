package com.ilp.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionHelper {

	public Connection getOracleConnection() {
		
		final String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "SYS as SYSDBA";
		String pwd = "12345";
		Connection connection = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("the connection object :: " + connection);
		return connection;
	}

}
