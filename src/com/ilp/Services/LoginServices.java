package com.ilp.Services;

import com.ilp.DAO.LoginDAO;
import com.ilp.DTO.User;

public class LoginServices {

	public User searchUser(String userID, String password) {
		
		// TODO Auto-generated method stub
		
		LoginDAO loginDao = new LoginDAO();
		User currentUser = loginDao.searchUser(userID, password);
		
		return currentUser;
	}
	

}


