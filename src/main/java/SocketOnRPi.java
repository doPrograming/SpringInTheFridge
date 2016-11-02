import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.net.*;

public class SocketOnRPi {

	public static void main(String args[]) throws IOException {
		final int portNumber = 88;
		
		System.out.println("Creating server socket on port " + portNumber);
		//Opening a new socket on local network
		ServerSocket serverSocket = new ServerSocket(portNumber);
		//Creating an object so that we can get informations from raspberry pi
		Informations info=new Informations();
		//Creating an object for the date, so we can know the exactly time
		Date date=new Date();
		
		while(true) {
		
		
			OutputStream outputStream = serverSocket.accept().getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			printWriter.println("Hello Sir, the temperature of fridge is "+" " + info.getTemperature());
		

			BufferedReader br = new BufferedReader(new InputStreamReader(serverSocket.accept().getInputStream()));
			String str = br.readLine();
			printWriter.println("Hello"+str);
			printWriter.println("The time is: "+date);
		
			
			System.out.println("The socket has been created on port:"+portNumber);
			System.out.println("Hej hej");
			
		}
	}
}
