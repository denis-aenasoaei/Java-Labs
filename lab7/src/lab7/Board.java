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
public class Board {
    Vector<Token> tokens = new Vector<>();

    public Board(int numberOfTokens, int maxValue){ 
       for(int i=0;i<numberOfTokens;i++)
       {
           tokens.add(new Token(i+1));
       }
    }

    public Vector<Token> getTokens() {
        return tokens;
    }
    
    
    public void removeToken(int index)
    {
        tokens.remove(index);
    }
    public void removeToken(Token tok)
    {
        tokens.remove(tok);
    }
    public Token tokenAt(int index)
    {
        return tokens.get(index);
    }
    
    public int tokensLeft()
    {
        return this.tokens.size();
    }
}
