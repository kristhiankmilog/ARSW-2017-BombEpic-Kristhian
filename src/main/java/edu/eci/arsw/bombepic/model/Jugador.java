/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.bombepic.model;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author tiffany
 */
public class Jugador{
    String nombre; 
    String nick; 
    
    public Jugador (String nombre){
        this.nombre=nombre;
    }
    
    public String getnick(){
        return nick;
    }
    
    public String getnombre() {
        return nombre;
    }
    public void setnick(String nick) {
        this.nick= nick;
    }

    public void setnombre(String nombre){
        this.nombre=nombre;
    }

    
    public Jugador(){}
    

    
}
