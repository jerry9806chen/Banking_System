//search SQL database for entered userID and password

package com.ilp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ilp.DTO.User;
import com.ilp.Helper.DBConnectionHelper;

public class LoginDAO {

 

    public User searchUser(String userID, String password) {

    	return null;

        /*DBConnectionHelper helper = new DBConnectionHelper();
        Connection connection = helper.getOracleConnection();
        System.out.println(connection);
        Statement stmt = null;
        ResultSet resultSet = null;
        
        User currentUser = null;
        {
            try {
                String sql = "SELECT * FROM UserTable " + "WHERE userId = '" + userID +"' AND password = '" + password + "'";
                
                //get Table name and field names from SQL database
                
                stmt = connection.createStatement();
                resultSet = stmt.executeQuery(sql);
            
                while (resultSet.next()) {
                    
                    String id = resultSet.getString(1);
                    String pwd = resultSet.getString(2);

 

                    currentUser = new User();
                    currentUser.setUserID(id);
                    currentUser.setPassword(pwd);
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

 

        return currentUser;*/
    }
    
}
