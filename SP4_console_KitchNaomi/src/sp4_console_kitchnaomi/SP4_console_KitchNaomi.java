/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_kitchnaomi;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author naomi
 */
public class SP4_console_KitchNaomi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       Scanner sc;
        System.out.println("bonjour veuillez saisir un pseudo pour le premier joueur");
        sc = new Scanner(System.in);
        String nom1 = sc.next(); //On demande de saisir le pseudo du joueur 1
        Joueur joueur1 = new Joueur(nom1);
        
        System.out.println("bonjour veuillez saisir un pseudo pour le deuxième joueur");
        sc = new Scanner(System.in);
        String nom2 = sc.next();//On demande de saisir le pseudo du joueur 2
        Joueur joueur2 = new Joueur(nom2);
        Partie part1=new Partie(joueur1,joueur2);
        part1.attribuerCouleursAuxJoueurs();
        part1.initialiserPartie();
        part1.debuterPartie();
    }
    
}
