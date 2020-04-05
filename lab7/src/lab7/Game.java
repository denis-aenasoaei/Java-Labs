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
        for(Player player : players)
        {
            new Thread((Runnable) player).start();
        }
        
        while(board.tokensLeft() != 0)
        {
             
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
