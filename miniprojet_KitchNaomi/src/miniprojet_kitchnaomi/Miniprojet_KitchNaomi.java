/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet_kitchnaomi;

/**
 *
 * @author naomi
 */
public class Miniprojet_KitchNaomi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*idée d'ajout d'option : ajout de couleur, aggrandir le plateau(la grille), 
choisir le nombre d'essaies...*/
      Joueur J1=new Joueur("Nao");
        Partie test=new Partie(J1);
        test.debuterpartie();
     
     
         
    }
    
}
