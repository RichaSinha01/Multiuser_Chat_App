package com.Richa.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Dashboard(String message) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle(message);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(130, -11, 643, 456);
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/assets/Dashboard_img.png")));
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 101, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Chat Options");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(Color.GRAY);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Start Chat");
		mnNewMenu_1.setBackground(Color.GRAY);
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mnNewMenu_1);
		
	}
}
