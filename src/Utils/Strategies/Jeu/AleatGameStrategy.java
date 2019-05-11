/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Strategies.Jeu;

import Modele.Combattant;
import Modele.Definitions;
import Modele.Grille;
import Modele.MunitionHorizontal;

import java.util.List;
import java.util.Random;

/**
 *
 * @author yaba
 */
public class AleatGameStrategy implements GameStrategy{

    private List<MunitionHorizontal> munitions;
    private Grille g;

    AleatGameStrategy(Grille grille) {
        g = grille;
    }

    /**
     *
     * @param combattant
     */
    @Override
    public void actionCombattant(Combattant combattant) {
        Random r = new Random();
        int nbreAlea = r.nextInt(8); 
        
        System.out.println("======>Action : "+nbreAlea);
        
                if (combattant.getEnergie() > 0){
            switch (nbreAlea) {
              
                case 0: // deplacement a gauche   
                    
                        deplacementAGauche(combattant);
                         System.out.println("=====> Deplacement a gauche ");
                        System.out.println("==> Position : ("+combattant.getX()+","+combattant.getY()+")");
                    
                    break;
                case 1: // deplacement a droite
                    
                        deplacementADroite(combattant);
                        System.out.println("==> Position : ("+combattant.getX()+","+combattant.getY()+")");
                        System.out.println("=====> Deplacement a droite ");
                    
                    break;
                case 2: // deplacement en haut
                     
                        deplacementEnHaut(combattant);
                        System.out.println("==> Position : ("+combattant.getX()+","+combattant.getY()+")");
                        System.out.println("=====> Deplacement en haut ");
                     
                    break;
                case 3: //deplacement en bas
                   
                        deplacementEnBas(combattant);
                        System.out.println("==> Position : ("+combattant.getX()+","+combattant.getY()+")");
                        System.out.println("=====> Deplacement en bas ");
                    

                    break;
                case 4: // tirerH horizontalement
                    
                        if (combattant.getNombreDeTir() > combattant.getMinMunition() && combattant.getNombreDeTir()<=combattant.getMaxMunition()){
                           updateMunitionHorizontal(combattant);
                           combattant.setNombreDeTir(combattant.getNombreDeTir()-1);
                           combattant.setMunition(combattant.getNombreDeTir());
                        }  
                   

                    break;
                case 5: // deposer bombe
                    
                        if(combattant.getBombeDepose() > Definitions.MIN_BOMBE && combattant.getBombeDepose() <= Definitions.MAX_BOMBE){
                             updateBombe(combattant);
                             combattant.setBombeDepose(combattant.getBombeDepose() - 1);
                             combattant.setBombe(combattant.getBombeDepose());
                        
                        }
                    
                    break;
                case 6: //deposer Mine
                    
                        if(combattant.getMineDepose() > Definitions.MIN_MINE && combattant.getMineDepose() <= Definitions.MAX_MINE){
                           updateMine(combattant);
                           combattant.setMineDepose(combattant.getMineDepose() - 1);
                           combattant.setMine(combattant.getMineDepose());
                        }
                    break;
                case 7: // tirerH verticalement
                    
                        if (combattant.getNombreDeTir() > combattant.getMinMunition() && combattant.getNombreDeTir()<=combattant.getMaxMunition()){
                           combattant.tirerV();
                           combattant.setNombreDeTir(combattant.getNombreDeTir()-1);
                           combattant.setMunition(combattant.getNombreDeTir());
                        }
                        break;
                 }   

            }else if (combattant.getEnergie() <= 0){
                combattant.setVisibilite(false);
                combattant.setTermine(combattant.getTermine() + 1);
                
            }
    }
    
     /* Methode appelee pour tirer horizontalement*/
     private void updateMunitionHorizontal(Combattant combattant) {
        
        combattant.tirerH();
        
        munitions = combattant.getListeMunitions();
            
        for (int i = 0; i < munitions.size(); i++) {
            MunitionHorizontal munition = munitions.get(i);
                
            if(munition.estVisible()==true)
                munition.deplacerMunitionHorizontal();
            else
                    munitions.remove(i);
               
        }
        
    }
     
       /* Methode appelee lors du depot d'une bombe*/
    private void updateBombe(Combattant combat){
         combat.deposerBombe();
    }
    
    /* Methode appelee lors du declenchement du bouclier*/
    private void updateBouclier(Combattant combat){
       
        combat.setBouclier(true);
      
    }
    
    /* Methode appelee lors du depot d'une mine*/
    private void updateMine(Combattant combat){
         combat.deposerMine();
    }
    
     /* Methode appelee lors du deplacement a gauche */
    private void deplacementAGauche(Combattant cbta){
        
        cbta.seDeplacer(-Definitions.SPACE, 0);
        cbta.setEnergie(cbta.getEnergie() - 1);
        
    }
    
     /* Methode appelee lors du deplacement a droite */
    private void deplacementADroite(Combattant cbta){
      
        cbta.seDeplacer(Definitions.SPACE, 0);
        cbta.setEnergie(cbta.getEnergie() - 1);
              
    }
    
    /* Methode appelee lors du deplacement en haut */
    private void deplacementEnHaut(Combattant cbta){
 
            cbta.seDeplacer(0, Definitions.SPACE);
            cbta.setEnergie(cbta.getEnergie() - 1);  
            
    }
    
    /* Methode appelee lors du deplacement en bas*/
    private void deplacementEnBas(Combattant cbta){

            cbta.seDeplacer(0, -Definitions.SPACE);
            cbta.setEnergie(cbta.getEnergie() - 1);
           
    }
    
    
}
