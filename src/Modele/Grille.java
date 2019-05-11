/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Utils.Strategies.Initialisation.ContextInit;
import Utils.Factories.UsineDeCombattant;
import Utils.Factories.Fabrique_1;
import Utils.Strategies.Initialisation.InitStrategy_2;
import Utils.Strategies.Initialisation.InitStrategy_3;
import Utils.Observer.Observable;
import Utils.Observer.Observer;
import Utils.Observer.ObservableImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Utils.Strategies.Initialisation.InitStrategy;


/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
Classe représentant la grille, autrement le plateau de jeu
*/
public class Grille extends ObservableImpl  implements  Observer, GroupeElement{
    /* Caractéristiques d'une grille */
    private int lignes;
    private int colonnes;
    private int nbre_combattant;
    private Mur mur;
    private Case case_vide;
    private Combattant comb;
    private Pastille past;
    private List<Combattant> combattants;
    private List<Pastille> pastilles;
    private List<Case> listeCase;
    private List<Mur> murs;

    /**
     *
     */
    public static int[][] grille;   
    Scanner sc = new Scanner(System.in); 
    private int nb_combattant;
    private InitStrategy strat; 
    private int w = 0;
    private int h = 0;
    private ContextInit context;
    private UsineDeCombattant usine;
    int x = 0;//OFFSET=30;
    int y = 0;
   
    /**
     *
     */
    public Grille(){
    
    }
    
    /**
     *
     * @param l
     * @param c
     * @param com
     */
    public Grille(int l, int c, int com){
        this.combattants = new ArrayList();
        this.murs = new ArrayList();
        this.pastilles= new ArrayList();
        this.listeCase = new ArrayList();
        lignes=l;
        colonnes=c;
        nb_combattant=com;
        grille = new int [lignes][colonnes];
        context = new ContextInit(grille); 
        initialiserGrille();
        afficheGrille();
        
    }
    
    /**
     *
     * @param s
     */
    public Grille(InitStrategy s){
        this.strat = s;
 
    }
    
    // Méthode qui récupère la grille

    /**
     *
     * @return
     */
    public int[][] getGrille(){
        return grille;
    }
    
    // Méthode récuperant le nombre de lignes

    /**
     *
     * @return
     */
    public int getLignes(){
        return lignes;
    }
    
    // Méthode récuperant le nombre de colonnes

    /**
     *
     * @return
     */
    public int getColonnes(){
        return colonnes;
    }
    
    // Cette méthode permet de récupérer la liste des combattants

    /**
     *
     * @return
     */
    public List<Combattant> listeDeCombattant(){
        return combattants;
    }
    
    // Cette méthode récupère la liste des murs

    /**
     *
     * @return
     */
    public List<Mur> listeDeMur(){
        return murs;
    }
    
    // Cette méthode récupère la liste des pastilles 

    /**
     *
     * @return
     */
    public List<Pastille> listeDePastille(){
        return pastilles;
    }
    
      //Cette méthode récupère la liste des cases vides

    /**
     *
     * @return
     */
    public List<Case> listeDeCase(){
          return listeCase;
    }
    
    /*On récupère le nombre total des combattants*/

    /**
     *
     * @return
     */

    @Override
    public int getSizeCombattant(){
        return combattants.size();
    }
    
    /*On récupère le nombre total des pastilles*/

    /**
     *
     * @return
     */

    @Override
    public int getSizePastille(){
        return pastilles.size();
    }
    
    /*On récupère la taille du tableau contenu tous les murs*/

    /**
     *
     * @return
     */

    @Override
    public int getSizeMur(){
        return murs.size();
    }
    
    /* on récupère un élément de la liste des combattants*/

    /**
     *
     * @param i
     * @return
     */

    @Override
    public Combattant getCombattant(int i){
        return combattants.get(i);
    }
    
      /* on récupère un élément de la liste des murs*/

    /**
     *
     * @param i
     * @return
     */

    @Override
    public Mur getMur(int i){
        return murs.get(i);
    }
    
      /* on récupère un élément de la liste des pastilles*/

    /**
     *
     * @param i
     * @return
     */

    @Override
    public Pastille getPastille(int i){
        return pastilles.get(i);
    }
    
    /*On récupère la taille du tableau contenu toutes les cases vides*/

    /**
     *
     * @return
     */

    @Override
    public int getSizeCase() {
        return listeCase.size();
    }

    // On récupère une case donnée

    /**
     *
     * @param i
     * @return
     */
    @Override
    public Case getCase(int i) {
        return listeCase.get(i);
    }

    /*
    Méthode permettant de créer la grille avec des cases vides
    */

    /**
     *
     * @param g
     */

    public void creerGrille(int[][] g){
        
        for (int i=0; i<g.length; i++){ //lignes
            for(int j=0; j<g[i].length; j++){ //colonnes
                g[i][j] = Definitions.CASE;
            }
        }
        
    }
    
    /*
    Cette méthode affiche la grille en console
    */

    /**
     *
     */

