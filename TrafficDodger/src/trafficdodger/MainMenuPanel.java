/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.*;
import java.awt.event.*;
import static java.lang.String.valueOf;
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
    private JPanel top;
    private JPanel center;
    private JLabel usernameLabel;
    private JTextField usernameField;
    
    private JLabel [] jstring = new JLabel[20];
    private JLabel [] jnumber = new JLabel[20];
   
    
    private JLabel highScoreLabel;
    private JTextArea highScoreArea;
    private int size;
    Scores score;
    
    public MainMenuPanel(){
        createButtons();
        setLayout(new BorderLayout());
        top = new JPanel();
        center = new JPanel();
        center.setLayout(new GridLayout(size, 2));
        //initializes variables
        usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(20);
        usernameField.setText("Default User");
        
        highScoreLabel = new JLabel("Highscores: ");
      //  highScoreArea = new JTextArea(20,40);
        
        score = new Scores();
        
        ArrayList<String> strings = score.getStringList();
        ArrayList<Integer> ints = score.getIntList();
        size = strings.size();
        for(int i = 0; i < size; i++){
             jstring[i] = new JLabel();
             jnumber[i] = new JLabel();
             jstring[i].setText(strings.get(i));
             jnumber[i].setText(valueOf(ints.get(i)));
             center.add(jstring[i]);
             center.add(jnumber[i]);
          /*  highScoreArea.append(strings.get(i));
            highScoreArea.append("               ");
            highScoreArea.append(ints.get(i).toString() + "\n");*/
        }
        
        

        
        //adds objects to Panel
        top.add(playButton);
        top.add(quitButton);
        top.add(usernameLabel);
        top.add(usernameField);
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        //this.add(highScoreLabel);
    //    this.add(highScoreArea);
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
