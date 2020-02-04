var vehicleType = "Bicycle";
var empRegister = 0;
var vehicleRegister = 0;
var vehicleChanged = 0;
var organisationValidation = 0;


function updateProfile()
{
	
    window.location.href = "updateProfile.jsp";

}
function organisationSelect() {
	if(organisationValidation==0)
	{
    document.getElementById("organisation").remove(0);
	}
	organisationValidation = 1;
}
function signupPage() {
    window.location.href = "signup.jsp";
}

function logoutPage() {
	alert("Logged Out Successfully");
    window.location.href = "logout.jsp";

}

function loginPage() {
    window.location.href = "login.jsp";
}

function findFriendsPage() {
    window.location.href = "friends.jsp";

}

function regitserEmployee() {
    var empName = document.getElementById("employeeName").value;
    var empEmail = document.getElementById("employeeEmail").value;
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var contact = document.getElementById("contactNumber").value;
    var gender= document.getElementsByName("gender");
    var contactValidation = 1;
    var emailValidation = 0;
    var genderValidation = 0;
    var passwordValidation=1;
    for (var i = 0; i < gender.length; i++) {
        if (gender[i].checked) {
            genderValidation = 1;
            genderValue = gender[i].value;
            break;
        }
    }
    for (var i = 0; i < contact.length; i++) {
        if ((contact.charCodeAt(i) < 48) || (contact.charCodeAt(i) > 57)) {
            contactValidation = 0;
            break;
        }
    }
    for (var i = 0; i < empEmail.length; i++) {
        if (empEmail.charCodeAt(i) == 64) {
            if (i >= 2 && (empEmail.length - i) >= 3) {
                emailValidation = 1;
            }
        }
    }
    var UpperCase = 0,
        lowerCase = 0,
        alphabet = 0,
        specialChar = 0;
    for (var i = 0; i < password.length; i++) {
        if ((password.charCodeAt(i) >= 48) && (password.charCodeAt(i) <= 57)) {
            alphabet++;
        } else if ((password.charCodeAt(i) >= 65) && (password.charCodeAt(i) <= 91)) {
            UpperCase++;
        } else if ((password.charCodeAt(i) >= 97) && (password.charCodeAt(i) <= 123)) {
            lowerCase++;
        } else {
            specialChar++;
        }
    }
    if (alphabet == 0 || lowerCase == 0 || specialChar == 0 || UpperCase == 0) {
        passwordValidation = 0;
    }
    
    if (empName.length > 2) {
        if (genderValidation == 1) {
            if ((empEmail.length != 0) && (emailValidation != 0)) {
                if (password.length != 0) {
                    if ((password.length >= 8) && (passwordValidation != 0)) {
                        if (confirmPassword.lenght != 0) {
                            if ((password == confirmPassword)) {
                                if ((contact.length > 8) && (contactValidation == 1)) {
                                    if (organisationValidation == 1) {
                                    	  var employeeId=document.getElementById("employeeName").value[0]+document.getElementById("employeeName").value[1]+(Math.floor(Math.random()*10000)).toString();
                                    	  document.getElementById("employeeId").value = "Employee Id : " + (employeeId);
                                          document.getElementById("employeeId").readOnly = true;
                                          document.getElementById("employeeId").style.backgroundColor = "blue";
                                          document.getElementById("employeeId").style.borderColor = "green";
                                          document.getElementById("employeeId").style.color = "white";
                                          empRegister = 1;
                                          document.getElementById("submitEmpName").value=document.getElementById("employeeName").value;
                                          document.getElementById("submitEmpId").value=employeeId;
                                          document.getElementById("submitEmpEmail").value=document.getElementById("employeeEmail").value ;
                                          document.getElementById("submitEmpPassoword").value=document.getElementById("password").value ;
                                          document.getElementById("submitEmpGender").value=document.getElementById("gender").value ;
                                          document.getElementById("submitEmpContact").value=document.getElementById("contactNumber").value ;
                                          document.getElementById("submitEmpOrganisation").value=document.getElementById("organisation").value ;  
                                          document.getElementById("employeeRegistrationForm").innerHTML = "Registration SuccessFul </br>Employee Id : " + employeeId;
                                          document.getElementById("VehicleRegistrationForm").style = "display:block";
                                    } else {
                                        alert("Please select Organistaion");

                                    }
                                } else {
                                    alert("Invalid Contact Number");
                                }
                            } else {
                                alert("Password does not match with confirm Password");
                            }

                        } else {
                            alert("please Enter confirm Passowrd");

                        }
                    } else {
                        alert("Password does not match expected strength");
                    }

                } else {
                    alert("please Enter Passowrd");

                }
            } else {
                alert("please Enter Valid Employee Email Id");
            }

        } else {
            alert("please select Gender");

        }
    } else {
        alert("please Enter Valid Employee Name");
    }
}



