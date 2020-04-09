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
public abstract class Player {
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

        
    }
    
