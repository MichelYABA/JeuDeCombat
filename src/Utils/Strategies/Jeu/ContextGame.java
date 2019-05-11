/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Strategies.Jeu;

import Modele.Combattant;
import Modele.Grille;

/**
 *
 * @author yaba
 */
public class ContextGame {
    private GameStrategy strategie;

    /**
     *
     * @param grille
     */
    public ContextGame(Grille grille){
        strategie =  new AleatGameStrategy(grille);
    }
    
    /**
     *
     * @param comb
     * 
     */
    public void actionJeu(Combattant comb){
        strategie.actionCombattant(comb);
    }
    
    /**
     *
     * @param strat
     */
    public void setStrategy(GameStrategy strat){
        this.strategie = strat;
    }
    
}
