function submitForm(url){
	var form = document.getElementById("homeNavigationForm");
	document.getElementById("homeNavigationHidden").value = url;
	form.submit();
}