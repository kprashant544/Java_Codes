package com.simpleprogram;

import java.util.Scanner;

public class GreatestNum {
	public static void main(String[] args) {
		
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Enter any three numbers: ");
		
		int a = scInt.nextInt();
		int b = scInt.nextInt();
		int c = scInt.nextInt();
		
		
		if (a>=b && a>=c) {
			System.out.println("The greatest number is  "+a);
		}else if (b>=a && b>=c) {
			System.out.println("The greatest number is "+b);
		}else {
			System.out.println("The greatest number is "+c);
		}
		
		
		
	}

}
