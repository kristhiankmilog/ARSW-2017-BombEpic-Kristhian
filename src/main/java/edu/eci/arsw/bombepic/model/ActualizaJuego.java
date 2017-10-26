/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.bombepic.model;

import java.util.ArrayList;

/**
 *
 * @author tiffany
 */
public class ActualizaJuego {
    private ArrayList<Elemento> actualizaciones;
    private Boolean poderes=false;
    private Boolean rompibles = false;

    public Boolean getRompibles() {
        return rompibles;
    }

    public void setRompibles(Boolean rompibles) {
        this.rompibles = rompibles;
    }
    int [] posiciones=new int[2];
    private String jugador;

    public ArrayList<Elemento> getActualizaciones() {
        return actualizaciones;
    }

    public void setActualizaciones(ArrayList<Elemento> actualizaciones) {
        this.actualizaciones = actualizaciones;
    }

    public Boolean getPoderes() {
        return poderes;
    }

    public void setPoderes(Boolean poderes) {
        this.poderes = poderes;
    }

    public int[] getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(int[] posiciones) {
        this.posiciones = posiciones;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    
    
}
