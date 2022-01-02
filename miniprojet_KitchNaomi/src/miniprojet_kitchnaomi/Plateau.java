/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet_kitchnaomi;

import java.util.Random;

/**
 *
 * @author naomi
 */
public class Plateau {

    Pion[][] CellulesPlateau = new Pion[12][12];
    Combinaison Combimystere = new Combinaison();//Combinaison mystérieuse que le joueur doit deviner 
    Languette langbonnecouleur = new Languette();//Languette correspondant aux nb de pions de bonne couleur
    Languette langbonnecetp = new Languette();//Languette correspondant aux nb de pions de bonne couleur et bonne position
    Pion pionR = new Pion("rouge");
    Pion pionV = new Pion("vert");
    Pion pionJ = new Pion("jaune");
    Pion pionN = new Pion("noir");
    Pion pionB = new Pion("bleu");
    Pion pionM = new Pion("mauve");
    Pion pionBlc = new Pion("blanc");
    Pion pionT = new Pion("turquoise");

    public Plateau() {//contrusteur de la classe 
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                CellulesPlateau[i][j] = new Pion("vide"); //12 lignes et 4 colonnes de pion d'aucune couleur
            }
        }
    }

    public Combinaison initialisationcombimyst() {
        //renvoie une combinaison àléatoire qui sera la combinaison à retrouver
        Random random = new Random();
        int cpion;//correspondra à la couleur du pion

        for (int i = 0; i < 4; i++) {
            cpion = random.nextInt(8);//prend une valeur comprise entre 0 et 7

            Pion pioncombi = new Pion("vide"); //On créer une varaible qui me permettra de remplir le tableau de la ocmbinaison
            switch (cpion) {
                case 0:
                    //si cpion==0 alors le pioncombi prend la valeur d'un pion rouge 
                    Pion pionR = new Pion("rouge");
                    pioncombi = pionR;
                    break;
                case 1:
                    //si cpion==1 alors le pioncombi prend la valeur d'un pion orange
                    Pion pionO = new Pion("orange");
                    pioncombi = pionO;
                    break;
                case 2:
                    //si cpion==2 alors le pioncombi prend la valeur d'un pion bleu
                    Pion pionB = new Pion("bleu");
                    pioncombi = pionB;
                    break;
                case 3:
                    //si cpion==3 alors le pioncombi prend la valeur d'un pion vert 
                    Pion pionV = new Pion("vert");
                    pioncombi = pionV;
                    break;
                case 4:
                    //si cpion==4 alors le pioncombi prend la valeur d'un pion jaune
                    Pion pionJ = new Pion("jaune");
                    pioncombi = pionJ;
                    break;
                case 5:
                    //si cpion==5 alors le pioncombi prend la valeur d'un pion mauve
                    Pion pionM = new Pion("mauve");
                    pioncombi = pionM;
                    break;
                case 6:
                    //si cpion==4 alors le pioncombi prend la valeur d'un pion jaune
                    Pion pionBlc = new Pion("blanc");
                    pioncombi = pionBlc;
                    break;
                case 7:
                    //si cpion==5 alors le pioncombi prend la valeur d'un pion mauve
                    Pion pionF = new Pion("fuschia");
                    pioncombi = pionF;
                    break;

            }
            Combimystere.tabcombi[i] = pioncombi;
//La valeur de la case du tableau indiquée prend comme référence celle du pion combi
        }
        return Combimystere;
    }

    public boolean Combigagnante(Combinaison combiproposee) {
        //retourne vrai si le joueur a trouvé la combinaison sinon renvoie faux
        int pionscorrects = 0;
        for (int i = 0; i < 4; i++) {
            if (Combimystere.tabcombi[i].lireCouleur() == combiproposee.tabcombi[i].lireCouleur()) {
                pionscorrects = pionscorrects + 1;
            }
        }
        if (pionscorrects == 4) {
            return true;
        } else {
            return false;
        }
    }

    public int[] comparaisoncombi(Combinaison combiproposee) {
        //retourne un tableau contenant le nombre de pions à la bonne position et de la bonne couleur dans la première case et 
        //le nombre de pions de la bonne couleur dans la seconde

        int nbbonnecetp = 0;//nb de pion de la bonne couleur et de la bonne position
        int nbbonnecouleur = 0;//nb de pion de la bonne couleur
        boolean[] checkcombimyst = new boolean[4];
        boolean[] checkcombiproposee = new boolean[4];
        for (int k = 0; k < 4; k++) {
            checkcombimyst[k] = false; //On initialise notre tableau qu'avec la valeur false
            checkcombiproposee[k] = false;//On initialise notre tableau qu'avec la valeur false
        }
        for (int i = 0; i < 4; i++) {
//si les cases des combi sont identiques alors le pion est à la bonne position et est de la bonne couleur
            if (Combimystere.tabcombi[i].lireCouleur() == combiproposee.tabcombi[i].lireCouleur()) {
                nbbonnecetp = nbbonnecetp + 1;
                checkcombimyst[i] = true;
                checkcombiproposee[i] = true;
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int x = 0; x < 4; x++) {
                if (Combimystere.tabcombi[j].lireCouleur() == combiproposee.tabcombi[x].lireCouleur() && checkcombimyst[j] == false && checkcombiproposee[x] == false) {
//si des cases de positions ont la même valeur et n'ont pas été déjà check alors cela veut dire que le pion est de la bonne couleur mais pas à la bonne posiiton
                    nbbonnecouleur = nbbonnecouleur + 1;
                    checkcombimyst[j] = true;
                    checkcombiproposee[x] = true;
                }
            }
        }

        int[] res = new int[2];
        res[0] = nbbonnecetp;
        res[1] = nbbonnecouleur;
        return res;
    }

    public Languette affichagelangbonnecouleur(int nbbonnecouleur) {
        //Remplie de pion blanc le nombre de case correspondant au nombre de pion de bonne couleur et renvoie le tableau
        Pion pionrouge = new Pion("rouge");
        for (int i = 0; i < nbbonnecouleur; i++) {
            langbonnecouleur.tablang[i] = pionrouge;
            langbonnecouleur.couleurlang = pionrouge.couleur;//la couleur de la languette correspond à la couleur des pions
        }
        return langbonnecouleur;
    }

    public Languette affichagelangbonnecetp(int nbbonnecetp) {
        //Remplie de pion reouge le nombre de case correspondant au nombre de pion de bonne couleur et renvoie le tableau
        Pion pionvert = new Pion("vert");
        for (int i = 0; i < nbbonnecetp; i++) {
            langbonnecetp.tablang[i] = pionvert;
        }
        langbonnecetp.couleurlang = pionvert.couleur;//la couleur de la languette correspond à la couleur des pions
        return langbonnecetp;
    }

    public Combinaison combiproposee(Pion pion1, Pion pion2, Pion pion3, Pion pion4) {
        //renvoie la combinaison composée des pions en entré dans l'ordre donné en entrée aussi
        Combinaison combiproposee = new Combinaison();
        combiproposee.tabcombi[0] = pion1;
        combiproposee.tabcombi[1] = pion2;
        combiproposee.tabcombi[2] = pion3;
        combiproposee.tabcombi[3] = pion4;

        return combiproposee;
    }

    public Combinaison suppression(Combinaison combiproposee) {
        //prend une combianais et supprime le dernier pion du tableau ayant une couleur différente de "vide"

        if (combiproposee.tabcombi[3].couleur != "vide") { //si la couleur du pion de la dernière case n'est pas "vide" 
            //alors cette couleur renvoie vide et on retourne la nouvelle combinaison
            combiproposee.tabcombi[3].couleur = "vide";
            return combiproposee;
        } else if (combiproposee.tabcombi[2].couleur != "vide") {//si la couleur du pion de la dernière case n'est pas "vide" 
            //alors cette couleur renvoie vide et on retourne la nouvelle combinaison
            combiproposee.tabcombi[2].couleur = "vide";
            return combiproposee;
        } else if (combiproposee.tabcombi[1].couleur != "vide") {//si la couleur du pion de la dernière case n'est pas "vide" 
            //alors cette couleur renvoie vide et on retourne la nouvelle combinaison
            combiproposee.tabcombi[1].couleur = "vide";
            return combiproposee;
        } else if (combiproposee.tabcombi[0].couleur != "vide") {//si la couleur du pion de la dernière case n'est pas "vide" 
            //alors cette couleur renvoie vide et on retourne la nouvelle combinaison
            combiproposee.tabcombi[0].couleur = "vide";
            return combiproposee;
        }

        return combiproposee; //si toutes les pions ont la couleur "vide" alors on retourne la combinaison 

    }

    public void afficherPlateauSurConsole() {

        //fonction d’affichage de la grille sur la console. 
        //Doit faire apparaitre les couleurs des pions des combinaisons
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 12; j++) {

                if (langbonnecouleur.tablang[j].couleur == "rouge" && CellulesPlateau[i][j].couleur == "rouge") {
                    System.out.print("\033[31m   ");
                } else if (langbonnecetp.tablang[j].couleur == "vert" && CellulesPlateau[i][j].couleur == "vert") {
                    System.out.print("\033[31m   ");
                } else if (CellulesPlateau[i][j].couleur == "vide") {
                    System.out.print(" X ");
                } else if (CellulesPlateau[i][j].couleur == "rouge") {
                    System.out.print("\033[31m O ");
                } else if (CellulesPlateau[i][j].couleur == "noir") {
                    System.out.print("\033[30m O ");
                } else if (CellulesPlateau[i][j].couleur == "bleu") {
                    System.out.print("\033[34m O ");
                } else if (CellulesPlateau[i][j].couleur == "blanc") {
                    System.out.print("\033[37m O ");
                } else if (CellulesPlateau[i][j].couleur == "jaune") {
                    System.out.print("\033[33m O ");
                } else if (CellulesPlateau[i][j].couleur == "mauve") {
                    System.out.print("\033[35m O ");
                } else if (CellulesPlateau[i][j].couleur == "vert") {
                    System.out.print("\033[32m O ");
                } else if (CellulesPlateau[i][j].couleur == "turquoise") {
                    System.out.print("\033[36m O ");

                }

            }
            System.out.println(""); //sinon on affiche rien
        }

    }
}
