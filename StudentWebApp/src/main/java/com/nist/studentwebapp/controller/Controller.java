package com.nist.studentwebapp.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nist.studentwebapp.databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String value = request.getParameter("action"); // edit
		PreparedStatement ps = null;
		ArrayList<Student> studentList = new ArrayList<>();

		if (value.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String sql = "Delete from studentdata where id=?";

			try {
				ps = DatabaseConnection.getConnection().prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}

			// Method to retrieve all students from the database
			String sql1 = "Select * from studentdata";

			try {
				ps = DatabaseConnection.getConnection().prepareStatement(sql1);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int id1 = rs.getInt("id");
					String firstname1 = rs.getString("firstname");
					String lastname1 = rs.getString("lastname");
					String gender1 = rs.getString("gender");
					String course1 = rs.getString("course");
					String address1 = rs.getString("address");
					long contact1 = rs.getLong("contact");

					Student student = new Student();
					student.setId(id1);
					student.setFirstname(firstname1);
					student.setLastname(lastname1);
					student.setGender(gender1);
					student.setCourse(course1);
					student.setAddress(address1);
					student.setContact(contact1);

					studentList.add(student);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			RequestDispatcher rd = request.getRequestDispatcher("Student_Details.jsp");
			request.setAttribute("stdList", studentList);
			rd.forward(request, response);

		} else if (value.equalsIgnoreCase("edit")) {
			int id = Integer.parseInt(request.getParameter("id")); // 1
			String sql = "select * from studentdata where id=?";

			try {
				ps = DatabaseConnection.getConnection().prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				Student student = new Student();

				while (rs.next()) {
					student.setId(rs.getInt("id"));
					student.setFirstname(rs.getString("firstname"));
					student.setLastname(rs.getString("lastname"));
					student.setGender(rs.getString("gender"));
					student.setCourse(rs.getString("course"));
					student.setAddress(rs.getString("address"));
					student.setContact(rs.getLong("contact"));

				}

				RequestDispatcher rd = request.getRequestDispatcher("StudentForm.jsp");
				request.setAttribute("studentKey", student);
				rd.forward(request, response);

			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
