<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
        Car Parking
    </title>
    <link rel="stylesheet" href="style.css" type="text/css">
    <script src="script.js"></script>

</head>

<body>

    <panel>
        <button id="signup" onclick="signupPage()">
            SignUp
        </button> <a id="heading" href="index.jsp">Metacube Connection</a>
        <button id="login" onclick="loginPage()">
            Login
        </button>
        <hr>
    </panel>
    <panel>


        <form id="employeeRegistrationForm" action="Servlet1" method="post">

            <h1 id="helo">Employee Registration Form</h1>
            <input type="text" name="employeeName" id="employeeName" placeholder="Enter Full Name(Minimum 3 character)" required>
            </br><span> Gender</span></br>
            <label> <input type="radio" name="gender" id="gender" value="male">Male</label>
            <label> <input type="radio" name="gender" id="gender" value="female">Female</label>
            <label> <input type="radio" name="gender" id="gender" value="male">Other</label>
            </br>
            <input type="text" name="employeeEmail" id="employeeEmail" placeholder="Email Id( '@' at minimum 3 index from both side) " required>
            </br>
            <input type="password" name="password" id="password" placeholder="Password(min 8 len+lower,upper,numeric, special char)" required>
            </br>
            <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" required>
            </br>
            <input type="text" name="contactNumber" id="contactNumber" placeholder="Contact Number(min 8 length + all numbers)" required>
             </br><select id="organisation" onchange="organisationSelect()">
            <Option>Choose your Organistation</Option>
            <Option>Metacube</Option>
            <Option>Google</Option>
            <Option>Microsoft</Option>
            <Option>Apple</Option>
        </select>
            </br>
			 <input type="button" value="Register Employee" id="empRegisterButton" onclick="regitserEmployee();">
			
        </form>
        <br> </br>
        </br>
        </br>
        <form id="VehicleRegistrationForm">
            <h1>Vehicle Registration Form</h1>
            <input type="text" name="VehicleName" id="VehicleName" placeholder="Enter Vehicle Name " required>
            </br>
            <select id="vehicleType" onchange="vehicleChange()">
            <option value="">Choose Type of vehicle</option>         
            <option value="Bicycle">Bicycle</option>
            <option value="MotorCycle">MotorCycle</option>
            <option value="FourWheelers">Four Wheelers</option>
        </select>
            </br>
            <input type="text" name="VehicleNumber" id="VehicleNumber" placeholder="Enter Vehicle Number(minimum 4 length)" required>
            </br>
            <input type="text" name="VehicleName" id="employeeId" placeholder="Enter employeeId" required>
            </br>
            <textArea id="vehicleIdentification" placeholder="Enter vehicle Identification(minimum 5 length)"></textArea>
            </br>
            <input type="button" value="Register Vehicle" id="vehicleRegisterButton" onclick="regitserVehicle();">
        </form>
        </br>
        </br>
        </br>

        <div id="payment">
            <form>
                <h2 id="parkingRate">Parking Rate</h2>
                <select onchange="currencyChange()" id="CurrencyChange">
                <option value="null">Choose Currency Type To Pay</option>
                <option value="INR">INR</option>
                <option value="USD">USD</option>
                <option value="YEN">YEN</option>
            </select>
            </form>
            <button id="dailyParking" value="daily parking " onclick="payDaily()"></button>
            <button id="monthlyParking" value="monthly parking " onclick="payMonthly()"></button>
            <button id="yearlyParking" value="yearly parking " onclick="payYearly()"></button>
        </div>
        <form id="allFormSubmit" method="post" action="SignUpServlet">
        <input type="hidden" name="submitEmpName" id="submitEmpName">
        <input type="hidden" name="submitEmpId" id="submitEmpId">
        <input type="hidden" name="submitEmpEmail" id="submitEmpEmail">
        <input type="hidden" name="submitEmpPassoword" id="submitEmpPassoword">
        <input type="hidden" name="submitEmpGender" id="submitEmpGender">
        <input type="hidden" name="submitEmpContact" id="submitEmpContact">
        <input type="hidden" name="submitEmpOrganisation" id="submitEmpOrganisation">
        <input type="hidden" name="submitEmpVehicleName" id="submitEmpVehicleName">
        <input type="hidden" name="submitEmpVehicleType" id="submitEmpVehicleType">
        <input type="hidden" name="submitEmpVehicleIdentification" id="submitEmpVehicleIdentification">
        <input type="hidden" name="submitEmpVehicleNumber" id="submitEmpVehicleNumber">
        <input type="hidden" name="submitEmpVehiclePassType" id="submitEmpVehiclePassType">
        <input type="hidden" name="submitEmpVehiclePassCost" id="submitEmpVehiclePassCost">
        <input type="hidden" name="submissionType" id="submissionType">
        
    </form>
    
    </panel>
	
</body>

</html>