/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet_kitchnaomi;

import java.util.Scanner;

/**
 *
 * @author naomi
 */
public class Partie {

    Plateau PlateauJeu; //Le plateau de la partie
    Joueur joueurCourant;//Joueur qui joue à la partie

    public Partie(Joueur unjoueur) {
//constructeur de la partie

        joueurCourant = unjoueur;
    }

    public void debuterpartie() {
        PlateauJeu = new Plateau();
        PlateauJeu.afficherPlateauSurConsole();
        Combinaison combiMyst = PlateauJeu.initialisationcombimyst();
        Combinaison combiProposee = new Combinaison();
        for (int i = 0; i < 4; i++) {
            System.out.println("\nChoisissez la couleur d'un pion de votre combinaison :" + "\n 1 pour rouge" + "\n 2 pour jaune" + "\n 3 pour mauve" + "\n 4 pour turquoise" + "\n 5 pour vert" + "\n 6 pour bleu" + "\n 7 pour noir" + "\n 8 pour blanc");
            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt(); //On demande au joueur son choix
            String cpion = null;//on initialise la couleur du pion choisi

            switch (choix) {
                case 1:
                    cpion = "rouge";
                    break;
                case 2:
                    cpion = "jaune";
                    break;
                case 3:
                    cpion = "mauve";
                    break;
                case 4:
                    cpion = "turquoise";
                    break;
                case 5:
                    cpion = "vert";
                    break;
                case 6:
                    cpion = "bleu";
                    break;
                case 7:
                    cpion = "noir";
                    break;
                case 8:
                    cpion = "blanc";
                    break;

            }
            Pion pion = new Pion(cpion);//On créer le premier pion de la combinaison proposée par le joueur
            combiProposee.tabcombi[i] = pion;
            
            PlateauJeu.CellulesPlateau[0][4+i] = pion;
            PlateauJeu.afficherPlateauSurConsole();
            
            
        }
           int nbpionbonnecetp = PlateauJeu.comparaisoncombi(combiProposee)[0]; //nb de pions bien positionnés et de la bonne couleur
                int nbpionbonnecouleur = PlateauJeu.comparaisoncombi(combiProposee)[1]; //nb de pions qui sont seulement de la bonne couleur 
                Languette langVerte = PlateauJeu.affichagelangbonnecetp(nbpionbonnecetp);
                Languette langRouge = PlateauJeu.affichagelangbonnecouleur(nbpionbonnecouleur);
                for (int a = 0; a < 4; a++) {
                        PlateauJeu.CellulesPlateau[0][a] = langVerte.tablang[a];
                    }
                    for (int b = 8; b < 12; b++) {
                        PlateauJeu.CellulesPlateau[0][b] = langRouge.tablang[b];
                    }
                System.out.println("Vous avez " + nbpionbonnecetp + " pion(s) bien placé(s) et de bonne couleur et " + nbpionbonnecouleur + " pion(s) de bonne couleur mais mal positionné(s)");
                joueurCourant.EssaiesRestants--;
                System.out.println("il vous reste " + joueurCourant.EssaiesRestants + " essaies restants"); 

        //Combinaison combiProposee = PlateauJeu.combiproposee(pion1, pion2, pion3, pion4);//On créer la combinaison proposée par le joueur
        while (PlateauJeu.Combigagnante(combiProposee) == false && joueurCourant.EssaiesRestants != 0) {
//tant que le joueur n'a pas trouvé la combinaison ou tant qu'il a toujours des essaies possibles

            for (int j = 1; j < 12; j++) {
                
                
                for (int k = 0; k < 4; k++) {
                    System.out.println("Choisissez la couleur d'un pion de votre combinaison : " + "\n 1 pour rouge" + "\n 2 pour jaune" + "\n 3 pour mauve" + "\n 4 pour turquoise" + "\n 5 pour vert" + "\n 6 pour bleu" + "\n 7 pour noir" + "\n 8 pour blanc");
                    Scanner sc = new Scanner(System.in);
                    int choix = sc.nextInt(); //On demande au joueur son choix
                    String cpion = null;//on initialise la couleur du pion choisi

                    switch (choix) {
                        case 1:
                            cpion = "rouge";
                            break;
                        case 2:
                            cpion = "jaune";
                            break;
                        case 3:
                            cpion = "mauve";
                            break;
                        case 4:
                            cpion = "turquoise";
                            break;
                        case 5:
                            cpion = "vert";
                            break;
                        case 6:
                            cpion = "bleu";
                            break;
                        case 7:
                            cpion = "noir";
                            break;
                        case 8:
                            cpion = "blanc";
                            break;

                    }

                    Pion pion = new Pion(cpion);//On créer le premier pion de la combinaison proposée par le joueur
                    combiProposee.tabcombi[k] = pion;
                    
                    
                     PlateauJeu.CellulesPlateau[j][4+k] = pion;
                    PlateauJeu.afficherPlateauSurConsole();
            
                    
                    
                    }
                }
                for (int a = 0; a < 4; a++) {
                        PlateauJeu.CellulesPlateau[0][a] = langVerte.tablang[a];
                    }
                    for (int b = 8; b < 12; b++) {
                        PlateauJeu.CellulesPlateau[0][b] = langRouge.tablang[b];
                    }
                System.out.println("Vous avez " + nbpionbonnecetp + " pion(s) bien placé(s) et de bonne couleur et " + nbpionbonnecouleur + " pion(s) de bonne couleur mais mal positionné(s)");
                joueurCourant.EssaiesRestants--;
                System.out.println("il vous reste " + joueurCourant.EssaiesRestants + " essaies restants");
                if (PlateauJeu.Combigagnante(combiProposee) == true || joueurCourant.EssaiesRestants == 0) {
                        break;
            }

        }
        
        if (PlateauJeu.Combigagnante(combiProposee) == true){
            System.out.println("Félicitation vous avez gagné");
        }
        else {
            System.out.println("Vous avez perdu !");
        }

    }
}
