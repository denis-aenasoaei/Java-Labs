/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author denis
 */
public class Game {
    Vector<Player> players = new Vector<>();
    Board board;

    public Game(Board board) {
        this.board = board;
    }
  
    public void addPlayer(Player p)
    {
        players.add(p);
    }
    
    public void startGame()
    {
        
        if(board == null || players == null || players.isEmpty())
            return;
        
        DaemonThread timeKeeper = new DaemonThread(this);
        timeKeeper.setDaemon(true);
        
        timeKeeper.start();
        
        for(Player player : players)
        {
            new Thread((Runnable) player).start();
        }
        
        
        while(board.tokensLeft() != 0)
        {
        }
        
        for(Player p : players)
        {
            System.out.println(p.getClass().getName() + p.name + " has gathered the following tokens\n");
            for(Token t : p.extractedTokens)
            {
                System.out.printf("%d ",t.value);
            }
            System.out.println("");
        }
        //ToDo - See who won
           
    }
    public void removeToken(int index)
    {
        board.tokens.remove(index);
    }
    public void removeToken(Token tok)
    {
        board.tokens.remove(tok);
    }
    public Token tokenAt(int index)
    {
        return board.tokens.get(index);
    }
    
    public int tokensLeft()
    {
        return board.tokens.size();
    }
    
}
