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
    Pion [][] CellulesPlateau=new Pion[12][4];
    Combinaison Combimystere;//Combinaison mystérieuse que le joueur doit deviner
    Pion [] nbbonnecouleur=new Pion[4];//nb de pion de la bonne couleur
    Pion [] nbbonnecetp=new Pion[4];//nb de pion de la bonne couleur et de la bonne position 
    Pion pionR=new Pion("rouge");
    Pion pionV=new Pion("vert");
    Pion pionJ=new Pion("jaune");
    Pion pionO=new Pion("orange");
    Pion pionB=new Pion("bleu");
    Pion pionM=new Pion("mauve");
    
    public Plateau(){//contrusteur de la classe 
        for (int i=0; i<12;i++){
            for(int j=0; j<4; j++){
                CellulesPlateau[i][j]=new Pion("vide"); //12 lignes et 4 colonnes de pion d'aucune couleur
            }
        }
    }
    
    public void initialisationcombimyst() {
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
    
    public boolean Combigagnante(Combinaison combiproposee){//retourne vrai si le joueur a trouvé la combinaison sinon renvoie faux
        if (Combimystere.tabcombi==combiproposee.tabcombi){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int bonneCouleur(Combinaison combiproposee){
        //renvoie le nombre de pion qui à la bonne couleur mais pas à la bonne position
        int nbbonnecouleur=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(Combimystere.tabcombi[i].couleur==combiproposee.tabcombi[j].couleur){
                    nbbonnecouleur=nbbonnecouleur+1;
                }
            }
        }
        return nbbonnecouleur;
    }
    
    public int bonneCouleuretPosition(Combinaison combiproposee){
        //renvoie le nombre de pion qui à la bonne couleur mais pas à la bonne position
        int nbbonnecouleuretposition=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(Combimystere.tabcombi[i]==combiproposee.tabcombi[j]){
                    nbbonnecouleuretposition=nbbonnecouleuretposition+1;
                }
            }
        }
        return nbbonnecouleuretposition;
    }
    //méthode s'il y a une bonne couleur
    //méthode s'il y a bonne couleur et bonne combinaison
}
