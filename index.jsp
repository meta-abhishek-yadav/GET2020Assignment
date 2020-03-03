<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
button {
	font-size: 50px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student data</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script src="script.js"></script>
</head>
<body id="body">
	<center>
		</br>
		</br> <a href="addStudent.jsp">
			<button>Add Student</button>
		</a></br>
		</br>
		<form id="showStudentForm" action="ShowStudents" method="post">
			<button onclick="showStudentMethod()">Show Students</button>
		</form>
		</br>
		<a href="searchStudent.jsp"><button>Search Student</button></a>
	</center>
	<script>
		
	</script>
</body>
</html>