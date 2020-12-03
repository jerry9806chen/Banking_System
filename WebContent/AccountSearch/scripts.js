/**
 * 
 */

var accountInput = document.getElementById("accountID");
accountInput.onchange = function () {
   if (this.value != "" || this.value.length > 0) {
      document.getElementById("customerID").disabled = true;
   } else {
   document.getElementById("customerID").disabled = false;
   } 
};

var customerInput = document.getElementById("customerID");
customerInput.onchange = function () {
   if (this.value != "" || this.value.length > 0) {
      document.getElementById("accountID").disabled = true;
   } else {
   document.getElementById("accountID").disabled = false;
   } 
};