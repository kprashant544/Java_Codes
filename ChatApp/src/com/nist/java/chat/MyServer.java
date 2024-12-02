package com.nist.java.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6003);
			System.out.println("server waiting for connection....");
			Socket clientSocket = serverSocket.accept();
			System.out.println("client connection");
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

			String serverMessage;
			String clientMessage;

			while (true) {

				clientMessage = reader.readLine();

				System.out.println("Client:" + clientMessage);

				if (clientMessage.equals("bye")) {
					break;
				}

				System.out.println("server:");
				serverMessage = consoleReader.readLine();
				writer.println(serverMessage);

				if (clientMessage.equals("bye")) {
					break;
				}

			}
			reader.close();
			writer.close();
			consoleReader.close();
			clientSocket.close();
			serverSocket.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}