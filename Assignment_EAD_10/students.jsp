<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="../includes/header.jsp" %>


<table class="table table-striped">
    <thead>
      <tr>
      	<th> Name</th>      	
        <th>Gender</th>
        <th>Email</th>
        <th>Password</th>
        <th>Contact </th>
        <th>Organization</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">


 <tr>   <td>${student.name}</td>
        <td>${student.gender}</td>
        <td>${student.email}</td>
        <td>${student.password}</td>
        <td>${student.organisation}</td>
        <td>${student.contact}</td>
        <td>${student.vehicleName}</td> 		
 		<td>${student.vehicleType}</td>
 		<td>${student.vehicleNumber}</td>
 		<td>${student.vehicleIdentification}</td>
 		
 		<td>${student.passType}</td>
      </tr>
	
</c:forEach>
     
      
    </tbody>
  </table>




