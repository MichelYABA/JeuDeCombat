/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Vue.GrilleGUI;
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

public class Mine implements Acteur{
    private Image image;
    private int w;
    private int h;
    private int x, y;
   
    private Boolean visible ;
    
    /**
     *
     * @param xx
     * @param yy
     */
    public Mine(int xx, int yy){
        
        positionMine(xx, yy);
        //initMissile();
        loadImage();
        visible=true;
        
    }
    
     private void positionMine(int xx, int yy){
         if ((xx < 2) || (xx < 1))
             xx += 20;
             
        if ((xx > GrilleGUI.panG.largeurPanneau()-20) || (xx > GrilleGUI.panG.largeurPanneau()))
            xx -= 20;
        if ((yy < 2) || (yy<1))
            yy +=20;
        
        if ((yy > GrilleGUI.panG.hauteurPanneau()-20)||  (yy > GrilleGUI.panG.hauteurPanneau())){
                yy-=20 ;
            }
        
           
            
        this.x = xx;
        this.y = yy;
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon(getClass().getResource("/ressources/alien.png"));
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
        return image;
    }

    /**
     *
     * @param img
     */
    @Override
    public void setImage(Image img) {
        this.image = img;
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
        visible = v;
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

    /**
     *
     * @param xx
     * @param yy
     */
    public  void seDeplacer(int xx, int yy){
        
        int dx = this.x + xx;
        int dy= this.y + yy;
        
        this.setX(dx);
        this.setY(dy);
            
    }

    
}
