package model;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		/*
		 *  Identify side using port number
		 */
		
		String ip = "localhost";
		int port = 9999;
		Socket s = new Socket(ip, port);
		
		String str = "Name";
		
		/*
		 * Output Steam Writer - Converts data into stream format 
		 * Data is being sent to i.e., socket, printer, monitor
		 * getOutputStream from socket
		 */
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream()); 
		PrintWriter out = new PrintWriter(os);
		
		os.write(str);
		os.flush();
	}
}  
