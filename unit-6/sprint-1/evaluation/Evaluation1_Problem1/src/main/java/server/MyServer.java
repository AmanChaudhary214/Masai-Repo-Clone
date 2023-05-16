package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) {
		connectToServer();
	}
	
	public static void connectToServer() {
		try(ServerSocket serverSocket = new ServerSocket(9991)) {
		
			Socket connectionSocket = serverSocket.accept();
			
			InputStream inputStream = connectionSocket.getInputStream();
			OutputStream outputStream = connectionSocket.getOutputStream();
			
			Scanner scanner = new Scanner(inputStream, "UTF-8");
			PrintWriter serverPrintWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
			
			serverPrintWriter.println("Enter 0 to exit");
			boolean temp = false;
			
			while(!temp && scanner.hasNextLine()) {
				String input = scanner.next();
				if (input.matches("\\d+")) {
					int num = Integer.parseInt(input);
					int count = 0;
					if (num == 0) {
						temp = true;
					}
					for (int i=1; i<=num; i++)
					{
						if (num%i==0) {
							count++;
						}
					}
					if (count==2) {
						serverPrintWriter.println("prime");
					}
					else serverPrintWriter.println("not prime");
				}
				else if (input.equals("true") || input.equals("false")) {
					if (input.equals("true")) {
						serverPrintWriter.println("false");
					}
					else {
						serverPrintWriter.println("true");
					}
				}
				else {
					String revString = "";
					for (int i=0; i<input.length(); i++) {
						char ch = input.charAt(i);
						revString = ch+revString;
					}
					serverPrintWriter.println(revString);
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
