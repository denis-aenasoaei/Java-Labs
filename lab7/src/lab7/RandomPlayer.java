/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class RandomPlayer extends Player implements Runnable {
    
    
    public RandomPlayer(String name, Game game) {
        super(name,game);
    }
    
    @Override
    public synchronized void run() {
        
        while(game.tokensLeft() != 0)
        {
            if(game.tokensLeft() % game.players.size()==1)
            {
            synchronized(game){
            Random random = new Random();
            int index = random.nextInt(game.tokensLeft());
            
            System.out.println("Random player " + name + " removed the token at index " + index);
            
            if(game.tokensLeft() == 0)
                break;
            
            extractedTokens.add(game.tokenAt(index));
            game.removeToken(index);
            }
            }
        }
        
            
        }
        
    
}
