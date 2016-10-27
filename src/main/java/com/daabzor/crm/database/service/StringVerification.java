package com.daabzor.crm.database.service;

import org.springframework.stereotype.Service;

@Service
public class StringVerification {

	public String stringCreateAccountVerification(String userName, String password, String confirmedPassword) {
		if(userName.equals(password)) {
			return "User name and password can't be the same.";
		} else if (userName.contains(" ") || password.contains(" ")) { 
			return "User name and password can't contain space.";
		} else if (!password.equals(confirmedPassword)) {
			return "Passwords are not equals.";
		} else {
			return null;
		}
	}
}
