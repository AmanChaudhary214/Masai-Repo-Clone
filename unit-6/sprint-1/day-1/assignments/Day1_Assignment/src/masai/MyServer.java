package masai;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
* Written by Martin Ombura Jr. <@martinomburajr>
*/
public class MyServer {
    public static void main(String[] args) {
        connectToServer();
    }

    public static void connectToServer() {
        //Try connect to the server on an unused port eg 9991. A successful connection will return a socket
    	System.out.println("Server started");
        try(ServerSocket serverSocket = new ServerSocket(9991)) {
            Socket connectionSocket = serverSocket.accept();

            //Create Input&Outputstreams for the connection
            InputStream inputToServer = connectionSocket.getInputStream();
            OutputStream outputFromServer = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(inputToServer, "UTF-8");
            PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);

            serverPrintOut.println("Hello World! Enter 0 to exit.");

            //Have the server take input from the client and echo it back
            //This should be placed in a loop that listens for a terminator text e.g. bye
            boolean done = false;

            while(!done && scanner.hasNextLine()) {
                int num = scanner.nextInt();
                serverPrintOut.println("Echo from Aman's Server: " + num*num);

                if(num==0) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}