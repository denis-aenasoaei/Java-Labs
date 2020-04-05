/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class Player implements Runnable {
    ArrayList<Token> extractedTokens = new ArrayList<>();
    String name;
    final Game game;
    
    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    public String getName() {
        return name;
    }

    @Override
    public synchronized void run() {
        
        while(game.tokensLeft() != 0)
        {
            
            synchronized(game){
            this.notifyAll();
            System.out.println("Available tokens");
            for(Token t : game.board.tokens)
            {
                System.out.printf("%d ",t.value);
            }
            System.out.println("");
            
            System.out.println(name + ", write the index of the token you want to take:");
            Scanner scanner = new Scanner(System.in);
            int answear;
            
            while((answear = scanner.nextInt()) > game.tokensLeft() -1 && game.tokensLeft() != 0)
            {
                System.out.println("Invalid token for " + name + ", enter it again");
            }
            if(game.tokensLeft() == 0)
                break;
            
            extractedTokens.add(game.tokenAt(answear));
            game.removeToken(answear);
            
            }
        }
            
        }
        
    }
    
