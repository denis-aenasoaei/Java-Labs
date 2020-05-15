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
public class Player {
    ClientThread ct;
    String name;

    public Player(ClientThread ct) {
        this.ct = ct;
    }

    public Player(String name) {
        this.name = name;
    }
}