    public void afficheGrille(){
        System.out.println();
        for (int[] lignes : grille){
            
            System.out.print(" |");
            for (int cellule : lignes) {
                switch (cellule) {
                    case Definitions.CASE:
                        System.out.print(' ');
                        break;
                    case Definitions.PASTILLE:
                        System.out.print('0');
                        break;
                    case Definitions.COMBATTANT:
                        System.out.print('C');
                        break;
                    case Definitions.MUR:
                        System.out.print('#');
                        break;
                    default:
                        System.out.print('X');
                        break;
                }
                System.out.print("|");
            }
             System.out.println();
        } 
    }
    
    /*
    Cette méthode intialise la grille avec les murs, les pastilles et les combattants
    */

    /**
     *
     */

    public void initialiserGrille(){
         creerGrille(grille);
        
        int choix =(int)(Math.random()*(3));
        
        System.out.println("choix de strategie: "+ choix);
         
       switch (choix) {
            case 0:
                context.setStrategie(new InitStrategy_2(grille));
                context.initialiserGrille(nb_combattant);
                break;
            case 1:
                context.setStrategie(new InitStrategy_3(grille));
                context.initialiserGrille(nb_combattant);
                break;
            default:
               
                context.initialiserGrille(nb_combattant);
                break;
        }
        defGrille();
    }
    
    /*
    Cette méthode fait le pont vers la représentation de la grille en mode graphique
    */

    /**
     *
     */

    public void defGrille(){

        int typeCombattant, attX=0, attY=0;
         
        for (int i=0; i<grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                int item = grille[i][j];
                   
                switch (item) {
                    case Definitions.CASE:
                        case_vide = new Case(x,y);
                        listeCase.add(case_vide);
                        
                        x += Definitions.SPACE;
                        
                        break;
                    case Definitions.COMBATTANT:
                         
                        typeCombattant =(int)(Math.random()*(nb_combattant));
                        
                        usine = new UsineDeCombattant(new Fabrique_1());
                        // En fonction du nombre aléatoire choisi, on peut créer 2 types de combattants
                        comb = usine.creeCombattant(typeCombattant); //creation du combattant
                        System.out.println("Combattant : "+typeCombattant); 
                        if (typeCombattant==2){
                            attX++;
                            comb.setNom(comb.getNom()+"_"+attX);
                        }    
                        else{
                            attY++;
                            comb.setNom(comb.getNom()+"_"+attY);
                        }
                        //Mis à jour des coordonnées du combattant
                        comb.setX(x);
                        comb.setY(y);
                        combattants.add(comb); //on ajoute un combattant dans une liste
                        comb.addObservateur(this);
                        notifyChange();
                       x += Definitions.SPACE;
                        break;
                    case Definitions.MUR:
                        mur = new Mur(x,y);
                        murs.add(mur);
                        x += Definitions.SPACE;
                        break;
                    case Definitions.PASTILLE:
                        past = new Pastille(x,y);
                        pastilles.add(past);
                        x += Definitions.SPACE;
                        break;
                   
                }
                
            }
            y+=Definitions.SPACE;
            if (this.w<x)
                this.w=x; // on récupère la largeur de la grille en sorte qu'elle soit adaptable
            x=0;
        }
        
        h=y; // on récupère la hauteur de la grille en sorte qu'elle soit adaptable

    }
    
   /*
    Méthode utilisée au départ pour la saisie des lignes en console
    */
    
    private void saisieLignes(){
         do{
            System.out.println("Veuillez saisir le nombre de ligne :");
            lignes = sc.nextInt();
            
            if (lignes<15){
                System.out.println("\n Choisir au minimum 15 lignes \n");
                
            }
            
        }while(lignes <15);
        
    }
    
    /*
    Méthode utilisée au départ pour la saisie des colonnes en console
    */  
    
    private void saisieColonnes(){
        do{    
            System.out.println("Veuillez saisir le nombre de colonne :");
            colonnes = sc.nextInt();
            
            if (colonnes<15){
                System.out.println("\n Choisir au minimum 15 colonnes \n");
               
            }
           
        }while(colonnes <15);
    }
    
     /*
    Méthode utilisée au départ pour la saisie des combattants en console
    */ 
    private void saisieCombattants(){
       
         do{
            System.out.println("Veuillez saisir le nombre de combattants :");
            nbre_combattant = sc.nextInt();
            
            if (nbre_combattant <2)
                System.out.println("\n Tu dois choisir au minimum 2 combattants \n");
        }while(nbre_combattant <2);
         //return nc;
    }
    
    /*
    Cette méthode permet de récupérer la largeur de la grille
    */

    /**
     *
     * @return
     */

     public int getBoardWidth() {
        return w;
    }
      /*
    Cette méthode permet de récupérer la hauteur de la grille
    */

    /**
     *
     * @return
     */

    public int getBoardHeight() {
        return h;
    }

    /**
     *
     * @param obs
     */
    @Override
    public void update(Observable obs) {
      
        notifyChange();
        
    }
    
    
}
