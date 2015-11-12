/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author sdt5106
 */
public class GameScreenPanel extends JPanel implements KeyListener, ActionListener{

    private Timer t1;
    private Timer t2;
    private Car car;
    private ArrayList<Car> carlist = new ArrayList();
    private int listsize;
    private Player player;

    GameScreenPanel() {
        super();
        setLayout(null);
       // setBackground(Color.BLACK);
        init();
        listsize = 0;
        t1 = new Timer(3000, this);
        t2 = new Timer(100, carmove);
        t1.start();
        t2.start();
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
        player.draw(g);
        for (int i = 0; i < listsize; i++){
            carlist.get(i).draw(g);
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        car = new Car();
        carlist.add(car);
        listsize++;
    }
    
    ActionListener carmove = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           for(int i = 0; i<listsize; i++){
               carlist.get(i).move();
           }
           repaint();
        }
    };
}
