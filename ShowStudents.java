import java.sql.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ShowStudents")
public class ShowStudents extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw = response.getWriter();
			pw.println("<html><head><script src='script.js'></script><style>"
					+ "form input{"
					+ "   text-align: center;"
					+ "  margin: 10px;"
					+ " padding: 15px;"
					+ "  border-width: 3px;"
					+ "border-color: black;"
					+ " width: 500px;"
					+ " border-radius: 30px;"
					+ " outline: 10px;"
					+ " transition: 0.5px;"
					+ " font-size: 20px;"
					+ "border-color: red;} #updateForm{display:none;}#panel1{display:block;}"
					+ " select" + "{" + " text-align: center;"
					+ "  margin: 10px;" + "  padding: 5px;" + "  border: 5px;"
					+ "  border-color: red;" + "  width: 500px;"
					+ "  border-radius: 30px;" + "  outline: 0px;"
					+ " transition: 0.5px;" + "  font-size: 20px; "
					+ "  border-color:red;    " + "  }"
					+ "</style></head><body>");
			pw.println("<panel><center><form id='updateForm' action='Update' method='post'>Update Data<input type='text' name='studentFirstName'   placeholder='Enter First Name' required></br><input type='text' name='studentLastName'  placeholder='Enter Last Name' required></br><input type='text' name='studentFatherName'  placeholder='Enter Father's Name' required></br>"
					+ "<input type='email' name='studentEmail'  placeholder='Enter New Email Id' required></br>"
					+ " Choose Class</br><select id='studentClass' name='studentClass'><option>1</option><option>2</option><option>3</option>"
					+ " <option>4</option>"
					+ " <option>5</option>"
					+ "<option>6</option>"
					+ "<option>7</option>"
					+ " <option>8</option>"
					+ "<option>9</option>"
					+ "<option>10</option>"
					+ " <option>11</option>"
					+ "<option>12</option>"
					+ "</select>"
					+ " </br>Choose Age</br>"
					+ " <input type='number' name='studentAge' min='1' max='100' placeholder='choose Age' required></br>"
					+ "<input type='hidden' value='' name='previousEmail' id='previousEmail'>"
					+ " <input type='submit' value='update' >"
					+ " </form><center></panel>");
			pw.println("<panel id='panel1'><center><h1>Students</h1><hr><table cellspacing='25px' cellpadding='10px'>"
					+ "<tr><th>firstName</th><th>LastName</th><th>Father's Name</th><th>Email</th><th>Class</th><th>Age</th></tr>");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/StudentData", "root",
					"abhishek");
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from student");
			HttpSession session = request.getSession();
			while (rs.next()) {
				pw.println("<tr><td>" + rs.getString(1) + "</td>");
				pw.println("<td> " + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("<td>" + rs.getString(4) + "</td>");
				pw.println("<td>" + rs.getString(5) + "</td>");
				pw.println("<td>" + rs.getString(6) + "</td>");
				pw.println("<td><button value='"
						+ rs.getString(4)
						+ "' style='background-color:black;color:white;' onclick='updateData(this)'>update</button></td>");
				// pw.println("<script>function updateData(){ window.location.href='update.jsp';}</script>");
				pw.println("</tr>");

				pw.println("<form id='" + rs.getString(4)
						+ "'><input type='hidden'  value='" + rs.getString(1)
						+ "'><input type='hidden'  value='" + rs.getString(2)
						+ "'><input type='hidden'  value='" + rs.getString(3)
						+ "' ><input type='hidden'  value='" + rs.getString(4)
						+ "'><input type='hidden' value='" + rs.getString(5)
						+ "' ><input type='hidden' value='" + rs.getString(6)
						+ "'></form>");
				// response.sendRedirect("showStudents.jsp");
			}
			pw.println("</center> </table></panel>");

			pw.println("</body></html>");
		} catch (Exception e) {
		}
	}

}
