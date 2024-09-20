package com.simpleprogram;

import java.util.Scanner;

public class AreaOfRectangle {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in) ;
		System.out.print("Enter length:");
		
		int length = scanner.nextInt();
		
		System.out.print("Enter breadth:");
		int breadth = scanner.nextInt();
		
		
		int area = length * breadth;
		
		System.out.println("The area of the rectangle is "+area);
		
	}

}
