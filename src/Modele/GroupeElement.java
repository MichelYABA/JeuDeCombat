/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Utils.Observer.Observable;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public interface GroupeElement extends Observable{
     /*On récupère la liste des combattants*/

    /**
     *
     * @return
     */

    public int getSizeCombattant();
    
    /* Méthode qui récupère la liste des cases*/

    /**
     *
     * @return
     */

    public int getSizeCase();
    
     /* Méthode qui récupère une case donnée*/

    /**
     *
     * @param i
     * @return
     */

    public Case getCase(int i);
    
    /*On récupère la liste des pastilles*/

    /**
     *
     * @return
     */

    public int getSizePastille();
    
    /*On récupère la liste des murs*/

    /**
     *
     * @return
     */

    public int getSizeMur();
    
    /* on récupère chaque élément de la liste des combattants*/

    /**
     *
     * @param i
     * @return
     */

    public Combattant getCombattant(int i);
    
      /* on récupère chaque élément de la liste des murs*/

    /**
     *
     * @param i
     * @return
     */

    public Mur getMur(int i);
    
      /* on récupère chaque élément de la liste des pastilles*/

    /**
     *
     * @param i
     * @return
     */

    public Pastille getPastille(int i);
    
    

}
