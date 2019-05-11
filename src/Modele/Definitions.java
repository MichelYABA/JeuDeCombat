/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public interface Definitions {

    /**
     *
     */
    final  int CASE =0; //case utilisable

    /**
     *
     */
    final  int PASTILLE =1; // case contenant une pastille

    /**
     *
     */
    final  int MUR =2; // case non utilisable

    /**
     *
     */
    final  int COMBATTANT =3; // case contenant un combattant
   
    /**
     *
     */
    final int MIN_MINE = 0; // Nombre minimum de mine

    /**
     *
     */
    final int MIN_BOMBE = 0; // Nombre minimum de bombe

    /**
     *
     */
    final int MAX_MINE = 3; // Nombre maximum de mine

    /**
     *
     */
    final int MAX_BOMBE = 2; // Nombre maximum de bombe
   
    /**
     *
     */
    final int MIN_LIGNE =15; // Nombre minimum de ligne

    /**
     *
     */
    final int MIN_COLONNE = 15; // Nombre minimum de colonne

    /**
     *
     */
    final int MIN_COMBATTANT = 2; // Nombre minimum de combattant
   
    /**
     *
     */
    final int COMP_HAUT = 24; //ajoute les bordures au panneau
   
    /**
     *
     */
    final int LEFT_COLLISION=1; // Valeur correspondant à une collision à gauche

    /**
     *
     */
    final int RIGHT_COLLISION=2; // Valeur correspondant à une collision à droite

    /**
     *
     */
    final int TOP_COLLISION=3; // Valeur correspondant à une collision en haut

    /**
     *
     */
    final int BOTTOM_COLLISION=4; // Valeur correspondant à une collision en bas

    /**
     *
     */
    final int IN_COLLISION = 5; // Valeur correspondant à une collision à l'endroit où se trouve le combattant 
   
    /**
     *
     */
    final int SPACE = 20; //Pas entre chaque case de la grille

    /**
     *
     */
    final int MIN_MUNITION=0; // nombre minimum de munition

    /**
     *
     */
    final int SPEED = 20; //pas de deplacement de la munition
}
