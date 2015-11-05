/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Marchetti
 */
public class MainMenuPanel extends JPanel{
    
    //calls initial variables for Panel
    private JButton playButton;
    private JButton quitButton;
    
    private JLabel usernameLabel;
    private JTextField usernameField;
    
    private JLabel highScoreLabel;
    private JTextArea highScoreArea;
    
    
    
    public MainMenuPanel(){
        createButtons();
        
        //initializes variables
        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(20);
        
        highScoreLabel = new JLabel("Highscores: ");
        highScoreArea = new JTextArea(20,50);
                
        //adds objects to Panel
        this.add(playButton);
        this.add(quitButton);
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(highScoreLabel);
        this.add(highScoreArea);
        
    }
    
    public void createButtons(){
        //creates buttons
        playButton = new JButton("Play");
        
        quitButton = new JButton("Quit");
    }
    
    public JButton getPlayButton(){
        //button is private; used for actionlister in JPanelController
        return playButton;
    }
    
    public JButton getQuitButton(){
        //button is private; used for actionlister in JPanelController
        return quitButton;
    }
    

    
}
