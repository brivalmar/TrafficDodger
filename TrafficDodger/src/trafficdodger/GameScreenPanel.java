/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficdodger;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
public class GameScreenPanel extends JPanel implements KeyListener, ActionListener {

    private Timer t1;
    private Timer t2;
    private Timer roadTimer;

    private Car car;
    private ArrayList<Car> carlist = new ArrayList<>();

    private BufferedImage road1;
    private BufferedImage road2;
    private BufferedImage explosion;
    private BufferedImage tmpImg = new BufferedImage(200, 139, BufferedImage.TYPE_INT_ARGB);

    private int roadUsed = 1;

    private int listsize;
    private Player player;
    private String name;
    private Scores scores;
    private JPanelController controller;

    private boolean isPaused = true;
    private boolean collision = false;
    private boolean explosionMade = false;
    private boolean gameOver = false;

    BufferedImage road;

    GameScreenPanel(String nm, Scores sc, JPanelController j) {
        super();

        name = nm;
        scores = sc;
        controller = j;

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
        scores.writeToFile(name, player.getScore());
        t1.stop();
        t2.stop();
        roadTimer.stop();
        controller.switchToMain();
    }
    
    public void reset(){
        carlist = new ArrayList<>();
        listsize = 0;
        collision = false;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        drawRoad(g);
        player.drawHUD(g);
        for (int i = 0; i < listsize; i++) {
            carlist.get(i).draw(g);
        }
        player.draw(g);
        
        if (!explosionMade) {
            makeExplosion(g);
        }

        if (isPaused) {
            if (gameOver) {
                gameOver(g);
            }
            else {
                drawInst(g);
            }
        }
        if (collision) {
            drawExplosion(g);
        }
    }

    void loadimage() {
        try {
            road1 = ImageIO.read(new File("src/trafficdodger/images/road1.png"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        try {
            road2 = ImageIO.read(new File("src/trafficdodger/images/road2.png"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        try{
            explosion = ImageIO.read(new File("src/trafficdodger/images/explosion.png"));
        }
        
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void drawRoad(Graphics g) {
        if (roadUsed == 1) {
            g.drawImage(road1, 0, 0, null);
        } else if (roadUsed == 2) {
            g.drawImage(road2, 0, 0, null);
        }
    }

    public void drawInst(Graphics g) {
        Font myFont = new Font("Times New Roman", Font.BOLD, 32);

        g.setColor(Color.white);
        g.setFont(myFont);
        g.drawString("Press Space To Start/Pause", 75, 350);
    }
    
    public void gameOver(Graphics g) {
        Font myFont = new Font("Times New Roman", Font.BOLD, 60);

        g.setColor(Color.white);
        g.setFont(myFont);
        g.drawString("Game Over!", 95, 225);
        g.drawString("Your score is " + Integer.toString(player.getScore()), 20, 275);
        g.drawString("Play again?  Y/N", 35, 450);
    }
    
    public void makeExplosion(Graphics g) {
        Graphics2D g2d = (Graphics2D) tmpImg.getGraphics();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.7f)); 
            // set the transparency level in range 0.0f - 1.0f 
        g2d.drawImage(explosion, 0, 0, null);
        explosion = tmpImg;
        explosionMade = true;
    }
    public void drawExplosion(Graphics g) {
        g.drawImage(explosion, player.getxpos() - 50, player.getypos() - 60, null);
    }
    
    public void pause() {
        boolean t1State = t1.isRunning();

            if (t1State) {
                t1.stop();
                t2.stop();
                roadTimer.stop();
                isPaused = true;
            } else {
                if (collision == true){
                    reset();
                    
                }
                t1.start();
                t2.start();
                roadTimer.start();
                isPaused = false;
                collision = false;
            }
            repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //Not used yet.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int x = ke.getKeyCode();
        if (x == KeyEvent.VK_LEFT) {
            if (!isPaused) {
                if (player.getxpos() == 365) {
                    player.setxpos(200);
                    repaint();
                } else if (player.getxpos() == 200) {;
                    player.setxpos(45);
                    repaint();
                }
            }
        }

        if (x == KeyEvent.VK_RIGHT) {
            if (!isPaused) {
                if (player.getxpos() == 45) {
                    player.setxpos(200);
                    repaint();
                } else if (player.getxpos() == 200) {
                    player.setxpos(365);
                    repaint();
                }
            }
        }

        if (x == KeyEvent.VK_SPACE && !gameOver) {
            pause();
        }
        
        if (x == KeyEvent.VK_Y && gameOver) {
            gameOver();
        }
        
        if (x == KeyEvent.VK_N && gameOver) {
           controller.exitGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //Not used yet.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == t1) {
            car = new Car();
            carlist.add(car);
            listsize++;
        }

        
        if (e.getSource() == t2) {
            for (int i = 0; i < listsize; i++) {
                if (carlist.get(i).getstate() == true) {
                    carlist.get(i).move();
                    if (carlist.get(i).getx() == player.getxpos())
                        if ((carlist.get(i).gety() + player.height > player.getypos()) && (carlist.get(i).gety() < player.getypos() + player.height))
                        {
                            pause();
                            collision = true;
                            player.decrementLife();                       
                        }
                    if (carlist.get(i).gety() > 700) {
                        carlist.get(i).setstatefalse();
                        player.addscore();
                    }
                    if (player.getLives() == 0) {
                        gameOver = true;
                    }
                }
            }
            repaint();
        }

        if (e.getSource() == roadTimer) {
            if (roadUsed == 1) {
                roadUsed = 2;
            } else if (roadUsed == 2) {
                roadUsed = 1;
            }
            repaint();
        }
        
   
        
    }
}
