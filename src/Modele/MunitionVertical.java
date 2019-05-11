/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public class MunitionVertical implements Acteur, ActionListener {

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
    public MunitionVertical(int xx, int yy){
         
         this.x = xx;
         this.y = yy;
        
        loadImage();
        visible=true;
        
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src/ressources/src/ressources/missile_vertical.png");
        image = ii.getImage(); 
        
        w = image.getWidth(null);
        h = image.getHeight(null);
    }
    
    /**
     *
     */
    public void deplaceMuntionVertical(){
        
        y += Definitions.SPEED;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
