package com.Richa.chatapp.dao;

import static com.Richa.chatapp.utils.configReader.getValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ChatDAO {
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName(getValue("DRIVER"));
		
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USER_ID");
		final String PASSWORD = getValue("PASSWORD");
		
		Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
		if(conn != null) {
			System.out.println("Connection Created....");
			//conn.close();
		}
		return conn;
	}
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ChatDAO dao = new ChatDAO();
		dao.createConnection();
	}*/
    
}
