
import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try
	{
	String firstName=request.getParameter("studentFirstName");
	String lastName=request.getParameter("studentLastName");
	String fatherName=request.getParameter("studentFatherName");
	String email=request.getParameter("studentEmail");
	String studentClass=request.getParameter("studentClass");
	String age=request.getParameter("studentAge");
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData","root","abhishek");
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from student");
	int foundUser=0;
	while(rs.next())
	{
		if(rs.getString(4).equals(email))
		{
			foundUser=1;
			break;
		}
	}
	//System.out.println(firstName+" "+email+"  "+foundUser);
	if(foundUser==1)
	{
		response.sendRedirect("exists.jsp");
	}
	else 
	{
		
	PreparedStatement preparedstmt=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
	preparedstmt.setString(1,firstName);
	preparedstmt.setString(2,lastName);
	preparedstmt.setString(3,fatherName);
	preparedstmt.setString(4,email);
	preparedstmt.setString(5,studentClass);
	preparedstmt.setString(6,age);
	preparedstmt.executeUpdate();
	response.sendRedirect("loggedIn.jsp");
	}
	}
	catch(Exception e)
	{}
	}

}
