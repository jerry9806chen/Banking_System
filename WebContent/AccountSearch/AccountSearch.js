function goToDelete(accountId, customerId) {
	var form = document.getElementById("viewAccountForm");
	
	document.getElementById("accountID").value = accountId;
	console.log(accountId);
	document.getElementById("customerID").value = customerId;
	console.log(customerId);
	
	form.submit();
}