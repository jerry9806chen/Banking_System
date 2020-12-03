package com.ilp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Customer;
import com.ilp.Services.CustomerServices;

public class UpdateNavigationController extends HttpServlet {
	
	public UpdateNavigationController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String formActionType = request.getParameter("formActionType").trim();
	
		if(formActionType.equals("update")) {
			int customerId = Integer.parseInt(request.getParameter("customerId").trim());
			int customerSSN = Integer.parseInt(request.getParameter("customerSSN").trim());
			Customer tempCustomer = new Customer();
			tempCustomer.setCustomerID(customerId);
			tempCustomer.setCustomerSSN(customerSSN);
		
			CustomerServices customerServices = new CustomerServices();
			Customer customer = customerServices.getCustomer(tempCustomer);
			
			request.setAttribute("customer", customer);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer/UpdateCustomer.jsp");
			requestDispatcher.forward(request, response);
		} else if(formActionType.equals("delete")) {
			int customerId = Integer.parseInt(request.getParameter("customerId").trim());
			int customerSSN = Integer.parseInt(request.getParameter("customerSSN").trim());
			Customer tempCustomer = new Customer();
			tempCustomer.setCustomerID(customerId);
			tempCustomer.setCustomerSSN(customerSSN);
		
			CustomerServices customerServices = new CustomerServices();
			Customer customer = customerServices.getCustomer(tempCustomer);
			request.setAttribute("customer", customer);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer/DeleteCustomer.jsp");
			requestDispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

}
