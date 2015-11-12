/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author sdt5106
 */
public class GameScreenPanel extends JPanel implements KeyListener {

    private Car car;
    private Player player;
    private String name;
    
    private JLabel playerName;
    private JLabel playerScore;
    private JLabel playerLives;

    GameScreenPanel(String nm) {
        super();
        
        name = nm;
        
        setLayout(null);
        init();

        repaint();
    }

    private void init() {
        car = new Car();
        player = new Player(name);
        
        createHUD();
        
        this.add(playerName);
        this.add(playerLives);
        this.add(playerScore);

        setFocusable(true);
        addKeyListener(this);
    }
    
    private void createHUD() {
        playerName = new JLabel("Name: " + name);
        playerName.setBounds(10, 10, 200, 15);
        playerName.setOpaque(true);
        playerName.setForeground(Color.white);
        
        playerLives = new JLabel("Lives: " + player.getLives());
        playerLives.setBounds(10, 25, 100, 15);
        playerLives.setOpaque(true);
        playerLives.setForeground(Color.white);
        
        playerScore = new JLabel("Score: " + player.getScore());
        playerScore.setBounds(10, 40, 200, 15);
        playerScore.setOpaque(true);
        playerScore.setForeground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        player.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //Not used yet.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int x = ke.getKeyCode();
        if (x == KeyEvent.VK_LEFT) {
            if (player.getxpos() == 365) {
                player.setxpos(200);
                repaint();
            }
            
            else if (player.getxpos() == 200) {;
                player.setxpos(45);
                repaint();
            }
        }
        
        if (x == KeyEvent.VK_RIGHT) {
            if (player.getxpos() == 45) {
                player.setxpos(200);
                repaint();
            }
            
            else if (player.getxpos() == 200) {
                player.setxpos(365);
                repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //Not used yet.
    }
}
