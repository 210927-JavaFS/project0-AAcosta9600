package com.revature.controller;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.service.ManagerService;

public class CustomerController {

	private static Scanner scan = new Scanner(System.in);
	private static ManagerService managerService = new ManagerService();
	
	public static void menu() {
		System.out.println("1) Open Account");
		System.out.println("2) Withdraw");
		System.out.println("3) Deposit");
		System.out.println("4) Transfer");
		System.out.println("5) See Acounts");
		System.out.println("6) Logout");
		String response = scan.nextLine();
		while (!response.equals("6")) {
			switch (response) {
			case "1":
				openAccount();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("5) See Acounts");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;
			case "2":
				withdraw();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("5) See Acounts");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;
			case "3":
				deposit();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("5) See Acounts");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;
			case "4":
				transfer();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("5) See Acounts");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;
			case "5":
				seeAccounts();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("5) See Acounts");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;

			}
		}
	}
	private static void seeAccounts() {
		System.out.println("Please enter your username to see all of your accoutns.");
		String username = scan.nextLine();
		List<Account> accounts = managerService.seeAccounts(username);
		for(Account a:accounts) {
			System.out.println(a.toString());
		}
		
	}
	private static void transfer() {
		System.out.println("Input the account you would like to withdraw from.");
		String account1 = scan.nextLine();
		System.out.println("Input the account where you would like to deposit the funds.");
		String account2 = scan.nextLine();
		System.out.println("Input how much you would like to transfer.");
		String amount = scan.nextLine();
		managerService.transfer(account1,account2,amount);
	}

	private static void deposit() {
		System.out.println("Input the account where you would like to deposit the funds.");
		String account = scan.nextLine();
		System.out.println("Input the amount you would like to deposit.");
		String amount = scan.nextLine();
		managerService.deposit(account,amount);
		
		
	}

	private static void withdraw() {
		System.out.println("Input the account where you would like to withdraw the funds from.");
		String account = scan.nextLine();
		System.out.println("Input the amount you would like to withdraw.");
		String amount = scan.nextLine();
		managerService.withdraw(account,amount);
		
	}

	private static void openAccount() {
		
		System.out.println("Please enter your username to create your account.");
		String username = scan.nextLine();
		managerService.createAccount(username);
		System.out.println("Thank you. An associate will approve or deny your account within 3 business days.");

		
	}

}
