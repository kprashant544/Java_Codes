package com.nist.studentwebapp.model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nist.studentwebapp.databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class StudentService
 */
@WebServlet("/StudentService")
public class StudentService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

		System.out.println("First name is :" + firstname);
		System.out.println("Last name is :" + lastname);
		System.out.println("Gender is :" + gender);
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

//		doGet(request, response);

	}

}
