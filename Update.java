

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		String firstName=request.getParameter("studentFirstName");
		String lastName=request.getParameter("studentLastName");
		String fatherName=request.getParameter("studentFatherName");
		String email=request.getParameter("studentEmail");
		String studentClass=request.getParameter("studentClass");
		String age=request.getParameter("studentAge");
		String previousEmail=request.getParameter("previousEmail");
		System.out.println(firstName+lastName+fatherName+email+studentClass+age+previousEmail);

		System.out.println(firstName+lastName+fatherName+email+studentClass+age+previousEmail);
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData","root","abhishek");
		PreparedStatement preparedstmt1=con.prepareStatement("delete from student where email=?");
		preparedstmt1.setString(1,previousEmail);
		preparedstmt1.executeUpdate();

		PreparedStatement preparedstmt=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
		preparedstmt.setString(1,firstName);
		preparedstmt.setString(2,lastName);
		preparedstmt.setString(3,fatherName);
		preparedstmt.setString(4,email);
		preparedstmt.setString(5,studentClass);
		preparedstmt.setString(6,age);
		preparedstmt.executeUpdate();
		response.sendRedirect("updated.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
