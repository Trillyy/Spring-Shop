package com.shop.utils;

public class PasswordValidator {
	
	public static boolean isValidPassword(String password) {
		 return password.length() > 7;
	}
	
	public static boolean matches(String password, String cpassword) {
		 return password.equals(cpassword);
	}
}
