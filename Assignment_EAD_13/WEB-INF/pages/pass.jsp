<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/pass" var="userActionUrl" />

<form:form modelAttribute="pass" action="${userActionUrl}" >
	<form:errors /><br>
		<center>
			<button type="button" class="btn btn-primary">Pass</button>
		</center>

			<form:input path="name" type="hidden" class="form-control" id="empName"
				placeholder="Name" />
			<form:input path="gender" type="hidden" class="form-control"
				 placeholder="Email" />
		
			<form:input path="email" type="hidden" class="form-control"
				 placeholder="Email" />
		
			<form:input path="password" type="hidden" class="form-control"
				 placeholder="Password" />
				

			<form:input path="confirmPassword" type="hidden" />

					<form:input path="organisation" type="hidden" />
		
			<form:input path="contact" type="hidden" />
			<form:input path="image" type="hidden" />
			<form:input path="vehicleName" type="hidden" />
		
			<form:input path="vehicleNumber" type="hidden" />
		
			<form:input path="id" type="hidden"/>
	
			<form:input path="vehicleIdentification" type="hidden"
				 />
		<div>
			<form:label path="vehicleType">Vehicle Type</form:label>
			<form:input path="vehicleType" type="text" class="form-control"
				id="vehicleType"  />
			<form:errors path="vehicleType" cssClass="text-danger" />
				
		</div>
		<br>

		<div class="form-group">
			Currency Type
			<select class="form-control" id="currency"
				onchange="currencyTypeChange()">
				<option value=""/>
				<option value="INR" />INR
				<option value="USD" />USD
				<option value="YEN" />YEN
			</select>
			
		</div>
		<div class="form-group">
			<form:label path="passType">pass Type</form:label>
			<form:select path="passType" class="form-control" id="passType"
				onchange="passTypeChange()">
				<form:option value="daily" id="dailyPass" />
				<form:option value="monthly" id="monthlyPass" />
				<form:option value="yearly" id="yearlyPass" />
			</form:select>
		<form:errors path="passType" cssClass="text-danger" />
					<form:errors path="passType" cssClass="text-danger" />
			
		</div>
		<form:input path="passCost" type="hidden" id="passCost" value="0 $" />
				<form:errors path="passCost" cssClass="text-danger" />
		
		<center>
					<button type="submit" id="btn" class="btn btn-primary"
				onclick="assign()">Proceed</button>

		</center>

</form:form>
<script>
document.getElementById("vehicleType").readOnly=true;

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