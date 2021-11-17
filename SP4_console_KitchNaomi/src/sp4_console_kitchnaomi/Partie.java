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
    Joueur[] ListeJoueurs = new Joueur[2];

    public Partie(Joueur J1, Joueur J2) {
        ListeJoueurs[0] = J1;
        ListeJoueurs[1] = J2;

    }

    /*
    Partie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
    public void attribuerCouleursAuxJoueurs() {
        //attribue des couleurs aux joueurs
        Random random = new Random();
        int nb;
        nb = random.nextInt(2);
        if (nb == 0) { //si nb=0
            ListeJoueurs[0].couleur = "jaune"; 
            //joueur1 est associé  à la couleur jaune
            ListeJoueurs[1].couleur = "rouge";
        }
        if (nb == 1) {
            ListeJoueurs[0].couleur = "rouge";
            ListeJoueurs[1].couleur = "jaune";
        }
    }

    public void initialiserPartie() {
        //crée la grille, crée les jetons et les attribue aux joueurs correspondants. 
        //Place les trous noirs (version 2) et les téléporteurs (version 3).
        grilleJeu = new Grille();
        Random random = new Random();
        int ligne;
        int colonne;
        ligne = random.nextInt(6);
        colonne = random.nextInt(7);
        grilleJeu.placerTrouNoir(ligne, colonne);
        for (int i = 0; i < 4; i++) {
            ligne = random.nextInt(6);
            colonne = random.nextInt(7);
            while (grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir() == true) {
                ligne = random.nextInt(6);
                colonne = random.nextInt(7);
            }
            grilleJeu.placerTrouNoir(ligne, colonne);
        }
        grilleJeu.afficherGrilleSurConsole();
        for (int k = 0; k < 21; k++) {
            ListeJoueurs[0].recevoirJeton(new Jeton(ListeJoueurs[0].couleur));
            ListeJoueurs[1].recevoirJeton(new Jeton(ListeJoueurs[1].couleur));
            ListeJoueurs[0].nombreJetonsRestants++;
            ListeJoueurs[1].nombreJetonsRestants++;
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

    public void debuterPartie() {
        //lance la partie
        String c = null; 
        //initialisation de la variable c qui prendra une couleur par la suite
        Random random = new Random();
        int nb;
        nb = random.nextInt(2); //nb prend une valeur aléatoire 0 ou 1
        if (nb == 0) {
            c = "rouge"; //c prrend la valeur "rouge" si nb=0
        }
        if (nb == 1) {
            c = "jaune";//c prrend la valeur "rouge" si nb=1
        }
        if (ListeJoueurs[1].couleur == c) { //si la couleur du joueur 2 est la même que c alors il commence à jouer
            joueurCourant = ListeJoueurs[1];
        } else {
            joueurCourant = ListeJoueurs[0];//sinon c'est l'autre joueur qui joue
        }

        while (grilleJeu.etreGagnantePourJoueur(joueurCourant) == false || grilleJeu.etreRemplie() == false) {
            //tant qu'il n'ya pas de gagnant ou tant que la grille n'est pas pleine
            System.out.println("Si vous voulez jouer un Jeton entrez 1" + "\nSi vous voulez récupérer un Jeton entrez 2");
            Scanner sc;
            sc = new Scanner(System.in);
            int choix = sc.nextInt();

            while (choix < 1 || choix > 2) { //tant que choix n'est pas 2 ou 1
                System.out.println("Ce choix est inexistant, veuillez choisir à nouveau");
                System.out.println("Si vous voulez jouer un Jeton entrez 1" + "\nSi vous voulez récupérer un Jeton entrez 2");
                choix = sc.nextInt();
            }

            if (choix == 1) { //si choix=1, le joueur souhaite jouer un jeton

                System.out.println("Choisissez le numéro de la colonne souhaitée");
                //le joueur saisi la colonne dans laquelle il vuet jouer son jeton
                int colonne = sc.nextInt();

                while (colonne < 1 || colonne > 7) { 
                    //si le numéro de la colonne n'est pas compris entre 1 et 7
                    System.out.println("la colonne choisie est inexistante");
                    System.out.println("Choisissez à nouveau le numéro de la colonne souhaitée");
                    colonne = sc.nextInt();
                }

                System.out.println("vous avez saisi la colonne : " + colonne);

                while (grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants - 1], colonne) == false) {
                    //tant que le jeton n'a pas été correctement ajouté dans la grille, le joueur doit choisir une autre colonne
                    System.out.println("La colonne choisi est soit remplie ou soit inexistante"+"\nChoisissez à nouveau le numéro de la colonne souhaitée");
                    colonne = sc.nextInt();

                }

               
                grilleJeu.afficherGrilleSurConsole(); 
                //affiche la grille sur la console
                joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants - 1] = null;
                //le jeton qui vient d'être joué est enlevé du tableau du joueur correspondant
                joueurCourant.nombreJetonsRestants = joueurCourant.nombreJetonsRestants - 1;
                //le nb de jetons restants du joueur diminue de 1 pour chaque jeton joué

                if (joueurCourant == ListeJoueurs[0]) {
                    //on échange de joueur
                    joueurCourant = ListeJoueurs[1];
                } else {
                    joueurCourant = ListeJoueurs[0];
                }

            } else { //si choix=2, le joueur souhaite récupérer un jeton
                System.out.println("Choisissez  les coordonnées souhaitées" + "\n Commencez à entrer le numéro la ligne");
                int ligne = sc.nextInt();
                //le joueur commence à saisir le numéro de la ligne souhaitée

                while (ligne < 1 || ligne > 6) { //si le numéro de la ligne n'est pas entre 1 et 6
                    System.out.println("la colonne choisie est inexistante");
                    System.out.println("Choisissez à nouveau le numéro de la ligne souhaitée");
                    ligne = sc.nextInt();
                }

                System.out.println("entrez le numéro la colonne souhaitée");
                int colonne = sc.nextInt();
                //le joueur saisi le numéro de la colonne souhaitée 

                while (colonne < 1 || colonne > 7) {//si le numéro de la colonne n'est pas entre 1 et 7
                    System.out.println("la colonne choisie est inexistante");
                    System.out.println("Choisissez à nouveau le numéro de la colonne souhaitée");
                    colonne = sc.nextInt();
                }

                System.out.println("vous avez saisi les coordonnées: " + ligne + "(ligne)" + colonne + "(colonne)");
              
                
                
                while(joueurCourant.couleur != grilleJeu.lireCouleurDuJeton(ligne-1, colonne-1)) {
                    //si la couleur du jeton choisi ne correspond pas à la couleur du joueur, le joueur doit saisir les coordonnées
                    //d'un autre jeton qui correspond à sa couleur
                    System.out.println("vous avez saisi les coordonnées d'un pion qui n'est pas le votre");
                    //System.out.println("attendu :" + joueurCourant.couleur + "trouvé : "+ grilleJeu.lireCouleurDuJeton(ligne, colonne));
                    System.out.println("Choisissez  les coordonnées souhaitées" + "\n Commencez à entrer le numéro la ligne");
                    ligne = sc.nextInt();

                    while (ligne < 1 || ligne > 6) {
                        System.out.println("la colonne choisie est inexistante");
                        System.out.println("Choisissez à nouveau le numéro de la ligne souhaitée");
                        ligne = sc.nextInt();
                    }

                    System.out.println("entrez le numéro la colonne souhaitée");
                    colonne = sc.nextInt();

                    while (colonne < 1 || colonne > 7) {
                        System.out.println("la colonne choisie est inexistante");
                        System.out.println("Choisissez à nouveau le numéro de la colonne souhaitée");
                        colonne = sc.nextInt();
                    }
                
                }
                //si la couleur correspond à celle du joueur
                    Jeton j = grilleJeu.recupererJeton(ligne, colonne);
                    //On récupère ce jeton et on le supprime de la grille
                    joueurCourant.recevoirJeton(j);
                    //On ajoute ce jeton à la liste des jetons du joueur
                    grilleJeu.tasserGrille(colonne);
                    grilleJeu.afficherGrilleSurConsole();
                    
                    if (joueurCourant == ListeJoueurs[0]) {
                    //on échange de joueur
                    joueurCourant = ListeJoueurs[1];
                    } else {
                    joueurCourant = ListeJoueurs[0];
                }
            }
        }
        
        System.out.println("Félicitation"+joueurCourant+" Vous avez gagné");
    }

}
