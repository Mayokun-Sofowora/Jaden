package com.Mayor.Jaden.Entity.Mob;

import com.Mayor.Jaden.Entity.Entity;
import com.Mayor.Jaden.Entity.Projectile.PlayerProjectile;
import com.Mayor.Jaden.Entity.Projectile.Projectile;
import com.Mayor.Jaden.UI.Sprite;

import java.util.ArrayList;
import java.util.List;

public abstract class Mob extends Entity {
    protected Sprite sprite;
    protected int direction = 0;
    protected boolean moving = false;
    protected boolean walking = false;
    protected List<Projectile>projectiles = new ArrayList<Projectile>();

    public void move(int xa, int ya){
        if(xa  != 0 && ya != 0){
            move(xa, 0);
            move(0, ya);
            return;
        }
        if(xa > 0) direction = 1;
        if(xa < 0) direction = 3;
        if(ya > 0) direction = 2;
        if(ya < 0) direction = 0;
        if(!collision(xa, ya)){
            x += xa;
            y += ya;
        }
    }
    public void update() {
    }
    protected void shoot(int x, int y, double direction){
       // direction = Math.toDegrees(direction);
       Projectile p = new PlayerProjectile(x, y, direction);
       projectiles.add(p);
       level.add(p);
    }
    private boolean collision(int xa, int ya){
        boolean solid = false;
        for(int c = 0; c < 4; c++) {
            int xt = ((x + xa) + c % 2 * 17 - 1) / 16; //x col offsets
            int yt = ((y + ya) + c / 2 * 12 + 3) / 16; //y col offsets
            if (level.getTile(xt, yt).solid()) solid = true;
        }
        return solid;

    }
    public void render(){
    }

}
