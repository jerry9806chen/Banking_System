package com.ilp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Account;
import com.ilp.Services.SearchServices;

/**
 * Servlet implementation class OnlineSearchController
 */
public class SearchAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AccountSearch.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accId = request.getParameter("accountID");//Integer.parseInt(request.getParameter("account_id"));
		String custId = request.getParameter("customerID");//Integer.parseInt(request.getParameter("customer_id"));
		
		SearchServices s = new SearchServices();
		
		ArrayList<Account> searchList = new ArrayList<Account>();
		
		System.out.println(accId);
		System.out.println(custId);
		
		if((accId == null || accId.trim().equals("")) && (custId == null|| custId.trim().equalsIgnoreCase(""))) {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("AccountSearch/AccountSearch.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		if (accId == null || accId.trim().equals("")) {
			int real_accId = Integer.parseInt(request.getParameter("customerID"));
			searchList = s.getAccountSearchResultsByCustomerId(real_accId);
		}
		else {
			int real_custId = Integer.parseInt(request.getParameter("accountID"));
			searchList = s.getAccountSearchResultsByAccountId(real_custId);
		}
		
		System.out.println("No errors so far.");
		if(!searchList.isEmpty()) {
			request.setAttribute("accountList", searchList);
			System.out.println("Found and redirecting");
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("AccountSearch/AccountSearchResults.jsp");
			requestDispatcher.forward(request, response);
		} else {
			System.out.println("Ran into error!");
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("ErrorMessage.jsp");
		}
	}
	
}