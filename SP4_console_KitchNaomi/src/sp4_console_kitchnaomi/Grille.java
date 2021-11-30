/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_kitchnaomi;

/**
 *
 * @author naomi
 */
public class Grille {

    Cellule[][] CellulesJeu = new Cellule[6][7];

    public Grille() {//contrusteur de la classe 
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                CellulesJeu[i][j] = new Cellule(); //i ligne et j colonne
            }
        }
    }

    public boolean ajouterJetonDansColonne(Jeton J1, int colonne) {
        //ajoute le jeton dans la colonne ciblée, sur la cellule vide la plus basse.
        //Renvoie faux si la colonne était pleine.

        boolean res = false;
        int j = colonne - 1; //On fait -1 pour que cela me donne la bonne case de la grille
        for (int i = 0; i < 6; i++) {

            if (colonneRemplie(j) == true) {
                return res;
            }

            if (CellulesJeu[i][j].JetonCourant == null) { //s'il n'y a pas de jeton
                CellulesJeu[i][j].JetonCourant = J1;//alors on place le jeton voulu
                res = true;
                if (CellulesJeu[i][j].presenceTrouNoir() == true) { // s'il y a la présence d'un trounoir
                    CellulesJeu[i][j].activerTrouNoir();//alors on active le trou noir
                }
                /*if (CellulesJeu[i][j].presenceDesintegrateur()==true){
                    CellulesJeu[i][j].recupererDesintegrateur();
                    joueurCourant.nombreDesintegrateurs++;
                    cette partie a été directement mise dans la classe partie dans debuterpartie
                    
                }*/
                break;
            }

        }
        return res;
    }

    public boolean etreRemplie() {//renvoie vrai si la grille est pleine

        for (int i = 0; i < 6; i++) { //Pour tout i allant de 0 à 5
            for (int j = 0; j < 7; j++) { //Pour tout j allant de 0 à 6
                if (CellulesJeu[i][j].JetonCourant == null) { //s'il n' y pas de jeton
                    return false; //alors la grille n'est pas remplie donc on renvoie faux

                }

            }

        }
        return true;//sinon on renvoie vrai
    }

    public void viderGrille() {//vide la grille
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                CellulesJeu[i][j].JetonCourant = null;//on supprime tous les jetons
            }
        }
    }

    public void afficherGrilleSurConsole() {
        //fonction d’affichage de la grille sur la console. 
        //Doit faire apparaitre les couleurs, et les trous noirs.
        for (int i = 5; i >= 0; i--) { //on part de 5 jusqu'à 0
            for (int j = 0; j < 7; j++) {
                if (CellulesJeu[i][j].presenceDesintegrateur() == true&&CellulesJeu[i][j].presenceTrouNoir() == false) {
                    System.out.print("\033[34m D  "); //s'il y a la présence d'un désintégrateur mais pas de trou noir alors on affiche un D bleu
                }
                else if (CellulesJeu[i][j].presenceTrouNoir() == true&&CellulesJeu[i][j].presenceDesintegrateur() == true||CellulesJeu[i][j].presenceTrouNoir() == true) {
                    //si il ya présence d'un trou noir et d'un désintégrateur à la fois ou s'il y a seulement un trou noir on affiche une croix noire
                    System.out.print("\033[30m X  ");
                } else if (celluleOccupee(i, j) == true) { //si il y a un jeton

                    if (lireCouleurDuJeton(i, j) == "rouge") {
                        //Si le jeton est rouge on affiche un O rouge
                        System.out.print("\033[31m O  ");
                    }
                    if (lireCouleurDuJeton(i, j) == "jaune") {
                        //si la couleur est jaune on affiche un O jaune
                        System.out.print("\033[33m O  ");
                    }

                } else {
                    System.out.print("\033[37m O  ");
                    //S'il ny a pas de jeton alors on affiche un O noir

                }
            }
            System.out.println(""); //sinon on affiche rien
        }

    }

    public boolean celluleOccupee(int ligne, int colonne) {
        //renvoie vrai si la cellule de coordonnées données est occupée par un jeton.
        boolean res = false;
        int i = ligne;
        int j = colonne;
        if (CellulesJeu[i][j].JetonCourant != null) { //Si il y a un jeton on renvoie vrai
            res = true;
        }
        return res;//sinon on renvoie faux
    }

    public String lireCouleurDuJeton(int ligne, int colonne) {
        //renvoie la couleur du jeton de la cellule ciblée.
        int i = ligne;
        int j = colonne;
        String res;
        if (celluleOccupee(i, j) == false) {
            res = "vide"; //s'il n'y a pas de jeton la couleur de lase est "vide"
        } else {
            res = CellulesJeu[i][j].JetonCourant.couleur;
        }
        return res;
    }

    
    public boolean etreGagnantePourJoueur(Joueur A) {
        //renvoie vrai si la grille est gagnante pour le joueur passé en paramètre,
        //c’est-à-dire que 4 pions de sa couleur sont alignés en ligne, en colonne ou en diagonale.
        boolean res = false;
        for (int i=0; i<6 ;i++){
          for(int j=0;j<4;j++){
              if(celluleOccupee(i,j)&&celluleOccupee(i,j+1)&&celluleOccupee(i,j+2)&&celluleOccupee(i,j+3)==true){
               if (CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i][j+1].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i][j+2].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i][j+3].JetonCourant.couleur){
                    res=true; //vérifie s'il y a 4 jetons alignés sur une ligne
                          
              }
              }
          } 
        }
        for(int j=0;j<7;j++){
          for(int i=0; i<3 ;i++){
             if(celluleOccupee(i,j)&&celluleOccupee(i+1,j)&&celluleOccupee(i+2,j)&&celluleOccupee(i+3,j)==true){
              if (CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i+1][j].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i+2][j].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i+3][j].JetonCourant.couleur){
                  res=true;//vérifie s'il y a 4 jetons alignés sur une colonne
              }            
              }
          } 
        }
        for (int i=0; i<3 ;i++){
          for(int j=0;j<4;j++){
              if(celluleOccupee(i,j)&&celluleOccupee(i+1,j+1)&&celluleOccupee(i+2,j+2)&&celluleOccupee(i+3,j+3)==true){
              
              if (CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i+1][j+1].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i+2][j+2].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i+3][j+3].JetonCourant.couleur){
                  res=true;//vérifie s'il y a 4 jetons alignés sur une diagonale
              }           
              }
          } 
        }
        for (int i=3; i<6 ;i++){
          for(int j=0;j<4;j++){
              if(celluleOccupee(i,j)&&celluleOccupee(i-1,j+1)&&celluleOccupee(i-2,j+2)&&celluleOccupee(i-3,j+3)==true){
              
              if (CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i-1][j+1].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i-2][j+2].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur==CellulesJeu[i-3][j+3].JetonCourant.couleur){
                  res=true;//vérifie s'il y a 4 jetons alignés sur une autre diagonale
              }           
              }
          } 
        }
        
        return res;
    }



    public boolean colonneRemplie(int colonne) {
        int j = colonne;
        boolean res = true;
        for (int i = 0; i < 6; i++) {
            if (CellulesJeu[i][j].JetonCourant == null) { //s'il y a pas la présence d'un jeton alors la colonne n'est pas remplie
                res = false;
            }
        }
        return res;
//renvoie vrai si la colonne est remplie (on ne peut y jouer un Jeton)
    }

    public boolean placerTrouNoir(int ligne, int colonne) {
        //ajoute un trou noir à l’endroit indiqué et retourne vrai si l’ajout 
        //s’est bien passé, ou faux sinon (exemple : trou noir déjà présent)
        if (CellulesJeu[ligne][colonne].trouNoir == false) {//s'il n'y a pas de trou noir à l'endroit voulu
            CellulesJeu[ligne][colonne].trouNoir = true;//alors on en place un
            return true;
        } else {
            return false; //s'il y en avait déjà un on renvoie faux
        }
    }

    public void tasserGrille(int colonne) {
        //lorsqu’un jeton est capturé ou détruit, tasse la grille en décalant de une 
        //ligne les jetons situés au dessus de la cellule libérée. 
        int j = colonne - 1;
        for (int i = 0; i < 5; i++) {
            if (CellulesJeu[i][j].JetonCourant == null) { //Le jeton qui a été supprimé se supprime
                CellulesJeu[i][j].JetonCourant = CellulesJeu[i + 1][j].JetonCourant; //la case de la girlle ou le jeton a été supprimé prend la valeur du jeton de la case d'au dessu
                CellulesJeu[i + 1][j].JetonCourant = null; //La case d'au dessu supprime aussi son jeton et ainsi de suite

            }

        }

    }

    public Jeton recupererJeton(int ligne, int colonne) {
        //enlève le jeton de la cellule visée et renvoie une référence vers ce jeton.
        Jeton J = CellulesJeu[ligne-1][colonne-1].recupererJeton(); //On récupère le jeton dans une variable
        CellulesJeu[ligne-1][colonne-1].JetonCourant = null; //on vide la case
        return J;

    }
    
    
    public boolean placerDesintegrateur(int ligne,int colonne){
        //ajoute un désintégrateur à l’endroit indiqué et retourne vrai si l’ajout
        //s’est bien passé, ou faux sinon (exemple : désintégrateur déjà présent)
         if (CellulesJeu[ligne][colonne].desintegrateur == false) {//s'il n'y a pas de désintégrateur à l'endroit voulu
            CellulesJeu[ligne][colonne].desintegrateur = true;//alors on place un désintégrateur
            return true;
        } else {
            return false; //s'il y a déjà un désintégrateur on renvoie faux
         }
    }

    public boolean supprimerJeton(int ligne, int colonne){
    //supprime le jeton de la cellule visée. Renvoie vrai si la suppression 
    //s’est bien déroulée, ou faux autrement (jeton absent)
    if(CellulesJeu[ligne-1][colonne-1].supprimerJeton()==true){ //on supprime le jeton
        return true;
    }
    else{
        return false;
    }
    
    }

   
  

}
