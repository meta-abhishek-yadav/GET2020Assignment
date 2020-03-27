import java.sql.*;
import java.io.*;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try
	{
	String name=request.getParameter("submitEmpName");
	String employeeId=request.getParameter("submitEmpId");
	String gender=request.getParameter("submitEmpGender");
	String email=request.getParameter("submitEmpEmail");
	String password=request.getParameter("submitEmpPassoword");
	String contact=request.getParameter("submitEmpContact");
	String organisation=request.getParameter("submitEmpOrganisation");
	String vehicleName=request.getParameter("submitEmpVehicleName");
	String vehicletype=request.getParameter("submitEmpVehicleType");
	String vehicleIdentification=request.getParameter("submitEmpVehicleIdentification");
	String vehicleNumber=request.getParameter("submitEmpVehicleNumber");
	String vehiclePassType=request.getParameter("submitEmpVehiclePassType");
	String vehiclePassCost=request.getParameter("submitEmpVehiclePassCost");
	
	
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","abhishek");
	PreparedStatement preparedstmt=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("select * from employee");
	int foundUser=0;
	while(rs.next())
	{
		if(rs.getString(4).equals(email))
		{
			foundUser=1;
		}
	}
	if(foundUser==1)
	{
		response.sendRedirect("exists.jsp");
	}
	else
	{
	preparedstmt.setString(1,name);
	preparedstmt.setString(2,employeeId);
	preparedstmt.setString(3,gender);
	preparedstmt.setString(4,email);
	preparedstmt.setString(5,password);
	preparedstmt.setString(6,contact);
	preparedstmt.setString(7,organisation);
	preparedstmt.setString(8,vehicleName);
	preparedstmt.setString(9,vehicletype);
	preparedstmt.setString(10,vehicleIdentification);
	preparedstmt.setString(11,vehicleNumber);
	preparedstmt.setString(12,vehiclePassType);
	preparedstmt.setString(13,vehiclePassCost);
	preparedstmt.executeUpdate();
	con.close();
	response.sendRedirect("registered.jsp");
	}
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	}
}
