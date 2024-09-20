package com.datapack.lab.assignment;
import java.util.Scanner;

	public class DataPack {

		Scanner scInt = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);

		public void ntc() {
			System.out.println("welcome to ntc");
			System.out.println("Enter *1415# for ntc datapack ");
			String  userChoice = scString.nextLine();
			if(userChoice.equals("*1415#")) {
				ntcDataPack();
			}
			else {
				System.out.println("Your choice is Invalid.");
			}
		}
			public void ntcDataPack() {
				System.out.println("1.Monsoon Offer");
				System.out.println("2.Prepaid Packs");
				System.out.println("3.Unltd Night Packs");
				System.out.println("4.Voice");

				int userChoice=scInt.nextInt();
				if(userChoice==1) {
					monsoonOffer();
				}
				else if(userChoice==2) {
					prepaidPacks();
				}
				else if(userChoice==3) {
					unltdNightPacks();
				}
				else if(userChoice==4) {
					voice();
				}
				else {
					System.out.println("Your choice is Invalid.");
				}
			}
			
			public void monsoonOffer() {
				System.out.println("1.All Time Data");
				System.out.println("2.Night Data");
				

				int userChoice=scInt.nextInt();
				if(userChoice==1) {
					allTimeData();
				}
				else if(userChoice==2) {
					nightData();
				}
				else {
					System.out.println("Your choice is Invalid.");
				}
			}

			public void allTimeData() {
				System.out.println("1. 1GB@Rs29-1D");
				System.out.println("2. 3GB@Rs99-1D");

				int userChoice=scInt.nextInt();
				if(userChoice==1) {
					System.out.println("You Have Choosen 1GB at Rs29.");
				}
				else if(userChoice==2) {
					System.out.println("You Have Choosen 3GB at Rs39");
				}

				else {
					System.out.println(" Invalid Choice.");
				}
			}
			public void nightData() {
				System.out.println("1. 1GB@Rs29-1D");
				System.out.println("2. 3GB@Rs99-1D");

				int userChoice=scInt.nextInt();
				if(userChoice==1) {
					System.out.println("You Have Choosen 1GB at Rs29.");
				}
				else if(userChoice==2) {
					System.out.println("You Have Choosen 3GB at Rs99");
				}

				else {
					System.out.println(" Invalid Choice.");
				}
			}
			public void prepaidPacks() {
				System.out.println("1.Sajilo Prepaid");
				System.out.println("2.Combo Packs");
				int userChoice=scInt.nextInt();
				if(userChoice==1) {
					SajiloPrepaid();
				}
				else if(userChoice==2) {
					ComboPacks();
				}
				else {
					System.out.println("Your choice is Invalid.");
				}
			}
			
			public void SajiloPrepaid() {
				System.out.println("1.Utd-Combo@Rs699");
				System.out.println ("2.Utd-Combo@Rs799");
				
				int userChoice=scInt.nextInt();
				if(userChoice==1) {
					System.out.println("You Have Choosen Utd-Combo@Rs699.");
				}
				else if(userChoice==2) {
					System.out.println("You Have Choosen Utd-Combo@Rs799");
				}

				else {
					System.out.println("Invalid Choice.");
				}
			}
			
			public void ComboPacks() {
				System.out.println("Combo:Voice:AllNet:28D");
				System.out.println("1.200Min+2GB@Rs199");
				System.out.println("2.300Min+4GB+20SMS-NT@Rs299");
				int userChoice=scInt.nextInt();
				if(userChoice==1) {
					System.out.println("You Have Choosen 200Min+2GB@Rs199.");
				}
				else if(userChoice==2) {
					System.out.println("You Have Choosen 300Min+4GB+20SMS-NT@Rs299");
				}

				else {
					System.out.println("Invalid Choice.");
				}
			}
			public void unltdNightPacks() {
				System.out.println("1.Unt-Data-5Mbps+Unt-Call-NT-NT@Rs59(10pm-6am)");
				System.out.println("2.Unt-Call-NT-NT@Rs15(11pm-6am)");
				int userChoice=scInt.nextInt();
				if(userChoice==1) {
					System.out.println("You Have Choosen Unt-Data-5Mbps+Unt-Call-NT-NT@Rs59(10pm-6am).");
				}
				else if(userChoice==2) {
					System.out.println("You Have Choosen Unt-Call-NT-NT@Rs15(11pm-6am)");
				}
				else {
					System.out.println("You Have Choosen Invalid Choice.");
				}
			}
			
		public void voice() {
			System.out.println("1.NT-NT-Network");
			System.out.println("2.All-Network");
			int userChoice=scInt.nextInt();
			if(userChoice==1) {
				ntNetwork();
			}
			else if(userChoice==2) {
				allNetwork();
			}
			

			else {
				System.out.println("Invalid Choice.");
			}

		}
		public void ntNetwork() {
		System.out.println("1.30Min@Rs18-1D");
		System.out.println("2.50Min@Rs59-1D");
		int userChoice=scInt.nextInt();
		if(userChoice==1) {
			System.out.println("You Have Choosen 30Min@Rs18-1D .");
		}
		else if(userChoice==2) {
			System.out.println("You Have Choosen 50Min@Rs50-1D");
		}

		else {
			System.out.println("Invalid Choice.");
		}
		}
		public void allNetwork() {
		System.out.println("1.30Min@Rs20-1D");
		System.out.println("2.150Min@Rs69-1D");
		int userChoice=scInt.nextInt();
		if(userChoice==1) {
			System.out.println("You Have Choosen 30Min@Rs20-1D .");
		}
		else if(userChoice==2) {
			System.out.println("You Have Choosen 150Min@Rs69-1D");
		}

		else {
			System.out.println("Invalid Choice.");
		}
		}
		public static void main(String[] args) {
			DataPack dt=new DataPack();
			dt.ntc();
		}
		

		}