package com.simpleprogram;

import java.util.Scanner;

public class UserInfo {
	public static void main(String[] args) {
		
		Scanner scInt = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		Scanner scLong= new Scanner(System.in);
		
		System.out.println("Enter your Name : ");
		String name = scString.nextLine();
		
		System.out.println("Enter your address: ");
		String address = scString.nextLine();
		
		System.out.println("Enter you age: ");
		int age = scInt.nextInt();
		
		System.out.println("Enter your phone no: ");
		long phoneNumber = scLong.nextLong();
		
		System.out.println("Your name is "+name+"\tYour address is "+address+
				"\tYour age is "+age+"\tYour phone number is "+phoneNumber);
		
		
	
		
		
	}

}
