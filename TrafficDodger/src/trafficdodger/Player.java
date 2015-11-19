/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.Color;
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

    private String userName;
    
    private int lives;
    private int score;
    
    private int x = 200;
    private int y = 545;
    

    BufferedImage image1;
    
    Player(String name) {
        userName = name;
        lives = 3;
        score = 0;
        width = 100;
        height = 124;
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
    
    public int getLives() {
        return lives;
    }
    
    public int getScore() {
        return score;
    }    
    
    public int getxpos() {
        return x;
    }

    public int getypos() {
        return y;

    }
    public void setxpos(int a){
        x = a;
    }

    public void addscore(){
        score = score + 100;
    }
    
    public void decrementLife(){
        lives = lives - 1;
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
    
    public void drawHUD(Graphics g) {
        g.setColor(Color.white);
        g.drawString("Name: " + userName, 22, 10);
        g.drawString("Lives: " + lives, 22, 25);
        g.drawString("Score: " + score, 22, 40);
    }
}
