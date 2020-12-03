<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%@ page import="com.ilp.DTO.Customer"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<head>
<link href="${pageContext.request.contextPath}/ViewAllCustomerStatus/StatusTableStyle.css" rel="stylesheet">

<% ArrayList<Customer> custStatusList = (ArrayList<Customer>) request.getAttribute("customerStatusList");  %>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="headerAndFooterStyle.css">
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<form id="homeNavigationForm" name="homeNavigationForm"
		action="HomeNavigationController" method="get">
		<input type="hidden" id="homeNavigationHidden"
			name="homeNavigationHidden" value="">
	</form>

	<header>
		<h1 class="site-title">
			<span id="title1">FedChoice </span><span id="title2">Bank</span>
		</h1>

		<div class="customNavbar">
			<a href="#" onclick="submitForm('index.html')" id="home">Home</a>
			<div class="customDropDown">
				<button type="button" id="customer-management">Customer
					Management</button>
				<div class="customDropDown-content">
					<a href="#" onclick="submitForm('Customer/createcustomer.html')">Create Customer</a>
					<a href="#" onclick="submitForm('CustomerSearch/CustomerSearch.jsp')">Search Customer</a>
				</div>
			</div>
			<div class="customDropDown">
				<button type="button" id="account-management">Account
					Management</button>
				<div class="customDropDown-content">
					<a href="#" onclick="submitForm('Account/createaccount.html')">Create Account</a>
					<a href="#" onclick="submitForm('AccountSearch/AccountSearch.jsp')">Search Account</a>
				</div>
			</div>
			<div class="customDropDown">
				<button type="button" id="status-details">Status Details</button>
				<div class="customDropDown-content">
					<a href="#"
						onclick="submitForm('ViewAllCustomerStatus/ViewCustomerStatus.jsp')">Customer
						Status</a> <a href="#"
						onclick="submitForm('ViewAllAccountStatus/ViewAccountStatus.jsp')">Account
						Status</a>
				</div>
			</div>
			<div class="customDropDown">
				<button type="button" id="account-operations">Account
					Operations</button>
				<div class="customDropDown-content">
					<a href="#">Under Maintenance</a> <a href="#">Under Maintenance</a>
				</div>
			</div>
			<a href="#logout" onclick="submitForm('Login.jsp')" id="logout">Logout</a>
		</div>
	</header>

	<div class="mainContent">
	
		<!----------------------------------- Main Content ---------------------------------------------->
	

<main>
<div class="text-center row" style="width: 100%; min-height: 400px;">
			<div class="col-md-2"></div>
			<div class="col-md-8">

<form id="viewCustomerForm" name="viewCustomerForm" action="ViewCustomerController" method="get">
	<input type="hidden" id="customerId" name="customerId" value="">
	<input type="hidden" id="customerSSN" name="customerSSN" value="">
	<table id="cust-status-table" cellspacing="0">
		<tr>
			<th>Customer ID</th>
			<th>Customer SSN ID</th>
			<th>Status</th>
			<th>Message</th>
			<th>Last Updated</th>
			<th>Operations</th>
			<th>View Profile</th>
		</tr>
		<%
			Iterator myIterator = custStatusList.iterator();
			while (myIterator.hasNext()) {
				Customer customerStatus = (Customer) myIterator.next();
		%>
		<tr>
			<td><%= customerStatus.getCustomerID() %></td>
			<td><%= customerStatus.getCustomerSSN() %></td>
			<td><%= customerStatus.getStatus() %></td>
			<td><%= customerStatus.getMessage() %></td>
			<td><%= customerStatus.getLastUpdated() %></td>
			<td><a href="#">Refresh</a></td>
			<td><a href="#" onclick="goToViewDetails(<%= customerStatus.getCustomerID() %>,
			<%= customerStatus.getCustomerSSN() %>)">View Details</a></td>
		</tr>
		 <% } %>
	</table>
</form>
</div>
			<div class="col=md-2"></div>
		</div>
</main>


	<!-------------------------------------  Footer ------------------------------------------->
	<footer class="footer">
		<div class="row">
			<div class="col-sm-5">
				<div class="footer-widget">
					<h3>About Us</h3>
					<div class="footer-widget-content">Welcome to Retail Bank,
						your number one source for all things [product]. We're dedicated
						to providing you the best of [product], with a focus on
						dependability. customer service, and [store characteristic].</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="footer-widget">
					<h3>Services</h3>
					<div class="footer-widget-content list-group">
						<a href="#">Personal Banking</a> <a href="#">Retail Banking</a> <a
							href="#">Corporate Internet Banking</a> <a href="#">Debit and
							Credit Cards</a>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="footer-widget">
					<h3>Contact Us</h3>
					<div class="footer-widget-content">
						Email: <a href="mail to:contactus@retailbank.com">contactus@retailbank.com</a><br>Contact
						No: +1 123-456-7890<br> Address: Corporate office, 66 Perry
						Street<br> West Village, NY 12345
					</div>
				</div>
			</div>
		</div>
	</footer>
	

	<script type="text/javascript" src="main.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/ViewAllCustomerStatus/ViewCustomerStatus.js"></script>
	<!--  Bootstrap scripts -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>