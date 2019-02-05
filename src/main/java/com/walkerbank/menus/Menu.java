package com.walkerbank.menus;

import org.apache.log4j.Logger;

/** 
 * @author Courtney Walker
 */

public interface Menu {
	static Logger menuLog = Logger.getRootLogger();
	/**
	 * Display a Menu of options to the User
	 */
	void showMenu();
	
	/**
	 * Hooks user choice into a functional service process
	 * @return View
	 */
	Menu process();
	
	/**
	 * Method for getting user input regarding the 
	 * menu shown in {@link #showMenu()}
	 */
	void getUserInput();
}


