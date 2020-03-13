<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="../includes/loginheader.jsp" %>

<html>
<body>
<table class="table table-striped">
</br>
<center><button class="btn btn-primary">Profile</button></center>
</br>

    <thead>
    <tr><center><img src=${employee.image} height="200px" alt="xnscx"/></center></tr>
      <tr><th> Name</th>      	  <td>${employee.name}</td></tr>
       <tr><th> Id</th>      	  <td>${employee.id}</td></tr>
      
        <tr> <th>Gender</th>  <td>${employee.gender}</td></tr>
        <tr> <th>Email</th><td>${employee.email}</td></tr>
        <tr> <th>Password</th> <td>${employee.password}</td></tr>
        <tr> <th>Contact </th>        <td>${employee.contact}</td></tr>
        
        <tr> <th>Organisation</th>  <td>${employee.organisation}</td></tr>
       <tr> <th>vehicle Name</th>  <td>${employee.vehicleName}</td> </tr>
         <tr> <th>vehicle Type</th><td>${employee.vehicleType}</td></tr>
        <tr> <th>vehicle Number</th> <td>${employee.vehicleNumber}</td></tr>
         <tr> <th>vehicle Identification</th><td>${employee.vehicleIdentification}</td></tr>
        <tr> <th>pass Type</th> <td>${employee.passType}</td></tr>
        <tr> <th>pass Cost</th> <td>${employee.passCost}</td></tr>
        
    </thead>
  </table>

</body>
</html>



