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
public class Cellule {
    Pion PionCourant;//Pion courant, celui qui nous permettra de comparer avec celui da la combinaison 
    
    
    public Cellule(){//constructeur initialisant les attributs avec des valeurs par défaut
        PionCourant=null;
        //trouNoir=false; pour la version 2.0
        // desintegrateur=false; pour la version 4.0
    }
}
