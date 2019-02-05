package com.walkerbank;

/** 
 * @author Courtney Walker
 */

import com.walkerbank.menus.StartMenu;
import com.walkerbank.menus.UserMainMenu;
import com.walkerbank.menus.Menu;
import org.apache.log4j.Logger;

public class BankLauncher {
	static Logger launcherLog = Logger.getRootLogger();
	
	public static void main(String[] args) {
		runStartMenu();
	}
	
	public static void runStartMenu() {
		Menu menu = new StartMenu();
		do {
			launcherLog.debug("The Walker Banking Application Log is running! :)");
			menu.showMenu();
			menu.getUserInput();
			menu = menu.process();
		} while(menu!=null);
		
		System.out.println();
		System.out.println("         Thank You! See you again soon!");
	}
	
	public static void toUserMainMenu() {
		Menu menu = new UserMainMenu();
		do {
			menu.showMenu();
			menu.getUserInput();
			menu = menu.process();
		} while(menu!=null);
	}
}