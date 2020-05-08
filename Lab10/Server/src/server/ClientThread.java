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
            if(request.contains("create"))
            {
                Player player1 = new Player(this);
                String[] words = (request.split("\\s"));
                for(String word : words)
                    System.out.println(word);
                int id = Integer.parseInt(words[1]);
                Game game = new Game(id, player1);
                
                GameServer.addGame(game);
                out.println("Game created, waiting for players");
                out.flush();
                
                while(!game.gameEnded())
                {
                    String move = in.readLine();
                    String[] coords = move.split("\\s");
                    int line = Integer.parseInt(coords[0]);
                    int column = Integer.parseInt(coords[1]);
                    
                    game.putStone(line, column, 1);
                    out.println("Inserted stone");
                    out.flush();
                }
                
                if(game.getWinner() == 1)
                {
                    out.println("Congratulations, you won, exiting...");
                    out.flush();
                }
                else{
                    out.println("You lost, exiting...");
                    out.flush();
                }
                
                GameServer.deleteGame(game);
            }
            if(request.contains("join"))
            {
                Player player2 = new Player(this);
                
                Game game = null;
                while(game == null)
                {
                    String[] words = (request.split("\\s"));
                    int id = Integer.parseInt(words[1]);
                    game = GameServer.gameExists(id);
                    
                    if(game != null)
                    {
                        out.println("Game joined");
                        out.flush();
                    }
                    else
                    {
                        out.println("Game does not exist");
                        out.flush();
                    }
                }
                while(!game.gameEnded())
                {
                    String move = in.readLine();
                    String[] coords = move.split("\\s");
                    int line = Integer.parseInt(coords[0]);
                    int column = Integer.parseInt(coords[1]);
                    
                    game.putStone(line, column, 2);
                    out.println("Inserted stone");
                    out.flush();
                }
                
                if(game.getWinner() == 1)
                {
                    out.println("You lost, exiting...");
                    out.flush();
                }
                else{
                    out.println("You lost, exiting...");
                    out.flush();
                }
                
            }
            
        }
        }
        catch (IOException e) {
            System.err.println("Communication error... " + e);
        }
            
    }
}
