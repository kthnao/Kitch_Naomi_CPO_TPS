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
public class Grille {
    Cellule [][] CellulesJeu;
    
    public Grille(){//contrusteur de la classe 
        for (int i=0; i<7;i++){
            for(int j=0; j<6; j++){
                CellulesJeu[i][j]=new Cellule(); //i colonne et j ligne
            }
        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton J1, int colonne){
    //ajoute le jeton dans la colonne ciblée, sur la cellule vide la plus basse.
    //Renvoie faux si la colonne était pleine.
    
    boolean res=false; 
    int i=colonne-1;
    for (int j=0; i<7 ; i++){
        if(CellulesJeu[i][j].Jetoncourant==null){
            CellulesJeu[i][j].Jetoncourant=J1;
            res = true;  
        }

    }
    return res;
    }
    
    public boolean etreRemplie(){//renvoie vrai si la grille est pleine
        boolean res=true;
        for (int i=0; i<7;i++){
            for(int j=0; j<6; j++){
                if(CellulesJeu[i][j]==null){
                    res=false;
                    break;
                }
                break;
            }
            break;
        }
        return res;
    }
    
    public void viderGrille(){//vide la grille
        for (int i=0; i<7;i++){
            for(int j=0; j<6; j++){
                CellulesJeu[i][j]=null;
            }
        }
    }
    
    public void afficherGrilleSurConsole(){
        //fonction d’affichage de la grille sur la console. 
        //Doit faire apparaitre les couleurs, et les trous noirs.
        for (int i=0; i<7;i++){
            for(int j=0; j<6; j++){
                System.out.println(CellulesJeu[i][j]);
            }
        }
        
    }
}

