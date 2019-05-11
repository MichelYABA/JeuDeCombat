/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*Cette interface définit les méthodes communes aux classes Combattant, Mur, Pastille, Munition, Bombe, Mine, Case*/
public interface Acteur {
    //méthode permettant de récupérer la visibilité d'un acteur (true ou false)

    /**
     *
     * @return
     */
     Boolean estVisible();
    
     // méthode permettant de modifier la visibilité d'un acteur donné

    /**
     *
     * @param v
     */
     void setVisibilite(Boolean v);
     
     //méthode permettant de récupérer depuis le dossier ressources l'image correspondant à un acteur donné

    /**
     *
     * @return
     */
     Image getImage();
     
     //méthode permettant de changer l'image d'un acteur

    /**
     *
     * @param img
     */
     void setImage(Image img);
   
     //méthode permettant de récupérer la position d'un acteur selon l'axe des abscisses sur le plateau

    /**
     *
     * @return
     */
     int getX();

    //méthode permettant de récupérer la position d'un acteur selon l'axe des ordonnées sur le plateau

    /**
     *
     * @return
     */
     int getY();
    
     //méthode permettant de modifier la position d'un acteur selon l'axe des abscisses sur le plateau

    /**
     *
     * @param xx
     */
     void setX(int xx);
    
     //méthode permettant de modifier la position d'un acteur selon l'axe des ordonnées sur le plateau

    /**
     *
     * @param yy
     */
    void setY(int yy);
   
    //méthode permettant de récupérer un rectangle lié à un acteur donné

    /**
     *
     * @return
     */
    Rectangle getBounds();
    
   
}
