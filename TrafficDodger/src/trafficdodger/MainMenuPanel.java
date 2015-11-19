/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    
    Scores score;
    
    public MainMenuPanel(){
        createButtons();
        
        //initializes variables
        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(20);
        usernameField.setText("Default User");
        
        highScoreLabel = new JLabel("Highscores: ");
        highScoreArea = new JTextArea(20,40);
        
        score = new Scores();
        
        ArrayList<String> strings = score.getStringList();
        ArrayList<Integer> ints = score.getIntList();
        for(int i = 0; i < 20; i++){
            highScoreArea.append(strings.get(i));
            highScoreArea.append("               ");
            highScoreArea.append(ints.get(i).toString() + "\n");
        }

        
        //adds objects to Panel
        this.add(playButton);
        this.add(quitButton);
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(highScoreLabel);
        this.add(highScoreArea);
//        highScoreArea.addLists();
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
    
    public String getPlayerName() {
        String name = usernameField.getText();
        
        return name;
    }
    
    public JTextArea getHighScoreArea(){
        return highScoreArea;
    }
    

    
}
