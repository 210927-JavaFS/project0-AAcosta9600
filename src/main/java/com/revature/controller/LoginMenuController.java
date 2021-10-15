package com.revature.controller;

import java.util.Scanner;

import com.revature.service.LoginService;

public class LoginMenuController {

	private static Scanner scan = new Scanner(System.in);
	
	private LoginService loginService = new LoginService();
	
	public void welcomeMenu() {
		System.out.println("Welcome to AA Banking!");
		System.out.println("Please choose your account status to login.");
		System.out.println("1) Manager");
		System.out.println("2) Teller");
		System.out.println("3) Customer");
		System.out.println("4) Register for new account");
		System.out.println("5) Exit");
		String response = scan.nextLine();

		while (!response.equals("5")) {
			switch (response) {
			case "1":
				managerLogin();
				System.out.println("Please choose how you would like to login.");
				System.out.println("1) Manager");
				System.out.println("2) Teller");
				System.out.println("3) Customer");
				System.out.println("4) Register for new account");
				System.out.println("5) Exit");
				response = scan.nextLine();
				break;
			case "2":
				tellerLogin();
				System.out.println("Please choose how you would like to login.");
				System.out.println("1) Manager");
				System.out.println("2) Teller");
				System.out.println("3) Customer");
				System.out.println("4) Register for new account");
				System.out.println("5) Exit");
				response = scan.nextLine();
				break;
			case "3":
				customerLogin();
				System.out.println("Please choose how you would like to login.");
				System.out.println("1) Manager");
				System.out.println("2) Teller");
				System.out.println("3) Customer");
				System.out.println("4) Register for new account");
				System.out.println("5) Exit");
				response = scan.nextLine();
				break;
			case "4":
				register();
				System.out.println("Please choose how you would like to login.");
				System.out.println("1) Manager");
				System.out.println("2) Teller");
				System.out.println("3) Customer");
				System.out.println("4) Register for new account");
				System.out.println("5) Exit");
				response = scan.nextLine();
				break;
			}
		}

	}

	private void register() {
		System.out.println("Please enter a username. You can also input 5 to cancel.");
		String username = scan.nextLine();
		if(username.equals("5")) {
			welcomeMenu();
		}
		else if(loginService.checkUsername(username)) {
			System.out.println("Sorry that username is taken. Try again.");
			register();
		}
		System.out.println("Please enter a password.");
		String password = scan.nextLine();
		loginService.register(username,password);
		System.out.println("Account successfully created!");

	}

	private void customerLogin() {
		System.out.println("Enter 5 to cancel and go back.");
		System.out.println("Please enter your username.");
		String username = scan.nextLine();

		while (!(username.equals("5"))) {
			System.out.println("Please enter your password.");
			String password = scan.nextLine();

			if ((loginService.checkUsername(username) == false) || !(loginService.checkAdminLevel(username).equals("Customer"))) {
				System.out.println("We do not have a customer account with this username. Please try again.");
				break;
			} else if (loginService.checkPassword(password) == false) {
				System.out.println("Wrong password. Please try again");
				break;
			}
			else {
				CustomerController.menu();
				welcomeMenu();
			}
		}
	}

	private void tellerLogin() {
		System.out.println("Enter 5 to cancel and go back.");
		System.out.println("Please enter your username.");
		String username = scan.nextLine();

		while (!(username.equals("5"))) {
			System.out.println("Please enter your password.");
			String password = scan.nextLine();

			if ((loginService.checkUsername(username) == false) || !(loginService.checkAdminLevel(username).equals("Teller") )) {
				System.out.println("We do not have a teller account with this username. Please try again.");
				break;
			} else if (loginService.checkPassword(password) == false) {
				System.out.println("Wrong password. Please try again");
				break;
			}
			else {
				TellerController.menu();
				welcomeMenu();
			}
		}
	}

	private void managerLogin() {
		System.out.println("Enter 5 to cancel and go back.");
		System.out.println("Please enter your username.");
		String username = scan.nextLine();

		while (!(username.equals("5"))) {
			System.out.println("Please enter your password.");
			String password = scan.nextLine();
			if ((loginService.checkUsername(username) == false) || !(loginService.checkAdminLevel(username).equals("Manager"))) {
				System.out.println("We do not have a manager account with this username. Please try again.");
				break;
			} else if (loginService.checkPassword(password) == false) {
				System.out.println("Wrong password. Please try again");
				break;
			}
			else {
				ManagerController.menu();
				welcomeMenu();
			}

		}

	}

}
