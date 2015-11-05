/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Marchetti
 */
public class JPanelController extends JPanel implements ActionListener{
    
    private MainMenuPanel mainMenu;
    
    
    public JPanelController(){
        
        mainMenu = new MainMenuPanel();
        this.setLayout(new BorderLayout());
        this.add(CENTER, mainMenu);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == MainMenuPanel.playButton){
            System.out.println("Hello world.");
        }
        if(e.getSource() == MainMenuPanel.quitButton){
            System.out.println(" world.");

        }
    }
    
    
    
}
