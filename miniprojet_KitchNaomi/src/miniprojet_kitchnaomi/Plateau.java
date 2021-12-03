/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet_kitchnaomi;

/**
 *
 * @author naomi
 */
public class Plateau {
    Cellule [][] CellulesPlateau=new Cellule[12][4];
    
    public Plateau(){//contrusteur de la classe 
        for (int i=0; i<12;i++){
            for(int j=0; j<4; j++){
                CellulesPlateau[i][j]=new Cellule(); //12 lignes et 4 colonnes
            }
        }
    }
    
}
