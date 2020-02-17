<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<% session.setAttribute("name","");
     session.setAttribute("employeeId","");
     session.setAttribute("gender","");
     session.setAttribute("email","");
     session.setAttribute("contact","");
     session.setAttribute("organisation","");
     session.setAttribute("vehicleName","");
     session.setAttribute("vehicleType","");
     session.setAttribute("vehicleInformation","");
     session.setAttribute("vehicleNumber","");
     session.setAttribute("passType","");
     session.setAttribute("passCost","");
     session.setAttribute("friends","");
    session.setAttribute("friendEmployeeId","");
    session.setAttribute("friendGender","");
    session.setAttribute("friendEmail","");
    session.setAttribute("friendContact","");
    session.setAttribute("friendOrganisation","");
    session.setAttribute("friendVehicleName","");
    session.setAttribute("friendVehicleType","");
    session.setAttribute("friendVehicleInformation","");
    session.setAttribute("friendVehicleNumber","");
    session.setAttribute("friendPassType","");
    session.setAttribute("friendPassCost","");	
    response.sendRedirect("index.jsp");%> 
</body>
</html>