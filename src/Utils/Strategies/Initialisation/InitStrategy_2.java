/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Strategies.Initialisation;

import Modele.Definitions;
import java.util.Random;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
 Deuxieme strategie d'intialisation par defaut
A la difference de la strategie par defaut, elle est caracterisee par la presence des murs uniquements 
aux extremites gauches et droites de la grille
*/
public class InitStrategy_2 implements InitStrategy{
    private int[][] g;
    private int nc;
    private int tab[]; 
    //Positions possibles des murs dans la grille
    private final int[][] posMur ={{2, 3}, {3,3}, {5, 2}, {6,2}, {2,11}, {2,12}, {7,13}, {7,14}, {10,4}, {10,5}, 
                                    {13,12}, {12,12}};
     //Positions possibles des pastilles dans la grille
    private final int[][] posPastille ={{2, 6}, {7, 4}, {5,12}, {13,8}};
    
    /**
     *
     * @param grille
     */
    public InitStrategy_2(int[][] grille){
        this.g = grille;
    }
    
    /**
     *
     * @param n
     */
    @Override
    public void initGrille(int n) {
        this.nc = n;
        int tailleL=g.length;
        int tailleC=g[0].length;
        Random r = new Random();
        int ligne; 
        int colonne;
        
        /* Initialisation des murs a l'interieur de la grille*/
        for (int[] p : posMur) {
            
            g[p[0]][p[1]] = Definitions.MUR;
            
        }
        
        /* Initialisation des pastilles a l'interieur de la grille*/
        for (int[] p : posPastille) {
            
            g[p[0]][p[1]] = Definitions.PASTILLE;
           
        }
   
        /*
        Initialisation des combattants dans la grille
        */
        for (int k=0; k<this.nc; k++){ //parcours de combattant
            ligne = 1+r.nextInt(this.g.length-2);
            colonne =1+ r.nextInt(this.g[0].length-2);
            for (int i=0; i<posMur.length-1; i++){  
               for (int j=0; j<posPastille.length - 1; j++){
                    while (((posMur[i][0] == ligne) && (posMur[i][1] == colonne)) && ((posPastille[j][0] == ligne) && (posPastille[j][1] == colonne))){
                        ligne = 1+r.nextInt(this.g.length-2);
                        colonne =1+ r.nextInt(this.g[0].length-2);
                    } 
                    g[ligne][colonne] = Definitions.COMBATTANT;
                
               }    
            }
          
            
        }
         
        /*
        Initialisation des murs des 2 cotes verticales de la grille
        */
        for(int k=0; k<this.g.length; k++){
            for(int j=0; j<(this.g[0].length); j++){
                g[k][0] = Definitions.MUR; // on place les murs sur chaque ligne de la premiere colonne
                g[k][tailleC-1]=Definitions.MUR; // on place les murs sur chaque ligne de la derniere colonne
            }
        }
    
    }

    
}
