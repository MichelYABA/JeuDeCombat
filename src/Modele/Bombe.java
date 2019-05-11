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

/*Cette classe représente une bombe : ses caractéristiques et ses actions*/
public class Bombe implements Acteur{
    // attribut d'une bombe
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
    public Bombe(int xx, int yy){
        positionBombe(xx, yy);
        loadImage();
        visible=true; // Par défaut la visibilité d'une bombe est à True
        
    }
    
    /**
     *
     * @param actor
     */
    public void explosion(Acteur actor){
       int precX = this.x-1;
       int suivX = this.x+1;
       int precY = this.y-1;
       int suivY = this.y+1;
       
       Boolean isAvantBombe_1 = ((actor.getX() == precX) && (actor.getY() == this.y)); 
       Boolean isAvantBombe_2 = ((actor.getX() == precX) && (actor.getY() == precY));
       Boolean isAvantBombe_3 = ((actor.getX() == precX) && (actor.getY() == suivY));
       Boolean isApresBombe_1 = ((actor.getX() == suivX) && (actor.getY() == this.y));
       Boolean isApresBombe_2 = ((actor.getX() == suivX) && (actor.getY() == precY));
       Boolean isApresBombe_3 = ((actor.getX() == suivX) && (actor.getY() == suivY));
       Boolean isPresBombe_1 = ((actor.getX() == this.x) && (actor.getY() == precY));
       Boolean isPresBombe_2 = ((actor.getX() == this.x) && (actor.getY() == suivY));
       
       if (isAvantBombe_1 || isAvantBombe_2 || isAvantBombe_3 || isApresBombe_1 
               || isApresBombe_2 || isApresBombe_3 || isPresBombe_1 ||isPresBombe_2){
           
           Explosion expl = new Explosion(this.x, this.y);
           this.setVisibilite(false);
       }
   }
    
   //méthode permettant de controler et attribuer les coordonnées d'une bombe
    private void positionBombe(int xx, int yy){
          if ((xx < 2) || (xx < 1))
             xx += Definitions.SPACE;
             
        if ((xx > GrilleGUI.panG.largeurPanneau()-Definitions.SPACE) || (xx > GrilleGUI.panG.largeurPanneau()))
            xx -= Definitions.SPACE;
        
        if ((yy < 2) || (yy<1))
            yy += Definitions.SPACE;
        
        if ((yy > GrilleGUI.panG.hauteurPanneau()-Definitions.SPACE)||  (yy > GrilleGUI.panG.hauteurPanneau())){
                yy-= Definitions.SPACE ;
            }
            
        this.x = xx;
        this.y = yy;
    }
    
    //méthode permettant de récupérer l'image d'une bombe
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon(getClass().getResource("/ressources/bombe.png"));
        //getClass().getResource
       
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
