/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author denis
 */
public class Game {
    Board board;
    int gameId;
    Player player1;
    Player player2;

    public Game(Board board, int gameId, Player player1, Player player2) {
        this.board = board;
        this.gameId = gameId;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Game(int gameId, Player player1) {
        this.gameId = gameId;
        this.board = new Board(15);
        this.player1 = player1;
    }
    
    public void addPlayer(Player p2)
    {
        if(player2 == null)
            player2 = p2;
    }
    
    public boolean gameEnded()
    {
        if(board.checkWin()!= -1)
            return true;
        return false;
    }
    
    public int getWinner()
    {
        return board.checkWin();
    }
    
    public void putStone(int i, int j, int player)
    {
        if(i>board.size || j>board.size)
            return;
        
        if(player == 1)
        {
            board.board[i][j] = 1;
        }
        if(player == 2)
        {
            board.board[i][j] =2;
        }
    }
}
