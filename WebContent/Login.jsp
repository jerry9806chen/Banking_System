<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="login.css" rel="stylesheet">
<title>Login</title>
<script>
function validateForm(){

	console.log("validate");
	var user = document.forms["loginForm"]["userName"].value.length;
	var password = document.forms["loginForm"]["password"].value.length;	
	if(user == "" || password == "") {
		alert("Both text fields must be filled out. ");
		return false;
	} else if (user < 8) {
		alert("Username has to be 8 characters or more. ");
		return false;
	} else if (password < 10) {
		alert("password needs to be 10 characters or more. ");
		return false;
	} 
	
}
</script>
<!-- Bootstrap CSS -->
</head>
<body>
	<div class="flex-container">
	

		<!--------------------------------------------- Login ---------------------------------------------------------->

		<div class='login-form-container'>
			<form class="form-signin" name='loginForm' action='LoginController'  
				method='post'><!-- onsubmit="return validateForm()" -->
				<h1>Login</h1>
				<div class="text-container">
					<input type='text' name='userName' placeholder='Username' required>
					<input type='password' name='password' pattern = "^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" title="password needs to have uppercase, lowercase, special character and number" placeholder='Password'
						required>
				</div>
					<input id='submit-btn' type='submit'
						value='Login'>

			</form>
		</div>


		
	</div>

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