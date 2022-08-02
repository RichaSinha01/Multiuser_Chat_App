package com.Richa.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface PasswordEncryption {
	
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {
		String encryptedPassword = null;
		
		//To encrypt password (MD5 is a predefined algorithm which convert the plain password into 20 digits password)
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		md.update(plainPassword.getBytes()); //To convert the plain password into byte
		byte []encrypt = md.digest(); // Password encryption
		
		StringBuffer sb = new StringBuffer(); // convert the encrypted password in readable form
		for(byte b : encrypt) {
			sb.append(b);
		}
		
		encryptedPassword = sb.toString();
		//System.out.println("Encrypted Password : " + sb.toString());
		return encryptedPassword;
	}
	
}
