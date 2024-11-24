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
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String courses[] = request.getParameterValues("course");
		String address = request.getParameter("address");
		long contact = Long.parseLong(request.getParameter("contact"));
		String id = request.getParameter("id");
		System.out.println("value of id is " + id);

		// Join selected courses with commas
		String coursesJoined = String.join(",", courses);

		PreparedStatement ps = null;
		String sql = "";
		try {

			if (id == null || id.isEmpty()) {
				sql = "Insert into studentdata(firstname,lastname,gender,course,address,contact)values(?,?,?,?,?,?)";
			} else {
				sql = "update studentdata set firstname=?, lastname = ?, gender=?, course =?, address=?, contact=? where id=?";

			}

			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, gender);
			ps.setString(4, coursesJoined); // Print all selected courses
			ps.setString(5, address);
			ps.setLong(6, contact);

			if (id != null && !id.isEmpty()) {
				ps.setInt(7, Integer.parseInt(id));
			}
			ps.executeUpdate();

		} catch (Exception err) {
			System.out.println(err);
		}

		// after insert and select query
		String sql1 = "Select * from studentdata";
		ArrayList<Student> studentList = new ArrayList<>();
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

		doGet(request, response);
	}

}