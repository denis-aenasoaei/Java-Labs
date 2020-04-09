/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author denis
 */
public class DaemonThread extends Thread {
    
    Game game;

    public DaemonThread(Game game) {
        this.game = game;
    }
    
    
    @Override
    public void run()
    {
        long start = System.nanoTime();
        long maxTime = 50000 ; //miliseconds
        while(game.tokensLeft() != 0 && (System.nanoTime() - start ) /1000000 < maxTime)
        {
            
        }
        if((System.nanoTime() - start ) /1000000 >= maxTime)
        {
            System.out.println("Too much time, please go quicker on selecting");
            System.exit(0);
        }
        else
        {
            System.out.println("Time the game took: " + (System.nanoTime() - start ) /1000000  + " miliseconds");
        }
    }
}