function regitserVehicle() {
    if (empRegister == 1) {
    	 document.getElementById("submitEmpVehicleName").value=document.getElementById("VehicleName").value ;
         document.getElementById("submitEmpVehicleType").value=document.getElementById("vehicleType").value ;
         document.getElementById("submitEmpVehicleIdentification").value=document.getElementById("vehicleIdentification").value ;
         document.getElementById("submitEmpVehicleNumber").value=document.getElementById("VehicleNumber").value ;
        var VehicleName = document.getElementById("VehicleName").value;
        var VehicleNumber = document.getElementById("VehicleNumber").value;
        var vehicleIdentification = document.getElementById("vehicleIdentification").value;
        if (VehicleName.length >= 4 && VehicleNumber.length >= 4 && vehicleIdentification.length >= 5 && vehicleChanged == 1) {
            vehicleRegister = 1; 
            document.getElementById("VehicleRegistrationForm").innerHTML = "";
            document.getElementById("payment").style = "display:block";

        } else {
            alert("Please enter valid details of vehicle ");

        }
    } else {
        alert("Please Register Employee First");
    }
}

function currencyChange() {
    var currency = document.getElementById("CurrencyChange").value;
    document.getElementById("CurrencyChange").style.borderColor = "green";
    if (currency == ("INR")) {
        if (vehicleType == "Bicycle") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 5 Rs";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br>100 Rs";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br>500 Rs";
        } else if (vehicleType == "MotorCycle") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 10 Rs";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br> 200 Rs";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br> 1000 Rs";
        } else if (vehicleType == "FourWheelers") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 20 Rs";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br> 1000 Rs";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br> 3500 Rs";
        }



    } else if (currency == ("USD")) {
        if (vehicleType == "Bicycle") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 0.070 USD";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br> 1.40 USD";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br> 7.00 USD";
        } else if (vehicleType == "MotorCycle") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 0.140 USD";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br> 2.80 USD";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br> 14.00 USD";
        } else if (vehicleType == "FourWheelers") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 0.280 USD";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br> 14.00 USD";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br> 49.00 USD";
        }

    } else if (currency == ("YEN")) {
        if (vehicleType == "Bicycle") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 15.30 YEN";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br> 153.00 YEN";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br> 765.00 YEN";
        } else if (vehicleType == "MotorCycle") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 7.65 YEN";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br> 306.00 YEN";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br> 1530.00 YEN";
        } else if (vehicleType == "FourWheelers") {
            document.getElementById("dailyParking").innerHTML = "Daily Parking<br> 30.60 YEN";
            document.getElementById("monthlyParking").innerHTML = "Monthly Parking<br> 765.00 YEN";
            document.getElementById("yearlyParking").innerHTML = "Yearly Parking<br> 5355.00 YEN";
        }


    }
}

function payMonthly() {
    if (empRegister == 1) {
        if (vehicleRegister == 1) {
       	 document.getElementById("submitEmpVehiclePassType").value="monthly";
       	document.getElementById("submitEmpVehiclePassType").value="yearly";
   	 if(vehicleType == "Bicycle")
 		 {
  		document.getElementById("submitEmpVehiclePassCost").value="1.40 USD";          		 
 		 }
 	 else if (vehicleType == "MotorCycle")
 		 {
  		document.getElementById("submitEmpVehiclePassCost").value="2.80 USD";
 		 }
 	 else if (vehicleType == "FourWheelers")
 		 {
 		document.getElementById("submitEmpVehiclePassCost").value="14.0 USD";
 		 }            	document.getElementById("allFormSubmit").submit();
         
        } else {
            alert("Please Register vehicle First");

        }
    } else {
        alert("Please Register Employee First");
    }

}

function payDaily() {
    if (empRegister == 1) {
        if (vehicleRegister == 1) {
          	 document.getElementById("submitEmpVehiclePassType").value="daily";
          	 if(vehicleType == "Bicycle")
          		 {
           		document.getElementById("submitEmpVehiclePassCost").value="0.070 USD";          		 
          		 }
          	 else if (vehicleType == "MotorCycle")
          		 {
           		document.getElementById("submitEmpVehiclePassCost").value="0.014 USD";
          		 }
          	 else if (vehicleType == "FourWheelers")
          		 {
          		document.getElementById("submitEmpVehiclePassCost").value="0.028 USD";
          		 }
        	document.getElementById("allFormSubmit").submit();

          

        } else {
            alert("Please Register vehicle First");

        }
    } else {
        alert("Please Register Employee First");
    }

}

function payYearly() {
    if (empRegister == 1) {
        if (vehicleRegister == 1) {
        	 document.getElementById("submitEmpVehiclePassType").value="yearly";
        	 if(vehicleType == "Bicycle")
      		 {
       		document.getElementById("submitEmpVehiclePassCost").value="7.0 USD";          		 
      		 }
      	 else if (vehicleType == "MotorCycle")
      		 {
       		document.getElementById("submitEmpVehiclePassCost").value="14.0 USD";
      		 }
      	 else if (vehicleType == "FourWheelers")
      		 {
      		document.getElementById("submitEmpVehiclePassCost").value="49.0 USD";
      		 }        	document.getElementById("allFormSubmit").submit();

        } else {
            alert("Please Register vehicle First");

        }
    } else {
        alert("Please Register Employee First");
    }

}

function vehicleChange() {
	if(vehicleChanged==0)
		{
		document.getElementById("vehicleType").remove(0);
		}
    vehicleType = document.getElementById("vehicleType").value;
    vehicleChanged = 1;
    document.getElementById("vehicleType").style.borderColor = "green";
    document.getElementById("parkingRate").innerHTML = document.getElementById("parkingRate").innerHTML + " : " + vehicleType;
}