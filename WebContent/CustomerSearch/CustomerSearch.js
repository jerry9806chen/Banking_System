function goToUpdate(customerId, customerSSN) {
	var form = document.getElementById("viewCustomerForm");
	document.getElementById("formActionType").value = "update";

	document.getElementById("customerId").value = customerId;
	
	document.getElementById("customerSSN").value = customerSSN;
	
	form.submit();
}

function goToDelete(customerId, customerSSN) {
	var form = document.getElementById("viewCustomerForm");
	document.getElementById("formActionType").value = "delete";
	document.getElementById("customerId").value = customerId;
	document.getElementById("customerSSN").value = customerSSN;
	
	form.submit()
}