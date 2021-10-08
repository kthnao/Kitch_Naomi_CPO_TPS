/*
 *nom : KITCH Naomi
*groupe : TDA
*rôle du programme : guessmynumber TP1
 */
package guessmynumber_kitch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author naomi
 */
public class GuessMyNumber_Kitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random generateurAleat = new Random();
        
        /*Cette instruction crée un générateur de nombres aléatoires nommé generateurAleat 
        qui va nous fournir des nombres aléatoires. Cette instruction n’est à écrire qu’une 
        seule fois. Si on veut obtenir un nombre aléatoire n inférieur ou égal à 100, on écrira :
        int n = generateurAleat.nextInt(100);
        */
        
        int nbalea=generateurAleat.nextInt(100);
         Scanner sc;
         sc = new Scanner(System.in);
         System.out.println("choisissez votre mode de jeu"+"\n 1) facile"+"\n 2) normal"+"\n 3) difficile");
         int difficult=sc.nextInt();
         int nbtentative=0;
         
         
         if (difficult==1){
             System.out.println("Vous avez choisi le mode facile, vous avez donc un nombre de tentatives illimité et vous aurez plus d'indication pour essayer de deviner");
             System.out.println("essayez de deviner le nombre, il est compris entre 0 et 100");
            
            int nbtest=sc.nextInt();
            
            while(nbalea!=nbtest){
          
            if (nbalea<nbtest){
                System.out.println("Votre nombre est trop grand, essayez encore");
                nbtentative=nbtentative+1;
            }   
            if (nbalea>nbtest){
                System.out.println("Votre nombre est trop petit, essayez encore");
                nbtentative=nbtentative+1;
            }
            nbtest=sc.nextInt();
            }
            if (nbalea==nbtest){
                        System.out.println("Vous avez gagné ! et vous avez fait "+nbtentative+" tentatives");
                           
                          }
         }
          
            
            if(difficult==2){
                System.out.println("Vous avez choisi le mode normal, vous avez donc un nombre de tentatives limité à 50 essais");
                System.out.println("essayez de deviner le nombre, il est compris entre 0 et 100");
                int nbtest=sc.nextInt();
                
                while(nbalea!=nbtest){
                    
                
                 if (nbalea<nbtest){
                    System.out.println("Votre nombre est trop grand, essayez encore");
                    nbtentative=nbtentative+1;
                 }   
                 if (nbalea>nbtest){
                     System.out.println("Votre nombre est trop petit, essayez encore");
                     nbtentative=nbtentative+1;
                     }
            
                 
                 if (nbtentative==50){
                      break;
                   }
                 nbtest=sc.nextInt();
                 }
                if (nbalea==nbtest){
                     System.out.println("Vous avez gagné ! et vous avez fait "+nbtentative+" tentatives");
                }
            }
         
            if(difficult==3){
                  System.out.println("Vous avez choisi le mode difficle, vous avez donc un nombre de tentatives limité à 10 essais");
                  System.out.println("essayez de deviner le nombre, il est compris entre 0 et 100");
            
                  int nbtest=sc.nextInt();
            
                  while(nbalea!=nbtest){
                     
                     if (nbalea<nbtest){
                         System.out.println("Votre nombre est trop grand, essayez encore");
                         nbtentative=nbtentative+1;
                     }   
                     if (nbalea>nbtest){
                           System.out.println("Votre nombre est trop petit, essayez encore");
                           nbtentative=nbtentative+1;
                     }   
                         if (nbtentative==10){
                              break;
                          }
                         nbtest=sc.nextInt();
             
                  }
                  if (nbalea==nbtest){
                        System.out.println("Vous avez gagné ! et vous avez fait "+nbtentative+" tentatives");
                           
                          }
            }
        
    }   
}