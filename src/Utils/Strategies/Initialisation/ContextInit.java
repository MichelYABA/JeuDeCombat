/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Strategies.Initialisation;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public class ContextInit {
    private InitStrategy strategie; // variable de type l'interface InitStrategy

    /**
     *
     * @param g
     */
    public ContextInit(int[][] g){
        strategie =  new DefaultInitStrategy(g);
    }
    
    /* Methode appelee depuis la Grille pour initialiser la grille*/
    /**
     *
     * @param n
     */
    public void initialiserGrille(int n){
        strategie.initGrille(n);
    }
    
    /* Methode permettant de modifier la strategie d'initialisation*/
    /**
     *
     * @param strat
     */
    public void setStrategie(InitStrategy strat){
        this.strategie = strat;
    }
}
