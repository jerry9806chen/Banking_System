package com.ilp.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Customer;
import com.ilp.Services.CustomerServices;

public class UpdateCustomerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public UpdateCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String formActionType = request.getParameter("formActionType").trim();
		
		if(formActionType.equals("update")) {
			//adding updatedCustomer
			String customerId = request.getParameter("customerId").trim();
			String customerSSN = request.getParameter("customerSSN").trim();
			String customerName = request.getParameter("customerName").trim();
			String age = request.getParameter("age").trim();
			String address1 = request.getParameter("address1").trim();
			String city = request.getParameter("city").trim();
			String state = request.getParameter("state").trim();
		
			Customer customer = new Customer();
			customer.setCustomerID(Integer.parseInt(customerId));
			customer.setCustomerSSN(Integer.parseInt(customerSSN));
			customer.setCustomerName(customerName);
			customer.setAge(Integer.parseInt(age));
			customer.setAddress1(address1);
			customer.setCity(city);
			customer.setState(state);
		
			CustomerServices customerServices = new CustomerServices();
			Customer customerUpdated = customerServices.updateCustomer(customer);
			if(customerUpdated != null) {
				response.sendRedirect("Success.html");
			} else {
				response.sendRedirect("ErrorMessage.jsp");
			}
		} else if(formActionType.equals("delete")) {
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

}
