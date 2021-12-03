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
public class Pion {
    String couleur;
    
    public Pion(String uneCouleur){
//constructeur initialisant la couleur du pion avec le paramètre
        couleur=uneCouleur;
    }

   
    
 public String lireCouleur(){
//renvoie la couleur du pion
     return couleur;
 }
    
}
