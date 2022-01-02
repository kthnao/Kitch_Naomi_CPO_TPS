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
public class Languette {
    
    Pion [] tablang=new Pion[12];
    String couleurlang;//peut être rouge ou blanche
    
    public Languette(){//contrusteur de la classe 
        for (int i=0; i<12;i++){
            
                tablang[i]=new Pion("vide"); //composé de 4 cases de pion de couleur "vide"
  
            
        }
    }
    
    
}
