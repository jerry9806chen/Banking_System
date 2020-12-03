function submitUpdateForm(formActionType){
	var form = document.getElementById("UpdateCustomerForm");
	document.getElementById("formActionType").value = formActionType;
	form.submit();
}