/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 *
 * @author denis
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board board = new Board(15,30);
        Game game = new Game(board);
        Player player1 = new RandomPlayer("Gigi", game);
        Player player2 = new ManualPlayer("Cornel", game);
        Player player3 = new SmartPlayer("Ein", game); 
        
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        
        game.startGame();
    }
    
}
