package com.Richa.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame {
	int counter;
	public UserView() {
		counter = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //To close the window from everywhere after exist
		setSize(500, 500); //To set the width and height of the window 
		setResizable(false); //To hide the minimize maximize tab
		setTitle("chat Application"); //To set the title of the window
		setLocationRelativeTo(null); //To set the window at centre
		//setLocation(500, 150);
		JLabel login = new JLabel("Login"); //To make the label
		login.setFont(new Font("Arial", Font.BOLD, 40)); //To set the font of the label
		Container container = this.getContentPane(); //we find the content area from the current frame 
		container.setLayout(null); //to set the layout of the label
		login.setBounds(100, 70, 200, 60); //to set the bounds of the label as x, y, width, height
		container.add(login); //to add the label on the window
		JButton button = new JButton("count"); //to add button on the window
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				counter++;
				login.setText("Count "+counter);
			}
		});
		button.setBounds(100, 300, 200, 50); // to set the boundary for the button
		container.add(button); //to add button on the screen
		setVisible(true);    //To set the window visibility
	}
	public static void main(String[] args ) {
		UserView userView = new UserView();
		 
	}
    
}
