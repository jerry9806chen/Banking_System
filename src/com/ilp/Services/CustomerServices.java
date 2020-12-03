package com.ilp.Services;

import java.util.ArrayList;

import com.ilp.DAO.CustomerDao;
import com.ilp.DTO.Customer;

public class CustomerServices {
	
public CustomerServices() {}
	
	public Customer createCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.createCustomer(customer);
	}
	
	public boolean deleteCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.deleteCustomer(customer);
	}
	
	public ArrayList<Customer> viewCustomer(int customerID) {
		CustomerDao customerDao = new CustomerDao();
		ArrayList<Customer> customerInfo = customerDao.viewCustomer(customerID);
		return customerInfo;
	}
	
	public Customer updateCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.updateCustomer(customer);
	}

	public Customer getCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.getCustomer(customer);
	}
	
	public ArrayList<Customer> viewCustomerStatus() {
		CustomerDao customerDao = new CustomerDao();
		ArrayList<Customer> customerStatusList = customerDao.viewCustomerStatus();
		return customerStatusList;
	}

}
