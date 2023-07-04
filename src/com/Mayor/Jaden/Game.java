package com.Mayor.Jaden;

import com.Mayor.Jaden.Entity.Mob.Player;
import com.Mayor.Jaden.Input.Keyboard;
import com.Mayor.Jaden.Input.Mouse;
import com.Mayor.Jaden.Level.Level;
import com.Mayor.Jaden.Level.RandomLevel;
import com.Mayor.Jaden.Level.SpawnLevel;
import com.Mayor.Jaden.Level.TileCoordinate;
import com.Mayor.Jaden.UI.Screen;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    //static means it does not change
    private static int width = 300;
    //using aspect ratio 16 by 9
    private static int height = width / 16 * 9;
    //scale up w and h
    private static int scale = 3;
    public static String title = "Jaden";

    private Thread thread;
    public JFrame frame;
    private final Keyboard key;
    private Level level;
    private Player player;
    private boolean running = false;
    private Screen screen;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game(){
        Dimension size = new Dimension(width* scale, height*scale);
        setPreferredSize(size);

        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        level = Level.spawn;
        TileCoordinate playerSpawn = new TileCoordinate(21, 62);
        player = new Player(playerSpawn.x(),playerSpawn.y(), key);
        player.init(level);

        addKeyListener(key);
        Mouse mouse = new Mouse();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }
    public static int getWindowWidth(){
        return width * scale;
    }
    public static int getWindowHeight(){
        return height * scale;
    }
    public synchronized void start(){
        running = true;
        thread = new Thread(this,"Display");
        thread.start();
    }
    public synchronized void stop(){
        running = false;
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    /*game functions*/
    public void run() {
        long prevTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0/60.0;
        double dT = 0;
        int frames = 0;
        int updates =0;
        requestFocus();
        while(running){
            long currTime = System.nanoTime();
            dT += (currTime - prevTime)/ns;
            prevTime = currTime;
            while(dT>=1){
                update();
                updates++;
                dT--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " ups, " + frames + " fps ");
                frame.setTitle(title + "  |  " +  updates + " ups, " + frames + " fps ");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    public void update(){
        key.update();
        player.update();
        level.update();
    }
    public void render(){
    BufferStrategy bufferStrategy = getBufferStrategy();
        if(bufferStrategy == null){
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        int xScroll = player.x - screen.width / 2; //put player in the middle of the screen
        int yScroll = player.y - screen.height / 2;
        level.render(xScroll, yScroll, screen);
        player.render(screen);
        /*screen.render(x, y);*/
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        Graphics graphics = bufferStrategy.getDrawGraphics();


        graphics.fillRect(0,0, getWidth(), getHeight());

        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font ("Arial", 0, 10));

        //graphics.fillRect(Mouse.getX()-32, Mouse.getY()-32, 64, 64);
        //if(Mouse.getButton()!=-1) graphics.drawString("Button: " + Mouse.getButton(), 80,80);

        graphics.dispose();
        bufferStrategy.show();
    }
}