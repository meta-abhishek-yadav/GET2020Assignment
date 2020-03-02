import javax.servlet.*;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String loginEmail = request.getParameter("loginEmail");
			String loginPassword = request.getParameter("loginPassword");
			ArrayList<String> list = new ArrayList<String>();

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/parking", "root", "abhishek");
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from employee");
			int found = 0;
			HttpSession session = request.getSession();
			while (rs.next()) {
				if ((rs.getString(4).equals(loginEmail))
						&& (rs.getString(5).equals(loginPassword))) {
					found = 1;
					session.setAttribute("name", rs.getString(1));
					session.setAttribute("employeeId", rs.getString(2));
					session.setAttribute("gender", rs.getString(3));
					session.setAttribute("email", rs.getString(4));
					session.setAttribute("contact", rs.getString(6));
					session.setAttribute("organisation", rs.getString(7));
					session.setAttribute("vehicleName", rs.getString(8));
					session.setAttribute("vehicleType", rs.getString(9));
					session.setAttribute("vehicleInformation", rs.getString(10));
					session.setAttribute("vehicleNumber", rs.getString(11));
					session.setAttribute("passType", rs.getString(12));
					session.setAttribute("passCost", rs.getString(13));
				} else {
					list.add(rs.getString(4));
				}
			}
			if (found == 1) {
				session.setAttribute("friends", list);
				response.sendRedirect("loggedIn.jsp");
			} else {
				response.sendRedirect("failed.jsp");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
