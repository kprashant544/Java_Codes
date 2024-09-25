package com.service;

import java.util.ArrayList;

import com.model.Student;

public interface StudentService {
	public void saveStudent(Student student);

	public ArrayList<Student> getStudentList();
}