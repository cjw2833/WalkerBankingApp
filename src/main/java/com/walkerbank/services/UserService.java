package com.walkerbank.services;

import org.mindrot.jbcrypt.BCrypt;
import com.walkerbank.dao.UserDao;
import com.walkerbank.models.User;
import com.walkerbank.utility.InputUtility;

public class UserService {
	public static User user = new User();
	private static UserDao userDao = new UserDao();
	public static boolean newUser = false;
	
	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		UserService.user = user;
	}

	public int getUserId() {
		return user.getId();
	}
	
	public void setUserId(int id) {
		id = user.getId();
	}
	
	public String getUserFirstName() {
		return user.getFirstName();
	}
	
	public void setUserFirstName(String firstName) {
		firstName = user.getFirstName();
	}
	
	public String getUserLastName() {
		return user.getLastName();
	}
	
	public void setUserLastName(String lastName) {
		lastName = user.getLastName();
	}
	
	public String getUserEmail() {
		return user.getEmail();
	}
	
	public void setUserEmail(String email) {
		email = user.getEmail();
	}
	
	public String getUserPass_hash(String pass_hash) {
		return user.getPass_hash();
	}
	
	public void setPass_hash(String pass_hash) {
		pass_hash = user.getPass_hash();
	}
	
	public void createUser() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	*******************************************");
		System.out.println("        *             WALKER  BANKING             *");
		System.out.println("        *                                         *");
		System.out.println("        *         New User Account Sign Up!       *");
		System.out.println("    	*******************************************");
		System.out.println("                                                   ");
		System.out.print("         Please enter your first name: ");
		user.setFirstName(InputUtility.getStringInput(30));
		
		System.out.print("         Please enter your last name: ");
		user.setLastName(InputUtility.getStringInput(30));
		
		System.out.print("         Please enter your email: ");
		user.setEmail(InputUtility.getStringInput(30));
		
		// DEBUG -> Check isEmail

		System.out.print("         Please enter your password: ");
		user.setPass_hash(BCrypt.hashpw(InputUtility.getStringInput(30), BCrypt.gensalt()));
		
		// DEBUG -> Check passwords are equal
		
		user = userDao.insertUser(user);
		newUser = true;
	}
	
	public void userLogin() {
		System.out.println("                                                   ");
		System.out.println("                                                   ");
		System.out.println("    	*******************************************");
		System.out.println("        *             WALKER  BANKING             *");
		System.out.println("        *                                         *");
		System.out.println("        *                User Login               *");
		System.out.println("    	*******************************************");
		System.out.println("                                                   ");
		
		System.out.print("         Please enter your email: ");
		String email = InputUtility.getStringInput(30);
		
		System.out.print("         Please enter your password: ");
		String pw = InputUtility.getStringInput(30);
		
		user = userDao.checkUser(user, email, pw);
		System.out.println();
		System.out.println("         Logging into your account . . .");
	}
	
	public void displayAccts() {  userDao.getUserAccounts(user);  }
}
