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
    Cette classe représente une case sur la grille : ses coordonnées et ses actions
*/
public class Case implements Acteur{
    //attributs d'une case
    private int x;
    private int y, w, h;
    private Image image;
    private Boolean visible;
    int SPACE=20;
    
    /**
     *
     * @param xx
     * @param yy
     */
    public Case(int xx, int yy){
        //super(x,y);
        this.x=xx;
        this.y=yy;
        
        loadImage();
        
        visible=true;
    }
    
    //méthode permettant de charger une image depuis les ressources
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src/ressources/0.png");
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
     * @param xx
     */
    @Override
    public void setX(int xx) {
        this.x = xx;
    }

    /**
     *
     * @param yy
     */
    @Override
    public void setY(int yy) {
        this.y = yy;
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
     * @return
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    
   

}
