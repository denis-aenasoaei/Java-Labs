/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.util.Random;

/**
 *
 * @author denis
 */
public class Token {
    int value;
    
    public Token(int maxValue) {
        Random random = new Random();
        value = random.nextInt(maxValue);
        if(Math.random() < 0.1f)
            value = -1;
    }
    
    
}
