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
public class Partie {

    Plateau PlateauJeu; //Le plateau de la partie
    Joueur joueurCourant;//Joueur qui joue à la partie
    Combinaison Combimystere;//Combinaison mystérieuse que le joueur doit deviner

    public void initialisationPartie() {
        PlateauJeu = new Plateau();
        Random random = new Random();
        int cpion;//correspondra à la couleur du pion

        for (int i = 0; i < 4; i++) {
            cpion = random.nextInt(6);//prend une valeur comprise entre 0 et 5

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
            }
            Combimystere.tabcombi [i] = pioncombi; //La valeur de la case du tableau indiquée prend comme référence celle du pion combi

        }

    }
}
