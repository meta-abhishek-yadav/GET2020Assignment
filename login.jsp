<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
        Login
    </title>
    <link rel="stylesheet" href="style.css" type="text/css">
    <script src="script.js"></script>

</head>

<body>

    <panel>
        <button id="signup" onclick="signupPage()">
            SignUp
        </button> <a id="heading" href="index.jsp">Metacube Connection</a>
        <button id="login" onclick="loginPage()">
            Login
        </button>
        <hr>
    </panel>
    <panel>
        <form method="post" action="LoginServlet" id="loginForm">
            <table>

                <tr>
                    <th>
                        Email id
                    </th>
                    <td>
                        <input type="text" name="loginEmail" required>
                    </td>
                </tr>
                <tr>
                    <th>
                        Password
                    </th>
                    <td>
                        <input type="password" name="loginPassword" required>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit">
                    </td>
                </tr>
            </table>
        </form>
    </panel>

</body>

</html>