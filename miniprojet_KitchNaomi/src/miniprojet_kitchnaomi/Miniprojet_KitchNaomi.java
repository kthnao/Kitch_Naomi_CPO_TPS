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
public class Miniprojet_KitchNaomi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*idée d'ajout d'option : ajout de couleur, aggrandir le plateau(la grille), 
choisir le nombre d'essaies...*/
      
        Scanner sc;
        System.out.println("bonjour veuillez saisir votre pseudo");
        sc = new Scanner(System.in);
        String nom = sc.next();
        Joueur J1=new Joueur(nom);
        Partie test=new Partie(J1);
        test.debuterpartie();
     
     //rajouter la fonction suppression annuler, régler les bug d'affichage, mais avant tout rajouter les languettes à l'affichage
        // System.out.print("\033[42m   ");
         //System.out.print("\033[47m   ");
    }
    
}
