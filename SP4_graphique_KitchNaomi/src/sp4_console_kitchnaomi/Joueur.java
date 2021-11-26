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
public class Joueur {
    String nom;
    String couleur;
    int nombreJetonsRestants;
    Jeton [] ListeJetons;
    int nombreDesintegrateurs;
    
public Joueur(String unNom) { //constructeur initialisant le nom du joueur avec son paramètre
nom = unNom;
nombreDesintegrateurs=0;
nombreJetonsRestants=0;
ListeJetons=new Jeton [21];
}

public void affecterCouleur(String uneCouleur){//affecte la couleur en paramètre au joueur
    couleur=uneCouleur;
}

public boolean recevoirJeton(Jeton J1){ 
//ajoute le jeton passé en paramètre à la liste des jetons
    boolean res=true;

    if (ListeJetons[20]!=null){
        //ou nbJetonsRestants==21
         res=false;
         return res;
        }
    else{
            ListeJetons[nombreJetonsRestants]=J1;
           
        }
        return res;
        /*
        for(int i=0; i<21; i++){
            if (ListeJetons[i]!=null){
             res=false;
            }
            else {
                if (ListeJetons[i]==null){
                    ListeJetons[i]=J1;
                    res=true;
                    break;
                }
            }
        break;
        }
        return res;
        */
    } 

public void obtenirDesintegrateur(){
    //incrémente le nombre de désintégrateurs du joueur
    nombreDesintegrateurs++;
    
}
        
public boolean utiliserDesintegrateur(){
    //décrémente le nombre de désintégrateurs et confirme l’utilisation de ce 
    //dernier, ou renvoie faux s’il ne restait plus de désintégrateurs.
    if(nombreDesintegrateurs==0){
        return false;
    }
    else{
        nombreDesintegrateurs=nombreDesintegrateurs--;
        //if(JetonCourant.SupprimerJeton()==true){
         return true;   
        //}
        
    }
    }
}
