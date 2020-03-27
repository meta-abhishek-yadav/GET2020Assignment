<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/employee" var="userActionUrl" />

<form:form modelAttribute="employee" action="${userActionUrl}" id="form">
	<form:errors />
	
		<br>
		<center>
			<button type="button" class="btn btn-primary">Employee Data</button>
		</center>

		<div>
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" class="form-control" id="empName"
				placeholder="Name" />
		</div>
		<form:errors path="name" cssClass="text-danger" />
		<br>
		<div id="radiogender">
			<form:label path="gender">Gender</form:label>
			<br>
			<form:radiobutton path="gender"  id="empGender"
				name="gender" value="Male"  />Male
			
			<form:radiobutton path="gender" name="gender" value="Female"
				/>Female
			
			<form:radiobutton path="gender"  name="gender"
				value="Other" />Other
							<br>
				
		<form:errors path="gender" cssClass="text-danger" />
				
		</div>
		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:input path="email" type="text" class="form-control"
				id="empEmail" placeholder="Email" />
					<form:errors path="email" cssClass="text-danger" />

		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:input path="password" type="password" class="form-control"
				id="empPassword" placeholder="Password" />
					<form:errors path="password" cssClass="text-danger" />


		</div>
		<div class="form-group">
			<form:label path="confirmPassword">Confirm Password</form:label>
			<form:input path="confirmPassword" type="password"
				class="form-control" id="empConfirmPassword"
				placeholder="Confirm Password" />
			<form:errors path="confirmPassword" cssClass="text-danger" />

		</div>
		<div class="form-group">
			<form:label path="contact">Contact</form:label>
			<form:input path="contact" type="number" class="form-control"
				id="empContact" placeholder="Contact Number" />
		<form:errors path="contact" cssClass="text-danger" />

		</div>

		<div class="form-group">
			<form:label path="organisation">Organistaion</form:label>
			<form:select path="organisation" class="form-control">
				<form:option value="Metacube" />
				<form:option value="Google" />
				<form:option value="Microsoft" />
				<form:option value="Apple" />
				<form:option value="TCS" />
				<form:option value="Infosys" />
			</form:select>
		</div>
		Image<br><input type="file" id="image">
		<form:input path="image" type="hidden" class="form-control"
				id="Empimage"  />
		<form:errors path="image" cssClass="text-danger" />

		<center>
			<button type="submit" id="btn" class="btn btn-primary"
				onclick="assign()">Proceed</button>
	<script>
	function assign()
	{
		var image=document.getElementById("image").value;
		var index=image.lastIndexOf("\\");
		var name=image.substring(index+1);
		document.getElementById("Empimage").value=name;
	}
	</script>
		</form:form>