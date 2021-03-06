package model;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
 
/**
 * This program demonstrates a simple TCP/IP socket server that echoes every
 * message from the client in reversed form.
 * This server is single-threaded.
 *
 * @author www.codejava.net
 * Modified by: Matteo Pulcini
 */
public class Server {
 
    public static void main(String[] args) {
        if (args.length < 1) return; //command line arguments
 
        int port = Integer.parseInt(args[0]); //sets port number 
        int index = 0;
        ArrayList<String> a = new ArrayList<String>(); 
        try (ServerSocket serverSocket = new ServerSocket(port)) { //declares 'resource' that must be closed, end of block
 
            System.out.println("Server is listening on port " + port); 
 
            while (true) {
                Socket socket = serverSocket.accept(); 
                System.out.println("New client connected");
 
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
 
                String text;
 
                do {
                    text = reader.readLine();
                    a.add(text);
                    writer.println("Server (Blocked Site): " + text); //automatic flushing with println
                    writer.println(a.get(index));
                    index++;
                } while (!text.equals("bye"));
                socket.close();
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}