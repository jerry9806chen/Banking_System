var ssnInput = document.getElementById("ssnID");
ssnInput.onchange = function () {
   if (this.value != "" || this.value.length > 0) {
      document.getElementById("customerID").disabled = true;
   } else {
   document.getElementById("customerID").disabled = false;
   } 
};

var accountInput = document.getElementById("customerID");
accountInput.onchange = function () {
   if (this.value != "" || this.value.length > 0) {
      document.getElementById("ssnID").disabled = true;
   } else {
   document.getElementById("ssnID").disabled = false;
   } 
};