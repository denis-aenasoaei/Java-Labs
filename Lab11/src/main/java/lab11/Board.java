/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

/**
 *
 * @author denis
 */
public class Board {
    int size;
    int[][] board;
    
    public Board(int size) {
        this.size = size;
        this.board = new int[size][size];
        
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                board[i][j] = -1;
    }
    
    public void putStone(int i, int j, int player)
    {
        if(i>size || j>size)
            return;
        
        if(player == 1)
        {
            board[i][j] = 1;
        }
        if(player == 2)
        {
            board[i][j] =2;
        }
    }
    public int checkWin()
    {
        for(int i=0;i<size;i++)
        {
            int p1InARow = 0;
            int p2InARow = 0;
            
            int p1Column = 0;
            int p2Column = 0;
            for(int j=0;j<size;j++)
            {
                if(board[i][j] == 1)
                {
                    p1InARow++;
                    p2InARow = 0;
                    if(p1InARow == 5)
                    {
                        return 1;
                    }
                }
                if(board[i][j] ==2)
                {
                    p2InARow++;
                    p1InARow = 0;
                    if(p2InARow == 5)
                    {
                        return 2;
                    }
                }
                if(board[i][j] == -1)
                {
                    p2InARow = 0;
                    p1InARow = 0;
                }
                if(board[j][i] == 1)
                {
                    p1Column ++;
                    p2Column = 0;
                    if(p1Column == 5)
                    {
                        return 1;
                    }
                }
                if(board[j][i] == 2)
                {
                    p1Column = 0;
                    p2Column ++;
                    if(p2Column ==5)
                    {
                        return 2;
                    }
                }
                if(board[j][i] == -1)
                {
                    p1Column = 0;
                    p2Column = 0;
                }
               
                
            }
        }
    return -1;
    }
    
}
