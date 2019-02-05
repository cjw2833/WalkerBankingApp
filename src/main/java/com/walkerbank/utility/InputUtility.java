package com.walkerbank.utility;

import java.util.Scanner;

public class InputUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int getIntChoice(int max) {
		int inputValue;
		
		// Confirm user input is int type
		do {
			while(!scanner.hasNextInt()) {
				scanner.nextLine();
				System.out.println("Please enter a whole number.");
			}
			
			// Retrieve user input
			inputValue = scanner.nextInt();
			scanner.nextLine();
			
			// Confirm user input is within the range of 0 to max
			if(inputValue <= 0 || inputValue > max) {
				System.out.println("Please enter a number between 1 and " + max);
			}
			
		} while(inputValue < 0 || inputValue > max);

		// Return user input
		return inputValue;
	}
	
	public static double getDoubleInput(int max) {
		double inputValue;
		
		// Confirm user input is double type
		do {
			while(!scanner.hasNextDouble()) {
				scanner.nextLine();
				System.out.println("Please enter a number.");
			}
			
			// Retrieve user input
			inputValue = scanner.nextDouble();
			scanner.nextLine();
			
			// Confirm user input is within the range of 0 to max
			if(inputValue <= 0 || inputValue > max) {
				System.out.println("Please enter a number between 1 and " + max);
			}
			
		} while(inputValue < 0 || inputValue > max);

		// Return user input
		return inputValue;
	}
	
	public static String getStringInput(int max) {
		String input;
		
		while(true) {
			input = scanner.nextLine();
			
			input = input.trim();
			if(input.length() == 0){
				System.out.println("String has no content");
				continue;
			}
			
			if(input.length() > max){
				System.out.println("Enter string less than" + max);
				continue;
			}
			
			return input;
		}
	}
	
// Check if email is an email
//	public static boolean isEmail(String email) {
//		boolean isEmail = false;
//		
//		for (int i = 0; i < email.length(); i++) {
//			if(email.charAt(i) == '@') {
//				isEmail = true;
//				break;
//			}
//		}
//
//		return isEmail;
//	}
}
