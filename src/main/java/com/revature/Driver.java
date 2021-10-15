package com.revature;

import com.revature.controller.LoginMenuController;

public class Driver {

	private static LoginMenuController loginMenuController = new LoginMenuController();

	public static void main(String[] args) {

		loginMenuController.welcomeMenu();

	}
}