package com.datapack.lab.assignment;

import java.util.Scanner;

public class SwapNum {
	

	public static void main(String[] args) {
		System.out.println("Enter any two numbers:");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("Before swapping numbers: "+a +"  "+ b);  
		
		a=a+b;
		b=a-b;
		a=a-b;
		
		System.out.println("The swapped numbers are: "+a +" "+ b);
	

				
	}
}
