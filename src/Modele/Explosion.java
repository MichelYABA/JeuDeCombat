/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author yaba
 */
/*
Classe permettant de représenter une explosion
*/
public class Explosion implements Acteur{
    private Boolean visible;
    private int x;
    private int y;
    private int h;
    private int w;
    private Image imageB;
    Timer t ;
    
    /**
     *
     * @param xx
     * @param yy
     */
    public Explosion(int xx, int yy){
       // t = new Timer(15, this);
        this.x = xx;
        this.y=yy;
        loadImage();
        visible=true;
    }
    
    /**
     *
     */
    public  void loadImage() {
        //g.setColor(Color.BLACK);
        ImageIcon ii = new ImageIcon("src/ressources/12.png");
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
