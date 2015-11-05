/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author sdt5106
 */
public class GamePanel extends JPanel{
    Car car;
    Player player;
    JButton x;
    GamePanel()
    {
        super();
        setLayout(null);
        setBackground(Color.BLACK);
        init();
        
      //  repaint();
    }
    
    void init(){
        car = new Car();
        player = new Player("name");
        JButton x = new JButton("Test)");
        add(x);
        x.setBounds(0,0, 100, 200);
        
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        player.draw(g);
    }
}
