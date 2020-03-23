<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@include file="../includes/header.jsp" %>


<table class="table table-striped">
    <thead>
      <tr>
      	<th>First Name</th>
        <th> Last Name</th>
        <th>Father's Name</th>
        <th>Email</th>
        <th>class </th>
        <th>Age</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">


 <tr>   <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.fatherName}</td>
        <td>${student.email}</td>
        <td>${student.classOfStudent}</td>
       	<td>${student.age}</td>
      </tr>

</c:forEach>
     
      
    </tbody>
  </table>




