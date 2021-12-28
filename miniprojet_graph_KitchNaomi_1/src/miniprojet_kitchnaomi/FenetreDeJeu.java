/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package miniprojet_kitchnaomi;

//il faut faire la fonction qui permet de sélectionner les couleurs pour proposer une combinaison
//il faut faire la focntion qui permet de supprimer une couleur dans la fonction o alors des boutons qui sélectionne ou 
//qui déselectionne la couleur afin de proposer une combinaison
//il faut voir si la combi myst a été bien fait
//il faut mettre la fonction qui remet le bon nb d'essaies restant
//il faut la fonciyon des languettes et qui dit si c'est bon ou non
//fonction qui annonce si le joueur à bon ou non => partie gagnante


import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author naomi
 */
public class FenetreDeJeu extends javax.swing.JFrame {

    String[] tabcouleur = {"rouge", "vert", "jaune", "orange", "bleu", "mauve", "blanc", "fuschia"};
    Plateau plateauJeu = new Plateau();
    
    Joueur joueur;

    public FenetreDeJeu() {

        initComponents();
        panneau_info_joueur.setVisible(false);
        Panneau_couleur.setVisible(false);

        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                plateauGraphique pionGraph = new plateauGraphique();
                Panneau_grilleJeu.add(pionGraph);

            }
        }

        for (int l = 0; l < 8; l++) {
            couleurGraph couleurpionGraph = new couleurGraph(tabcouleur[l]);
            Panneau_couleur.add(couleurpionGraph);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panneau_grilleJeu = new javax.swing.JPanel();
        Panneau_couleur = new javax.swing.JPanel();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nom_joueur = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_joueur = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_j_essaiesrest = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_j_nom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1222, 714));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panneau_grilleJeu.setBackground(new java.awt.Color(153, 153, 153));
        Panneau_grilleJeu.setLayout(new java.awt.GridLayout(12, 4));
        getContentPane().add(Panneau_grilleJeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 592, 704));

        Panneau_couleur.setBackground(new java.awt.Color(0, 255, 255));
        Panneau_couleur.setLayout(new java.awt.GridLayout(2, 4));
        getContentPane().add(Panneau_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 310, 120));

        panneau_creation_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nom Joueur : ");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
        panneau_creation_partie.add(nom_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 110, 30));

        btn_start.setText("Démarrer partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 150, 40));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 290, 140));

        panneau_info_joueur.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setText("infos joueur");
        panneau_info_joueur.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 130, 30));

        lbl_j_essaiesrest.setText("nbessaierest");
        panneau_info_joueur.add(lbl_j_essaiesrest, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel7.setText("nb essaies restants :");
        panneau_info_joueur.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 20));

        jLabel8.setText("joueur :");
        panneau_info_joueur.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lbl_j_nom.setText("nomjoueur ");
        panneau_info_joueur.add(lbl_j_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        getContentPane().add(panneau_info_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 290, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        //lorsqu'on active le bouton
        panneau_info_joueur.setVisible(true);//fait apparaître les infos du joueur
        Panneau_couleur.setVisible(true);//fait apparaître les couleurs
        initialiserPartie(); //initialise la partie en appelant la méthode initialiser partie
        Panneau_grilleJeu.repaint(); //actualise la grille sans qu'on est besoin de passer la souris sur les cases
        btn_start.setEnabled(false); //le bouton ne peut plus être réutiliser après sa première utilisation
    }//GEN-LAST:event_btn_startActionPerformed

    public Combinaison initialisationcombimyst() {
        //renvoie une combinaison àléatoire qui sera la combinaison à retrouver
        Random random = new Random();
        int cpion;//correspondra à la couleur du pion

        for (int i = 0; i < 4; i++) {
            cpion = random.nextInt(8);//prend une valeur comprise entre 0 et 7

            Pion pioncombi = new Pion("vide"); //On créer une varaible qui me permettra de remplir le tableau de la ocmbinaison
            switch (cpion) {
                case 0:
                    //si cpion==0 alors le pioncombi prend la valeur d'un pion rouge 
                    Pion pionR = new Pion("rouge");
                    pioncombi = pionR;
                    break;
                case 1:
                    //si cpion==1 alors le pioncombi prend la valeur d'un pion orange
                    Pion pionO = new Pion("orange");
                    pioncombi = pionO;
                    break;
                case 2:
                    //si cpion==2 alors le pioncombi prend la valeur d'un pion bleu
                    Pion pionB = new Pion("bleu");
                    pioncombi = pionB;
                    break;
                case 3:
                    //si cpion==3 alors le pioncombi prend la valeur d'un pion vert 
                    Pion pionV = new Pion("vert");
                    pioncombi = pionV;
                    break;
                case 4:
                    //si cpion==4 alors le pioncombi prend la valeur d'un pion jaune
                    Pion pionJ = new Pion("jaune");
                    pioncombi = pionJ;
                    break;
                case 5:
                    //si cpion==5 alors le pioncombi prend la valeur d'un pion mauve
                    Pion pionM = new Pion("mauve");
                    pioncombi = pionM;
                    break;
                case 6:
                    //si cpion==4 alors le pioncombi prend la valeur d'un pion jaune
                    Pion pionBlc = new Pion("blanc");
                    pioncombi = pionBlc;
                    break;
                case 7:
                    //si cpion==5 alors le pioncombi prend la valeur d'un pion mauve
                    Pion pionF = new Pion("fuschia");
                    pioncombi = pionF;
                    break;   
              
            }
            plateauJeu.Combimystere.tabcombi[i] = pioncombi; 
//La valeur de la case du tableau indiquée prend comme référence celle du pion combi
        }
        return plateauJeu.Combimystere;
    }

    public boolean Combigagnante(Combinaison combiproposee) {
    //retourne vrai si le joueur a trouvé la combinaison sinon renvoie faux
        int pionscorrects = 0;
        for (int i = 0; i < 4; i++) {
            if (plateauJeu.Combimystere.tabcombi[i].lireCouleur() == combiproposee.tabcombi[i].lireCouleur()) {
                pionscorrects = pionscorrects + 1;
            }
        }
        if (pionscorrects == 4) {
            return true;
        } else {
            return false;
        }
    }

    public int[] comparaisoncombi(Combinaison combiproposee) {
        //retourne un tableau contenant le nombre de pions à la bonne position et de la bonne couleur dans la première case et 
        //le nombre de pions de la bonne couleur dans la seconde
        
        int nbbonnecetp = 0;//nb de pion de la bonne couleur et de la bonne position
        int nbbonnecouleur = 0;//nb de pion de la bonne couleur
        boolean[] checkcombimyst = new boolean[4];
        boolean[] checkcombiproposee = new boolean[4];
        for (int k = 0; k < 4; k++) {
            checkcombimyst[k] = false; //On initialise notre tableau qu'avec la valeur false
            checkcombiproposee[k] = false;//On initialise notre tableau qu'avec la valeur false
        }
        for (int i = 0; i < 4; i++) { 
//si les cases des combi sont identiques alors le pion est à la bonne position et est de la bonne couleur
            if (plateauJeu.Combimystere.tabcombi[i].lireCouleur() == combiproposee.tabcombi[i].lireCouleur()) {
                nbbonnecetp = nbbonnecetp + 1;
                checkcombimyst[i] = true;
                checkcombiproposee[i] = true;
            }
        }
        for(int j=0;j<4;j++){
            for(int x=0;x<4;x++){
                if(plateauJeu.Combimystere.tabcombi[j].lireCouleur() == combiproposee.tabcombi[x].lireCouleur()&&checkcombimyst[j]==false&&checkcombiproposee[x] ==false){
//si des cases de positions ont la même valeur et n'ont pas été déjà check alors cela veut dire que le pion est de la bonne couleur mais pas à la bonne posiiton
                    nbbonnecouleur=nbbonnecouleur+1;
                    checkcombimyst[j] = true;
                    checkcombiproposee[x] = true;
                }
            }
        }
        
       
        int[]res=new int[2];
        res[0]=nbbonnecetp;
        res[1]=nbbonnecouleur;
        return res;
    }

  
    public Languette affichagelangbonnecouleur(int nbbonnecouleur) {
        //Remplie de pion blanc le nombre de case correspondant au nombre de pion de bonne couleur et renvoie le tableau
        Pion pionBl = new Pion("blanc");
        for (int i = 0; i < nbbonnecouleur; i++) {
            plateauJeu.langbonnecouleur.tablang[i] = pionBl;
            plateauJeu.langbonnecouleur.couleurlang = pionBl.couleur;//la couleur de la languette correspond à la couleur des pions
        }
        return plateauJeu.langbonnecouleur;
    }

    public Languette affichagelangbonnecetp(int nbbonnecetp) {
        //Remplie de pion reouge le nombre de case correspondant au nombre de pion de bonne couleur et renvoie le tableau
        Pion pionrouge = new Pion("rouge");
        for (int i = 0; i < nbbonnecetp; i++) {
            plateauJeu.langbonnecetp.tablang[i] = pionrouge;
        }
        plateauJeu.langbonnecetp.couleurlang = pionrouge.couleur;//la couleur de la languette correspond à la couleur des pions
        return plateauJeu.langbonnecetp;
    }

    public Combinaison combiproposee(Pion pion1, Pion pion2, Pion pion3, Pion pion4) {
        //renvoie la combinaison composée des pions en entré dans l'ordre donné en entrée aussi
        Combinaison combiproposee=new Combinaison();
        combiproposee.tabcombi[0]=pion1;
        combiproposee.tabcombi[1]=pion2;
        combiproposee.tabcombi[2]=pion3;
        combiproposee.tabcombi[3]=pion4;
        
        return combiproposee;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreDeJeu().setVisible(true);
            }
        });
    }

    public void initialiserPartie() {
        String nomjoueur = nom_joueur.getText();
        Joueur J = new Joueur(nomjoueur);
        Combinaison combiMyst = plateauJeu.initialisationcombimyst();
        lbl_j_nom.setText(nomjoueur); //sur la fenêtre le lbl_J1_nom prend comme valeur le pseudo entrer pour le J1
       

        lbl_j_essaiesrest.setText(J.EssaiesRestants + "");//le lbl_j1_desint affiche le nombre de désintegrateur du joueur1
        //on rajoute "" pour que ce soit un String car sinon nombreDesintegrateur est un entier et on veut un string

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panneau_couleur;
    private javax.swing.JPanel Panneau_grilleJeu;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_j_essaiesrest;
    private javax.swing.JLabel lbl_j_nom;
    private javax.swing.JTextField nom_joueur;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_info_joueur;
    // End of variables declaration//GEN-END:variables
}
