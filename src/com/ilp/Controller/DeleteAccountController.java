package com.ilp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Account;
import com.ilp.Services.AccountServices;

public class DeleteAccountController extends HttpServlet {
	
	public DeleteAccountController() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//displaying customer accounts first:
		
		int customerID = Integer.parseInt(request.getParameter("accountID").trim());
		//int customerID = 100001;//testing
		
		AccountServices accountService = new AccountServices();
		Account account = accountService.viewCustomerAccountByAcctId(customerID);
		
		request.setAttribute("account", account);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Account/DeleteAccount.jsp");
		requestDispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//delete account:
		
		int accountID = Integer.parseInt(request.getParameter("accountID").trim());
		//int customerID = 100001;//testing
		
		AccountServices accountService = new AccountServices();
		
		boolean result = accountService.deleteAccount(accountID);
		
		if(result) {
			response.sendRedirect("Success.html");
		} else {
			response.sendRedirect("ErrorMessage.jsp");
		}
	}

}