
function goToViewDetails(customerId, customerSSN){
	var form = document.getElementById("viewCustomerForm");
	document.getElementById("customerId").value = customerId;
	document.getElementById("customerSSN").value = customerSSN;
	form.submit();
}