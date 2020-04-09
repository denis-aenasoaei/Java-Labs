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
public class ManualPlayer extends Player implements Runnable {
    
    
    public ManualPlayer(String name, Game game) {
        super(name,game);
    }
    @Override
    public synchronized void run() {
        
        while(game.tokensLeft() != 0)
        {
            
            if(game.tokensLeft() % game.players.size()==2) //wait + notify nu lasau playerii sa intre in acelasi timp
                                                           //dar nici nu ii lasa sa intre in ordine.
                                                           //nu am gasit o metoda de a ii spune unui anumit thread 
                                                           //sa se trezeasca/sa il notifici.
            { 
                synchronized(game){
                System.out.println("Available tokens");
                for(Token t : game.board.getTokens())
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
        

    
}
