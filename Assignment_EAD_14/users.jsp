<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Users</title>
<style>
.col{
font-size:20px;
margin-left:50px;
padding-left:150px;
}
</style>
</head>
<body>



<table class="table">
<thead>
<tr>

<th class="col">Name</th>
<th class="col">Role</th>
<th class="col">Email</th>
</tr>
</thead>
<tbody>
<c:forEach var="listValue" items="${users}">


<tr>
<td class="col">${listValue.getPassword() }</td>
<td class="col">${listValue.getRole() }</td>
<td class="col">${listValue.getEmail() }</td>
</tr>

</c:forEach>
</tbody>
</table>
</body>
</html>