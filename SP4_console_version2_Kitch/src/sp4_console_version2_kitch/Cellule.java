/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_version2_kitch;

/**
 *
 * @author naomi
 */
public class Cellule {
    Jeton JetonCourant;
    boolean trouNoir; 
    //boolean desintegrateur;
 
    
    public Cellule(){//constructeur initialisant les attributs avec des valeurs par défaut
        JetonCourant=null;
        trouNoir=false;
        // desintegrateur=false; pour la version 4.0
    }
    public boolean affecterJeton(Jeton J1){
// ajoute le jeton en paramètre à la cellule, et retourne vrai si l’ajout 
//s’est bien passé, ou faux sinon (ex : jeton déjà présent)  
        if (JetonCourant==null){
        JetonCourant=J1;
        return true;
        }
        else {
        return false;
        }
    }
    public String lireCouleurDuJeton(){//renvoie la couleur du jeton occupant la cellule
        return JetonCourant.couleur;
    }
    
         public boolean placerTrouNoir(){
        //ajoute un trou noir à l’endroit indiqué et retourne vrai si l’ajout s’est 
        //bien passé, ou faux sinon (exemple : trou noir déjà présent)
        boolean res=false;
        if (trouNoir==false){
            trouNoir=true;
            return true;
        }
        else{
            return res;
        }
    }
    
    public boolean presenceTrouNoir(){
        //renvoie vrai si un trou noir est présent sur la cellule
        boolean res=false;
        if(trouNoir==true){
            return true;
        }
        else {
            return res;
        }
    }
    
    public boolean activerTrouNoir(){
        //active le trou noir : le trou noir engloutit le jeton et disparait. 
        //Retourne vrai si tout s’est correctement déroulé, ou faux sinon (pas de trou noir)
        if(trouNoir==true){
            trouNoir=false;
            JetonCourant=null;
            return true;
        }
        else{
            return false;
        }
    }
   
}

