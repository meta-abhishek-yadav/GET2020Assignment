<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Login</title>
</head>
<body>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form method="post" action="login">
<input type="text" name="username">
<input text="password" name="password">
<input type="submit"></form>
</body>
</html>