package com.Mayor.Jaden.Entity.Mob;

import com.Mayor.Jaden.Game;
import com.Mayor.Jaden.Input.Keyboard;
import com.Mayor.Jaden.Input.Mouse;
import com.Mayor.Jaden.UI.Screen;
import com.Mayor.Jaden.UI.Sprite;

public class Player extends Mob{
    private Keyboard input;
    private Sprite sprite;
    private int  mov = 0;
    private boolean isMov = false;
    public Player(Keyboard input){
        this.input = input;
        sprite = Sprite.player_down;
    }
    public Player(int x, int y, Keyboard input){
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.player_down;
    }
    public void update(){
        int xa = 0, ya = 0;
        if (mov < 7500)mov++;
        else mov = 0;
        if(input.up) ya--;
        if(input.down) ya++;
        if(input.left) xa--;
        if(input.right) xa++;
        if(xa != 0 || ya != 0){
            move(xa,ya);
            isMov = true;
        }
        else{
            isMov = false;
        }
        updateShooting();
    }

    private void updateShooting() {
        if(Mouse.getButton() == 1){
            double dx = Mouse.getX() - (double) Game.getWindowWidth() / 2;
            double dy = Mouse.getY() - (double) Game.getWindowHeight() / 2;
            double direction = Math.atan2(dy, dx);
            shoot(x, y, direction);
        }
    }

    public void render(Screen screen){
        int flip = 0;
        if(direction == 0){
            sprite = Sprite.player_up;
            if(isMov){
                if(mov % 20 > 10) sprite = Sprite.player_up_l;
            }else {
                sprite = Sprite.player_up_r;
            }
        }
        if(direction == 1) {
            sprite = Sprite.player_side;
            if(isMov){
                if(mov % 20 > 10) sprite = Sprite.player_side_r;
            }else {
                sprite = Sprite.player_side_r;
            }
        }
        if(direction == 2) {
            sprite = Sprite.player_down;
            if(isMov){
                if(mov % 20 > 10) sprite = Sprite.player_down_l;
            }else {
                sprite = Sprite.player_down_r;
            }
        }
        if(direction == 3) {
            sprite = Sprite.player_side;
            if(isMov){
                if(mov % 20 > 10) sprite = Sprite.player_side_r;
            }else {
                sprite = Sprite.player_side_r;
            }   
            flip = 1;
        }

        screen.renderPlayer(x, y, sprite, flip);
    }

}
