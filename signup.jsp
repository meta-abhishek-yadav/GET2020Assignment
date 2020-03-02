<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/signup" var="userActionUrl" />


	<form:form modelAttribute="student" action="${userActionUrl}">

		<form:errors />
		<form:hidden path="id"/>
		
		<div class="form-group">
			<form:label path="firstName"> First Name</form:label>
			<form:input path="firstName" type="text" class="form-control"
				id="exampleInputName1" placeholder="First Name" />
			<form:errors path="firstName" cssClass="text-danger" />
				
		</div>
			<div class="form-group">
			<form:label path="lastName"> Last Name</form:label>
			<form:input path="lastName" type="text" class="form-control"
				id="exampleInputName1" placeholder="Last Name" />
		<form:errors path="lastName" cssClass="text-danger" />
				
		</div>
			<div class="form-group">
			<form:label path="fatherName"> Father's Name</form:label>
			<form:input path="fatherName" type="text" class="form-control"
				id="exampleInputName1" placeholder="Father's Name" />
		<form:errors path="fatherName" cssClass="text-danger" />
				
		</div>
		<div class="form-group">
			<form:label path="email">Email address</form:label>
			<form:input path="email" type="text" class="form-control"
				id="exampleInputEmail1" placeholder="Email" />
		<form:errors path="email" cssClass="text-danger" />
		</div>
			<div class="form-group">
			<form:label path="classOfStudent">class</form:label>
			<form:input path="classOfStudent" type="text" class="form-control"
				id="exampleInputName1" placeholder="Class" />
			<form:errors path="classOfStudent" cssClass="text-danger" />
				
		</div>
			<div class="form-group">
			<form:label path="age">Age</form:label>
			<form:input path="age" type="text" class="form-control"
				id="exampleInputName1" placeholder="Age" />
			<form:errors path="age" cssClass="text-danger" />
		</div>
	
		<button type="submit" class="btn btn-primary">Submit</button>		
	
	</form:form>
