/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import Controller.ControleurGrille;
import Modele.Combattant;
import Modele.Grille;
import Modele.MunitionHorizontal;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import Modele.Acteur;
import Modele.Bombe;
import Modele.Bouclier;
import Modele.Mine;
import Modele.MunitionVertical;
import Modele.Mur;
import Modele.Pastille;
import Utils.Strategies.Jeu.ContextGame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public class GrillePanel extends JPanel implements ActionListener{
    /* Attributs de la classe GrillePanel*/

    /**
     *
     */

    public static Grille grille;
    private Combattant combattant;
    private List<MunitionHorizontal> munitions;

    /**
     *
     */
    public static Timer combTimer;
    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 300;
    private Boolean jeuEnCours;
    private final Random r = new Random();
    private List<Bombe> bombes;
    private List<Mine> mines;
    private List<Bouclier> boucliers;
    private  int combattantCourant;
    private ArrayList listeActeurs;
    private ControleurGrille controleur;
    private int nbreCombattantTermine =0;
    private String msg2;
    private List<MunitionVertical> munitionsV;
    private final ControleurGrille controlG;
    private final ContextGame contexte;
    
    /**
     *
     * @param Cgril
     */
    public GrillePanel(ControleurGrille Cgril){
        controlG = Cgril;
        setFocusable(true);
        setDoubleBuffered(true);
        
        jeuEnCours=true;
        
        grille = controlG.getGrille();
        
        contexte = new ContextGame(grille);
        combTimer = new javax.swing.Timer(1000, this);
        
        combTimer.start();
    }
    
    /**
     *
     * @param g
     */
    public void buildWorld(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        listeActeurs = new ArrayList();
        
        listeActeurs.addAll(grille.listeDeCombattant());
        listeActeurs.addAll(grille.listeDeCase());
        listeActeurs.addAll(grille.listeDeMur());
        listeActeurs.addAll(grille.listeDePastille());


        for (int i = 0; i < listeActeurs.size(); i++) {

            Acteur item = (Acteur) listeActeurs.get(i);
                     
            if (item instanceof Combattant) {
                
                if (item.estVisible()==true && ((Combattant) item).isBouclier() == false){ //représentation du combattant sans bouclier
                    //g.setColor(Color.GREEN);
                    g.drawImage(item.getImage(), item.getX() + 2, item.getY() + 2, this);
                    String msg = ((Combattant) item).getNom();
                    Font small = new Font("Helvetica", Font.BOLD, 14);
                    FontMetrics fm = getFontMetrics(small);

                    g.setColor(Color.white);
                    g.setFont(small);

                    g.drawString(msg, item.getX()+2, item.getY() + 2);
                } else if (item.estVisible()==true && ((Combattant) item).isBouclier() == true){ // représentation du combattant avec bouclier
                    //((CombattantBis) item).declencherBoublier();
                    ImageIcon ii = new ImageIcon("src/ressources/dot.png");
                    Image imageB = ii.getImage(); 
                    
                    item.setImage(imageB);
                    
                    g.drawImage(item.getImage(), item.getX() + 2, item.getY() + 2, this);
                    String msg = ((Combattant) item).getNom();
                    
                    Font small = new Font("Helvetica", Font.BOLD, 14);
                    FontMetrics fm = getFontMetrics(small);
                    
                    g.setColor(Color.white);
                    g.setFont(small);
                    
                    g.drawString(msg, item.getX()+2, item.getY() + 2);
                }
               
            } else if (item instanceof Mur){
                if (item.estVisible() == true)
                    g.drawImage(item.getImage(), item.getX(), item.getY(), this);
                
            } else if (item instanceof Pastille){
                if (item.estVisible() == true)
                    g.drawImage(item.getImage(), item.getX(), item.getY(), this);
            }/*else if (item instanceof Case){
                 if (item.estVisible() == true)
                    g.drawImage(item.getImage(), item.getX(), item.getY(), this);
            }*/
        }
        
        // dessin des bombes sur la grille
        for(int k=0; k<grille.listeDeCombattant().size(); k++){
            combattant = grille.listeDeCombattant().get(k);
            bombes=combattant.getListeBombe();
            
            for (Bombe b : bombes){
                if (b.estVisible()==true)
                    g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }    
        
        // dessin des mines sur la grille
        for(int m=0; m<grille.listeDeCombattant().size(); m++){
            combattant = grille.listeDeCombattant().get(m);
            mines=combattant.getListeMine();
            
            for (Mine min : mines){
                if (min.estVisible())
                    g.drawImage(min.getImage(), min.getX(), min.getY(), this);
            }
        }   
            
        //dessin des tirs horizontals sur la grille
        for(int j=0; j<grille.listeDeCombattant().size(); j++){
            combattant = grille.listeDeCombattant().get(j);
            munitions = combattant.getListeMunitions();

            for (MunitionHorizontal mun : munitions) {
                if (mun.estVisible()==true) 
                    g.drawImage(mun.getImage(), mun.getX(), mun.getY(), this);

            }
        }
        
        //dessin des tirs verticales sur la grille
        for(int j=0; j<grille.listeDeCombattant().size(); j++){
            combattant = grille.listeDeCombattant().get(j);
            munitionsV = combattant.getListeMunitionsV();

            for (MunitionVertical mun : munitionsV) {
                if (mun.estVisible()==true) 
                    g.drawImage(mun.getImage(), mun.getX(), mun.getY(), this);

            }
        }
        
    }
    
    /* Méthode qui dessine qui afficheGrille le message qui indique que le jeu est terminé*/
    private void drawGameOver(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        String msg = "GAME OVER";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(small);
        msg2 = "Vainqueur = ";
        g.setColor(Color.red);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2, B_HEIGHT / 2);
       
    }
    
    /* Méthode permettant de récupérer la largeur du panneau*/

    /**
     *
     * @return
     */

    public int largeurPanneau(){
        return grille.getBoardWidth();
    }
    
    /* Méthode permettant de récupérer la hauteur du panneau*/

    /**
     *
     * @return
     */

    public int hauteurPanneau(){
        return grille.getBoardHeight();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (jeuEnCours)
            buildWorld(g);
        else
            drawGameOver(g);
        Toolkit.getDefaultToolkit().sync();
    }
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        int n=grille.getSizeCombattant();
        combattantCourant = r.nextInt(n);
        
        System.out.println("Combattant "+combattantCourant);
        
        updateAction(combattantCourant);
        
        verifieCollision(combattantCourant);
        
        repaint();
    }
    
    
    /*
       Methode qui gere les deplacements aleatoire d'un combattant
    */
    private void updateAction(int alea){

        combattant = grille.listeDeCombattant().get(alea);
                  
        contexte.actionJeu(combattant);
         
        if (combattant.getTermine() ==1){
            nbreCombattantTermine +=1;
            System.out.println("=========================================Termine : "+nbreCombattantTermine);
        }
            
        if (nbreCombattantTermine == grille.listeDeCombattant().size() -1){
            jeuEnCours = false;
            msg2 += (grille.listeDeCombattant().get(alea).getEnergie() >0) ? combattant.getNom() : "";
            combTimer.stop();
        }
                    
    }
    
    /* Methode qui verifie des collisions entre les differents elements qui sont sur le plateau*/
    private void verifieCollision(int Naleatoire){
        controlG.verificationCollisions(Naleatoire);
    }
    
   
}
