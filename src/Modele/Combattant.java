/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


import Utils.Observer.ObservableImpl;
import Vue.GrilleGUI;
import Vue.GrillePanel;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
    Classe représentant un combattant sur la grille
*/
public abstract class Combattant extends ObservableImpl implements  Acteur {

    //Attributs de combattant

    /**
     *
     */
    protected Boolean visible;

    /**
     *
     */
    protected String nom;

    /**
     *
     */
    protected int energie;

    /**
     *
     */
    protected int munition;

    /**
     *
     */
    protected String typeArme;

    /**
     *
     */
    protected int x;

    /**
     *
     */
    protected int y;

    /**
     *
     */
    protected int w;

    /**
     *
     */
    protected int h;

    /**
     *
     */
    protected Image imageC;

    /**
     *
     */
    protected int nbreDeTir;

    /**
     *
     */
    protected List<Bombe> listeBombe;

    /**
     *
     */
    protected List<Mine> listeMine;

    /**
     *
     */
    protected List<MunitionHorizontal> munitions;

    /**
     *
     */
    protected List<MunitionVertical> munitionsV;

    /**
     *
     */
    protected List<Bouclier> listeBouclier;

    /**
     *
     */
    protected Boolean bouclier;
    protected int bombe,

    /**
     *
     */

    /**
     *
     */

    /**
     *
     */
    mine,

    /**
     *
     */

    /**
     *
     */

    /**
     *
     */
    bombeDepose=2,

    /**
     *
     */

    /**
     *
     */

    /**
     *
     */
    mineDepose =3;

    /**
     *
     */
    protected  int termine;
    
    /**
     *
     */
    public Combattant(){
        nom = "";
        energie = 50;
        mine = 3;
        bombe = 2;
        bouclier=false;
        munition=0;
        nbreDeTir =0;
        typeArme="";
        munitions = new ArrayList<>();
        munitionsV = new ArrayList<>();
        listeBombe = new ArrayList<>();
        listeMine = new ArrayList<>();
        listeBouclier = new ArrayList<>();
        termine=0;
        loadImage();
        this.setImage(imageC);
        visible=true;
        
    }
    
    //Méthode permettant de vérifier si le bouclier d'un combattant est activé ou pas

    /**
     *
     * @return
     */
    public Boolean isBouclier(){
        return bouclier;
    }
    
    /* Methode permettant de mettre a jour la variable Termine qui s'incremente quand 
    l'energie d'un combattant passe a une valeur inferieure a 0*/

    /**
     *
     * @param t
     */

    public void setTermine(int t){
        termine=t;
    }
    
    /* Methode qui recupere le contenu de la variable Termine*/

    /**
     *
     * @return
     */

    public int getTermine(){
        return termine;
    }
    
    //Méthode permettant de récupérer le nombre de bombe déposé par un combattant

    /**
     *
     * @return
     */
    public int getBombeDepose(){
        return bombeDepose;
    }
    
    // Méthode permettant de mettre à jour le nombre de bombes déposées par un combattant

    /**
     *
     * @param bD
     */
    public void setBombeDepose(int bD){
        bombeDepose = bD;
        notifyChange();
    }
    
    //Méthode permettant de récupérer le total des bombes nécessaires par combattant

    /**
     *
     * @return
     */
    public int getBombe(){
        return bombe;
    }
    
    //méthode permettant de récupérer le total des mines disponibles pour chaque combattant

    /**
     *
     * @return
     */
    public int getMine(){
        return mine;
    }
    
     //méthode permettant de récupérer le nombre total des mines déposées par chaque combattant

    /**
     *
     * @return
     */
    public int getMineDepose(){
        return mineDepose;
    }
    
     //méthode permettant de mettre à jour le nombre de mines déposées 

    /**
     *
     * @param mD
     */
    public void setMineDepose(int mD){
        mineDepose = mD;
        notifyChange();
    }
    
    //méthode permettant de motifier l'état d'un combattant : activé ou désactivé son bouclier

    /**
     *
     * @param bouc
     */
    public void setBouclier(Boolean bouc){
        bouclier = bouc;
        notifyChange();
    }
    
   // Méthode permettant de récupérer le nom d'un combattant

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /* Methode de recuperation de l'energie d'un combattant*/

    /**
     *
     * @return
     */

    public int getEnergie() {
        return energie;
    }

    /* Méthode permettant de récupérer la liste des munitions d'un combattant
    car à chaque tir la munition tirée est ajoutée dans une liste pour les dessiner sur le panneau 
    */

    /**
     *
     * @return
     */

   public List<MunitionHorizontal> getListeMunitions() {
        return munitions;
    }
   
    /**
     *
     * @return
     */
    public List<MunitionVertical> getListeMunitionsV() {
        return munitionsV;
    }
   
   /* Methode de recuperation le nombre total de munition par combattant*/

    /**
     *
     * @return
     */

   public int getMaxMunition(){
       return munition;
   }
   
    /**
     *
     * @return
     */
    public int getMaxMunitionV(){
       return munition;
   }
   
   /* Méthode permettant de récupérer le nombre minimu de munition*/

    /**
     *
     * @return
     */

   public int getMinMunition(){
       return Definitions.MIN_MUNITION;
   }
   
   /* Méthode permettant de charger une image représentant un combattant*/

    /**
     *
     */

    public  abstract void loadImage();
    
    /* Méthode permettant de récupérer le type d'arme du combattant*/

    /**
     *
     * @return
     */

    public String getTypeArme() {
        return typeArme;
    }
    
    /* Méthode permettant de mettre à jour le nom d'un combattant*/

    /**
     *
     * @param nom
     */

    public void setNom(String nom) {
        this.nom = nom;
        notifyChange();
    }
    
