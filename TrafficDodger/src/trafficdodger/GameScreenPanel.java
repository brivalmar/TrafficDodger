/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author sdt5106
 */
public class GameScreenPanel extends JPanel implements KeyListener, ActionListener{

    private Timer t1;
    private Timer t2;
    private Timer roadTimer;
            
    private Car car;
    private ArrayList<Car> carlist = new ArrayList<>();
    
    private BufferedImage road1;
    private BufferedImage road2;

    private int roadUsed = 1;
    
    private int listsize;
    private Player player;
    private String name;
    
    private boolean isPaused = true;
    
    
    BufferedImage road;

    GameScreenPanel(String nm) {
        super();
        
        name = nm;
        
        setLayout(null);
        
        loadimage();
        
        init();
        listsize = 0;
        t1 = new Timer(3000, this);
        t2 = new Timer(100, this);
        roadTimer = new Timer(100, this);
    }

    private void init() {
        car = new Car();
        player = new Player(name);

        setFocusable(true);
        addKeyListener(this);
    }
    
    private void gameOver() {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        drawRoad(g);
        player.drawHUD(g);        
        for (int i = 0; i < listsize; i++){
            carlist.get(i).draw(g);
        }
        player.draw(g);
        
        if(isPaused) {
            drawInst(g);
        }
    }
    
    void loadimage(){
        try{
          road1 = ImageIO.read(new File("src/trafficdodger/images/road1.png"));
        }
        
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        try{
          road2 = ImageIO.read(new File("src/trafficdodger/images/road2.png"));
        }
        
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void drawRoad (Graphics g) {
        if(roadUsed == 1) {
            g.drawImage(road1, 0, 0, null);
        }
        else if (roadUsed == 2) {
            g.drawImage(road2, 0, 0, null);
        }
    }
    
    public void drawInst(Graphics g) {
        Font myFont = new Font("Times New Roman", Font.BOLD, 32);
        
        g.setColor(Color.white);
        g.setFont(myFont);
        g.drawString("Press Space To Start/Pause", 75, 350);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //Not used yet.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int x = ke.getKeyCode();
        if (x == KeyEvent.VK_LEFT) {
            if (!isPaused){
                if (player.getxpos() == 365) {
                    player.setxpos(200);
                    repaint();
                }

                else if (player.getxpos() == 200) {;
                    player.setxpos(45);
                    repaint();
                }
            }
        }
        
        if (x == KeyEvent.VK_RIGHT) {
            if (!isPaused){
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
        
        if ( x == KeyEvent.VK_SPACE) {
           boolean t1State = t1.isRunning();
           
           if(t1State) {
               t1.stop();
               t2.stop();
               roadTimer.stop();
               isPaused = true;
           } else { t1.start(); t2.start(); roadTimer.start(); isPaused = false;}
           repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //Not used yet.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == t1) {
            car = new Car();
            carlist.add(car);
            listsize++;
        }
        
        if(e.getSource() == t2) {
           for(int i = 0; i<listsize; i++){
               carlist.get(i).move();
           }
           repaint();
        }
        
        if (e.getSource() == roadTimer) {
            if (roadUsed == 1) {
                roadUsed = 2;
            }
            else if (roadUsed == 2) {
                roadUsed = 1;
            }
            repaint();
        }
    }
}
