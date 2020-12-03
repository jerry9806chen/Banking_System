package com.ilp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DAO.CustomerDao;
import com.ilp.DTO.Customer;

public class CreateCustomerController extends HttpServlet {
	
	public CreateCustomerController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String customerSSN = request.getParameter("ssn-input").trim();
		String customerName = request.getParameter("name-input").trim();
		String age = request.getParameter("age-input").trim();
		String address1 = request.getParameter("address-input").trim();
		String city = request.getParameter("city").trim();
		String state = request.getParameter("state").trim();
		
		Customer customer = new Customer();
		customer.setCustomerSSN(Integer.parseInt(customerSSN));
		customer.setCustomerName(customerName);
		customer.setAge(Integer.parseInt(age));
		customer.setAddress1(address1);
		customer.setCity(city);
		customer.setState(state);
	
		CustomerDao cdao = new CustomerDao();
		Customer customerCreated = cdao.createCustomer(customer);
		if(customerCreated != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Success.html");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ErrorMessage.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
