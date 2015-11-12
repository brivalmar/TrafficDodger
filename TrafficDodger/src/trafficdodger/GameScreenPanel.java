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
    private Car car;
    private ArrayList<Car> carlist = new ArrayList<>();
    
    private int listsize;
    private Player player;
    private String name;
    
    
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
    }

    private void init() {
        car = new Car();
        player = new Player(name);

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        drawRoad(g);
        player.drawHUD(g);
        drawInst(g);
        player.draw(g);
        for (int i = 0; i < listsize; i++){
            carlist.get(i).draw(g);
        }
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
        
        if ( x == KeyEvent.VK_SPACE) {
           boolean t1State = t1.isRunning();
           
           if(t1State) {
               t1.stop();
               t2.stop();
           } else { t1.start(); t2.start(); }
           
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
    }
}
