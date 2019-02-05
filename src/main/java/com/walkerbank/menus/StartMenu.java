package com.walkerbank.menus;

import com.walkerbank.services.UserService;
import com.walkerbank.utility.InputUtility;

public class StartMenu implements Menu {
	public int inputValue;
	private static UserService userService = new UserService();

	@Override
	public void showMenu() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	*******************************************");
		System.out.println("        *             WALKER  BANKING             *");
		System.out.println("        *                                         *");
		System.out.println("        *        Welcome to Walker Banking!       *");
		System.out.println("        *                                         *");
		System.out.println("        *     1. OPEN NEW USER ACCOUNT            *");
		System.out.println("        *     2. LOGIN TO EXISTING ACCOUNT        *");
		System.out.println("        *     3. EXIT BANKING APPLICATION         *");
		System.out.println("        *                                         *");
		System.out.println("        *******************************************");
	}
	
	@Override
	public Menu process() {
		switch(inputValue) {
			case 1: 
				menuLog.debug("Open new user account");
				userService.createUser();
				return new UserMainMenu();
			case 2:
				menuLog.debug("Login to existing account");
				userService.userLogin();
				return new UserMainMenu();
			case 3: 
				menuLog.debug("Exiting Banking App");
				return null;
		}
		return null;
	}

	@Override
	public void getUserInput() {
		this.inputValue = InputUtility.getIntChoice(3);
	}
	
}