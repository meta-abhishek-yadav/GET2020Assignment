import java.sql.*;
import java.io.*;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("updatesubmitEmpName");
			String employeeId = request.getParameter("updatesubmitEmpId");
			String gender = request.getParameter("updatesubmitEmpGender");
			String email = request.getParameter("updatesubmitEmpEmail");
			String password = request.getParameter("updatesubmitEmpPassoword");
			String contact = request.getParameter("updatesubmitEmpContact");
			String organisation = request
					.getParameter("updatesubmitEmpOrganisation");
			String vehicleName = request
					.getParameter("updatesubmitEmpVehicleName");
			String vehicletype = request
					.getParameter("updatesubmitEmpVehicleType");
			String vehicleIdentification = request
					.getParameter("updatesubmitEmpVehicleIdentification");
			String vehicleNumber = request
					.getParameter("updatesubmitEmpVehicleNumber");
			String vehiclePassType = request
					.getParameter("updatesubmitEmpVehiclePassType");
			String vehiclePassCost = request
					.getParameter("updatesubmitEmpVehiclePassCost");

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/parking", "root", "abhishek");
			PreparedStatement preparedstmt1 = con
					.prepareStatement("delete from employee where email = ? ");
			HttpSession session = request.getSession();
			String mail = (String) session.getAttribute("email");
			System.out.println(mail);
			preparedstmt1.setString(1, mail);
			preparedstmt1.executeUpdate();
			PreparedStatement preparedstmt = con
					.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedstmt.setString(1, name);
			preparedstmt.setString(2, employeeId);
			preparedstmt.setString(3, gender);
			preparedstmt.setString(4, email);
			preparedstmt.setString(5, password);
			preparedstmt.setString(6, contact);
			preparedstmt.setString(7, organisation);
			preparedstmt.setString(8, vehicleName);
			preparedstmt.setString(9, vehicletype);
			preparedstmt.setString(10, vehicleIdentification);
			preparedstmt.setString(11, vehicleNumber);
			preparedstmt.setString(12, vehiclePassType);
			preparedstmt.setString(13, vehiclePassCost);
			preparedstmt.executeUpdate();
			ArrayList<String> list = new ArrayList<String>();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from employee");
			int found = 0;
			while (rs.next()) {
				if (rs.getString(4).equals(email)) {
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
					session.setAttribute("friends", list);
				} else {
					list.add(rs.getString(4));
				}
			}
			session.setAttribute("friends", list);

			con.close();
			response.sendRedirect("updated.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
