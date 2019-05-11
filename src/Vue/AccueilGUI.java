/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import Controller.ControleurAccueil;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.*;



/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
C'est la porte d'entrée de notre application
Au lancemant  c'est cette classe qui est appelée en premier lieu
*/
public class AccueilGUI extends JFrame {
    JPanel panneau;
    JLabel label1, label2, label3, label4;
    public static JTextField text1,

    /**
     *
     */

    /**
     *
     */

    /**
     *
     */
    text2,

    /**
     *
     */

    /**
     *
     */

    /**
     *
     */
    text3;
    public static JFormattedTextField ligneText,

    /**
     *
     */

    /**
     *
     */

    /**
     *
     */
    colText,

    /**
     *
     */

    /**
     *
     */
    combText;
    JButton bt1; GridLayout grid;

    /**
     *
     */
    public static ControleurAccueil controleA;
    
   
    
    /**
     *
     */
    public AccueilGUI(){
        InitGUI();
    }
    
    /**
     *
     */
    public void InitGUI(){
        // création du panneau
        panneau = new JPanel();
        
        panneau.setSize(600, 400);
        
        // Initialisation des attributs déclarés
        label1 = new JLabel("Entrer le nombre de lignes " );
        label1.setForeground(Color.black);
        label4 = new JLabel("" );
        ligneText = new JFormattedTextField(NumberFormat.getIntegerInstance());
        label2 = new JLabel("Entrer le nombre de colonnes" );
        colText = new JFormattedTextField(NumberFormat.getIntegerInstance());
        label3 = new JLabel("Entrer le nombre de combattants" );
        combText = new JFormattedTextField(NumberFormat.getIntegerInstance());
        bt1= new JButton("valider"); 
        
        //Caractéristiques de la fenetre
        this.setSize(500, 150);
        this.setTitle("PARAMETRAGE DE LA GRILLE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Création d'un gridLayout
        grid = new GridLayout(4, 2);
        grid.setHgap(5);
        grid.setVgap(5);
        
        //ajout du GridLayout dans le panneau
        panneau.setLayout(grid);
        
        //Ajout des autres éléments dans le panneau
        panneau.add(label1);
        panneau.add(ligneText);
        panneau.add(label2);
        panneau.add(colText);
        panneau.add(label3);
        panneau.add(combText);
        panneau.add(label4);
        panneau.add(bt1);
        
        //ajout du panneau comme panneau par défaut
        this.add(panneau);
        this.setVisible(true); 
        controleA = new ControleurAccueil();
      
        bt1.addActionListener(new GrilleListener()); // Clic sur le bouton Valider
        
    }
    
    // Calsse interne qui implémente l'action à effectuer au clic sur le bouton Valider
    class GrilleListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Appel de la méthode setNewInterface de ControleurAccueil qui controle les données et affiche la nouvelle interface
            controleA.setNewInterface(ligneText, colText, combText);
                          
            dispose(); // On ferme la fenêtre courante càd l'interface d'accueil 
          
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        AccueilGUI acceuil = new AccueilGUI();
    }
    
   
   
}


