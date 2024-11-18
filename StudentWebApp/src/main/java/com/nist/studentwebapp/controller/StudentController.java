package com.nist.studentwebapp.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("view".equals(action)) {
			// View all students
			viewStudents(request, response);
		} else if ("delete".equals(action)) {
			// Delete a student
			int id = Integer.parseInt(request.getParameter("id"));
			deleteStudent(id);
			// Redirect back to the student details page after deletion
			response.sendRedirect("StudentController?action=view");
		}
	}

	// Method to retrieve all students from the database
	private void viewStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sql1 = "SELECT * FROM studentdata";
		ArrayList<Student> studentList = new ArrayList<>();
		try {
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstname1 = rs.getString("firstname");
				String lastname1 = rs.getString("lastname");
				String gender1 = rs.getString("gender");
				String course1 = rs.getString("course");
				String address1 = rs.getString("address");
				long contact1 = rs.getLong("contact");

				Student student = new Student();
				student.setId(id);
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

		request.setAttribute("stdList", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("Student_Details.jsp");
		rd.forward(request, response);
	}

	// Method to delete a student from the database
	private void deleteStudent(int id) {
		String sql = "DELETE FROM studentdata WHERE id = ?";
		try {
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String courses[] = request.getParameterValues("course");
		String address = request.getParameter("address");
		long contact = Long.parseLong(request.getParameter("contact"));

		// Convert courses array to a readable format for printing
		String coursesString = Arrays.toString(courses);

		System.out.println("first name is :" + firstname);
		System.out.println("last name is :" + lastname);
		System.out.println("gender is :" + gender);
		System.out.println("course is :" + coursesString);
		System.out.println("address is :" + address);
		System.out.println("contact is :" + contact);

		// Join selected courses with commas
		String coursesJoined = String.join(",", courses);

		PreparedStatement ps = null;
		String sql = "Insert into studentdata(firstname,lastname,gender,course,address,contact)values(?,?,?,?,?,?)";

		try {
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, gender);
			ps.setString(4, coursesJoined); // Print all selected courses
			ps.setString(5, address);
			ps.setLong(6, contact);
			ps.executeUpdate();

		} catch (Exception err) {
			System.out.println(err);
		}

		// after insert query
		String sql1 = "Select * from studentdata";
		ArrayList<Student> studentList = new ArrayList<>();
		try {
			ps = DatabaseConnection.getConnection().prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstname1 = rs.getString("firstname");
				String lastname1 = rs.getString("lastname");
				String gender1 = rs.getString("gender");
				String course1 = rs.getString("course");
				String address1 = rs.getString("address");
				long contact1 = rs.getLong("contact");

				Student student = new Student();
				student.setId(id);
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

		request.setAttribute("stdList", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("Student_Details.jsp");
		rd.forward(request, response);

//		for (Student std : studentList) {
//			System.out.println(std.id + "\t" + std.firstname + "\t" + std.lastname + "\t" + std.gender + "\t"
//					+ std.course + "\t" + std.address + "\t" + std.contact);
//		}

		doGet(request, response);
	}

}
