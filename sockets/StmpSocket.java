package sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StmpSocket {
    
    public static void main(String[] args) {
        String smtpServer = "smtp.gmail.com";
        int port = 25;
        try {
            System.out.println("Connecting to " + smtpServer + " on port " + port);
            
            // Connect to the SMTP server
            Socket socket = new Socket(smtpServer, port);
            
            // Create writer to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Create reader from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Fetch server greeting
            String serverGreeting = in.readLine(); // Read server's response/greeting
            System.out.println(serverGreeting);
            
            // Sending HELO command
            String heloCommand = "HELO kali.com"; // replace with your domain
            out.println(heloCommand);
            System.out.println(in.readLine());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}