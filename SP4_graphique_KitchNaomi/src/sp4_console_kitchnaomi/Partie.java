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
            //joueur2 est associé  à la couleur rouge
        }
        if (nb == 1) {
            ListeJoueurs[0].couleur = "rouge";
            //joueur1 est associé  à la couleur rouge
            ListeJoueurs[1].couleur = "jaune";
            //joueur2 est associé  à la couleur jaune
        }
    }

        public void initialiserPartie() {
        //crée la grille, crée les jetons et les attribue aux joueurs correspondants. 
        //Place les trous noirs (version 2) et les téléporteurs (version 3).
        grilleJeu = new Grille();
        Random random = new Random();
        int ligne;
        int colonne;
        ligne = random.nextInt(6); //ligne prend une valeur comprise entre 0 et 5
        colonne = random.nextInt(7);//ligne prend une valeur comprise entre 0 et 6
        grilleJeu.placerTrouNoir(ligne, colonne);
        
        for (int i = 0; i < 2; i++) { //Répétition de 2 fois 
            ligne = random.nextInt(6);
            colonne = random.nextInt(7);
            while (grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir() == true) {
                //On créer des coordonnées aléatoire tant que ces dernières ont déjà un trou noir
                ligne = random.nextInt(6);
                colonne = random.nextInt(7);
            }
            grilleJeu.placerTrouNoir(ligne, colonne);
            //On place 2 trou noirs (on a donc 3 en tout)
        }
        for (int i = 0; i < 2; i++) { //Répétition de 2 fois 
            ligne = random.nextInt(6);
            colonne = random.nextInt(7);
            while (grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir() == true) {
                //On créer des coordonnées aléatoire tant que ces dernières ont déjà un trou noir
                ligne = random.nextInt(6);
                colonne = random.nextInt(7);
            }
            grilleJeu.placerTrouNoir(ligne, colonne);
            grilleJeu.placerDesintegrateur(ligne, colonne);
            //On place 2 désintégrateurs/trou noirs au même coordonnées (2 désintégrateurs et 5 trous noirs en tout)
        }
        
        for (int i = 0; i < 3; i++) { //Répétition de 3 fois 
            ligne = random.nextInt(6);
            colonne = random.nextInt(7);
            while (grilleJeu.CellulesJeu[ligne][colonne].presenceDesintegrateur() == true||grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir() == true) {
                //On créer des coordonnées aléatoire tant que ces dernières ont déjà un trou noir ou un désintégrateur
                ligne = random.nextInt(6);
                colonne = random.nextInt(7);
            }
            grilleJeu.placerDesintegrateur(ligne, colonne);
            //On place les 3 derniers désintégrateurs (on a donc 5 en tout)
        }

            attribuerCouleursAuxJoueurs(); //on attribu les couleurs aux joueurs
        
        //On indique aux joueurs leur couleur
        System.out.println(ListeJoueurs[0].nom+" est de couleur "+ListeJoueurs[0].couleur); 
        System.out.println(ListeJoueurs[1].nom+" est de couleur "+ListeJoueurs[1].couleur);

        for (int k = 0; k < 21; k++) {
            ListeJoueurs[0].recevoirJeton(new Jeton(ListeJoueurs[0].couleur)); //on associe les jetons de la bonne couleur au joueur1
            ListeJoueurs[1].recevoirJeton(new Jeton(ListeJoueurs[1].couleur)); //on associe les jetons de la bonne couleur au joueur2
            ListeJoueurs[0].nombreJetonsRestants++;
            ListeJoueurs[1].nombreJetonsRestants++;
            
         grilleJeu.afficherGrilleSurConsole();
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

    public void debuterPartie() {//lance la partie

        Scanner sc;
        /*
        System.out.println("bonjour veuillez saisir un pseudo pour le premier joueur");
        sc = new Scanner(System.in);
        String nom1 = sc.next(); //On demande de saisir le pseudo du joueur 1
        Joueur joueur1 = new Joueur(nom1);
        
        System.out.println("bonjour veuillez saisir un pseudo pour le deuxième joueur");
        sc = new Scanner(System.in);
        String nom2 = sc.next();//On demande de saisir le pseudo du joueur 2
        Joueur joueur2 = new Joueur(nom2);
         */

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

            System.out.println("C'est à vous de jouer " + joueurCourant.nom);
            //On annonce le joueur qui doit jouer

            System.out.println("Vous avez " + joueurCourant.nombreDesintegrateurs + " désintégrateurs utilisables et " + joueurCourant.nombreJetonsRestants + " Jetons restants à jouer");
            //On indique l'inventaire du joueur au joueur

            System.out.println("Si vous voulez jouer un Jeton entrez 1" + "\nSi vous voulez récupérer un Jeton entrez 2" + "\nSi vous voulez utiliser un désintégrateur entrez 3");
            //On demande au joueur quel action il veut faire entre les 3 actions citées

            sc = new Scanner(System.in);
            int choix = sc.nextInt(); //On demande au joueur son choix

            while (choix < 1 || choix > 3) { //tant que choix n'est pas 1 2 ou 3
                System.out.println("Ce choix est inexistant, veuillez choisir à nouveau");
                System.out.println("Si vous voulez jouer un Jeton entrez 1" + "\nSi vous voulez récupérer un Jeton entrez 2" + "\nSi vous voulez utiliser un désintégrateur entrez 3");
                choix = sc.nextInt();
                //Le joueur doit rentrer à nouveau son choix

            }
            if (choix == 3 && joueurCourant.nombreDesintegrateurs == 0) {
                System.out.println("Vous n'avez pas de désintégrateur à jouer, veuillez choisir un autre choix (1 pour jouer un jeton ou 2 pour récupérer un jeton)");
                choix = sc.nextInt(); //On redemande au joueur de  faire son choix
                while (choix < 1 || choix > 2) { //tant que choix n'est pas 1 ou 2 
                    System.out.println("Ce choix est inexistant ou impossible, veuillez choisir à nouveau");
                    System.out.println("Si vous voulez jouer un Jeton entrez 1" + "\nSi vous voulez récupérer un Jeton entrez 2");
                    choix = sc.nextInt();
                    //Le joueur doit rentrer à nouveau son choix

                }
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
                
                int i=0;
                while(grilleJeu.celluleOccupee(i, colonne-1) == true) { //tant qu'il y a la orésence d'un jeton 
                    i++;//alors i ++, on sait donc que le jeton sera mis à la ligne i
                }
                    
                if (grilleJeu.CellulesJeu[i][colonne-1].presenceDesintegrateur()==true&&i<6){
                    grilleJeu.CellulesJeu[i][colonne-1].recupererDesintegrateur(); //On supprime le désintégrateur
                    joueurCourant.nombreDesintegrateurs++; //Le joueur gagne donc 1 désintégrateur en plus
                }  

                while (grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants - 1], colonne) == false) {
                    //tant que le jeton n'a pas été correctement ajouté dans la grille, le joueur doit choisir une autre colonne
                    System.out.println("La colonne choisi est soit remplie ou soit inexistante" + "\nChoisissez à nouveau le numéro de la colonne souhaitée");
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

            } else if (choix == 2) { //si choix=2, le joueur souhaite récupérer un jeton
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

                while (joueurCourant.couleur != grilleJeu.lireCouleurDuJeton(ligne - 1, colonne - 1)) {
                    //tant que la couleur du jeton choisi ne correspond pas à la couleur du joueur, le joueur doit saisir les coordonnées
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
                //si la couleur correspond à celle du joueur directement
                Jeton j = grilleJeu.recupererJeton(ligne, colonne);
                //On récupère ce jeton et on le supprime de la grille
                joueurCourant.recevoirJeton(j);
                //On ajoute ce jeton à la liste des jetons du joueur
                grilleJeu.tasserGrille(colonne);
                grilleJeu.afficherGrilleSurConsole();
                joueurCourant.nombreJetonsRestants++;

                if (joueurCourant == ListeJoueurs[0]) {
                    //on échange de joueur
                    joueurCourant = ListeJoueurs[1];
                } else {
                    joueurCourant = ListeJoueurs[0];
                }
            } else {//Si choix=3 le joueur souhaite utiliser un désintégrateur

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
                grilleJeu.supprimerJeton(ligne, colonne); //On supprime le jeton voulu
                grilleJeu.tasserGrille(colonne);

                joueurCourant.nombreDesintegrateurs--; //Le joueur à un désintégrateur en moins
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
        if(grilleJeu.etreRemplie() == true){
            System.out.println("la grille est pleine, il n'y a pas de gagnant");
            grilleJeu.viderGrille();
        }
        else if(grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == true&&grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == true){
            //s'il y a égalité
            System.out.println("Félicitation" + joueurCourant.nom + " Vous avez gagné");
            grilleJeu.viderGrille();
        }
        else {
            if (joueurCourant == ListeJoueurs[0]) {
                    //on échange de joueur car c'est le joueur d'avant qui a gagné
                    joueurCourant = ListeJoueurs[1];
                } else {
                    joueurCourant = ListeJoueurs[0];
                }
            System.out.println("Félicitation" + joueurCourant.nom + " Vous avez gagné");
            grilleJeu.viderGrille();
        }
        
    }
    
}
