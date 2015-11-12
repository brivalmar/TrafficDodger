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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author sdt5106
 */
public class GameScreenPanel extends JPanel implements KeyListener {

    private Car car;
    private Player player;
    BufferedImage road;

    GameScreenPanel() {
        super();
        setLayout(null);
        loadimage();
       // setBackground(Color.BLACK);
        init();

        repaint();
        
    }

    void init() {
        car = new Car();
        player = new Player("name");

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        drawRoad(g);
        player.draw(g);
    }
    
    void loadimage(){
        try{
          road = ImageIO.read(new File("src/trafficdodger/images/road1.png"));
        }
        
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void drawRoad (Graphics g) {
        g.drawImage(road, 0, 0, null);
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
                System.out.println("In 1");
                player.setxpos(200);
                repaint();
            }
            
            else if (player.getxpos() == 200) {
                System.out.println("In 1");
                player.setxpos(45);
                repaint();
            }
        }
        
        if (x == KeyEvent.VK_RIGHT) {
            if (player.getxpos() == 45) {
                System.out.println("In 3");
                player.setxpos(200);
                repaint();
            }
            
            else if (player.getxpos() == 200) {
                System.out.println("In 4");
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
