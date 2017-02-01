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

			// muestra el ID del cliente
			getId(in, out);

			// cuestionario
			answerQuestions(in, out);
			
			socket.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/**
	 * Devuelve el ID del Cliente asignado por el Servidor.
	 * 
	 * @param in
	 *            : flujo de entrada.
	 * @param out
	 *            : flujo de salida.
	 */
	private static void getId(Scanner in, PrintWriter out) {
		out.println("ID");
		out.flush();
		System.out.println(in.nextLine());
		System.out.println();
	}

	/**
	 * Inicia el cuestionario.
	 * 
	 * @param in
	 *            : flujo de entrada
	 * @param out
	 *            : flujo de salida
	 */
	private static void answerQuestions(Scanner in, PrintWriter out) {
		Scanner scan = new Scanner(System.in);
		int count = 0;

		out.println("NQUESTIONS");
		out.flush();
		count = in.nextInt();
		System.out.println("Hay " + count + " preguntas:");

		for (int i = 0; i < count; i++) {
			out.println("QUESTION");
			out.flush();

			for (int j = 0; j < 7; j++) { // 7 es el número de líneas que
											// contiene cada pregunta
				System.out.println(in.nextLine());
			}

			System.out.print(">");
			
			int answer = scan.nextInt();

			while (answer < 1 || answer > 4) {
				System.err.println("invalid response.");
				System.out.print(">");
				answer = scan.nextInt();
			}
			out.println("ANSWER " + answer);
			out.flush();
		}

		scan.close();

	}

}
