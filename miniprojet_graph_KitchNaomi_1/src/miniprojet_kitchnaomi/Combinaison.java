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
public class Combinaison {
    Pion [] tabcombi=new Pion[4];//Combinaison correspond à un tableau composé de 4 pions
    
    public Combinaison(){//contrusteur de la classe 
        for (int i=0; i<4;i++){
            
                tabcombi[i]= new Pion("vide"); //composé de 4 pions de couleur "vide"
            
        }
    }
}
