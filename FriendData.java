
import java.sql.*;

import javax.servlet.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FriendData")
public class FriendData extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		String email=request.getParameter("friendsList");
		System.out.println(email);
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","abhishek");
		Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery("select * from employee");
		HttpSession session=request.getSession();
		while(rs.next())
		{
			System.out.println(rs.getString(4));

			if(rs.getString(4).equals(email))
			{
				System.out.println("matched");
				 	session.setAttribute("friendName",rs.getString(1));
			        session.setAttribute("friendEmployeeId",rs.getString(2));
			        session.setAttribute("friendGender",rs.getString(3));
			        session.setAttribute("friendEmail",rs.getString(4));
			        session.setAttribute("friendContact",rs.getString(6));
			        session.setAttribute("friendOrganisation",rs.getString(7));
			        session.setAttribute("friendVehicleName",rs.getString(8));
			        session.setAttribute("friendVehicleType",rs.getString(9));
			        session.setAttribute("friendVehicleInformation",rs.getString(10));
			        session.setAttribute("friendVehicleNumber",rs.getString(11));
			        session.setAttribute("friendPassType",rs.getString(12));
			        session.setAttribute("friendPassCost",rs.getString(13));
			        response.sendRedirect("friend.jsp");
			}
		}

	}

	catch(Exception e){}
	}
}
