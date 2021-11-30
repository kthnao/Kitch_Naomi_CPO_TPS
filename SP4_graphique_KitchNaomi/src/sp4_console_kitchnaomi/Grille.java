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

    public void tasserGrille(){
        for(int i=0;i<7;i++){
            tasserColonne(i);
        }
    }
        
    public boolean ajouterJetonDansColonne(Joueur joueurCourant, int colonne) {
        //ajoute le jeton dans la colonne ciblée, sur la cellule vide la plus basse.
        //Renvoie faux si la colonne était pleine.

        Jeton J1 = joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants - 1];
        //On récupère un jeton dans la liste du joueur

        if (colonneRemplie(colonne) == true) {
            return false;
        }

        int i = 0;
        while (CellulesJeu[i][colonne].JetonCourant != null) {
            i++;
        }

        CellulesJeu[i][colonne].JetonCourant = J1;
        //On place le jeton dans la case
        if (CellulesJeu[i][colonne].presenceTrouNoir() == true) {
            CellulesJeu[i][colonne].activerTrouNoir();
        }
        if (CellulesJeu[i][colonne].presenceDesintegrateur() == true) {
            CellulesJeu[i][colonne].recupererDesintegrateur();
            joueurCourant.nombreDesintegrateurs++;
        }

        return true;

        /*
        for (int i = 0; i < 6; i++) {

            if (colonneRemplie(j) == true) {
                return false;
            }

            if (CellulesJeu[i][j].JetonCourant == null) {
                CellulesJeu[i][j].JetonCourant = J1;
                res = true;
                if (CellulesJeu[i][j].presenceTrouNoir() == true) {
                    CellulesJeu[i][j].activerTrouNoir();
                }
                if (CellulesJeu[i][j].presenceDesintegrateur()==true){
                    CellulesJeu[i][j].recupererDesintegrateur();
                    
                    
                }
                break;
            }

        }*/
    }

    public boolean etreRemplie() {//renvoie vrai si la grille est pleine
        boolean res = true;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (CellulesJeu[i][j].JetonCourant == null) {
                    res = false;
                    break;
                }
                break;
            }
            break;
        }
        return res;
    }

    public void viderGrille() {//vide la grille
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                CellulesJeu[i][j].JetonCourant = null;
            }
        }
    }

    public void afficherGrilleSurConsole() {
        //fonction d’affichage de la grille sur la console. 
        //Doit faire apparaitre les couleurs, et les trous noirs.
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                if (CellulesJeu[i][j].presenceDesintegrateur() == true && CellulesJeu[i][j].presenceTrouNoir() == false) {
                    System.out.print("\033[34m D ");
                }
                if (CellulesJeu[i][j].presenceTrouNoir() == true && CellulesJeu[i][j].presenceDesintegrateur() == true || CellulesJeu[i][j].presenceTrouNoir() == true) {
                    //si il ya présence d'un trou noir et d'un désintégrateur à la fois ou s'il y a seulement un trou noir
                    System.out.print("\033[30m X  ");
                } else if (celluleOccupee(i, j) == true) {

                    if (lireCouleurDuJeton(i, j) == "rouge") {
                        System.out.print("\033[31m O  ");
                    }
                    if (lireCouleurDuJeton(i, j) == "jaune") {
                        System.out.print("\033[33m O  ");
                    }

                } else {
                    System.out.print("\033[37m O  ");

                }
            }
            System.out.println("");
        }

    }

    public boolean celluleOccupee(int ligne, int colonne) {
        //renvoie vrai si la cellule de coordonnées données est occupée par un jeton.
        boolean res = false;
        int i = ligne;
        int j = colonne;
        if (CellulesJeu[i][j].JetonCourant != null) {
            res = true;
        }
        return res;
    }

    public String lireCouleurDuJeton(int ligne, int colonne) {
        //renvoie la couleur du jeton de la cellule ciblée.
        int i = ligne;
        int j = colonne;
        String res;
        if (celluleOccupee(i, j) == false) {
            res = "vide";
        } else {
            res = CellulesJeu[i][j].JetonCourant.couleur;
        }
        return res;
    }

    public boolean etreGagnantePourJoueur(Joueur A) {
        //renvoie vrai si la grille est gagnante pour le joueur passé en paramètre,
        //c’est-à-dire que 4 pions de sa couleur sont alignés en ligne, en colonne ou en diagonale.
        boolean res = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (celluleOccupee(i, j) && celluleOccupee(i, j + 1) && celluleOccupee(i, j + 2) && celluleOccupee(i, j + 3) == true) {
                    if (CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i][j + 1].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i][j + 2].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i][j + 3].JetonCourant.couleur) {
                        res = true;

                    }
                }
            }
        }
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if (celluleOccupee(i, j) && celluleOccupee(i + 1, j) && celluleOccupee(i + 2, j) && celluleOccupee(i + 3, j) == true) {
                    if (CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i + 1][j].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i + 2][j].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i + 3][j].JetonCourant.couleur) {
                        res = true;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (celluleOccupee(i, j) && celluleOccupee(i + 1, j + 1) && celluleOccupee(i + 2, j + 2) && celluleOccupee(i + 3, j + 3) == true) {

                    if (CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i + 1][j + 1].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i + 2][j + 2].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i + 3][j + 3].JetonCourant.couleur) {
                        res = true;
                    }
                }
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (celluleOccupee(i, j) && celluleOccupee(i - 1, j + 1) && celluleOccupee(i - 2, j + 2) && celluleOccupee(i - 3, j + 3) == true) {

                    if (CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i - 1][j + 1].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i - 2][j + 2].JetonCourant.couleur && CellulesJeu[i][j].JetonCourant.couleur == CellulesJeu[i - 3][j + 3].JetonCourant.couleur) {
                        res = true;
                    }
                }
            }
        }

        return res;
    }
    
    /*    public boolean etreGagnantePourJoueur(Joueur joueur){  //Teste si la grille est gagnante pour un Joueur donné
        int val=0;
        int i;
        int j;
        for(i=0;i<6;i++){  //Pour toutes les lignes
            if (val==1){  //Si une combinaison a été concluante on peut break, car la grill est déjà gagnante
                break;
            }
            for(j=0;j<4;j++){  //On teste si on a 4 jetons de suite sur 1a ligne
                if (celluleOccupee(i, j)&&celluleOccupee(i, j+1)&&celluleOccupee(i, j+2)&&celluleOccupee(i, j+3)==true){  //On doit d'abord tester que toutes les cellules sont bien occupées sinon on a une erreur car on essaye de comparer un null
                    if (CellulesJeu[i][j].JetonCourant.couleur==joueur.couleur && CellulesJeu[i][j+1].JetonCourant.couleur==joueur.couleur && CellulesJeu[i][j+2].JetonCourant.couleur==joueur.couleur && CellulesJeu[i][j+3].JetonCourant.couleur==joueur.couleur){
                        val=1; //C'est un test pour éviter de continuer à tester de combinaisons gagnantes si une a déjà été trouvée
                        break;
                    }
                }
            }
        }
        
        //On teste si on a 4 jetons de suite sur 1a colonne
        for(i=0;i<3;i++){
            if (val==1){
                break;
            }
            for(j=0;j<7;j++){ 
                if (celluleOccupee(i, j)&&celluleOccupee(i+1, j)&&celluleOccupee(i+2, j)&&celluleOccupee(i+3, j)==true){
                    if (CellulesJeu[i][j].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+1][j].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+2][j].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+3][j].JetonCourant.couleur==joueur.couleur){
                        val=1; 
                        break;
                    }
                }
            }
        }
        
        //On teste si on a 4 jetons de suite sur 1a diagonale ascendante
        for(i=0;i<3;i++){
            if (val==1){
                break;
            }
            for(j=0;j<4;j++){
                if (celluleOccupee(i, j)&&celluleOccupee(i+1, j+1)&&celluleOccupee(i+2, j+2)&&celluleOccupee(i+3, j+3)==true){
                    if (CellulesJeu[i][j].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+1][j+1].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+2][j+2].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+3][j+3].JetonCourant.couleur==joueur.couleur){
                        val=1;
                        break;
                    }
                }
            }
        }
        
        //On teste si on a 4 jetons de suite sur 1a diagonale descendante
        for(i=0;i<3;i++){
            if (val==1){
                break;
            }
            for(j=6;j>2;j--){ //Il faut faire attention à décroitre les colonne plutot qu'augmenter
                if (celluleOccupee(i, j)&&celluleOccupee(i+1, j-1)&&celluleOccupee(i+2, j-2)&&celluleOccupee(i+3, j-3)==true){
                    if (CellulesJeu[i][j].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+1][j-1].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+2][j-2].JetonCourant.couleur==joueur.couleur && CellulesJeu[i+3][j-3].JetonCourant.couleur==joueur.couleur){
                        val=1;
                        break;
                    }
                }
            }
        }
        if (val==1){ //Si grille gagnante
            return true;
        }
        else{ //sinon
            return false;
        }
    }*/

    public boolean colonneRemplie(int colonne) {
        
        boolean res = true;
        for (int i = 0; i < 6; i++) {
            if (CellulesJeu[i][colonne].JetonCourant == null) {
                res = false;
            }
        }
        return res;
//renvoie vrai si la colonne est remplie (on ne peut y jouer un Jeton)
    }


    public boolean placerTrouNoir(int ligne, int colonne) {
        //ajoute un trou noir à l’endroit indiqué et retourne vrai si l’ajout 
        //s’est bien passé, ou faux sinon (exemple : trou noir déjà présent)
        if (CellulesJeu[ligne][colonne].trouNoir == false) {
            CellulesJeu[ligne][colonne].trouNoir = true;
            return true;
        } else {
            return false;
        }
    }

    public void tasserColonne(int colonne) {
        //lorsqu’un jeton est capturé ou détruit, tasse la grille en décalant de une 
        //ligne les jetons situés au dessus de la cellule libérée. 
        int j = colonne ;
        for (int i = 0; i < 5; i++) {
            if (CellulesJeu[i][j].JetonCourant == null) {
                CellulesJeu[i][j].JetonCourant = CellulesJeu[i + 1][j].JetonCourant;
                CellulesJeu[i + 1][j].JetonCourant = null;

            }

        }

    }

    public Jeton recupererJeton(int ligne, int colonne) {
        //enlève le jeton de la cellule visée et renvoie une référence vers ce jeton.
        Jeton J = CellulesJeu[ligne - 1][colonne - 1].recupererJeton();
        CellulesJeu[ligne - 1][colonne - 1].JetonCourant = null;
        return J;

    }

    public boolean placerDesintegrateur(int ligne, int colonne) {
        //ajoute un désintégrateur à l’endroit indiqué et retourne vrai si l’ajout
        //s’est bien passé, ou faux sinon (exemple : désintégrateur déjà présent)
        if (CellulesJeu[ligne][colonne].desintegrateur == false) {
            CellulesJeu[ligne][colonne].desintegrateur = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean supprimerJeton(int ligne, int colonne) {
        //supprime le jeton de la cellule visée. Renvoie vrai si la suppression 
        //s’est bien déroulée, ou faux autrement (jeton absent)
        if (CellulesJeu[ligne - 1][colonne - 1].supprimerJeton() == true) {
            return true;
        } else {
            return false;
        }

    }

}
