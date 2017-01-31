package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	private final static int PORT = 8889; // puerto para conectarse al servidor
	private final static String IP = "127.0.0.1"; // localhost

	public static void main(String[] args) {
	
		try {
			Socket socket = new Socket(IP, PORT);
			
			// flujos de entrada y salida con el servidor
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			// flujo de salida del usuario
			Scanner scan = new Scanner(System.in);
			
			// muestra el ID del cliente
			out.println("ID");
			out.flush();
			System.out.println(in.nextLine());
			System.out.println();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
