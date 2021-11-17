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
        int j = colonne - 1;
        for (int i = 0; i < 6; i++) {

            if (colonneRemplie(j) == true) {
                return res;
            }

            if (CellulesJeu[i][j].JetonCourant == null) {
                CellulesJeu[i][j].JetonCourant = J1;
                res = true;
                if (CellulesJeu[i][j].presenceTrouNoir() == true) {
                    CellulesJeu[i][j].activerTrouNoir();
                }
                break;
            }

        }
        return res;
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
                if (CellulesJeu[i][j].presenceTrouNoir() == true) {
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

    public boolean colonneRemplie(int colonne) {
        int j = colonne;
        boolean res = false;
        for (int i = 0; i < 6; i++) {
            if (CellulesJeu[i][j].JetonCourant != null) {
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

    public void tasserGrille(int colonne) {
        //lorsqu’un jeton est capturé ou détruit, tasse la grille en décalant de une 
        //ligne les jetons situés au dessus de la cellule libérée. 
        int j = colonne - 1;
        for (int i = 0; i < 5; i++) {
            if (CellulesJeu[i][j].JetonCourant == null) {
                CellulesJeu[i][j].JetonCourant = CellulesJeu[i + 1][j].JetonCourant;
                CellulesJeu[i + 1][j].JetonCourant = null;

            }

        }

    }

    public Jeton recupererJeton(int ligne, int colonne) {
        //enlève le jeton de la cellule visée et renvoie une référence vers ce jeton.
        Jeton J = CellulesJeu[ligne-1][colonne-1].recupererJeton();
        CellulesJeu[ligne-1][colonne-1].JetonCourant = null;
        return J;

    }

}
