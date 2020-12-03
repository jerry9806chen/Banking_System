package com.ilp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Customer;
import com.ilp.Services.CustomerServices;

public class DeleteCustomerController extends HttpServlet {
	
	public DeleteCustomerController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("customerId").trim();
		String customerSSN = request.getParameter("customerSSN").trim();
		
		
		Customer customer = new Customer();
		customer.setCustomerID(Integer.parseInt(customerId));
		customer.setCustomerSSN(Integer.parseInt(customerSSN));
		
		CustomerServices customerServices = new CustomerServices();
		boolean result = customerServices.deleteCustomer(customer);
		
		if(result) {
			response.sendRedirect("Success.html");
		} else {
			response.sendRedirect("ErrorMessage.jsp");
		}
	}
}
