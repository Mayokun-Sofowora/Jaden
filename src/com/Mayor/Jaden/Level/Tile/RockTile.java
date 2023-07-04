package com.Mayor.Jaden.Level.Tile;

import com.Mayor.Jaden.UI.Screen;
import com.Mayor.Jaden.UI.Sprite;

public class RockTile extends Tile{
    public RockTile(Sprite sprite) {
        super(sprite);
    }
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x<<4, y<<4, Sprite.rock);
    }
    public boolean solid(){
        return true;
    }

}
