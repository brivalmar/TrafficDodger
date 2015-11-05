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
    private GameScreenPanel gameScreen;
    
    public JPanelController(){
        
        gameScreen = new GameScreenPanel();
        
        mainMenu = new MainMenuPanel();
        this.setLayout(new BorderLayout());
        this.add(CENTER, mainMenu);
        mainMenu.getPlayButton().addActionListener(this);
        mainMenu.getQuitButton().addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainMenu.getPlayButton()){
            System.out.println("hey baby");
            mainMenu.setVisible(false);
            this.add(gameScreen);
            //gameScreen = new GameScreenPanel();
        }
        
        if(e.getSource() == mainMenu.getQuitButton()){
            System.out.println(" world.");
            System.exit(0);

        }
    }
    
    
    
}
