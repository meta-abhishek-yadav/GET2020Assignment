<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/signup" var="userActionUrl" />

<form:form modelAttribute="employee" action="${userActionUrl}" id="form">
	<form:errors />


	<div id="employeeForm">
		<br>
		<center>
			<button type="button" class="btn btn-primary">Employee Data</button>
		</center>

		<div>
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control" id="empName"
				placeholder="Name" />
		</div>
		<div id="errorName" style="color: red">Please enter valid Name</div>
		<br>
		<div id="radiogender">
			<form:label path="gender">Gender</form:label>
			</br>
			<form:radiobutton path="gender"  id="empGender"
				name="gender" value="Male"  />Male
			
			<form:radiobutton path="gender" name="gender" value="Female"
				/>Female
			
			<form:radiobutton path="gender"  name="gender"
				value="Other" />Other
			<div id="errorGender" style="color: red">Please Select valid
				Gender</div>
		</div>
		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:input path="email" type="text" class="form-control"
				id="empEmail" placeholder="Email" />
			<div id="errorEmail" style="color: red">Please enter valid
				Email</div>
		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:input path="password" type="password" class="form-control"
				id="empPassword" placeholder="Password" />
			<div id="errorPassword" style="color: red">Please enter valid
				Password</div>

		</div>
		<div class="form-group">
			<form:label path="confirmPassword">Confirm Password</form:label>
			<form:input path="confirmPassword" type="password"
				class="form-control" id="empConfirmPassword"
				placeholder="Confirm Password" />
			<div id="errorConfirmPassword" style="color: red">Confirm
				Password did not match with Password</div>
		</div>
		<div class="form-group">
			<form:label path="contact">Contact</form:label>
			<form:input path="contact" type="text" class="form-control"
				id="empContact" placeholder="Contact Number" />
			<div id="errorContact" style="color: red">Please enter valid
				Contact</div>
		</div>

		<div class="form-group">
			<form:label path="organisation">Organistaion</form:label>
			<form:select path="organisation" class="form-control">
				<form:option value="Metacube" />
				<form:option value="Google" />
				<form:option value="Microsoft" />
				<form:option value="Apple" />
				<form:option value="TCS" />
				<form:option value="Infosys" />
			</form:select>
		</div>
		Image<br><input type="file" id="image">
		<div id="errorImage" style="color: red">Please select Image
				</div>		<form:input path="image" type="hidden" id="empImage" />
				
		<center>
			<button type="button" id="btn" class="btn btn-primary"
				onclick="studentsSubmission()">Proceed</button>
		</center>
	</div>
	<div id="vehicleForm">
		<br>
		<center>
			<button type="button" class="btn btn-primary">Vehicle Data</button>
		</center>

		<div>
			<form:label path="vehicleName">Vehicle Name</form:label>
			<form:input path="vehicleName" type="text" class="form-control"
				id="vehicleName" placeholder=" Vehicle Name" />
			<div id="errorVehicleName" style="color: red">Please enter
				valid Vehicle Name</div>

		</div>
		<br>
		<div>
			<form:label path="vehicleNumber">Vehicle Number</form:label>
			<form:input path="vehicleNumber" type="text" class="form-control"
				id="vehicleNumber" placeholder="Vehicle Number" />
			<div id="errorVehicleNumber" style="color: red">Please enter
				valid Vehicle Number</div>

		</div>
		<div class="form-group">
			<form:label path="id">Employee Id</form:label>
			<form:input path="id" type="text" class="form-control" id="empId"
				placeholder="Email" />
		</div>
		<div class="form-group">
			<form:label path="vehicleType">Vehicle Type</form:label>
			<form:select path="vehicleType" class="form-control" id="vehicleType">
				<form:option value="Bicycle" />
				<form:option value="MotorCycle" />
				<form:option value="FourWheeler" />
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="vehicleIdentification">Identification</form:label>
			<form:input path="vehicleIdentification" type="text"
				class="form-control" id="vehicleIdentification" placeholder="vehicle Identification" />
			<div id="errorVehicleIdentification" style="color: red">Please
				enter valid vehicle Identification</div>
		</div>
		<center>
			<button type="button" id="btn" class="btn btn-primary"
				onclick="studentsSubmission1()">Proceed</button>
		</center>
	</div>
	<div id="passForm">
		<br>
		<center>
			<button type="button" class="btn btn-primary">Pass</button>
		</center>

		<div>
			<label>Vehicle Type
				</form> <input type="text" class="form-control" id="vehicleNamePassForm"
				placeholder="Name" />
		</div>
		<br>

		<div class="form-group">
			<form>Currency Type</form>
			<select class="form-control" id="currency"
				onchange="currencyTypeChange()">
				<option value=""/>
				<option value="INR" />INR
				<option value="USD" />USD
				<option value="YEN" />YEN
			</select>
		</div>
		<div class="form-group">
			<form:label path="">pass Type</form:label>
			<form:select path="passType" class="form-control" id="passType"
				onchange="passTypeChange()">
				<form:option value="daily" id="dailyPass" />
				<form:option value="monthly" id="monthlyPass" />
				<form:option value="yearly" id="yearlyPass" />
			</form:select>
		</div>
		<form:input path="passCost" type="hidden" id="passCost" value="0 $" />
		
		<center>
			<button type="submit" id="btn" class="btn btn-primary"
				onclick="change()">Proceed</button>
		</center>

	</div>
