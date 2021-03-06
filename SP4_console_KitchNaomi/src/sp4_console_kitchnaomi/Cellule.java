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
public class Cellule {
    Jeton JetonCourant;
    boolean trouNoir; 
    boolean desintegrateur;
    
 
    
    public Cellule(){//constructeur initialisant les attributs avec des valeurs par défaut
        JetonCourant=null;
        trouNoir=false;
        // desintegrateur=false; pour la version 4.0
    }
    public boolean affecterJeton(Jeton J1){
// ajoute le jeton en paramètre à la cellule, et retourne vrai si l’ajout 
//s’est bien passé, ou faux sinon (ex : jeton déjà présent)  
        if (JetonCourant==null){ // s'il n'y a pas de jeton présent
        JetonCourant=J1; //alors on place le jeton
        return true;
        }
        else {
        return false;
        }
    }
    public String lireCouleurDuJeton(){
//renvoie la couleur du jeton occupant la cellule
        return JetonCourant.couleur;
    }
    
         public boolean placerTrouNoir(){
        //ajoute un trou noir à l’endroit indiqué et retourne vrai si l’ajout s’est 
        //bien passé, ou faux sinon (exemple : trou noir déjà présent)
        boolean res=false;
        if (trouNoir==false){ //s'il n'y a pas de trou noir 
            trouNoir=true;//alors on en rajoute 1
            return true;
        }
        else{
            return res;
        }
    }
    
    public boolean presenceTrouNoir(){
        //renvoie vrai si un trou noir est présent sur la cellule
        boolean res=false;
        if(trouNoir==true){//s'il y a un trou noir
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
            trouNoir=false; //on supprime le trou noir
            JetonCourant=null;//on active le trou noir en supprimant le jeton qui l'a activé
            System.out.println("Votre pion a été englouti par le trou noir");
            return true;
        }
        else{
            return false;
        }
    }
    
    public Jeton recupererJeton(){
        //renvoie une référence vers le jeton de la cellule
        return JetonCourant;
    }
    
    public boolean supprimerJeton(){
        //supprime le jeton et renvoie vrai si la suppression s’est bien passée, 
        //ou faux autrement (ex : pas de jeton présent)
        if (JetonCourant!=null){
            JetonCourant=null;
            return true;
        }
        else{
           return false; 
        }
    }
    
     public boolean placerDesintegrateur() {
        //ajoute un désintégrateur à l’endroit indiqué et retourne vrai si l’ajout
        //s’est bien passé, ou faux sinon (exemple : désintégrateur déjà présent))
        boolean res=false;
        if (desintegrateur==false){ //s'il n'y a pas de désintégrateur
            desintegrateur=true;//zlors on en rajoute 1
            return true;
        }
        else{
            return res;
        }
        
    }
   
     public boolean presenceDesintegrateur(){
         //renvoie vrai si un désintégrateur est présent sur la cellule
        boolean res=false;
        if(desintegrateur==true){//s'il y a un désintégrateur
            return true;
        }
        else {
            return res;
        }
     }
     
     public boolean recupererDesintegrateur (){
         //supprime le désintégrateur présent de la cellule, et renvoie vrai,
         //ou faux sinon (exemple : pas de désintégrateur présent)
         if(desintegrateur==true){
            desintegrateur=false;
            System.out.println("Vous avez gagné un désintégrateur");//on supprime le désintégrateur présent
            return true;
        }
        else{
            return false;
        }
     }
}
