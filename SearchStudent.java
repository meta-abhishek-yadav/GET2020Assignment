
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		PrintWriter pw=response.getWriter();
		pw.println("<html><body><center><h1>Search Student Result</h1><hr><table cellspacing='25px' cellpadding='10px'>"
				+ "<tr><th>firstName</th><th>LastName</th><th>Father's Name</th><th>Email</th><th>Class</th><th>Age</th></tr>");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		int  minimumClass=Integer.parseInt(request.getParameter("minimumClass"));
		int  maximumClass=Integer.parseInt(request.getParameter("maximumClass"));
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentData","root","abhishek");
		Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery("select * from student");
		while(rs.next())
		{			
			if(rs.getString(1).equals(firstName) && rs.getString(2).equals(lastName))
			{
				int classOfStudent=Integer.parseInt(rs.getString(5));
				if(classOfStudent>=minimumClass && classOfStudent<=maximumClass)
				{
				pw.println("<tr><td>"+rs.getString(1)+"</td>");
				pw.println("<td> "+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getString(4)+"</td>");
				pw.println("<td>"+rs.getString(5)+"</td>");
				pw.println("<td>"+rs.getString(6)+"</td>");
				pw.println("</br>");
				pw.println("</tr>");
				}
			}
			
		}
		pw.println("</table><center></body></html>");
		}
		catch(Exception e){}
	}

}
