package com.ilp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.DTO.User;
import com.ilp.Services.LoginServices;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//doGet(request, response);
		
		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		
		LoginServices loginServices = new LoginServices();
		User currentUser = loginServices.searchUser(userName, password);
		System.out.println(currentUser);
		//if (currentUser != null) {*/
			
			request.setAttribute("currentUser", currentUser);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");//get page name from frontend
			requestDispatcher.forward(request, response);
		/*}
		else {
			//if login not successful - error message
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ErrorMessage.jsp");//get page name from frontend
			requestDispatcher.forward(request, response);
		}*/
	}
}
