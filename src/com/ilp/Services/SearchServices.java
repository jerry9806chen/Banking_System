package com.ilp.Services;

import java.util.ArrayList;

import com.ilp.DAO.SearchDAO;
import com.ilp.DTO.Customer;
import com.ilp.DTO.Account;

public class SearchServices {

	public ArrayList<Customer> getCustomerSearchResultsBySsnId(int ssnId) {
		SearchDAO searchDao = new SearchDAO();
		ArrayList<Customer> searchList = searchDao.getCustomerSearchResultsBySsnId(ssnId);
		return searchList;
	}
	
	public ArrayList<Customer> getCustomerSearchResultsByCustId(int custId) {
		SearchDAO searchDao = new SearchDAO();
		ArrayList<Customer> searchList = searchDao.getCustomerSearchResultsByCustId(custId);
		return searchList;
	}
	
	public ArrayList<Account> getAccountSearchResultsByAccountId(int accId) {
		SearchDAO searchDao = new SearchDAO();
		ArrayList<Account> searchList = searchDao.getAccountSearchResultsByAccountId(accId);
		return searchList;
	}
	
	public ArrayList<Account> getAccountSearchResultsByCustomerId(int custId) {
		SearchDAO searchDao = new SearchDAO();
		ArrayList<Account> searchList = searchDao.getAccountSearchResultsByCustomerId(custId);
		return searchList;
	}

}