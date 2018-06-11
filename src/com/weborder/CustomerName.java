package com.weborder;

import java.util.Random;

public class CustomerName {

	String anything = "sdfodsgonOKANFsokNAFlkmlslDMG";
	String firstName = "John";
	String lasName = "Smith";
	static String fullName = "";
	String midOne = "";

	public String randomString() {
		for (int i = 0; i < 10; i++) {
			Random randomNumber = new Random();
			midOne = midOne + anything.charAt(randomNumber.nextInt(anything.length() - 1));
		}
		return firstName + " " + midOne + " " + lasName;
	}

	public static void main(String[] args) {
		CustomerName s1 = new CustomerName();
		fullName = s1.randomString();

		System.out.println(fullName);
		
		
		
		
		

	}

}
