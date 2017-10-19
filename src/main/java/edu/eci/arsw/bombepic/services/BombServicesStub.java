/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.bombepic.services;

import edu.eci.arsw.bombepic.model.InformacionJuego;
import edu.eci.arsw.bombepic.model.Jugador;
import edu.eci.arsw.bombepic.model.Sala;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiffany
 */

@Service

public class BombServicesStub implements BombServices{
    private ConcurrentHashMap<Integer, Jugador> salasData=new ConcurrentHashMap<>();
    private String[][] mat;

    public BombServicesStub() {
        salasData.put(1,new Jugador());
    }
    
    

    @Override
    public void registroJugador(int salanum, Jugador p) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jugador> getJugadores(int salanum) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[][] getTablero() throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSalaDisponile() throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSalaDisponible(int sala) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getID(int sala) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InformacionJuego> getInfo(int sala) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConcurrentHashMap<Integer, Sala> getSalasMat() throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSalasMat(ConcurrentHashMap<Integer, Sala> sala) throws ServicesException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
