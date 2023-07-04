package com.Mayor.Jaden.Entity.Projectile;

import com.Mayor.Jaden.UI.Screen;
import com.Mayor.Jaden.UI.Sprite;

public class PlayerProjectile extends Projectile{

    public PlayerProjectile(int x, int y, double direction) {
        super(x, y, direction);
        range = 200;
        speed = 4;
        damage = 20;
        rateOfFire = 15;
        sprite = Sprite.grass;
        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);
    }
    public void update(){
        move();
    }
    protected void move(){
        x += nx;
        y += ny;
    }
    public void render(Screen screen){
        screen.renderTile(x, y, sprite);
    }
}
