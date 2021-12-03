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
public class Joueur {
    String nom;
    int EssaiesRestants;
    Pion pionR=new Pion("rouge");
    Pion pionV=new Pion("vert");
    Pion pionJ=new Pion("jaune");
    Pion pionO=new Pion("orange");
    Pion pionB=new Pion("bleu");
    Pion pionM=new Pion("mauve");
    
  
    
public Joueur(String unNom) { //constructeur initialisant le nom du joueur avec son paramètre
nom = unNom;
EssaiesRestants=12;
}
    
}
