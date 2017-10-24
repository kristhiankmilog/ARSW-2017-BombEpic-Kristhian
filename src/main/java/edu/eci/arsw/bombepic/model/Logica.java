/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.bombepic.model;

import edu.eci.arsw.bombepic.services.BombServices;
import edu.eci.arsw.bombepic.services.ServicesException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tiffany
 */



/**
 * 
 *  Flecha izquierda 	37 	
    Flecha arriba 	38 	
    Flecha derecha 	39 	
    Flecha abajo 	40 	
    * 
    * 
    * //3 es un obstaculo
    //0 un espacio en blanco
    //2 pared comible
    //letras en mayusculas son jugadores


 */

@Service
public class Logica implements LogicaInter{
    
     @Autowired
    BombServices services;
    private ConcurrentHashMap<Integer, Sala> salasMatrices ;

    public Logica() {
    }


    @Override
    public ActualizaJuego mover(int idsala, PosJugador j) {
         try {
             salasMatrices= services.getSalasMat();
         } catch (ServicesException ex) {
             Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        ActualizaJuego ac = new ActualizaJuego();
        if (!salasMatrices.containsKey(idsala)) {
             try {
                 Sala sala = new Sala(Tablero.tablero(), Tablero.obstaculo);
                 salasMatrices.put(idsala, sala);
             } catch (IOException ex) {
                 Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        ArrayList<Elemento> actualizaciones = new ArrayList();
        String[][] matriz = salasMatrices.get(idsala).getMatriz();
        
        //para el jugador 
        if (matriz[j.getX()][j.getY()].equals("B") || matriz[j.getX()][j.getY()].equals("A") || matriz[j.getX()][j.getY()].equals("C") || matriz[j.getX()][j.getY()].equals("D")) {
             if (j.getKey() == 40) {
                    if (!(matriz[j.getX() + 1][j.getY()]).equals("3") && !(matriz[j.getX() + 1][j.getY()]).equals("A") && !(matriz[j.getX() + 1][j.getY()]).equals("B") && !(matriz[j.getX() + 1][j.getY()]).equals("C") && !(matriz[j.getX() + 1][j.getY()]).equals("D")) {
                        if ((matriz[j.getX() + 1][j.getY()]).equals("a") || (matriz[j.getX() + 1][j.getY()]).equals("b") || (matriz[j.getX() + 1][j.getY()]).equals("c") || (matriz[j.getX() + 1][j.getY()]).equals("d")) {
                            
                        
                        }

                    
                    }

             
             
             
             }
        
        
        }

        
        
        
        
        
    }

    @Override
    public int[] muerte(String data, String[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
