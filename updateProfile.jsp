<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
        Car Parking
    </title>
    <link rel="stylesheet" href="updateStyle.css" type="text/css">
    <script src="updatescript.js"></script>
</head>
<body>
 <% String email=(String)session.getAttribute("email");
    if(email.length()==0)
    {
    	response.sendRedirect("index.jsp");
    }
    %>
    <panel>
     <%String name=(String)session.getAttribute("name"); %>
    <%String employeeId=(String)session.getAttribute("employeeId"); %>
    <%String contact=(String)session.getAttribute("contact"); %>
    <%String organisation=(String)session.getAttribute("organisation"); %>
    <%String vehicleName=(String)session.getAttribute("vehicleName"); %>
    <%String vehicleType=(String)session.getAttribute("vehicleType"); %>
    <%String vehicleNumber=(String)session.getAttribute("vehicleNumber"); %>
	<%String vehicleInformation=(String)session.getAttribute("vehicleInformation"); %>
   	<%String passType=(String)session.getAttribute("passType"); %>
    <%String passCost=(String)session.getAttribute("passCost"); %>
    <%String gender=(String)session.getAttribute("gender"); %>

    <h1>Update profile</h1>
      <form id="updateallFormSubmit" method="post" action="UpdateData">
       Name</br> <input type="text" name="updatesubmitEmpName" id="updatesubmitEmpName" EmpId" required> 
       </br>  Employee Id</br><input type="text" name="updatesubmitEmpId" id="updatesubmitEmpId" required>
       </br> Gender</br><select name="updatesubmitEmpGender" id="updatesubmitEmpGender"><option>male</option><option>female</option><option>other</option></select>
      
      </br>  Email</br><input type="text" name="updatesubmitEmpEmail" id="updatesubmitEmpEmail" required>
       </br>Password</br> <input type="password" name="updatesubmitEmpPassoword" id="updatesubmitEmpPassoword" onchange="passwordChanged()" required>
       </br> Contact Number</br><input type="number" name="updatesubmitEmpContact" id="updatesubmitEmpContact" required>
       
        </br>Organisation</br>
        <select name="updatesubmitEmpOrganisation" id="updatesubmitEmpOrganisation"><option>Metacube</option><option>Apple</option><option>Google</option><option>MicroSoft</option></select>
        
       </br>Vehicle Name</br> <input type="text" name="updatesubmitEmpVehicleName" id="updatesubmitEmpVehicleName" required>
       </br>Vehicle Type</br><select name="updatesubmitEmpVehicleType" id="updatesubmitEmpVehicleType" onchange="currencyChanged()"><option>Bicycle</option><option>MotorCycle</option><option>FourWheelers</option></select>
       
       </br> Vehicle Identication</br><input type="text" name="updatesubmitEmpVehicleIdentification" id="updatesubmitEmpVehicleIdentification" required>
       </br> Vehicle Number</br><input type="text" name="updatesubmitEmpVehicleNumber" id="updatesubmitEmpVehicleNumber" required>
       </br> Pass Type</br><select name="updatesubmitEmpVehiclePassType" id="updatesubmitEmpVehiclePassType" onchange="currencyChanged()"><option>daily</option><option>monthly</option><option>yearly</option></select>
       </br> Pass Cost</br><input type="text" name="updatesubmitEmpVehiclePassCost" id="updatesubmitEmpVehiclePassCost" required>
        
        </br></br><input type="submit" value="update">
    </form>
        <script>
    document.getElementById("updatesubmitEmpName").value="<%=name %>";
    document.getElementById("updatesubmitEmpId").value="<%=employeeId %>";
    document.getElementById("updatesubmitEmpEmail").value="<%=email%>";
    document.getElementById("updatesubmitEmpContact").value="<%=contact %>";
    document.getElementById("updatesubmitEmpOrganisation").value="<%=organisation %>";
    document.getElementById("updatesubmitEmpVehicleName").value="<%=vehicleName %>";
    document.getElementById("updatesubmitEmpVehicleType").value="<%=vehicleType %>";
    document.getElementById("updatesubmitEmpVehicleNumber").value="<%= vehicleNumber%>";
    document.getElementById("updatesubmitEmpVehicleIdentification").value="<%= vehicleInformation%>";
    document.getElementById("updatesubmitEmpId").readOnly = true;
    document.getElementById("updatesubmitEmpId").style.backgroundColor = "blue";
    document.getElementById("updatesubmitEmpId").style.borderColor = "green";
    document.getElementById("updatesubmitEmpId").style.color = "white";
    document.getElementById("updatesubmitEmpVehiclePassType").value="<%= passType%>";
    document.getElementById("updatesubmitEmpGender").value="<%= gender%>";
    document.getElementById("updatesubmitEmpVehicleIdentification").value="<%= vehicleInformation%>";
    document.getElementById("updatesubmitEmpVehiclePassCost").value="<%= passCost%>";
	document.getElementById("updatesubmitEmpVehiclePassCost").readOnly = true;
    document.getElementById("updatesubmitEmpVehiclePassCost").style.backgroundColor = "blue";
    document.getElementById("updatesubmitEmpVehiclePassCost").style.borderColor = "green";
    document.getElementById("updatesubmitEmpVehiclePassCost").style.color = "white";
    function currencyChanged()
    {
    	var passtype=document.getElementById("updatesubmitEmpVehiclePassType").value;
    	var vehicleType=document.getElementById("updatesubmitEmpVehicleType").value;
    	if(passtype == "daily")
    		{
    		if(vehicleType == "Bicycle")
     		 {
      		document.getElementById("updatesubmitEmpVehiclePassCost").value="0.070 USD";          		 
     		 }
     	 else if (vehicleType == "MotorCycle")
     		 {
      		document.getElementById("updatesubmitEmpVehiclePassCost").value="0.014 USD";
     		 }
     	 else if (vehicleType == "FourWheelers")
     		 {
     		document.getElementById("updatesubmitEmpVehiclePassCost").value="0.028 USD";
     		 }
    		}
    	else if(passtype == "monthly")
    		{
    		if(vehicleType == "Bicycle")
    		 {
     		document.getElementById("updatesubmitEmpVehiclePassCost").value="1.40 USD";          		 
    		 }
    	 else if (vehicleType == "MotorCycle")
    		 {
     		document.getElementById("updatesubmitEmpVehiclePassCost").value="2.80 USD";
    		 }
    	 else if (vehicleType == "FourWheelers")
    		 {
    		document.getElementById("updatesubmitEmpVehiclePassCost").value="14.0 USD";
    		 }  
    		}
    	else if(passtype == "yearly")
    		{
    		 if(vehicleType == "Bicycle")
      		 {
       		document.getElementById("updatesubmitEmpVehiclePassCost").value="7.0 USD";          		 
      		 }
      	 else if (vehicleType == "MotorCycle")
      		 {
       		document.getElementById("updatesubmitEmpVehiclePassCost").value="14.0 USD";
      		 }
      	 else if (vehicleType == "FourWheelers")
      		 {
      		document.getElementById("updatesubmitEmpVehiclePassCost").value="49.0 USD";
      		 }     
    		}
    	
    }
    function passwordChanged()
    {
    	var password=document.getElementById("updatesubmitEmpPassoword").value;
    	var UpperCase = 0;
        var lowerCase = 0;
        var alphabet = 0;
        var specialChar = 0;
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
    if (alphabet == 0 || lowerCase == 0 || specialChar == 0 || UpperCase == 0 || password.length<8) {
		alert("Please Enter Strong Password");
    }
    
    }
    </script>
    </panel>
	
</body>

</html>