package com.ilp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Account;
import com.ilp.DTO.Customer;
import com.ilp.Services.AccountServices;
import com.ilp.Services.CustomerServices;

public class HomeNavigationController extends HttpServlet {
	
	public HomeNavigationController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("homeNavigationHidden").trim();
		
		if(url.equals("ViewAllCustomerStatus/ViewCustomerStatus.jsp")) {
			CustomerServices customerServices = new CustomerServices();
			ArrayList<Customer> customerStatusList = customerServices.viewCustomerStatus();
		
			request.setAttribute("customerStatusList", customerStatusList);		
		} else if(url.equals("ViewAllAccountStatus/ViewAccountStatus.jsp")) {
			AccountServices accountServices = new AccountServices();
			ArrayList<Account> accountStatusList = accountServices.viewAccountStatus();
		
			request.setAttribute("accountStatusList", accountStatusList);		
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

}
