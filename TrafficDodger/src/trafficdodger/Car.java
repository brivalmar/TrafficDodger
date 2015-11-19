/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sdt5106
 */
public class Car extends Rectangle {

    BufferedImage image;
    Boolean state;

    Car() {
        state = true;
        generatex();
        loadimage();
    }
    
    void generatex(){
        int rng = (int)(Math.random()*3);
        if (rng == 0){
            x = 45;
        }
        else if (rng == 1){
            x = 200;
        }
        else x = 365;
    }
    
    public int getx(){
        return x;
    }
    
    public int gety(){
        return y;
    }
    
    public boolean getstate(){
        return state;
    }
    
    public void setstatefalse(){
        state = false;
    }
    
    public void move(){
        y = y + 10;
    }
    
    void loadimage() {
        String temp;
        int rng = (int) (Math.random() * 5);
        if (rng == 0) {
            temp = "blueCar.png";
        } else if (rng == 1) {
            temp = "greenCar.png";
        } else if (rng == 2) {
            temp = "orangeCar.png";
        } else if (rng == 3) {
            temp = "redCar.png";
        } else {
            temp = "yellowCar.png";
        }
        try {
            image = ImageIO.read(new File("src/trafficdodger/images/" + temp));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);

    }
}
