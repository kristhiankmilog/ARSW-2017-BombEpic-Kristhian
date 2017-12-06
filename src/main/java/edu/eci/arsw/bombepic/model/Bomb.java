/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.bombepic.model;

/**
 *
 * @author kristhian
 */
public class Bomb {
    
    private int contbomb=0;
    private boolean statbomb=false;
    private int xbomb;
    private int ybomb;
    private String nick;
    
    public Bomb(){
        
    }
    
    public Bomb(int xbomb,int ybomb, String nick){
        this.xbomb = xbomb;
        this.ybomb = ybomb;
        this.nick = nick;
    }
    
    
    public int getCountbomb() {
        return contbomb;
    }

    public void setCountbomb(int count) {
        this.contbomb = count;
    }
    
    public boolean getStatbomb() {
        return statbomb;
    }

    public void setStatbomb(boolean stat) {
        this.statbomb = stat;
    }
    
    public int getXbomb() {
        return xbomb;
    }
    
    public void setXbomb(int xbomb) {
        this.xbomb = xbomb;
    }
    
    public int getYbomb() {
        return ybomb;
    }
    
    public void setYbomb(int ybomb) {
        this.ybomb = ybomb;
    }
    
    public String getNickbomb(){
        return nick;
    }
    
    public void setNickbomb(String nick){
        this.nick=nick;
    }
    
}