    /* Méthode permettant de mettre à jour les munitions d'un combattant*/

    /**
     *
     * @param mun
     */

    public void setMunition(int mun) {
        this.munition = mun;
        notifyChange();
    }
    
    /* Méthode permettant de mettre à jour l'énergie d'un combattant*/

    /**
     *
     * @param energie
     */

    public void setEnergie(int energie) {
        this.energie = energie;
         notifyChange();
    }
    
    /* Méthode permettant de mettre à jour le nombre de bombe possible par combattant*/

    /**
     *
     * @param bomb
     */

    public void setBombe(int bomb) {
        this.bombe = bomb;
         notifyChange();
    }
    
    /* Méthode permettant de mettre à jour le nombre de mine possible par combattant*/

    /**
     *
     * @param min
     */

    public void setMine(int min) {
        this.mine = min;
         notifyChange();
    }
    
   
    /* Méthode permettant de mettre à jour le type d'arme d'un combattant*/

    /**
     *
     * @param typeArme
     */

    public void setTypeArme(String typeArme) {
        this.typeArme = typeArme;
         notifyChange();
    }
    
    /**
     *
     * @param xx
     */
    @Override
    public void setX(int xx){
        x=xx;
        notifyChange();
    }

    /**
     *
     * @param yy
     */
    @Override
    public  void setY(int yy){
        y=yy;
        notifyChange();
    }
    
    /**
     *
     * @return
     */
    @Override
    public  int getX(){
        return x;
    }
    
    /**
     *
     * @return
     */
    @Override
    public  int getY(){
        return y;
    }
    
    /* Méthode permettant de déplacer un combattant*/

    /**
     *
     * @param xx
     * @param yy
     */

    public  void seDeplacer(int xx, int yy){
       
        int dx = this.x + xx;
        int dy= this.y + yy;
        
         for (Mur mur : GrillePanel.grille.listeDeMur()) {
             if (dx == mur.getX() && dy== mur.getY()){
                 dx=this.x ;
                 dy =this.y ;
                 System.out.println("Mur en face. Ne peut se deplacer. Desole");
             }
         }
         
        for (Combattant comb : GrillePanel.grille.listeDeCombattant()) {
             if (dx == comb.getX() && dy== comb.getY()){
                 dx=this.x ;
                 dy =this.y ;
                 System.out.println("Autre combattant. Ne peut se deplacer. Desole");
             }
         }
                 
       if ((dx < 2) || (dx > GrilleGUI.panG.largeurPanneau()-(2*Definitions.SPACE)) || (dx > GrilleGUI.panG.largeurPanneau())){
            dx=this.x ;
            //this.setEnergie(energie +2);
        }
        
        if ((dy < 2) || (dy > GrilleGUI.panG.hauteurPanneau()-(2*Definitions.SPACE))||  (dy > GrilleGUI.panG.hauteurPanneau())) {
            dy =this.y ;
            //this.setEnergie(energie +2);
        }
      
        this.setX(dx);
        this.setY(dy);
         
    }
    
    /* Méthode appelée quand un combattant effectue une action de tir*/

    /**
     *
     */

    public  void tirerH(){
        MunitionHorizontal mun= new MunitionHorizontal(x,y);    
        munitions.add(mun); 
       
    }
    
    /* Méthode appelée quand un combattant effectue une action de tir*/

    /**
     *
     */

    public  void tirerV(){
        MunitionVertical mun= new MunitionVertical(x,y);    
        munitionsV.add(mun); 
       
    }
    
    /**
     *
     * @return
     */
    @Override
    public Boolean estVisible(){
        return visible;
    }
    
    /**
     *
     * @param v
     */
    @Override
    public void setVisibilite(Boolean v){
        visible = v;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Image getImage() {
        return this.imageC;
    }

    /**
     *
     * @param img
     */
    @Override
    public void setImage(Image img) {
        imageC = img;
    }
    
    /* Méthode qui contient la liste des bombes à dessiner sur la grille*/

    /**
     *
     * @return
     */

    public List<Bombe> getListeBombe(){
        return listeBombe;
    }
    
     /* Méthode qui contient la liste des mines à dessiner sur la grille*/

    /**
     *
     * @return
     */

    public List<Mine> getListeMine(){
        return listeMine;
    }
    
     /* Méthode qui contient la liste des boucliers à dessiner sur la grille*/

    /**
     *
     * @return
     */

    public List<Bouclier> getListeBouclier(){
        return listeBouclier;
    }
    
     /* Méthode appelée pour déposer une bombe sur la grille */

    /**
     *
     */

    public void deposerBombe(){
        
        Bombe bomb = new Bombe(x+Definitions.SPACE,y+Definitions.SPACE);
        listeBombe.add(bomb);
           
    }
    
     /* Méthode appelée pour déclencher le bouclier d'un combattant*/

    /**
     *
     */

    public void declencherBoublier(){
       
        if (bouclier ==true){
            ImageIcon ii = new ImageIcon("src/ressources/dot.png");
            Image imageB = ii.getImage(); 
        
            this.setImage(imageB);
            this.setEnergie(this.energie - 2);
        }
        
    }
     
     /* Méthode appelée pour déposer une mine sur la grille*/

    /**
     *
     */

    public void deposerMine(){
        
        Mine mine = new Mine(x+Definitions.SPACE,y+Definitions.SPACE);
        listeMine.add(mine);
            
       
    }
    
    /* Méthode qui récupère le nombre de tir effectué par un combattant*/

    /**
     *
     * @return
     */

    public int getNombreDeTir(){
        return nbreDeTir;
    }
    
     /* Méthode qui met à jour les tirs effectués par un combattant*/

    /**
     *
     * @param tir
     */

    public void setNombreDeTir(int tir){
        nbreDeTir =tir;
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
