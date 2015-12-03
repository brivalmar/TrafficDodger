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
    private Scores scores;
    
    public JPanelController(){
        scores = new Scores();
        //creates new Panels to show
        mainMenu = new MainMenuPanel(scores);
        
        this.setLayout(new BorderLayout());
        
        //adds mainMenu Panel to JPanelController
        this.add(CENTER, mainMenu);
        
        //Adds listeners to JButtons
        mainMenu.getPlayButton().addActionListener(this);
        mainMenu.getQuitButton().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //decisions for button clicked
        if(e.getSource() == mainMenu.getPlayButton()){
            this.remove(mainMenu);
            gameScreen = new GameScreenPanel(mainMenu.getPlayerName(), scores, this);
            this.add(gameScreen);
            validate();
            repaint();
        }
        
        if(e.getSource() == mainMenu.getQuitButton()){
            System.exit(0);

        }
    }
    
    public void switchToMain()
    {
       System.out.println("In Switch to Main");
       this.remove(gameScreen);
       this.add(mainMenu);
       validate();
       repaint();
    }    
}
