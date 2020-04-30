/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class GameServer {

    
    static private final int PORT = 7075;
    private static ServerSocket serverSocket = null ;
    public static void main(String[] args) throws IOException {
        
        
        try {
        serverSocket = new ServerSocket(PORT);
        while (true) {
            System.out.println ("Waiting for a client ...");
            Socket socket = serverSocket.accept();
            // Execute the client's request in a new thread
            new ClientThread(socket).start();
        }
        }
        catch (SocketException se)
        {
            System.out.println("Server received exit command and stopped");
        }
    }
    
    public static void closeServerSocket(){
        try {
            serverSocket.close();
        } catch (IOException ex) {
            
        }
    }
    
}
