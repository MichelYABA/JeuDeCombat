/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modele.Definitions;
import Modele.Grille;
import Vue.GrilleGUI;
import javax.swing.JFormattedTextField;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
    Controleur destinée à l'interface d'accueil
*/
public class ControleurAccueil {
    int nLignes, nColonne, nCombattant;

    /**
     *
     */
    public ControleurAccueil() {
            
    }
    
    /*
        Cette methode permet de fermer la fenetre courante de demande des lignes et des colonnes
    
        et de lancer le plateau de jeu
    */

    /**
     *
     * @param li
     * @param col
     * @param comb
     */

    public void setNewInterface(JFormattedTextField li, JFormattedTextField col, JFormattedTextField comb){
       
        //si le champ de saisies des lignes est vide on lui donne une valeur par défaut de 15
        //sinon on affecte à la variables nLignes le nombre saisies
       nLignes = ("".equals(li.getText())) ? Definitions.MIN_LIGNE : Integer.parseInt(li.getText());
       
       //si le champ de saisies des colonnes est vide on lui donne une valeur par défaut de 15
        //sinon on affecte à la variables nColonne le nombre saisies
       nColonne = ("".equals(col.getText())) ? Definitions.MIN_COLONNE : Integer.parseInt(col.getText());
       
       //si le champ de saisies des combattants est vide on lui donne une valeur par défaut de 2
        //sinon on affecte à la variables nCombattant le nombre saisies
       nCombattant =("".equals(comb.getText())) ? Definitions.MIN_COMBATTANT : Integer.parseInt(comb.getText());
       
       controlNombreMinimum(); // appel de la methode de verfication des nombres inferieur a 15
       
       Grille gril = new Grille(nLignes, nColonne, nCombattant);
       
       ControleurGrille controlGril = new ControleurGrille(gril);
       
       GrilleGUI gFen = new GrilleGUI(controlGril);
       
       gFen.setVisible(true);
       
       //(new AccueilGUI()).dispose(); //on ferme la fenètre d'accueil
    }
    
    /*
        Cette methode est appelée lors du clic sur le bouton replay, qui se trouve dans la barre de menu, 
        permet de fermer la fenetre courante de demande des lignes et des colonnes
        et de lancer le plateau de jeu
    */

    /**
     *
     * @param li
     * @param col
     * @param comb
     */

     public void setNewInterface2(JFormattedTextField li, JFormattedTextField col, JFormattedTextField comb){
        
       nLignes = ("".equals(li.getText())) ? Definitions.MIN_LIGNE : Integer.parseInt(li.getText());
       
       nColonne = ("".equals(col.getText())) ? Definitions.MIN_COLONNE : Integer.parseInt(col.getText());
       
       nCombattant =("".equals(comb.getText())) ? Definitions.MIN_COMBATTANT : Integer.parseInt(comb.getText());
       
       controlNombreMinimum(); // appel de la methode qui vérifie si les nombres saisies sont inférieures à 15 pour les nombre et colonnes et 2 pour les combattant
       
       Grille gril = new Grille(nLignes, nColonne, nCombattant);
       
       ControleurGrille controlGril = new ControleurGrille(gril);
       
       GrilleGUI gFen = new GrilleGUI(controlGril);
       
    }
    
    /*Cette methode permet de verifier le nombre de lignes, de colonnes et de combattants saisies par l'utilisateur
    */

    /**
     *
     */

    public void controlNombreMinimum(){
        
        if (nLignes < Definitions.MIN_LIGNE) //on vérifie si le nombre de lignes est inférieur à 15
           nLignes = Definitions.MIN_LIGNE; //si c'est le cas on lui donne un nombre de ligne minimum càd 15
        
        if (nColonne < Definitions.MIN_COLONNE)  //on vérifie si le nombre de colonnes est inférieur à 15
           nColonne = Definitions.MIN_COLONNE; //si c'est le cas on lui donne un nombre de colonne minimum càd 15
        
        if (nCombattant < Definitions.MIN_COMBATTANT) //on vérifie si le nombre de combattants est inférieur à 2
           nCombattant = Definitions.MIN_COMBATTANT; //si c'est le cas on lui donne un nombre de combattant minimum càd 2
       
          
    }
    

}
