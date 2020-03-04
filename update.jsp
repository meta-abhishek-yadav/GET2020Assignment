<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">

<script src="script.js">
	
</script>
</head>
<body>
	<center>
		<h1 id="helo">Student Updation Form</h1>
		<form id="updateForm" action="Update" method="post">
			<input type='text' name='studentFirstName'
				placeholder='Enter First Name' required></br> <input type='text'
				name='studentLastName' placeholder='Enter Last Name' required></br>
			<input type='text' name='studentFatherName'
				placeholder='Enter Father' s Name' required></br> <input
				type='email' name='studentEmail' placeholder='Enter New Email Id'
				required></br> Choose Class</br>
			<select id='studentClass' name='studentClass'>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
				<option>5</option>
				<option>6</option>
				<option>7</option>
				<option>8</option>
				<option>9</option>
				<option>10</option>
				<option>11</option>
				<option>12</option>
			</select> </br> <input type='number' name='studentAge' min='1' max='100'
				placeholder='choose Age' required></br> <input type='button'
				onclick='xyz()' value='update'>
		</form>
	</center>
</body>
</html>