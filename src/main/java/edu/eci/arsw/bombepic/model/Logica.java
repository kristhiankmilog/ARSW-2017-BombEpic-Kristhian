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
import java.util.Arrays;
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
    Elemento bomba; 

    public Logica() {
    }


    @Override
    public String[][] mover(int idsala, PosJugador j) {
         try {
             salasMatrices= services.getSalasMat();
         } catch (ServicesException ex) {
             Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        ActualizaJuego ac = new ActualizaJuego();
        if (!salasMatrices.containsKey(idsala)) {
             try {
                 
                 Sala sala = new Sala(Tablero.tablero());
                 salasMatrices.put(idsala, sala);
                 
                 
             } catch (IOException ex) {
                 Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        ArrayList<Elemento> actualizaciones = new ArrayList();
        String[][] matriz = salasMatrices.get(idsala).getMatriz();
        
        //para el jugador
        System.out.println(j.getX()+"-+-+-+-+"+j.getY()+"+-+-+-+-+-+"+j.getKey());
        if (matriz[j.getX()][j.getY()].equals("B") || matriz[j.getX()][j.getY()].equals("A") || matriz[j.getX()][j.getY()].equals("C") || matriz[j.getX()][j.getY()].equals("D")) {
            
            if (j.getKey() == 40) {
                System.out.println("entro a"+j.getKey());
                if (((j.getX()+1)<20) && (matriz[j.getX()+1][j.getY()]).equals("1")  ) {
                        matriz[j.getX()+1][j.getY()] = matriz[j.getX()][j.getY()];
                        matriz[j.getX()][j.getY()] = "1";
                } 
                

            }else if(j.getKey() == 37){
                System.out.println("entro a"+j.getKey());
                if (((j.getY()-1)>0) && (matriz[j.getX()][j.getY()-1]).equals("1")  ) {
                        matriz[j.getX()][j.getY()-1] = matriz[j.getX()][j.getY()];
                        matriz[j.getX()][j.getY()] = "1";
                } 
                     
                    
                 
                 
                 
                 
            }else if (j.getKey() == 38){
                System.out.println("entro a"+j.getKey());
               if (((j.getX()-1)>0) && (matriz[j.getX()-1][j.getY()]).equals("1")  ) {
                   matriz[j.getX()-1][j.getY()] = matriz[j.getX()][j.getY()];
                   matriz[j.getX()][j.getY()] = "1";


               }



            }else if (j.getKey() == 39) {
                System.out.println("entro a "+j.getKey());
               if (((j.getY()+1)<20) && (matriz[j.getX()][j.getY()+1]).equals("1")  ) {
                   matriz[j.getX()][j.getY()+1] = matriz[j.getX()][j.getY()];
                   matriz[j.getX()][j.getY()] = "1";

               }





            }
             
                     
                 
            }
        
        
                
                salasMatrices.get(idsala).setMatriz(matriz);
                
         try {
             services.setSalasMat(salasMatrices);
             String[][] tmp=services.getSalasMat().get(idsala).getMatriz();
             System.out.println(ac);
             return tmp;
         } catch (ServicesException ex) {
             Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
         }
             
             
           return matriz;
         }
             
             
             
             
        
     

    @Override
    public int[] muerte(String data, String[][] matriz) {
        boolean flag = true;
        int myposx = 1, myposy = 1;
        int[] ans = new int[2];
        if (data.equals("A")) {
            myposx = 23;
            myposy = 1;
        } else if (data.equals("B")) {
            myposx = 1;
            myposy = 1;
        } else if (data.equals("D")) {
            myposx = 1;
            myposy = 34;
        } else if (data.equals("C")) {
            myposx = 23;
            myposy = 34;
        }
        
        if (flag) {
            if (!matriz[myposx][myposy].equals("0")) {
                for (int i = 0; i < 24; i++) {
                    for (int col = 0; col < 35; col++) {
                        if (matriz[i][col].equals("0")) {
                            myposx = i;
                            myposy = col;
                            i = 25;
                            break;
                        }
                    }
                }
            }
        } else if (!matriz[myposx][myposy].equals("0")) {
            for (int i = 14; i < 18; i++) {
                for (int col = 16; col < 20; col++) {
                    if (matriz[i][col].equals("0")) {
                        myposx = i;
                        myposy = col;
                        i = 21;
                        break;
                    }
                }
            }
        }
        ans[0] = myposx;
        ans[1] = myposy;
        return ans;
        
    }
    
    
    
    
}
