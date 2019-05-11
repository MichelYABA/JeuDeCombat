/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javax.swing.table.AbstractTableModel;

import Utils.Observer.Observable;
import Utils.Observer.Observer;


/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

/*
Cette classe fournit les données nécessaires à l'alimentation du tableau
*/
public class TableInfosCombattant extends AbstractTableModel implements Observer {
    private final static int NB_CHAMPS = 6;
    
    private final static int Nom = 0;
    private final static int Energie = 1;
    private final static int Arme = 2;
    private final static int Munition = 3;
    private final static int Bombe = 4;
    private final static int Mine = 5;
    
    
    private final static String[] COL_NAME;

    static {
        COL_NAME = new String[NB_CHAMPS];
        COL_NAME[Nom] = "Nom";
        COL_NAME[Energie] = "Energie";
        COL_NAME[Arme] = "Arme";
        COL_NAME[Munition] = "Munitions";
       COL_NAME[Bombe] = "Bombes";
        COL_NAME[Mine] = "Mines";
    }

    private Grille grille;

    /**
     *
     * @param g
     */
    public TableInfosCombattant(Grille g) {
        this.grille = g;
        grille.addObservateur(this);
        
    }

    @Override
    public int getRowCount() {
        return grille.getSizeCombattant();
    }

    @Override
    public int getColumnCount() {
        return NB_CHAMPS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Modele.Combattant comb = grille.getCombattant(rowIndex);
        switch (columnIndex) {
            case Nom:
                return comb.getNom();
            case Energie:
                return comb.getEnergie();
            case Arme:
                return comb.getTypeArme();
            case Munition:
                return comb.getMaxMunition();
            case Bombe:
                return comb.getBombe();
            case Mine:
                return comb.getMine();
        }
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return COL_NAME[col];
    }

    
    // Important : on adapte aussi la partie événeme

    /**
     *
     * @param obs
     */
    @Override
    public void update(Observable obs) {
        fireTableDataChanged();
    }

}
