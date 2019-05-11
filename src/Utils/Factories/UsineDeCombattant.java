/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Factories;

import Modele.Combattant;


/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public class UsineDeCombattant {
    private FabriqueCombattant fabrique;
    
    /**
     *
     * @param fab
     */
    public UsineDeCombattant(FabriqueCombattant fab){
        this.fabrique = fab;
    }
    
    /**
     *
     * @param type
     * @return
     */
    public Combattant creeCombattant(int type){
        Combattant combattant = fabrique.creerCombattant(type);
        
        return combattant;
    }
}
