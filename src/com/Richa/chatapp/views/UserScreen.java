package com.Richa.chatapp.views;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.Richa.chatapp.dao.UserDAO;
import com.Richa.chatapp.dto.UserDTO;


public class UserScreen extends JFrame {
	private JTextField user_id;
	private JPasswordField passwordField;

	

	/**
	 * Create the application.
	 */
	public UserScreen() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		setResizable(false);
		setTitle("Chat Application");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Chat App...");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(102, 10, 665, 96);
		getContentPane().add(lblNewLabel);
		
		user_id = new JTextField();
		user_id.setFont(new Font("Tahoma", Font.BOLD, 18));
		user_id.setBounds(441, 143, 326, 48);
		getContentPane().add(user_id);
		user_id.setColumns(10);
		
		JLabel userIdlbl = new JLabel("UserId");
		userIdlbl.setFont(new Font("Tahoma", Font.BOLD, 26));
		userIdlbl.setBounds(163, 155, 128, 36);
		getContentPane().add(userIdlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.BOLD, 26));
		pwdlbl.setBounds(163, 259, 128, 36);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField.setBounds(441, 259, 326, 48);
		getContentPane().add(passwordField);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		loginbt.setBackground(Color.GRAY);
		loginbt.setForeground(Color.BLACK); 
		loginbt.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginbt.setBounds(214, 386, 143, 43);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		
		registerbt.setForeground(Color.BLACK);
		registerbt.setBackground(Color.GRAY);
		registerbt.setFont(new Font("Tahoma", Font.BOLD, 18));
		registerbt.setBounds(525, 386, 143, 43);
		getContentPane().add(registerbt);
		setBackground(Color.WHITE);
		setBounds(100, 100, 876, 515);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	UserDAO userDAO = new UserDAO(); // Object of UserDAO
	private void register() {
		String userid = user_id.getText(); // return the value which is written in text field
		//String password = passwordField.getText(); //deprecated
		char []password = passwordField.getPassword(); //Covert password in hash code
		UserDTO userDTO = new UserDTO(userid, password); // object of userDTO
		
		try { // pass the userDTO to the userDAO
			int res = userDAO.register(userDTO);
			if(res > 0) {
				
				JOptionPane.showMessageDialog(this, "Registered Successfully"); //To show the output in dialog box
				//System.out.println("Registered Successfully...");
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Registeration Failed");
				//System.out.println("Cannot Register...");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//System.out.println("UserId : " +userid  +  " User Password : " +password.toString());
	
	public void login() {
		
		String userid = user_id.getText();
		char []password = passwordField.getPassword(); 
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message = "";
			
			if(userDAO.isLogin(userDTO)) {
				
				message = "Welcome : " + userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose(); 
				Dashboard dashboard = new Dashboard(message);
				dashboard.setVisible(true); // To see the dashboard screen
			}
			else {
				
				message = "Invalid Userid or Password";
				JOptionPane.showMessageDialog(this, message);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserScreen window = new UserScreen();
		
}
}
