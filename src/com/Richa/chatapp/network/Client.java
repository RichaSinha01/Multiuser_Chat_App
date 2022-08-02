package com.Richa.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.Richa.chatapp.utils.configReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	JTextArea textArea;
	ClientWorker worker;
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(configReader.getValue("PORTNO"));
		socket = new Socket(configReader.getValue("SERVER_IP"), PORT);
		readMessage();
		System.out.println("Client Arrived....");
		out = socket.getOutputStream();
		in = socket.getInputStream();
		this.textArea = textArea;
	}
	/*public Client() throws UnknownHostException, IOException {
		
		int PORT = Integer.parseInt(configReader.getValue("PORTNO"));
		socket = new Socket(configReader.getValue("SERVER_IP"), PORT);
		//Socket clientSocket = new Socket("localhost", 5000);
		//clientSocket.close();
	}*/
    
	public void sendMessage(String message) throws IOException {
		out.write(message.getBytes());
	}
	
	public void readMessage() {
		worker = new ClientWorker(in, textArea);
		worker.start();
	}

	
	/*public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
	}*/
}
