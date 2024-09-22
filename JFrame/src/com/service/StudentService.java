package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {
	public void saveStudent(Student student);

	public List<Student> getStudentList();
}