/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.TableInfosCombattant;
import Modele.Grille;

import javax.swing.*;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
Classe qui représente la fenêtre d'où sont affichées les données des combattants
*/
public class CombattantGUI extends JScrollPane {
    
    /**
     *
     * @param gril
     */
    public CombattantGUI(Grille gril)
    {
        super(new JTable(new TableInfosCombattant(gril)));
    }
    
   
}
