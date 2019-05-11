/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modele.Bombe;
import Modele.Combattant;
import Modele.Grille;
import Modele.Mine;
import Modele.MunitionHorizontal;
import Modele.Mur;
import Modele.Pastille;
import java.awt.Rectangle;
import java.util.List;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
    Controleur destinée à l'interface de jeu
*/
public class ControleurGrille {
    private Grille grille;
    
    /**
     *
     * @param g
     */
    public ControleurGrille(Grille g){
        grille = g;
    }
    
    /*
    Méthode permettant de récupérer la grille
    */

    /**
     *
     * @return
     */

    public Grille getGrille(){
        return grille;
    }

    /*
    Méthode permettant de vérifier s'il y'a des collisisons entre les murs, combattants, pastilles et autres
    */

    /**
     *
     * @param alea
     */

    public void verificationCollisions(int alea) {
        Combattant cbta = grille.listeDeCombattant().get(alea);
        Rectangle r3 = cbta.getBounds();
        
        // Collision entre une pastille et un combattant
        for (Pastille past : grille.listeDePastille()) {
            
            Rectangle r2 = past.getBounds();

            if (r3.intersects(r2)) {
                
                cbta.setVisibilite(true);
                past.setVisibilite(false);
                //ingame = false;
            }
        }
              
        //collision entre une munition et un combattant
        List<MunitionHorizontal> ms = cbta.getListeMunitions();

        for (MunitionHorizontal m : ms) {
            
            Rectangle r1 = m.getBounds();

            for (Combattant comb : grille.listeDeCombattant()) {

                Rectangle r2 = comb.getBounds();

                if (r1.intersects(r2)) {
                 
                    comb.setEnergie(comb.getEnergie() - 2);
                    System.out.println("touche : "+comb.getEnergie());
                }
            }
        }
        
         //collision entre une bombe et un mur
        List<Bombe> Listebomb = cbta.getListeBombe();
        
        for (Bombe bomb : Listebomb){
            Rectangle r7 = bomb.getBounds();
            
            for (Mur mur : grille.listeDeMur()){
                
                Rectangle r8 = mur.getBounds();
                
                if (r7.intersects(r8)){
                    //bomb.seDeplacer(-SPACE, 0);
                    bomb.setVisibilite(false);
                }
            }
            
        }
        
         //collision entre une mine et un mur
         
        List<Mine> ListeMine = cbta.getListeMine();
        
        for (Mine mine : ListeMine){
            Rectangle r9 = mine.getBounds();
            
            for (Mur mur : grille.listeDeMur()){
                
                Rectangle r10 = mur.getBounds();
                
                if (r9.intersects(r10)){
                    //mine.seDeplacer(-SPACE, 0);
                    mine.setVisibilite(false);
                }
            }
            
        }
        
        // collision possible entre une mine et une pastille
        for (Pastille p : grille.listeDePastille()){
            Rectangle rect = p.getBounds();
            
            for (Mine min : cbta.getListeMine()){
                Rectangle rect1 = min.getBounds();
                
                if (rect.intersects(rect1)){
                    min.setVisibilite(false);
                    cbta.setMineDepose(cbta.getMineDepose() + 1);
                    p.setVisibilite(false);
                }
            }
        }
        
        // Coollision entre une pastille et une bombe
        for (Pastille p : grille.listeDePastille()){
            Rectangle rect2 = p.getBounds();
            
            for (Bombe bo : cbta.getListeBombe()){
                Rectangle rect3 = bo.getBounds();
                
                if (rect2.intersects(rect3)){
                    bo.setVisibilite(false);
                    cbta.setBombeDepose(cbta.getBombeDepose() + 1);
                    p.setVisibilite(false);
                }
            }
        }
        
        
        //Collision entre une mine et une bombe
        for (Mine mine : ListeMine){
            Rectangle r11 = mine.getBounds();
            
            for (Bombe b : cbta.getListeBombe()){
                
                Rectangle r12 = b.getBounds();
                
                if (r11.intersects(r12)){ // Au contact de la bombe d'avec la mine les 2 disparaissent du plateau
                    //mine.seDeplacer(SPACE, 0);
                    mine.setVisibilite(false);
                    b.setVisibilite(false);
                }
            }
            
        }
        
        //collision entre une munition et un mur
        for (MunitionHorizontal m : ms) {

            for (Mur mur : grille.listeDeMur()) {

               if ((m.getX() == mur.getX()) && (m.getY() == mur.getY())){ //Au contact de la munition du mur, la munition disparait
                    
                    m.setVisibilite(false); 
               }
            }
        }
        
        // collision entre un combattant et une bombe
        for (Bombe b : cbta.getListeBombe()) {
            
            for (Combattant comb : grille.listeDeCombattant()){
               //Au contact de la munition du mur, la munition disparait
                    if ((b.getX() == comb.getX()) && (b.getY() == comb.getY())){
                         b.setVisibilite(false);
                         cbta.setEnergie(cbta.getEnergie() - 2);
                   }

               
            }
        }
        
         // collision entre un combattant et une mine
        for (Mine m : cbta.getListeMine()) {
            
            for (Combattant comb : grille.listeDeCombattant()){
               
                    if ((m.getX() == comb.getX()) && (m.getY() == comb.getY())){
                         m.setVisibilite(false);
                         cbta.setEnergie(cbta.getEnergie() - 2);
                   }

               
            }
        }
        
      
        
     }
     
}
