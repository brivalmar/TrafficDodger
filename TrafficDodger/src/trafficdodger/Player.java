/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sdt5106
 */
public class Player extends Rectangle {

    String userName;
    int lives;
    static int zwidth = 150;
    static int zheight = 300;

    BufferedImage image1;
    
    Player(String name) {
        userName = name;
        lives = 3;
        width = zwidth;
        height = zheight;
        
        loadimage();
        
    }
    
    void loadimage(){
        try{
          image1 = ImageIO.read(new File("src/trafficdodger/images/playerCar.png"));
        }
        
        catch(IOException e){
            System.err.println(e.getMessage());
        }
        
    }
    
    
    public int getxpos() {
        return x;
    }

    public int getypos() {
        return y;

    }
    public void setxpos(int a){
        x += a;
    }

    public int getwidth() {
        return width;
    }

    public int getheight() {
        return height;
    }
    
    public void draw(Graphics g){
        g.drawImage(image1, x, y, null);
       
    }
}
