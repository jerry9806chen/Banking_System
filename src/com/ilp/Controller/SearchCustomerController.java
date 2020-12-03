package com.ilp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.Customer;
import com.ilp.Services.SearchServices;

/**
 * Servlet implementation class OnlineSearchController
 */
public class SearchCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerSearch/CustomerSearch.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ssnIdStr = request.getParameter("ssnID");
		String custIdStr = request.getParameter("customerID");
		
		int ssnId, custId;
		SearchServices ss = new SearchServices();
		ArrayList<Customer> searchList = new ArrayList<Customer>();
		
		if ((ssnIdStr == null || ssnIdStr.equals("")) && (custIdStr == null || custIdStr.equals(""))) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("CustomerSearch/CustomerSearch.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		if (custIdStr== null ||custIdStr.equals("")) {
			ssnId = Integer.parseInt(request.getParameter("ssnID"));
			System.out.println("custId");
			searchList = ss.getCustomerSearchResultsBySsnId(ssnId);
		}
		else if (ssnIdStr == null || ssnIdStr.equals("")) {
			custId = Integer.parseInt(request.getParameter("customerID"));
			System.out.println("ssn");
			searchList = ss.getCustomerSearchResultsByCustId(custId);
		}
		
		if(!searchList.isEmpty()) {
			request.setAttribute("searchList", searchList);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("CustomerSearch/CustomerSearchResults.jsp");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("ErrorMessage.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}