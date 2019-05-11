/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javax.swing.ImageIcon;


/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public class Combattant_2 extends Combattant {

    /**
     *
     */
    public Combattant_2(){
      
        nom +="Y";
        typeArme += "Magnum";
        munition +=12;
        nbreDeTir +=munition;
    }

    /**
     *
     */
    @Override
    public void loadImage() {
        ImageIcon ii = new ImageIcon(getClass().getResource("/ressources/soldat_2.png"));
        imageC = ii.getImage(); 
        
        w = imageC.getWidth(null);
        h = imageC.getHeight(null);    
    }
    
    
}
