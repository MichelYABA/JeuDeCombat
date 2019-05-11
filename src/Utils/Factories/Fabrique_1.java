/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Factories;

import Modele.Combattant;
import Modele.Combattant_1;
import Modele.Combattant_2;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public class Fabrique_1 implements FabriqueCombattant {

    /**
     *
     * @param type
     * @return
     */
    @Override
    public Combattant creerCombattant(int type) {
                
        
        Combattant c;
        
        switch (type) {
            case 1:
                c = new Combattant_1();
                break;
            case 2:
                c = new Combattant_2();
                break;
            default:
                c = new Combattant_1();
                break;
        }
        
        return c;
    }
    
}
