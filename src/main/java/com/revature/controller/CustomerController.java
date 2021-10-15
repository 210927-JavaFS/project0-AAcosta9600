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
		System.out.println("6) Logout");
		String response = scan.nextLine();
		while (!response.equals("6")) {
			switch (response) {
			case "1":
				approvalList();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;
			case "2":
				withdraw();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;
			case "3":
				deposit();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;
			case "4":
				transfer();
				System.out.println("1) Open Account");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("6) Logout");
				response = scan.nextLine();
				break;

			}
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

	private static void approvalList() {
		List<Account> approvalList = managerService.getApprovalList();
		for(Account a:approvalList) {
			System.out.println(a.toString());
		}
		System.out.println("Please enter the account number of the account you would like to approve or deny.");
		String account = scan.nextLine();
		System.out.println("Please enter 'Approve' or 'Deny'");
		String approval = scan.nextLine();
		managerService.approve(account,approval);
		if(managerService.approve(account, approval)) {
			System.out.println("Change made.");
		}
		else {
			System.out.println("Something went wrong please try again.");
		}
		
	}

}
