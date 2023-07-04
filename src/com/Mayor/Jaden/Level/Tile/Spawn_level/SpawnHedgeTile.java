package com.Mayor.Jaden.Level.Tile.Spawn_level;

import com.Mayor.Jaden.Level.Tile.Tile;
import com.Mayor.Jaden.UI.Screen;
import com.Mayor.Jaden.UI.Sprite;

public class SpawnHedgeTile extends Tile {
    public SpawnHedgeTile(Sprite sprite) {
        super(sprite);
    }
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x<<4, y<<4, Sprite.spawn_hedge);
    }
    public boolean solid(){
        return true;
    }
    public boolean breakable(){
        return true;
    }

}
