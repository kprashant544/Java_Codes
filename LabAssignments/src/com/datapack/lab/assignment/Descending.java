package com.datapack.lab.assignment;

import java.util.Scanner;

public class Descending {
	public static void main(String[] args) {
		Scanner scInt=new Scanner(System.in);
		System.out.println("Enter Total numbers: ");
		int n=scInt.nextInt();
		int a[]=new int[n];
		int i,j;
		System.out.println("Enter "+n+" numbers: ");
		for(i=0;i<n;i++) {
			a[i]=scInt.nextInt();
		}
		
		for(i=0;i<n;i++) {
			for(j=0;j<n-1;j++) {
				if(a[j]<a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
		System.out.println("Descending Order: ");
		for(i=0;i<n;i++) {
			System.out.print(a[i]+"\t");
		}
	}
}