/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.bombepic.model;

/**
 *
 * @author tiffany
 */
public class PosJugador {
    private int x;
    private int y;
    private int key;
    
    
    public PosJugador(){}
    
    public PosJugador(int x, int y, int key) {
        this.x = x;
        this.y = y;
        this.key = key;
        
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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }   
    
    
}
