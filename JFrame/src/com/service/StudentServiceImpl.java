package com.service;

import java.sql.PreparedStatement;
import java.util.List;

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
	public List<Student> getStudentList() {
		String sql = "select * from students";
		return null;
	}

}