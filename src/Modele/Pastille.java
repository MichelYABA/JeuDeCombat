/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
Cette classe représente une pastille dans la grille
*/
public class Pastille implements Acteur{
    // Caractéristiques d'une pastilles
    private int x;
    private int y, w, h;
    private Image image;
    private Boolean visible;
    
    /**
     *
     * @param xx
     * @param yy
     */
    public Pastille(int xx, int yy){
      
        this.x=xx;
        this.y=yy;
        
        loadImage();
        
        visible = true;
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon(getClass().getResource("/ressources/baggage.png"));
        image = ii.getImage(); 
        
        w = image.getWidth(null);
        h = image.getHeight(null);
    }
    
    /**
     *
     * @return
     */
    @Override
    public Image getImage() {
        return this.image;
    }

    /**
     *
     * @param img
     */
    @Override
    public void setImage(Image img) {
        image = img;
    }

    /**
     *
     * @return
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     *
     * @return
     */
    @Override
    public int getY() {
        return this.y;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Boolean estVisible() {
        return visible;
    }

    /**
     *
     * @param v
     */
    @Override
    public void setVisibilite(Boolean v) {
        this.visible=v;
    }

    /**
     *
     * @param xx
     */
    @Override
    public void setX(int xx) {
        x=xx;
    }

    /**
     *
     * @param yy
     */
    @Override
    public void setY(int yy) {
        y=yy;
    }

    /**
     *
     * @return
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);   
    }

   
}
