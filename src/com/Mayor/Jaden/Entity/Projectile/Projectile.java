package com.Mayor.Jaden.Entity.Projectile;

import com.Mayor.Jaden.Entity.Entity;
import com.Mayor.Jaden.UI.Sprite;

public abstract class Projectile extends Entity {
    protected final int xOrigin, yOrigin;
    protected double angle;
    protected Sprite sprite;
    protected double nx, ny;
    protected double speed, rateOfFire, range, damage;
    public Projectile(int x, int y, double direction) {
        xOrigin = x;
        yOrigin = y;
        angle = direction;
        this.x = x;
        this.y = y;
    }
    protected void move(){

    }
}
