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

    GameScreenPanel() {
        super();
        setLayout(null);
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
        player.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int x = ke.getKeyCode();
        if (x == KeyEvent.VK_LEFT) {
            if (player.getxpos() > 0) {
                player.setxpos(-10);
                repaint();

            }
        }

        if (x == KeyEvent.VK_RIGHT) {
            if (player.getxpos() < 750) {
                player.setxpos(10);
                repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
