/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.awt.Color;

/**
 *
 * @author denis
 */
public class Shapes {
    private int sides;
    private int radius;
    private Color color;
    private int x;
    private int y;

    public Shapes(int sides, int radius, Color color, int x, int y) {
        this.sides = sides;
        this.radius = radius;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

   

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
}
