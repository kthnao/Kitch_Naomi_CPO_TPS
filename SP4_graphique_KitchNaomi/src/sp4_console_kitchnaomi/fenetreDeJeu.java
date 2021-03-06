/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp4_console_kitchnaomi;

import java.util.Random;

/**
 *
 * @author naomi
 */
public class fenetreDeJeu extends javax.swing.JFrame {

    Grille grilleJeu = new Grille();
    Joueur joueurCourant;
    Joueur[] ListeJoueurs = new Joueur[2];

    /**
     * Creates new form fenetreDeJeu
     */
    public fenetreDeJeu() {
        initComponents();
        panneau_info_joueurs.setVisible(false);
        panneau_info_partie.setVisible(false);

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                CelluleGraphique cellGraph = new CelluleGraphique(grilleJeu.CellulesJeu[i][j]);

                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Cellule c = cellGraph.celluleAssociee;
                        if (c.JetonCourant == null) {
                            return; //s'il n' y a pas de jeton
                        }
                        if (c.JetonCourant.couleur.equals(joueurCourant.couleur)) { //si le jeton est un jeton du joueur courant
                            textemsg.setText("Le joueur " + joueurCourant.nom + " récupère un de ses jetons");
                            Jeton jrecup = c.recupererJeton(); //on récupère le jeton en question
                            joueurCourant.recevoirJeton(jrecup); //on le donne au joueur
                            c.JetonCourant=null;//on enleve le jeton de la grille (j'ai une méthode dans grille qui enlève le jeton cependant il demande la ligne et la colonne en entrée et je ne les ai pas j'ai donc enlevé le jeton comme ça
                            joueurSuivant(); //on change de joueur
                        } else {//sinon
                            if (joueurCourant.nombreDesintegrateurs > 0) { //si le joueur a au moins 1 désintégrateur
                                textemsg.setText("Le joueur " + joueurCourant.nom + " veut désintégrer un de ses jetons");
                                //c.supprimerJeton(); //je n'ai pas utiliser la méthode supprimer jeton car elle ne marchait pas je ne sais pas pourquoi
                                c.JetonCourant=null;//on supprime le jeton voulu
                                joueurCourant.nombreDesintegrateurs--;//on enlève un désintégrateur au joueur
                            } else {
                                return; //c'est à dire qu'on ne fait aucune action
                            }
                        }
                        grilleJeu.tasserGrille();
                        panneau_grille.repaint();
                        boolean vicj1 = grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]);
                        boolean vicj2 = grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]);

                        if (vicj1 && !vicj2) { //si j1 gagne mais pas j2
                            textemsg.setText("Victoire de " + ListeJoueurs[0].nom);
                            //affichage d'un message de victoire dans le panneau info partie
                        }

                        if (vicj2 && !vicj1) {//si j2 gagne mais pas j1
                            textemsg.setText("Victoire de " + ListeJoueurs[1].nom);
                            //affichage d'un message de victoire dans le panneau info partie
                        }

                        if (vicj1 && vicj2) { //si les 2 joueurs gagnent
                            if (joueurCourant == ListeJoueurs[0]) {
                                textemsg.setText("Victoire de " + ListeJoueurs[1].nom + " (faute de jeu de l'autre joueur)");
                                //affichage d'un message de victoire dans le panneau info partie
                            } else {
                                textemsg.setText("Victoire de " + ListeJoueurs[0].nom + " (faute de jeu de l'autre joueur)");
                                //affichage d'un message de victoire dans le panneau info partie
                            }
                        }

                    }
                });

                panneau_grille.add(cellGraph);

            }
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

        panneau_grille = new javax.swing.JPanel();
        panneau_info_joueurs = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_j1_desint = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        lbl_j2_desint = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_j2_nom = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        panneau_creation_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nom_joueur1 = new javax.swing.JTextField();
        nom_joueur2 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_jcourant = new javax.swing.JLabel();
        message = new javax.swing.JScrollPane();
        textemsg = new javax.swing.JTextArea();
        btn_col_0 = new javax.swing.JButton();
        btn_col_1 = new javax.swing.JButton();
        btn_col_2 = new javax.swing.JButton();
        btn_col_3 = new javax.swing.JButton();
        btn_col_4 = new javax.swing.JButton();
        btn_col_5 = new javax.swing.JButton();
        btn_col_6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(255, 255, 255));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 672, 576));

        panneau_info_joueurs.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_joueurs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setText("infos joueurs");
        panneau_info_joueurs.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 130, 30));

        jLabel5.setText("désintégrateurs :");
        panneau_info_joueurs.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 20));

        lbl_j1_desint.setText("nbdesintjoueur1");
        panneau_info_joueurs.add(lbl_j1_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        jLabel7.setText("couleur : ");
        panneau_info_joueurs.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 20));

        jLabel8.setText("joueur 1 :");
        panneau_info_joueurs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        lbl_j1_nom.setText("nomjoueur1 ");
        panneau_info_joueurs.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        lbl_j1_couleur.setText("couleurjoueur1");
        panneau_info_joueurs.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));
        panneau_info_joueurs.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 270, -1));

        jLabel6.setText("désintégrateurs :");
        panneau_info_joueurs.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 20));

        lbl_j2_desint.setText("nbdesintjoueur2");
        panneau_info_joueurs.add(lbl_j2_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel9.setText("couleur : ");
        panneau_info_joueurs.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 60, 20));

        jLabel10.setText("joueur 2 :");
        panneau_info_joueurs.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        lbl_j2_nom.setText("nomjoueur2 ");
        panneau_info_joueurs.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        lbl_j2_couleur.setText("couleurjoueur2");
        panneau_info_joueurs.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        getContentPane().add(panneau_info_joueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 290, 230));

        panneau_creation_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_creation_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom Joueur 2:");
        panneau_creation_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setText("Nom Joueur 1:");
        panneau_creation_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setText("Nom Joueur 1:");
        panneau_creation_partie.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
        panneau_creation_partie.add(nom_joueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 110, -1));

        nom_joueur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur2ActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(nom_joueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 110, -1));

        btn_start.setText("Démarrer partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_creation_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 150, 40));

        getContentPane().add(panneau_creation_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 290, 160));

        panneau_info_partie.setBackground(new java.awt.Color(204, 255, 204));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel11.setText("infos jeu");
        panneau_info_partie.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 130, 30));

        jLabel12.setText("Joueur courant :");
        panneau_info_partie.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lbl_jcourant.setText("nomjoueur ");
        panneau_info_partie.add(lbl_jcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 80, 20));

        textemsg.setColumns(20);
        textemsg.setRows(5);
        message.setViewportView(textemsg);

        panneau_info_partie.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 290, 230));

        btn_col_0.setText("1");
        btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        btn_col_1.setText("2");
        btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        btn_col_2.setText("3");
        btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        btn_col_3.setText("4");
        btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        btn_col_4.setText("5");
        btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        btn_col_5.setText("6");
        btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        btn_col_6.setText("7");
        btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        setBounds(0, 0, 1200, 740);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        //lorsqu'on active le bouton
        panneau_info_joueurs.setVisible(true); //fait apparaître les infos des joueurs
        panneau_info_partie.setVisible(true); //fait apparapitre les infos de la partie
        initialiserPartie(); //initialise la partie en appelant la méthode initialiser partie
        panneau_grille.repaint(); //actualise la grille sans qu'on est besoin de passer la souris sur les cases
        btn_start.setEnabled(false); //le bouton ne peut plus être réutiliser après sa première utilisation
    }//GEN-LAST:event_btn_startActionPerformed

    private void nom_joueur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur2ActionPerformed

    private void btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_6ActionPerformed
        jouerDansColonne(6);
        if (grilleJeu.colonneRemplie(6) == true) {
            btn_col_6.setEnabled(false);
        }
        joueurSuivant();

    }//GEN-LAST:event_btn_col_6ActionPerformed

    private void btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_3ActionPerformed
        jouerDansColonne(3);
        if (grilleJeu.colonneRemplie(3) == true) {
            btn_col_3.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_3ActionPerformed

    private void btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_4ActionPerformed
        jouerDansColonne(4);
        if (grilleJeu.colonneRemplie(4) == true) {
            btn_col_4.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_4ActionPerformed

    private void btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_5ActionPerformed
        jouerDansColonne(5);
        if (grilleJeu.colonneRemplie(5) == true) {
            btn_col_5.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_5ActionPerformed

    private void btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_2ActionPerformed
        jouerDansColonne(2);
        if (grilleJeu.colonneRemplie(2) == true) {
            btn_col_2.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_2ActionPerformed

    private void btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_0ActionPerformed
        jouerDansColonne(0);
        if (grilleJeu.colonneRemplie(0) == true) {
            btn_col_0.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_0ActionPerformed

    private void btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_1ActionPerformed
        jouerDansColonne(1);
        if (grilleJeu.colonneRemplie(1) == true) {
            btn_col_1.setEnabled(false);
        }
        joueurSuivant();

    }//GEN-LAST:event_btn_col_1ActionPerformed

    public boolean jouerDansColonne(int indice_colonne) {

        boolean resultatAction;

        resultatAction = grilleJeu.ajouterJetonDansColonne(joueurCourant, indice_colonne);
        panneau_grille.repaint();//on actualise la grille de jeu

        lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + ""); //on affiche le nb de désintégrateur du joueur 1 dans le label en question
        lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + "");//on affiche le nb de désintégrateur du joueur 2 dans le label en question

        boolean vicj1 = grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]);
        boolean vicj2 = grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]);

        if (vicj1 && !vicj2) { //si j1 gagne mais pas j2
            textemsg.setText("Victoire de " + ListeJoueurs[0].nom);
        }

        if (vicj2 && !vicj1) {//si j2 gagne mais pas j1
            textemsg.setText("Victoire de " + ListeJoueurs[1].nom);
        }

        if (vicj1 && vicj2) { //si les 2 joueurs gagnent
            if (joueurCourant == ListeJoueurs[0]) {
                textemsg.setText("Victoire de " + ListeJoueurs[1].nom + " (faute de jeu de l'autre joueur)");
            } else {
                textemsg.setText("Victoire de " + ListeJoueurs[0].nom + " (faute de jeu de l'autre joueur)");
            }
        }

        if (resultatAction == true) {
            return true;
        } else {
            return false;
        }

    }

    public void joueurSuivant() { //fonction qui permet d'alterner le joueur courant entre J1 et J2
        if (joueurCourant == ListeJoueurs[0]) {
            joueurCourant = ListeJoueurs[1];
        } else {
            joueurCourant = ListeJoueurs[0];
        }
        lbl_jcourant.setText(joueurCourant.nom);
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
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetreDeJeu().setVisible(true);
            }
        });
    }

    public void attribuerCouleursAuxJoueurs() {
        //attribue des couleurs aux joueurs
        Random random = new Random();
        int nb;
        nb = random.nextInt(2);
        if (nb == 0) { //si nb=0
            ListeJoueurs[0].couleur = "Jaune";
            //joueur1 est associé  à la couleur jaune
            ListeJoueurs[1].couleur = "Rouge";
            //joueur2 est associé  à la couleur rouge
        }
        if (nb == 1) {
            ListeJoueurs[0].couleur = "Rouge";
            //joueur1 est associé  à la couleur rouge
            ListeJoueurs[1].couleur = "Jaune";
            //joueur2 est associé  à la couleur jaune
        }
    }

    public void initialiserPartie() {
        String nomJoueur1 = nom_joueur1.getText();
        Joueur J1 = new Joueur(nomJoueur1);
        String nomJoueur2 = nom_joueur2.getText();
        Joueur J2 = new Joueur(nomJoueur2);
        ListeJoueurs[0] = J1;
        ListeJoueurs[1] = J2;

        //crée la grille, crée les jetons et les attribue aux joueurs correspondants. 
        //Place les trous noirs (version 2) et les téléporteurs (version 3).
        Random random = new Random();
        int ligne;
        int colonne;
        ligne = random.nextInt(6); //ligne prend une valeur comprise entre 0 et 5
        colonne = random.nextInt(7);//ligne prend une valeur comprise entre 0 et 6
        grilleJeu.placerTrouNoir(ligne, colonne);

        for (int i = 0; i < 2; i++) { //Répétition de 2 fois 
            ligne = random.nextInt(6);
            colonne = random.nextInt(7);
            while (grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir() == true) {
                //On créer des coordonnées aléatoire tant que ces dernières ont déjà un trou noir
                ligne = random.nextInt(6);
                colonne = random.nextInt(7);
            }
            grilleJeu.placerTrouNoir(ligne, colonne);
            //On place 2 trou noirs (on a donc 3 en tout)
        }
        for (int i = 0; i < 2; i++) { //Répétition de 2 fois 
            ligne = random.nextInt(6);
            colonne = random.nextInt(7);
            while (grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir() == true) {
                //On créer des coordonnées aléatoire tant que ces dernières ont déjà un trou noir
                ligne = random.nextInt(6);
                colonne = random.nextInt(7);
            }
            grilleJeu.placerTrouNoir(ligne, colonne);
            grilleJeu.placerDesintegrateur(ligne, colonne);
            //On place 2 désintégrateurs/trou noirs au même coordonnées (2 désintégrateurs et 5 trous noirs en tout)
        }

        for (int i = 0; i < 3; i++) { //Répétition de 3 fois 
            ligne = random.nextInt(6);
            colonne = random.nextInt(7);
            while (grilleJeu.CellulesJeu[ligne][colonne].presenceDesintegrateur() == true || grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir() == true) {
                //On créer des coordonnées aléatoire tant que ces dernières ont déjà un trou noir ou un désintégrateur
                ligne = random.nextInt(6);
                colonne = random.nextInt(7);
            }
            grilleJeu.placerDesintegrateur(ligne, colonne);
            //On place les 3 derniers désintégrateurs (on a donc 5 en tout)
        }

        attribuerCouleursAuxJoueurs(); //on attribu les couleurs aux joueurs

        //On indique aux joueurs leur couleur
        System.out.println(J1.nom + " est de couleur " + J1.couleur);
        System.out.println(J2.nom + " est de couleur " + J2.couleur);

        lbl_j1_nom.setText(nomJoueur1); //sur la fenêtre le lbl_J1_nom prend comme valeur le pseudo entrer pour le J1
        lbl_j2_nom.setText(nomJoueur2);//sur la fenêtre le lbl_J2_nom prend comme valeur le pseudo entrer pour le J2

        lbl_j1_couleur.setText(J1.couleur);//le lbl_j1_couleur affiche la couleur du joueur1
        lbl_j2_couleur.setText(J2.couleur);//le lbl_j2_couleur affiche la couleur du joueur2

        lbl_j1_desint.setText(J1.nombreDesintegrateurs + "");//le lbl_j1_desint affiche le nombre de désintegrateur du joueur1
        lbl_j2_desint.setText(J2.nombreDesintegrateurs + "");//le lbl_j2_desint affiche le nombre de désintegrateur du joueur2
        //on rajoute "" pour que ce soit un String car sinon nombreDesintegrateur est un entier et on veut un string

        String c = null;
        //initialisation de la variable c qui prendra une couleur par la suite
        int nb;
        nb = random.nextInt(2); //nb prend une valeur aléatoire 0 ou 1
        if (nb == 0) {
            c = "Rouge"; //c prrend la valeur "rouge" si nb=0
        }
        if (nb == 1) {
            c = "Jaune";//c prrend la valeur "rouge" si nb=1
        }
        if (J2.couleur == c) { //si la couleur du joueur 2 est la même que c alors il commence à jouer
            joueurCourant = J2;
        } else {
            joueurCourant = J1;//sinon c'est l'autre joueur qui joue
        }

        lbl_jcourant.setText(joueurCourant.nom);//affiche le pseudo du joueur courant dans le lbl_jcourant

        for (int k = 0; k < 21; k++) {
            J1.recevoirJeton(new Jeton(J1.couleur)); //on associe les jetons de la bonne couleur au joueur1
            J2.recevoirJeton(new Jeton(J2.couleur)); //on associe les jetons de la bonne couleur au joueur2
            J1.nombreJetonsRestants++;
            J2.nombreJetonsRestants++;

            //grilleJeu.afficherGrilleSurConsole();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_col_0;
    private javax.swing.JButton btn_col_1;
    private javax.swing.JButton btn_col_2;
    private javax.swing.JButton btn_col_3;
    private javax.swing.JButton btn_col_4;
    private javax.swing.JButton btn_col_5;
    private javax.swing.JButton btn_col_6;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_desint;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_desint;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_jcourant;
    private javax.swing.JScrollPane message;
    private javax.swing.JTextField nom_joueur1;
    private javax.swing.JTextField nom_joueur2;
    private javax.swing.JPanel panneau_creation_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_joueurs;
    private javax.swing.JPanel panneau_info_partie;
    private javax.swing.JTextArea textemsg;
    // End of variables declaration//GEN-END:variables
}
