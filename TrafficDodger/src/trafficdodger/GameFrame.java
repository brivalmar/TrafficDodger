/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import javax.swing.*;

/**
 *
 * @author Marchetti
 */
public class GameFrame extends JFrame {
    
    
    public GameFrame(){
        //builds the frame
        super("Traffic Dodger");
        
        this.setSize(500, 700);
        this.setResizable(false);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new JPanelController());
        this.setVisible(true);
        
    }
    
    public static void switchToMain(){
        
    }
    
    public static void switchToGame(){
        
    }
    
}
