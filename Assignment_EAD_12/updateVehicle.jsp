<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="../includes/loginheader.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/updateVehicle" var="userActionUrl" />

<form:form modelAttribute="vehicle" action="${userActionUrl}" id="form">
	<form:errors />
	
	<div>

			<form:input path="name" type="hidden" class="form-control" id="empName"
				placeholder="Name" />
			<form:input path="gender" type="hidden" class="form-control"
				 placeholder="Email" />
		
			<form:input path="email" type="hidden" class="form-control"
				 placeholder="Email" />
		
			<form:input path="password" type="hidden" class="form-control"
				 placeholder="Password" />
				

			<form:input path="confirmPassword" type="hidden" />

					<form:input path="organisation" type="hidden" />
		
			<form:input path="contact" type="hidden" />
			<form:input path="image" type="hidden" />
		<form:errors path="image" cssClass="text-danger" />
		<div>
			<form:label path="vehicleName">Vehicle Name</form:label>
			<form:input path="vehicleName" type="text" class="form-control"
				id="vehicleName" placeholder=" Vehicle Name" />
			<form:errors path="vehicleName" cssClass="text-danger" />


		</div>
		<br>
		<div>
			<form:label path="vehicleNumber">Vehicle Number</form:label>
			<form:input path="vehicleNumber" type="text" class="form-control"
				id="vehicleNumber" placeholder="Vehicle Number" />
			<form:errors path="vehicleNumber" cssClass="text-danger" />


		</div>
		<div class="form-group">
			<form:label path="id">Employee Id</form:label>
			<form:input path="id" type="text" class="form-control" id="empId"
				placeholder="Email" />
		</div>
		<div class="form-group">
			<form:label path="vehicleType">Vehicle Type</form:label>
			<form:select path="vehicleType" class="form-control" id="vehicleType">
				<form:option value="Bicycle" />
				<form:option value="MotorCycle" />
				<form:option value="FourWheeler" />
			</form:select>
		<form:errors path="vehicleType" cssClass="text-danger" />
			
		</div>
		<div class="form-group">
			<form:label path="vehicleIdentification">Identification</form:label>
			<form:input path="vehicleIdentification" type="text"
				class="form-control" id="vehicleIdentification" placeholder="vehicle Identification" />
		<form:errors path="vehicleIdentification" cssClass="text-danger" />
		
		</div>
		<center>
			<button type="submit" id="btn" class="btn btn-primary"
				>Proceed</button>
		</center>
	</div>
	</form:form>
	<script>
	document.getElementById("empId").readOnly=true;
	</script>