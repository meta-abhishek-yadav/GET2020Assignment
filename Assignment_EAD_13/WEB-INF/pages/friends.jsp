<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="../includes/loginheader.jsp" %>


<table class="table table-striped">
    <thead>
      <tr>
      	<th> Name</th>
      	<th>Employee Id</th>
        <th>Gender</th>
        <th>Email</th>
        <th>Contact</th>
        <th>organization</th>
        <th>Vehicle Name</th>
        <th>Vehicle Type</th>
        <th>Vehicle Number</th>
        <th>Vehicle Identification</th>
        <th>pass Type</th>        
        <th>pass Cost</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">


 <tr>   <td>${employee.name}</td>
         <td>${employee.id}</td>
        <td>${employee.gender}</td>
        <td>${employee.email}</td>
        <td>${employee.contact}</td>
        <td>${employee.organisation}</td>
        <td>${employee.vehicleName}</td>
        <td>${employee.vehicleType}</td>
        <td>${employee.vehicleNumber}</td>
        <td>${employee.vehicleIdentification}</td>
        <td>${employee.passType}</td>
        <td>${employee.passCost}</td>
        <td><img src="images/${employee.image}" height="100px"/></td>
      </tr>

</c:forEach>
     
      
    </tbody>
  </table>




