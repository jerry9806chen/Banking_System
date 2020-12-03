<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%@ page import="com.ilp.DTO.Account" %>

<head>
<% Account account = (Account) request.getAttribute("account"); %>
<meta charset="ISO-8859-1">
<title>Delete Account</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="headerAndFooterStyle.css">
<link rel="stylesheet" href="Customer/UpdateCustomerStyle.css">
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
<main class="update-customer-table">
	<h1 style="text-align:center;">Delete Account</h1>
	<h1 style="text-align:center;"> </h1>
	<h1 style="text-align:center;"> </h1>
	<h1 style="text-align:center;"> </h1>
	<h1 style="text-align:center;"> </h1>
	<h1 style="text-align:center;"> </h1>
	<!--  adding space between "Update Customer" and table -->
	<form id="DeleteCustomerForm" name="DeleteAccountForm" action="DeleteAccountController" method="post">
		<table align="left" style="text-align:left;" class="customer-info-table" width="100%">
			<col style="width:50%">
			<col style="width:50%">
			<tr>
				<td class="row-label" style="text-align:left;">Account ID </td>
				<td style="text-align:left;"><%= account.getAccountId() %></td>
				<input type="hidden" name="accountID" value=<%= account.getAccountId() %>>
			</tr>
			<tr></tr>
			<tr>
				<td class="row-label" style="text-align:left;">Customer ID </td>
				<td style="text-align:left;"><%= account.getCustomerId() %></td>
				<input type="hidden" name="customerID" value="<%= account.getCustomerId() %>">
			</tr>
			<tr></tr>
			<tr>
				<td class="row-label" style="text-align:left;">Account Type </td>
				<td style="text-align:left;"><%= account.getAccountType() %></td>
			</tr>
			<tr></tr>
			
			<tr>
				<td class="row-label" style="text-align:left;">Deposit Amount </td>
				<td style="text-align:left;"><%= account.getDepositAmt() %></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
				<input id='submit-btn' type='submit'
						value='delete'>
				<input type="hidden" id="formActionType" name="formActionType" value=""></td>
			</tr>
				
		</table>
	</form>
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
	<script type="text/javascript" src="Customer/UpdateCustomer.js"></script>
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
