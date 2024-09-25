package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.model.Student;
import com.studentform.databaseconnection.DatabaseConnection;

public class StudentServiceImpl implements StudentService {
	PreparedStatement ps = null;

	@Override
	public void saveStudent(Student student) {
		String sql = "Insert into students(first_name,last_name,address,gender,contact)values(?,?,?,?,?)";

		try {
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getGender());
			ps.setLong(5, student.getContactNumber());
			ps.executeUpdate();

		} catch (Exception err) {
			System.out.println(err);
		}
	}

	@Override
	public ArrayList<Student> getStudentList() {
		ArrayList<Student> studentList = new ArrayList<Student>();
		String sql = "select * from students";
		try {
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setAddress(rs.getString("address"));
				student.setContactNumber(rs.getLong("contact"));
				student.setGender(rs.getString("gender"));
				studentList.add(student);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return studentList;
	}
}