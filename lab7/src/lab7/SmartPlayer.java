/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class SmartPlayer extends Player implements Runnable {
    int chosenRatio = 1;
    
    public SmartPlayer(String name, Game game) {
        super(name,game);
    }
    
    @Override
    public synchronized void run() {
        
        while(game.tokensLeft() != 0)
        {
            if(game.tokensLeft() % game.players.size()==0)
            {
            synchronized(game){
            int choice = 0;
            if(this.extractedTokens.size() != 0)
            {
                for(int ratio = chosenRatio; ratio < game.board.getTokens().size() - 1; ratio++)
                {
                    for(Token t : game.board.getTokens())
                    {
                        if(this.extractedTokens.get(this.extractedTokens.size() -1).value + chosenRatio == t.value)
                        {
                           choice = game.board.getTokens().indexOf(t);
                           break;
                        }
                    }
                    if(choice != -1)
                        break;
                }
            }
            
            if(game.tokensLeft() == 0)
                break;
            System.out.println("Smart player " + name + " removed token at index " + choice );
            extractedTokens.add(game.tokenAt(choice));
            game.removeToken(choice);
            
            }
            }
        }
        
            
        }
       
}
