package com.simpleprogram;

import java.util.Scanner;

public class OddEven {

	public static void main(String[] args) {
		
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Enter any number");
		
		int a = scInt.nextInt();
		
		if(a%2==0) {
			System.out.println("The given number is even");
		}else {
			System.out.println("The given number is odd");
		}
		
		String ouputString = (a%2==0)?"Number is even":"Number is odd";
		
		System.out.println(ouputString);
		
		
	}
}
