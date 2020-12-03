package com.ilp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Account;
import com.ilp.Services.AccountServices;

public class CreateAccountController  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		String customer_id = request.getParameter("id-input").trim();
		String deposit = request.getParameter("deposit-input").trim();
		String account_type = request.getParameter("account-type").trim();
		
		if (customer_id == "" || deposit == "") {
			System.out.println("All fields are required.");
		}
		
		else {
			int customerId = Integer.parseInt(customer_id);
			
			Account acc = new Account();
			acc.setCustomerId(customerId);
			acc.setDepositAmt(Integer.parseInt(deposit));
			acc.setAccountType(account_type);
			
			AccountServices accServices = new AccountServices();
			boolean isAccAdded = accServices.createAccount(acc);
			
			if (isAccAdded) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Success.html");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ErrorMessage.jsp");
				requestDispatcher.forward(request, response);
			}
			
		}
		
		
	}
}
