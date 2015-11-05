/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Marchetti
 */
public class MainMenuPanel extends JPanel{
    
    private JButton playButton;
    private JButton quitButton;
    
    private JLabel usernameLabel;
    private JTextField usernameField;
    
    private JLabel highScoreLabel;
    private JTextArea highScoreArea;
    
    public MainMenuPanel(){
        playButton = new JButton("Play");
        quitButton = new JButton("Quit");
        
        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(20);
        
        highScoreLabel = new JLabel("Highscores: ");
        highScoreArea = new JTextArea(20,50);
                
        this.add(playButton);
        this.add(quitButton);
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(highScoreLabel);
        this.add(highScoreArea);
        
    }
    
}
