/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.bombepic.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiffany
 */
public class Tablero {
    public static int obstaculo;
    
    public static String [][] tablero() throws IOException{
        String [][] t1=null; 
        FileReader file=null;
        
        try{
            String x;
            file= new FileReader("tablero.txt");
            BufferedReader b= new BufferedReader(file);
            int i=0;
            x=b.readLine();
            String [] cadena=x.split(" ");
            
            int filas=Integer.valueOf(cadena[0]);
            int colu=Integer.valueOf(cadena[1]);
            obstaculo=Integer.valueOf(cadena[2]);
            
            t1=new String[filas][colu];
            for (int j = 0; j < filas; j++) {
                x=b.readLine();
                cadena=x.split("\t");
                for (int k = 0; k < cadena.length; k++) {
                    t1[j][k]= cadena[k];
                    
                }
                
            }
            b.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t1;
    }
}
