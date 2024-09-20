package com.simpleprogram;

import java.util.Scanner;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);//used to take input from users
		System.out.println("Enter any two numbers:");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = a + b;
		
		System.out.println("The sum of two numbers is :"+c);
		
		
	}
	

}
