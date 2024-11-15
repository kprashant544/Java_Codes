package com.nist.studentwebapp.controller;

public class Student {

	int id;
	String firstname, lastname, gender, course, address;
	long contact;

	Student(int id, String firstname, String lastname, String gender, String course, String address, long contact) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.course = course;
		this.address = address;
		this.contact = contact;
	}

}