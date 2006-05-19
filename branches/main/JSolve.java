package main;

import GUI.*;import GUImodel.GUImodel;
/*

 * Main.java
 *
 * Created on 7 mei 2006, 10:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author Kurt Deklerck
 */
public class JSolve {
    
    /** Creates a new instance of Main */
    public JSolve() {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       GUImodel gModel = new GUImodel();
       HoofdVenster hoofdVenster = new HoofdVenster(gModel); 
       
    }
    
}
