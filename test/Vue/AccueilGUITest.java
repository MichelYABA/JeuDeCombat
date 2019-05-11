/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yaba
 */
public class AccueilGUITest {
    
    /**
     *
     */
    public AccueilGUITest() {
    }

    /**
     * Test of InitGUI method, of class AccueilGUI.
     */
    @Test
    public void testInitGUI() {
        System.out.println("InitGUI");
        AccueilGUI instance = new AccueilGUI();
        instance.InitGUI();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AccueilGUI.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AccueilGUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
