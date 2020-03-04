<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/login" var="Url" />

	<form:form  modelAttribute="logindata" action="${Url}" >
<br>				<center><form:errors path="password" cssClass="text-danger" /></center>
<br>
		<center><button type="button" class="btn btn-primary" >Sign In</button></center>
		
		<div >
			<form:label path="email">Email</form:label>
			<form:input path="email" type="text" class="form-control"
				 placeholder="Email" />
			<form:errors path="email" cssClass="text-danger" />
				 
		</div>
		<div >
			<form:label path="password" >Password</form:label>
			<form:input path="password" type="password" class="form-control"
				id="empEmail" placeholder="Password" />
		</div>
		<br>	
		<center><button type="submit" id="btn" class="btn btn-primary">Proceed</button></center>
				</form:form>
		