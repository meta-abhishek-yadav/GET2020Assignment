<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
        home
    </title>
    <link rel="stylesheet" href="style.css" type="text/css">
    <script src="script.js"></script>

</head>

<body>
 <% String email=(String)session.getAttribute("email");
    if(email.length()==0)
    {
    	response.sendRedirect("index.jsp");
    }
    %>
    <panel>
        </button>
        <a id="heading" href="">Metacube Connection</a>
        <button id="findFriends" onclick="findFriendsPage()">find Friends</button>
        <button id="updateprofile" onclick="updateProfile()">update Profile</button>
      <button id="logout" onclick="logoutPage()">Logout</button>
         
        <hr>
    </panel>
    <panel>
 
	
        <center><span id="profileName">Your Profile</span></center>
        <center><table id="profileTable" cellspacing="50">
            <tr>
                <td class="column">
                	Name
                </td>
                <td class="values">
                   <%String name=(String)session.getAttribute("name"); %>
                   <%=name %>
                </td>
            </tr>
            <tr>
                <td class="column">
                	Employee Id
                </td>
                <td class="values">
                   <%String employeeId=(String)session.getAttribute("employeeId"); %>
                   <%=employeeId%>
                </td>
            </tr>
            <tr>
                <td class="column">
                    Gender
                </td>
                <td class="values">
                   <%String gender=(String)session.getAttribute("gender"); %>
                   <%=gender %>
                </td>
            </tr>
            <tr>
                <td class="column">
                    Email
                </td>
                <td class="values">
                   <%=email %>
                </td>
            </tr>
            <tr>
                <td class="column">
                    Contact
                </td>
                <td class="values">
                   <%String contact=(String)session.getAttribute("contact"); %>
                   <%=contact %>
                </td>
            </tr>
            <tr>
                <td class="column">
                    Organisation
                </td>
                <td class="values">
                    <%String organisation=(String)session.getAttribute("organisation"); %>
                   <%=organisation %>
                </td>
            </tr>
            <tr>
                <td class="column">
                   	Vehicle Name
                </td>
                <td class="values">
                    <%String vehicleName=(String)session.getAttribute("vehicleName"); %>
                   <%=vehicleName %>
                </td>
            </tr>
            <tr>
                <td class="column">
                    Vehicle Type
                </td>
                <td class="values">
                    <%String vehicleType=(String)session.getAttribute("vehicleType"); %>
                   <%=vehicleType %>
                </td>
            </tr>
            <tr>
                <td class="column">
                    Vehicle Number
                </td>
                <td class="values">
                    <%String vehicleNumber=(String)session.getAttribute("vehicleNumber"); %>
                   <%=vehicleNumber %>
                </td>
            </tr>
            <tr>
                <td class="column">
                    Vehical Information
                </td>
                <td class="values">
                    <%String vehicleInformation=(String)session.getAttribute("vehicleInformation"); %>
                   <%=vehicleInformation %>
                </td>
            </tr>
            <tr>
                <td class="column">
                    Pass Type 
                </td>
                <td class="values">
                    <%String passType=(String)session.getAttribute("passType"); %>
                   <%=passType %>
                </td>
            </tr>
               <tr>
                <td class="column">
                    Pass Cost 
                </td>
                <td class="values">
                    <%String passCost=(String)session.getAttribute("passCost"); %>
                   <%=passCost %>
                </td>
            </tr>
        </table></center>
    </panel>
</body>

</html>