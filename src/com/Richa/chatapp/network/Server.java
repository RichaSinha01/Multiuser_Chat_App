package com.Richa.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.Richa.chatapp.utils.configReader;

public class Server {
	ServerSocket serversocket;
	ArrayList<ServerWorker> workers = new ArrayList<ServerWorker>();
	public Server() throws IOException {
		int PORT = Integer.parseInt(configReader.getValue("PORTNO"));
		serversocket = new ServerSocket(PORT);
		System.out.println("Server Started and waiting for client to join...");
		handleClientReq();
	}
	
	public void handleClientReq() throws IOException {
		while(true) {
			Socket socket = serversocket.accept();
//			Per client there will be a separate thread
			ServerWorker serverworker = new ServerWorker(socket,this);		// creating a new thread per client
			workers.add(serverworker);
			serverworker.start();
		}
	}
	
	/*public Server() throws IOException {
		int PORT = Integer.parseInt(configReader.getValue("PORTNO"));
		serversocket = new ServerSocket(PORT);
		System.out.println("Server started and waiting for client to join...");
		Socket socket = serversocket.accept(); 
		System.out.println("Client has joined successfully...");
		InputStream in = socket.getInputStream();
		byte arr[] = in.readAllBytes();
        String str = new String(arr);
        System.out.println("Message received from client: "+ str);
        in.close();

	}*/
	
	public static void main(String[] args) throws IOException {
		Server server = new Server();
	}
}
