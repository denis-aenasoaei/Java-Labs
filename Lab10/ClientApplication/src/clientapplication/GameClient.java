/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author denis
 */
public class GameClient {
    String serverAddress = "127.0.0.1"; 
    int PORT = 7075; 
    
    public GameClient(){
        try {
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out =
            new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
            Scanner commandReader = new Scanner(System.in);
            String request = "";
            while(!request.equals("exit"))
            {
                request = commandReader.nextLine().toLowerCase();
                out.println(request);
                String response = in.readLine ();
                System.out.println(response);
            }
            
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch(java.net.ConnectException ce){
            System.out.println("Connection could not be made");
        }
        catch (IOException IOe)
        {
            System.out.println("Connection error");
        }
}
}
