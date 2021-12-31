/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniprojet_kitchnaomi;


import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author naomi
 */
public class plateauGraphique extends JLabel {
    Pion pionAssocie;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/blank.gif"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/rouge.gif"));
    ImageIcon img_fushia = new javax.swing.ImageIcon(getClass().getResource("/images/fuschia.gif"));
    ImageIcon img_bleu = new javax.swing.ImageIcon(getClass().getResource("/images/bleu.gif"));
    ImageIcon img_blanc = new javax.swing.ImageIcon(getClass().getResource("/images/blanc.gif"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jaune.gif"));
    ImageIcon img_mauve = new javax.swing.ImageIcon(getClass().getResource("/images/mauve.gif"));
    ImageIcon img_vert = new javax.swing.ImageIcon(getClass().getResource("/images/vert.gif"));
    ImageIcon img_orange = new javax.swing.ImageIcon(getClass().getResource("/images/orange.gif"));
    
    public plateauGraphique (Pion unpion) {
        pionAssocie = unpion;
        this.setHorizontalAlignment(CENTER);
       //this.setText(pionAssocie.couleur);
      
    
    }
    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        String couleur_pion=pionAssocie.lireCouleur();
        switch (couleur_pion) {
            case "vide":
                setIcon(img_vide); //on attribue l'image blank.gif
                break;
            case "rouge":
                setIcon(img_rouge);
                break;
                case "fuschia":
                setIcon(img_fushia);
                break;
                case "bleu":
                setIcon(img_bleu);
                break;
                case "blanc":
                setIcon(img_blanc);
                break;
                case "jaune":
                setIcon(img_jaune);
                break;
                case "mauve":
                setIcon(img_mauve);
                break;
                case "vert":
                setIcon(img_vert);
                break;
                case "orange":
                setIcon(img_orange);
                break;
             
        }

    }
    
}
