/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author denis
 */
class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) 
    {  
        this.socket = socket ;
    }
    @Override
    public void run () {
        try {
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        boolean stop=false;
        while(!stop)
        {
            
            String request = in.readLine();
            if(request.equals("exit"))
            {
                stop = true;
                
                out.println("Server stopped");
                out.flush();
                GameServer.closeServerSocket();
            }
            else
            {
                out.println("Server Received the request ...");
                out.flush();
            }
        }
        }
        catch (IOException e) {
            System.err.println("Communication error... " + e);
        }
            
    }
}
