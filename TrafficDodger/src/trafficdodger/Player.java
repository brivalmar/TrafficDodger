/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author sdt5106
 */
public class Player extends Rectangle {

    String userName;
    int lives;
    static int zwidth = 150;
    static int zheight = 300;

    Player(String name) {
        userName = name;
        lives = 3;
        width = zwidth;
        height = zheight;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;

    }

    public int getwidth() {
        return width;
    }

    public int getheight() {
        return height;
    }
    
    public void draw(Graphics g){
        g.fillRect(x, y, width, height);
       
    }
}
