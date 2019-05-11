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
 * @author yaba
 */

/*
Classe representant un bouclier
*/
public class Bouclier implements Acteur{
    //attributs d'un bouclier
    private Boolean visible;
    private int x;
    private int y;
    private int h;
    private int w;
    private Image imageB;
    
    /**
     *
     * @param xx
     * @param yy
     */
    public Bouclier(int xx, int yy){
        
        this.x = xx;
        this.y=yy;
        loadImage();
        visible=true;
    }
    
    //méthode permettant de charger l'image du bouclier depuis les ressources
    private  void loadImage() {
        //g.setColor(Color.BLACK);
        ImageIcon ii = new ImageIcon("src/ressources/dot.png");
        imageB = ii.getImage(); 
        
        w = imageB.getWidth(null);
        h = imageB.getHeight(null);
    }

    /**
     *
     * @return
     */
    @Override
    public Boolean estVisible() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return visible;
    }

    /**
     *
     * @param v
     */
    @Override
    public void setVisibilite(Boolean v) {
        visible = v;
    }

    /**
     *
     * @return
     */
    @Override
    public Image getImage() {
        return imageB;
    }

    /**
     *
     * @param img
     */
    @Override
    public void setImage(Image img) {
        this.imageB = img;
    }

    /**
     *
     * @return
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     *
     * @param xx
     */
    @Override
    public void setX(int xx) {
        x = xx;
    }

    /**
     *
     * @param yy
     */
    @Override
    public void setY(int yy) {
        y = yy;
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
