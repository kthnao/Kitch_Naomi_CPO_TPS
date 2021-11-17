/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_kitchnaomi;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author naomi
 */
public class Partie {
    Grille grilleJeu;
    Joueur joueurCourant;
    Joueur [] ListeJoueurs=new Joueur[2];
    
    public Partie(Joueur J1, Joueur J2){
        ListeJoueurs[0]=J1;
        ListeJoueurs[1]=J2;
        
    }
    
    /*
    Partie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    public void attribuerCouleursAuxJoueurs(){
        //attribue des couleurs aux joueurs
        Random random = new Random();
        int nb;
        nb = random.nextInt(2);
        if (nb==0){
        ListeJoueurs[0].couleur="jaune";
        ListeJoueurs[1].couleur="rouge";
        }
        if (nb==1){
        ListeJoueurs[0].couleur="rouge";
        ListeJoueurs[1].couleur="jaune";
        }
    }
    
    public void initialiserPartie(){
        //crée la grille, crée les jetons et les attribue aux joueurs correspondants. 
        //Place les trous noirs (version 2) et les téléporteurs (version 3).
       grilleJeu = new Grille();
       Random random = new Random();
        int ligne;
        int colonne;
        ligne = random.nextInt(6);
        colonne = random.nextInt(7);
        grilleJeu.placerTrouNoir(ligne, colonne);
        for(int i=0;i<4;i++){
            ligne = random.nextInt(6);
            colonne = random.nextInt(7);
            while (grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir()==true){
                ligne = random.nextInt(6);
                colonne = random.nextInt(7);
            }
         grilleJeu.placerTrouNoir(ligne, colonne);  
        }
       grilleJeu.afficherGrilleSurConsole();
      for(int k=0; k<21; k++){
            ListeJoueurs[0].recevoirJeton(new Jeton (ListeJoueurs[0].couleur));
            ListeJoueurs[1].recevoirJeton(new Jeton (ListeJoueurs[1].couleur));
            ListeJoueurs[0].JetonsRestants++;
            ListeJoueurs[1].JetonsRestants++;
            }
       
        
        /* for(int k=0; k<21; k++){
            Jeton JJ=new Jeton("jaune");
            Jeton JR=new Jeton("rouge");
            if (ListeJoueurs[1].couleur=="rouge"){
                ListeJoueurs[1].recevoirJeton(JR);
                ListeJoueurs[0].recevoirJeton(JJ);
            }
            if (ListeJoueurs[1].couleur=="jaune"){
                ListeJoueurs[1].recevoirJeton(JJ);
                ListeJoueurs[0].recevoirJeton(JR);
            }
        */
           
            
                 
        }      
    
    public void debuterPartie(){
        //lance la partie
        String c = null;
        Random random = new Random();
        int nb;
        nb = random.nextInt(2);
        if (nb==0){
        c="rouge";
        }
        if (nb==1){
        c="jaune";
        }
        if (ListeJoueurs[1].couleur==c){
            joueurCourant=ListeJoueurs[1];
        }
        else {
            joueurCourant=ListeJoueurs[0];
        }
        
        while (grilleJeu.etreGagnantePourJoueur(joueurCourant)==false||grilleJeu.etreRemplie()==false){
        
       
        Scanner sc;
        System.out.println("Choisissez la numéro de la colonne souhaitée");
        sc = new Scanner(System.in);
        int colonne = sc.nextInt();
        System.out.println("vous avez saisi la colonne : "+colonne);
        grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.JetonsRestants-1], colonne);
        
        grilleJeu.afficherGrilleSurConsole();
        joueurCourant.ListeJetons[joueurCourant.JetonsRestants-1]=null;
        joueurCourant.JetonsRestants=joueurCourant.JetonsRestants-1;
        
        
        
        if (joueurCourant==ListeJoueurs[0]){
            joueurCourant=ListeJoueurs[1];
        }
        else{
            joueurCourant=ListeJoueurs[0];
        }
        
         
    }
        
    }
}