</form:form>

<script>
	document.getElementById("vehicleForm").style = "display:none";
	document.getElementById("passForm").style = "display:none";
	document.getElementById("errorName").style = "display:none";
	document.getElementById("errorGender").style = "display:none";
	document.getElementById("errorPassword").style = "display:none";
	document.getElementById("errorConfirmPassword").style = "display:none";
	document.getElementById("errorContact").style = "display:none";
	document.getElementById("errorVehicleName").style = "display:none";
	document.getElementById("errorVehicleNumber").style = "display:none";
	document.getElementById("errorEmail").style = "display:none";
	document.getElementById("errorVehicleIdentification").style = "display:none";
	document.getElementById("errorImage").style = "display:none";

	function studentsSubmission() {
		var empName = document.getElementById("empName").value;
		var empGender = document.getElementById("empGender").value;
		var empEmail = document.getElementById("empEmail").value;
		var image = document.getElementById("image").value;
		
		var empContact = document.getElementById("empContact").value;
		var empPassword = document.getElementById("empPassword").value;
		var empConfirmPassword = document.getElementById("empConfirmPassword").value;
		var emailValid = 0, passwordvalid = 1, number = 0, small = 0, big = 0, special = 0, contactValid = 0;
		for (var i = 0; i < empEmail.length; i++) {
			if (empEmail[i] == "@") {
				if (i > 2 && (empEmail.length - i) > 2) {
					emailValid = 1;
				}
				break;
			}
		}
		for (var i = 0; i < empPassword.length; i++) {
			if (empPassword.charCodeAt(i) >= 48
					&& empPassword.charCodeAt(i) <= 57) {
				number++;
			} else if (empPassword.charCodeAt(i) >= 97
					&& empPassword.charCodeAt(i) <= 123) {
				small++;
			} else if (empPassword.charCodeAt(i) >= 65
					&& empPassword.charCodeAt(i) <= 91) {
				big++;
			} else {
				special++;
			}
		}
		if (empPassword.length < 8 || number == 0 || small == 0 || big == 0
				|| special == 0) {
			passwordvalid = 0;
		}
		
		for (var i = 0; i < empContact.length; i++) {
			if (empContact.charCodeAt(i) >= 48
					&& empContact.charCodeAt(i) <= 57) {
				contactValid = 1;
			} else {
				contactValid = 0;
				break;

			}

		}
		if(empContact.length<8 || empContact.length>10)
		{
		contactValid=0;
		}
		if (empName.length > 2) {
			document.getElementById("errorName").style = "display:none";

			if (empGender != null) {
				document.getElementById("errorGender").style = "display:none";

				if (emailValid == 1) {
					document.getElementById("errorEmail").style = "display:none";

					if (passwordvalid == 1) {
						document.getElementById("errorPassword").style = "display:none";

						if (empPassword == empConfirmPassword) {
							document.getElementById("errorConfirmPassword").style = "display:none";

							if (contactValid == 1) {
			
								document.getElementById("errorContact").style = "display:none";
								if(image.length>0)
									{
									document.getElementById("errorImage").style = "display:none";
									
								document.getElementById("vehicleForm").style = "display:block";
								document.getElementById("employeeForm").style = "display:none";
								document.getElementById("empImage").value=image;
								document.getElementById("empId").value = empName[0]
										+ empName[1]
										+ empContact[0]
										+ empContact[1]
										+ empContact[2]
										+ empContact[3];
								document.getElementById("empId").readOnly = true;
								document.getElementById("empId").style = "color:RED";
							}
								else
								{
									document.getElementById("errorImage").style = "display:inline; color:red;";
									
								}
							}
								 else {
								document.getElementById("errorContact").style = "display:inline; color:red;";

							}
						} else {
							document.getElementById("errorConfirmPassword").style = "display:inline; color:red;";

						}
					} else {
						document.getElementById("errorPassword").style = "display:inline; color:red;";

					}
				} else {
					document.getElementById("errorEmail").style = "display:inline; color:red;";

				}
			} else {
				document.getElementById("errorGender").style = "display:inline; color:red;";

			}
		} else {
			document.getElementById("errorName").style = "display:inline; color:red;";

		}

		/*document.getElementById("errorContact").style="display:none";
		document.getElementById("vehicleForm").style="display:block";
		document.getElementById("employeeForm").style="display:none";

		document.getElementById("empId").value=empName[0]+empName[1]+empContact[0]+empContact[1]+empContact[2]+empContact[3];
		document.getElementById("empId").readOnly=true;
		document.getElementById("empId").style="color:RED";*/
	}

	function studentsSubmission1() {
		var vehicleName = document.getElementById("vehicleName").value;
		var vehicleNumber = document.getElementById("vehicleNumber").value;
		var vehicleIdentification = document
				.getElementById("vehicleIdentification").value;
		if (vehicleName.length > 0) {
			document.getElementById("errorVehicleName").style = "display:none";

			if (vehicleNumber.length > 0) {
				document.getElementById("errorVehicleNumber").style = "display:none";

				if (vehicleIdentification.length > 0) {
					document.getElementById("errorVehicleIdentification").style = "display:none";
					document.getElementById("passForm").style = "display:block";
					document.getElementById("vehicleForm").style = "display:none";
					document.getElementById("vehicleNamePassForm").value = document
							.getElementById("vehicleType").value;
					document.getElementById("vehicleNamePassForm").readOnly = true;
					document.getElementById("vehicleNamePassForm").style = "color:RED";

				} else {
					document.getElementById("errorVehicleIdentification").style = "display:inline; color:red;";

				}
			} else {
				document.getElementById("errorVehicleNumber").style = "display:inline; color:red;";

			}
		} else {
			document.getElementById("errorVehicleName").style = "display:inline; color:red;";

		}

	}
	function currencyTypeChange() {
		var vehicle = document.getElementById("vehicleType").value;
		var currency = document.getElementById("currency").value;
		if (currency == "INR") {
			if (vehicle == "Bicycle") {
				document.getElementById("passCost").value = "0.07 $";
				document.getElementById("dailyPass").innerHTML = "Daily Parking 5 RS";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 100 RS";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 500 RS";
			} else if (vehicle == "MotorCycle") {
				document.getElementById("passCost").value = "0.14 $";				
				document.getElementById("dailyPass").innerHTML = "Daily Parking 10 RS";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 200 RS";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 1000 RS";
			} else if (vehicle == "FourWheeler") {
				document.getElementById("passCost").value = "0.28 $";				
				document.getElementById("dailyPass").innerHTML = "Daily Parking 20 RS";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 500 RS";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 3500 RS";
			}
		} else if (currency == "USD") {
			if (vehicle == "Bicycle") {
				document.getElementById("passCost").value = "0.07 $";				
				document.getElementById("dailyPass").innerHTML = "Daily Parking 0.07 $";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 1.4 $";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 7.0 $";
			} else if (vehicle == "MotorCycle") {
				document.getElementById("passCost").value = "0.14 $";				
				document.getElementById("dailyPass").innerHTML = "Daily Parking 0.14 $";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 2.8 $";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 14.0 $";
			} else if (vehicle == "FourWheeler") {
				document.getElementById("passCost").value = "0.28 $";				
				document.getElementById("dailyPass").innerHTML = "Daily Parking 0.28 $";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 7.14 $";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 50$";

			}
		} else if (currency == "YEN") {
			if (vehicle == "Bicycle") {
				document.getElementById("passCost").value = " 0.07 $";				
				document.getElementById("dailyPass").innerHTML = "Daily Parking 7 YEN";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 150 YEN";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 1500 YEN";
			} else if (vehicle == "MotorCycle") {
				document.getElementById("passCost").value = "0.14 $";
				document.getElementById("dailyPass").innerHTML = "Daily Parking 14 YEN";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 300 YEN";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 3000 YEN";
			} else if (vehicle == "FourWheeler") {
				document.getElementById("passCost").value = "0.28 $";
				document.getElementById("dailyPass").innerHTML = "Daily Parking 30 YEN";
				document.getElementById("monthlyPass").innerHTML = "Monthly Parking 750 YEN";
				document.getElementById("yearlyPass").innerHTML = "Yearly Parking 5250 YEN";
			}
		}
	}
	function passTypeChange() {
		var vehicle = document.getElementById("vehicleType").value;
			
		var x = document.getElementById("passType").selectedIndex;
		if (x == 0) {
			if (vehicle == "Bicycle") {
				document.getElementById("passCost").value = "0.07 $";
			} else if (vehicle == "MotorCycle") {
				document.getElementById("passCost").value = "0.14 $";
			} else if (vehicle == "FourWheeler") {
				document.getElementById("passCost").value = "0.28 $";
			}
		}
		 else if (x == 1) {
			 if (vehicle == "Bicycle") {
					document.getElementById("passCost").value = "1.4 $";
				} else if (vehicle == "MotorCycle") {
					document.getElementById("passCost").value = "2.8 $";
				} else if (vehicle == "FourWheeler") {
					document.getElementById("passCost").value = "7.14 $";
				}
		} else if (x == 2) {
			if (vehicle == "Bicycle") {
				document.getElementById("passCost").value = "7 $";
			} else if (vehicle == "MotorCycle") {
				document.getElementById("passCost").value = "14 $";
			} else if (vehicle == "FourWheeler") {
				document.getElementById("passCost").value = "50 $";
			}
		}

	}
</script>
