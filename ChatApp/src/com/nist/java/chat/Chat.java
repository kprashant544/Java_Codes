package com.nist.java.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Chat {
	public static void main(String[] args) {
		try {
			// Updated to use correct port
			Socket socket = new Socket("192.168.1.70", 6003);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

			String serverMessage;
			String clientMessage;

			while (true) {
				System.out.print("Client: ");
				clientMessage = consoleReader.readLine();
				writer.println(clientMessage);

				if (clientMessage.equals("bye")) {
					break;
				}

				serverMessage = reader.readLine();
				System.out.println("Server: " + serverMessage);
			}

			reader.close();
			writer.close();
			consoleReader.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
