/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_version1.pkg0_kitch;

/**
 *
 * @author naomi
 */
public class Joueur {
    String nom;
    String couleur;
    //int nbDesintegrateurs; pour la V 4.0
    int JetonsRestants;
    Jeton [] ListeJetons;
    
public Joueur(String unNom) { //constructeur initialisant le nom du joueur avec son paramètre
nom = unNom;
//nbDesintegrateurs=0; pour la V 4.0
JetonsRestants=0;
ListeJetons=new Jeton [21];
}

public void affecterCouleur(String uneCouleur){//affecte la couleur en paramètre au joueur
    couleur=uneCouleur;
}

public boolean recevoirJeton(Jeton J1){ //ajoute le jeton passé en paramètre à la liste des jetons
    boolean res=true;

    if (ListeJetons[21]!=null){
         res=false;
         return res;
        }
    else{
        for (int i=0; i<3; i++){
        if (ListeJetons[i]==null){
            ListeJetons[i]=J1;
            break;
        }
        }
        return res;
    }    
        
}

  
    
}
