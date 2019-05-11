/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Observer;

import java.util.ArrayList;

/**
 *
 * @author yaba bilongo michel davel - 21713717
 * @author diallo mamadou bobo - 21713853
 * @author mpassi matondo desty hermann exauce - 21711427
 * @author kourouma jean faya - 21812905
 */

public class ObservableImpl implements Observable{
    
    private ArrayList<Observer> observers;
    
    /**
     *
     */
    public ObservableImpl(){
        
        observers = new ArrayList<>();
    }

    /**
     *
     * @param o
     */
    @Override
    public void addObservateur(Observer o) {
        
        observers.add(o);
    }

    /**
     *
     * @param o
     */
    @Override
    public void removeObservateur(Observer o) {
        
        observers.remove(o);

    }
    
    /**
     *
     */
    protected void notifyChange(){
        for(Observer o : observers){
            o.update(this);
        }
    }
}
