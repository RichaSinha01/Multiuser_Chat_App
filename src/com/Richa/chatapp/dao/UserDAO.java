package com.Richa.chatapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Richa.chatapp.dto.UserDTO;
import com.Richa.chatapp.utils.PasswordEncryption;

public class UserDAO {
	
	public static int register(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception {
		
		Connection conn = null; // to establish the connection 
		Statement stmt = null; // To trigger or execute the query
		
		conn = ChatDAO.createConnection();
		stmt = conn.createStatement();
		
		try {
			String userId = userDTO.getUserid();
			char []password = userDTO.getPassword();
			String pass = PasswordEncryption.passwordEncrypt(new String(password)); // to convert the hash code in string 
			String query = "insert into users values('"+userId+"'" + ",'" +pass+ "'" + ",'A')";
			int record = stmt.executeUpdate(query);
			System.out.println("User ID: " + userId);
			System.out.println("User Password: " + password);
			return record;
		}
		finally { // Always Execute except one case : System.exit()
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
		
	}
	
	public boolean isLogin(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception {
		
		Connection conn = null; 
		PreparedStatement stmt = null; 		
		
		ResultSet rs = null;
		String query = "select userid from users where userid = ? and password = ?";
		try {
			conn = ChatDAO.createConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, userDTO.getUserid());
			String encPassword = PasswordEncryption.passwordEncrypt(new String(userDTO.getPassword()));
			stmt.setString(2, encPassword);
			rs = stmt.executeQuery();
			return rs.next();
		}
		finally {
			
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
	

}
