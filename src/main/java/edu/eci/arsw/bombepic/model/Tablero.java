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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiffany
 */
public  class Tablero {
    public static int obstaculo;
    public  static String[][] tabl;
    
    public Tablero(){
        
        tabl=new String[21][21];
        
      
        obstaculo=3;
        
        for (int i = 0; i < tabl.length; i++) {
            for (int j = 0; j < tabl.length; j++) {
                if(((i%2)==0) && ((j%2)==0)){
                    tabl[i][j]="3";
                }else if((i==1 && j==2)||(i==2 && j==1)||(i==1 && j==18)||(i==2 && j==19)||(i==18 && j==1)||(i==19 && j==2)||(i==19 && j==18)||(i==18 && j==19)){
                    tabl[i][j]="1";
                }else{
                    Random numAleatorio = new Random ();
                    tabl[i][j]=String.valueOf(numAleatorio.nextInt(2)+1);
                }
            }
            
        }
        
        for (int i = 0; i < tabl.length; i++) {
            tabl[i][0]="3";
            tabl[i][tabl.length-1]="3";            
        }
        for (int j = 0; j < tabl.length; j++) {
            tabl[0][j]="3";
            tabl[tabl.length-1][j]="3";
        }
        tabl[1][1]="A";
        tabl[19][1]="B";
        tabl[1][19]="C";
        tabl[19][19]="D";
        
    }
    
    
    public static String [][] tablero() throws IOException{
        return tabl;
    }
    
    
}
