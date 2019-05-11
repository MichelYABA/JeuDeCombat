/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import Controller.ControleurAccueil;
import Controller.ControleurGrille;
import Modele.Definitions;
import Modele.Grille;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
Classe représentant la fenêtre de la grille
*/
public class GrilleGUI extends JFrame {
    // déclaration des variables
    private JMenuBar menu;
    private JMenu game;
    private JMenu about;
    private JMenuItem replay ;
    private JMenuItem exit ;
    private JMenuItem propos ;

    /**
     *
     */
    public static GrillePanel panG;
    private final ControleurGrille controle;
    private JFormattedTextField ligne, colonne, combattant;
    
    /**
     *
     * @param cont
     */
    public GrilleGUI(ControleurGrille cont){
        controle = cont;
        InitUI(controle.getGrille());
        menu();
    }
    

    /* Methode d'initialisation de la grille GUI*/

    /**
     *
     * @param g
     */

    public void InitUI(Grille g) {
        /* Initialisation des variables déclarées */
        menu = new JMenuBar();
        game = new JMenu("Game"); // Nom du menu Game
        about = new JMenu("About"); 
        replay = new JMenuItem("Reinit"); 
        exit = new JMenuItem("Exit"); 
        propos = new JMenuItem("A propos");
        ligne = AccueilGUI.ligneText;
        colonne= AccueilGUI.colText;
        combattant  = AccueilGUI.combText;
        
        panG = new GrillePanel(controle);
        panG.setPreferredSize(new Dimension(g.getBoardWidth(), g.getBoardHeight() + Definitions.COMP_HAUT));
         
        
        JLabel jeu = new JLabel("Combattant "+ 0);
        
        CombattantGUI tabG= new CombattantGUI(g);
        tabG.setPreferredSize(new Dimension(400, 300));
        tabG.setMaximumSize(new Dimension(400, 300));
        
        this.getContentPane().setLayout(new BorderLayout());
        this.add(panG, BorderLayout.CENTER);
        this.add(tabG, BorderLayout.EAST);
          
        this.add(jeu, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        
        setLocationRelativeTo(null);
        setTitle("JEU DE COMBAT TOUR A TOUR");
        
    }

    /* Methode qui definit les menus*/

    /**
     *
     */

    public void menu(){
        
        this.menu.add(game);
        this.game.add(replay);
        this.game.add(about);
        this.game.add(exit);
        this.menu.add(about);
        this.about.add(propos);
        
        // Au clic sur le menu EXIT
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   
               System.exit(0); // la fenetre se ferme
            }

        });
        
        // Au clic sur le menu APROPOS
        propos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Le jeu est mis en pause
               GrillePanel.combTimer.stop();
               // Une boite de dialogue s'affiche
               JOptionPane.showMessageDialog(null, "Ce projet a été réalisé par YABA - DIALLO - MPASSI - KOUROUMA, un groupe d'étudiants en Informatique Licence 3");
               // Le jeu reprend à l'endroit où il s'est arreté
               GrillePanel.combTimer.start();
                           
            }
        });
        
        // Au clic sur le menu Replay
        replay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControleurAccueil cont = new ControleurAccueil();
                 //controleA.setNewInterface(AccueilGUI.ligneText, AccueilGUI.colText, AccueilGUI.combText);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ligne); 
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+colonne); 
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+combattant);
                JFormattedTextField l=ligne, c =colonne, cb = combattant;
                
                cont.setNewInterface2(l, c, cb); // Le jeu est reinitialisé
                dispose();
                
            }
        });
                
        
        this.setJMenuBar(menu);
        this.setVisible(true);
    }
    
    
  
    
}
