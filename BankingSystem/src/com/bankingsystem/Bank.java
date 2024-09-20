package com.bankingsystem;

import java.util.*;

public class Bank {
	
	Scanner scInt = new Scanner(System.in);
	Scanner scDouble = new Scanner(System.in);
	Scanner scString = new Scanner(System.in);
	Scanner scLong = new Scanner(System.in);
	
	ArrayList<Customer> customerList = new ArrayList<>();
	
	long accountNumber = 100;
	
	public void menu() {
		
		System.out.println("Welcome to XYZ Bank");
		System.out.println("1.Create Account");
		System.out.println("2.View Details");
		System.out.println("3.Deposit");
		System.out.println("4.Withdraw");
		
		
		int userChoice = scInt.nextInt();
		if (userChoice==1) {
			createAccount();
		}else if (userChoice==2) {
			viewDetails();
		}
		else if (userChoice==3) {
			deposit();
		}else if (userChoice==4) {
			withdraw();
		}
		
		menu();
	}
	
	public void createAccount() {
		System.out.print("Enter your name:");
		String name = scString.nextLine();
		
		System.out.print("Enter your address:");
		String address = scString.nextLine();
		
		System.out.print("Enter your contact number:");
		long contact = scLong.nextLong();
		
		accountNumber++;
		
		Customer c1 = new Customer(name, address, accountNumber, contact,0.0);
		
		customerList.add(c1);
		
		System.out.println("Account created successfully and your account number is" +accountNumber);
	}
	
	public void viewDetails() {
		
		System.out.print("Enter your account number:");
		long accNo = scLong.nextLong();
		boolean found = false;
		
		for (Customer c : customerList) {
			if (accNo==c.accountNumber) {
				found=true;
				System.out.println("Customer details");
				System.out.println("==================");
			
			System.out.println("Name is\t"+c.name);
			System.out.println("Address is\t"+c.address);
			System.out.println("Contact is\t"+c.contactNumber);
			System.out.println("Account number is\t"+c.accountNumber);
			System.out.println("Current balance is\t"+c.balance);
			System.out.println("================");
			break;
			}
		}
		if (found==false) {
			System.out.println("Your account number is not in the list so please create your account.");
		}
		
	}
	
	public void deposit() {
		System.out.println("Enter your account number:");
		long accNo = scLong.nextLong();
		boolean found = false;
		
		for (Customer c : customerList) {
			if (accNo==c.accountNumber) {
				found= true;
				
				System.out.println("Enter the amount you want to deposit.");
				
				double amount = scDouble.nextDouble();
				if (amount>0) {
					c.deposite(amount);
					System.out.println("Amount successfully deposited.");
				}else {
					System.out.println("Zero or negative value cannot be deposited..");
				}
			
			}
		}
		if (found==false) {
			
			System.out.println("Your account number is not in the list. Please create your account.");
		}
	}
	
	public void withdraw() {
		System.out.println("Enter your account number:");
		long accNo = scLong.nextLong();
		boolean found = false;
		
		for (Customer c : customerList) {
			if (accNo==c.accountNumber) {
				found= true;
				
				System.out.println("Enter the amount you want to withdraw:");
				
				double amount = scDouble.nextDouble();
				if (amount<=c.balance && amount!=0) {
					c.withdraw(amount);
					System.out.println("Amount successfully withdrawn.");
				}else if(amount==0) {
					System.out.println("You've entered zero amount");
				}else {
					System.out.println("Insufficient balance...");
				}
			
			}
		}
		if (found==false) {
			System.out.println("Your account number is not in the list. Please create your account.");
		}
	}
	
	
	
	public static void main(String[] args) {
		Bank obj =  new Bank();
		obj.menu();
	}

}
