/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_version1.pkg0_kitch;

/**
 *
 * @author naomi
 */
public class Partie {
    Grille grilleJeu;
    Joueur joueurCourant;
    Joueur [] ListeJoueurs;
    
    public Partie(Joueur unNom){
        ListeJoueurs=new Joueur[2];
        joueurCourant=unNom;
        
    }
}
