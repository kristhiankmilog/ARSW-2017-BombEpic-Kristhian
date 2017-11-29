/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.bombepic.services;

import edu.eci.arsw.bombepic.model.InformacionJuego;
import edu.eci.arsw.bombepic.model.Jugador;
import edu.eci.arsw.bombepic.model.Sala;
import edu.eci.arsw.bombepic.model.Jugadores;
import edu.eci.arsw.bombepic.model.Tablero;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiffany
 */

@Service

public class BombServicesStub implements BombServices{
    private ConcurrentHashMap<Integer, Jugadores> salasData=new ConcurrentHashMap<>();
     private ConcurrentHashMap<Integer, String[][]> salasTab=new ConcurrentHashMap<>();
    private String[][] mat;
    private int salas=0;
    private ConcurrentHashMap<Integer, Sala> salasMat = new ConcurrentHashMap<>();
    private Tablero tab;
    
    public BombServicesStub(){
        salasData.put(0,new Jugadores());
        tab= new Tablero();
        
    }
    
    
    @Override
    public void registroJugador(int salanum, Jugador p,String carac) throws ServicesException {
        CopyOnWriteArrayList tmp =salasData.get(salanum).getJugadores();
        int a = 65 +tmp.size();
        salasData.get(salanum).setIds(p.getnick(), Character.toString((char)a));
        InformacionJuego inf=new InformacionJuego(p.getnombre(), Character.toString((char)a));
        tmp.add(p);
        salasData.get(salanum).setJugadores(tmp);
          
        }

    @Override
    public List<Jugador> getJugadores(int salanum) throws ServicesException {
        if(salasData.get(salanum)==null){
            salasData.put(salanum,new Jugadores());
            return salasData.get(salanum).getJugadores();
        }
        return salasData.get(salanum).getJugadores();
    }


    @Override
    public String[][] getTablero(int salanum) throws ServicesException {
        if (salasTab.get(salanum)==null){
            try {
                salasTab.put(salanum, new Tablero().tablero());
                return salasTab.get(salanum);
            } catch (IOException ex) {
                Logger.getLogger(BombServicesStub.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return salasTab.get(salanum);
               
    }

    @Override
    public int getSalaDisponible() throws ServicesException {
        return salas;

    }

    @Override
    public void setSalaDisponible(int sala) throws ServicesException {
        salasData.put(sala,new Jugadores());
        this.salas=sala;

    }
    
    @Override
    public String getId(int sala, String user) throws ServicesException {
        return salasData.get(sala).getIds().get(user);
    }

    

    @Override
    public List<InformacionJuego> getInfo(int sala) throws ServicesException {
        return salasData.get(sala).getInformacion();


    }

    @Override
    public ConcurrentHashMap<Integer, Sala> getSalasMat() throws ServicesException {
        return this.salasMat;
    }

    @Override
    public void setSalasMat(ConcurrentHashMap<Integer, Sala> sala) throws ServicesException {
        this.salasMat=sala;


    }
    
    @Override
    public Jugador getJugador(int sala,String jugador){
        for (int i = 0; i < salasData.get(sala).getJugadores().size(); i++) {
            if(salasData.get(sala).getJugadores().get(i).getnombre()==jugador){
                Jugador tmp=salasData.get(sala).getJugadores().get(i);
                return tmp;
            }
        }
       
        return null;
    }

    
 
    
}
