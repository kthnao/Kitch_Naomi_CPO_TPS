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
        Combinaison combiMyst = PlateauJeu.initialisationcombimyst();
        Combinaison combiProposee = new Combinaison();
        
        Languette langRouge = new Languette();
        Languette langVerte = new Languette();
        

        for (int d = 0; d < 12; d++) {
            for (int e = 0; e < 4; e++) {
                PlateauJeu.CellulesPlateau[d][e] = langRouge.tablang[e];
            }
            for (int f = 8; f < 12; f++) {
                PlateauJeu.CellulesPlateau[d][f] = langVerte.tablang[f];
            }
        }
        //On initialise les languettes sur l'affichage pour qu'elles s'affichent blanches en donnant leur valeur au cellule du plateau de jeu
        PlateauJeu.afficherPlateauSurConsole();

        for (int i = 0; i < 4; i++) {
            System.out.println("\nChoisissez la couleur d'un pion de votre combinaison :" + "\n 1 pour rouge" + "\n 2 pour jaune" + "\n 3 pour fuschia" + "\n 4 pour turquoise" + "\n 5 pour vert" + "\n 6 pour bleu" + "\n 7 pour noir" + "\n 8 pour blanc");
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
                    cpion = "fuschia";
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

            PlateauJeu.CellulesPlateau[0][4 + i] = pion;
            //je mets 4+ car il y a 12 colonnes dans le plateau mais je veux que les pions soient au centre donc soient placé dans les colonnes 4,5,6 et 7
            //je n'ai pas fait une boucle allant directement à ses colonnes car sinon ça allait bloqué pour ma combinaison qui ne comporte que 4 cases (0,1,2 et 3)
            PlateauJeu.afficherPlateauSurConsole();

        }
        int nbpionbonnecetp = PlateauJeu.comparaisoncombi(combiProposee)[0]; //nb de pions bien positionnés et de la bonne couleur
        int nbpionbonnecouleur = PlateauJeu.comparaisoncombi(combiProposee)[1]; //nb de pions qui sont seulement de la bonne couleur 
        langVerte = PlateauJeu.langbonnecetp(nbpionbonnecetp);
        langRouge = PlateauJeu.langbonnecouleur(nbpionbonnecouleur);
        for (int a = 0; a < 4; a++) {
            PlateauJeu.CellulesPlateau[0][a] = langRouge.tablang[a];
        }
        for (int b = 8; b < 12; b++) {
            PlateauJeu.CellulesPlateau[0][b] = langVerte.tablang[b];
        }

        System.out.println(combiMyst.tabcombi[0].couleur);
        System.out.println(combiMyst.tabcombi[1].couleur);
        System.out.println(combiMyst.tabcombi[2].couleur);
        System.out.println(combiMyst.tabcombi[3].couleur);

        System.out.println("Vous avez " + nbpionbonnecetp + " pion(s) bien placé(s) et de bonne couleur et " + nbpionbonnecouleur + " pion(s) de bonne couleur mais mal positionné(s)");
        joueurCourant.EssaiesRestants--;
        System.out.println("il vous reste " + joueurCourant.EssaiesRestants + " essaies restants");
        PlateauJeu.afficherPlateauSurConsole();

        //Combinaison combiProposee = PlateauJeu.combiproposee(pion1, pion2, pion3, pion4);//On créer la combinaison proposée par le joueur
        while (PlateauJeu.Combigagnante(combiProposee) == false && joueurCourant.EssaiesRestants != 0) {
//tant que le joueur n'a pas trouvé la combinaison ou tant qu'il a toujours des essaies possibles

            for (int j = 1; j < 12; j++) {

                for (int k = 0; k < 4; k++) {
                    System.out.println("Choisissez la couleur d'un pion de votre combinaison : " + "\n 1 pour rouge" + "\n 2 pour jaune" + "\n 3 pour fuschia" + "\n 4 pour turquoise" + "\n 5 pour vert" + "\n 6 pour bleu" + "\n 7 pour noir" + "\n 8 pour blanc");
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
                            cpion = "fuschia";
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

                    PlateauJeu.CellulesPlateau[j][4 + k] = pion;
                    PlateauJeu.afficherPlateauSurConsole();

                }
                nbpionbonnecetp = PlateauJeu.comparaisoncombi(combiProposee)[0]; //nb de pions bien positionnés et de la bonne couleur
                nbpionbonnecouleur = PlateauJeu.comparaisoncombi(combiProposee)[1]; //nb de pions qui sont seulement de la bonne couleur 
                langVerte = PlateauJeu.langbonnecetp(nbpionbonnecetp);
                langRouge = PlateauJeu.langbonnecouleur(nbpionbonnecouleur);
                for (int a = 0; a < 4; a++) {
                    PlateauJeu.CellulesPlateau[j][a] = langRouge.tablang[a];
                }
                for (int b = 8; b < 12; b++) {
                    PlateauJeu.CellulesPlateau[j][b] = langVerte.tablang[b];
                }

                System.out.println("Vous avez " + nbpionbonnecetp + " pion(s) bien placé(s) et de bonne couleur et " + nbpionbonnecouleur + " pion(s) de bonne couleur mais mal positionné(s)");
                joueurCourant.EssaiesRestants--;
                System.out.println("il vous reste " + joueurCourant.EssaiesRestants + " essaies restants");
                PlateauJeu.afficherPlateauSurConsole();
                if (PlateauJeu.Combigagnante(combiProposee) == true || joueurCourant.EssaiesRestants == 0) {
                    break;
                }

                System.out.println(combiMyst.tabcombi[0].couleur);
                System.out.println(combiMyst.tabcombi[1].couleur);
                System.out.println(combiMyst.tabcombi[2].couleur);
                System.out.println(combiMyst.tabcombi[3].couleur);
                System.out.println(langVerte.tablang[8].couleur);
                System.out.println(langVerte.tablang[9].couleur);
                System.out.println(langVerte.tablang[10].couleur);
                System.out.println(langVerte.tablang[11].couleur);
                System.out.println(PlateauJeu.CellulesPlateau[j][8].couleur);
                System.out.println(PlateauJeu.CellulesPlateau[j][9].couleur);
                System.out.println(PlateauJeu.CellulesPlateau[j][10].couleur);
                System.out.println(PlateauJeu.CellulesPlateau[j][11].couleur);
                

            }

        }

        if (PlateauJeu.Combigagnante(combiProposee) == true) {
            System.out.println("Félicitation vous avez gagné");
        } else {
            System.out.println("Vous avez perdu !");
        }

    }
}
