package com.Richa.chatapp.utils;

import java.util.ResourceBundle;

public class configReader {
	configReader(){}
	private static ResourceBundle rb = ResourceBundle.getBundle("config"); // To load the class with variable
	// it will call the getValue function and pass the key i.e USER_ID, PASSWORD, etc and it will return the value of the key
	public static String getValue(String key) {
		return rb.getString(key);
	}

}
