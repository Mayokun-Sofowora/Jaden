package com.Mayor.Jaden.Entity;

import com.Mayor.Jaden.Level.Level;
import com.Mayor.Jaden.UI.Screen;

import java.util.Random;

public abstract class Entity {
    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();
    public void update(){

    }
    public void render(Screen screen){

    }
    public void remove(){
        removed = true;
    }
    public boolean isRemoved(){
        return removed;
    }
    public void init(Level level){
        this.level = level;
    }
}
