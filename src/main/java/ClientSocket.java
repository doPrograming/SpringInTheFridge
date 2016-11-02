

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;

public class ClientSocket {

	public static void main(String args[]) throws IOException {
		final String host = "localhost";
		
		final int portNumber= 88;
		Informations info=new Informations();
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);

		while (true) {
		
			Socket socket = new Socket(host, portNumber);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("server says:" + bufferedReader.readLine());
			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
			String userInput = userInputBR.readLine();
			
			

			out.println(userInput);

			System.out.println("server says:" + bufferedReader.readLine());

			if ("exit".equalsIgnoreCase(userInput)) {
				socket.close();
				break;
			}
		}
	}
}