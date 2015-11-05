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

    Car() {
        loadimage();
    }

     
    void loadimage() {
        String temp;
        int rng = (int) (Math.random() * 5);
        if (rng == 0) {
            temp = "blue";
        } else if (rng == 1) {
            temp = "green";
        } else if (rng == 2) {
            temp = "orange";
        } else if (rng == 3) {
            temp = "red";
        } else {
            temp = "yellow";
        }
        try {
            image = ImageIO.read(new File("trafficdodger.images/" + temp + "Car.png"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, null);

    }
}
