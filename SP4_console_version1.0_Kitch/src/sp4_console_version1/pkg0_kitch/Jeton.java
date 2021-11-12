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
public class Jeton {
    String couleur;
    
    public Jeton(String uneCouleur){//constructeur initialisant la couleur du jeton avec le paramètre
        couleur=uneCouleur;
    }
 public String lireCouleur(){//renvoie la couleur du jeton
     return couleur;
 }
}
