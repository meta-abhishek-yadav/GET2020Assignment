<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="style.css" type="text/css">
<script src="script.js"></script>
</head>
<body>
	<center>
		<form action="SearchStudent" method="post">
			<h1>Search Student</h1>
			<input type="text" name="firstName" placeholder="Enter First Name"
				required> </br>
			<input type="text" name="lastName" placeholder="Enter Last Name"
				required> </br> Select Minimum class to Filter</br> <select
				name="minimumClass" id="minimumClass" onchange="verify();"><option>1</option>
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
				<option>12</option></select> </br>Select Maximum class to Filter </br>
			<select name="maximumClass" onchange="verify();" id="maximumClass"><option>12</option>
				<option>11</option>
				<option>10</option>
				<option>9</option>
				<option>8</option>
				<option>7</option>
				<option>6</option>
				<option>5</option>
				<option>4</option>
				<option>3</option>
				<option>2</option>
				<option>1</option></select>
			<script>
				function verify() {
					var x = document.getElementById("minimumClass").value;
					var y = document.getElementById("maximumClass").value;
					if (parseInt(x) > parseInt(y)) {
						alert("Please select correct data in filter");
					}
				}
			</script>
			</br>
			<input type="submit">
		</form>
	</center>
</body>
</html>