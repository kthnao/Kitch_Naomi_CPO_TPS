/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_version2_kitch;

/**
 *
 * @author naomi
 */
public class Cellule {
    Jeton JetonCourant;
    //boolean trouNoir; pour la version 2.0
    //boolean desintegrateur;
 
    
    public Cellule(){//constructeur initialisant les attributs avec des valeurs par défaut
        JetonCourant=null;
        //trouNoir=false; pour la version 2.0
        // desintegrateur=false; pour la version 4.0
    }
    public boolean affecterJeton(Jeton J1){
// ajoute le jeton en paramètre à la cellule, et retourne vrai si l’ajout 
//s’est bien passé, ou faux sinon (ex : jeton déjà présent)  
        if (JetonCourant==null){
        JetonCourant=J1;
        return true;
        }
        else {
        return false;
        }
    }
    public String lireCouleurDuJeton(){//renvoie la couleur du jeton occupant la cellule
        return JetonCourant.couleur;
    }
}

