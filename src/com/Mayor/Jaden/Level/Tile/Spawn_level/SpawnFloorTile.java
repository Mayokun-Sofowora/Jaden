package com.Mayor.Jaden.Level.Tile.Spawn_level;

import com.Mayor.Jaden.Level.Tile.Tile;
import com.Mayor.Jaden.UI.Screen;
import com.Mayor.Jaden.UI.Sprite;

public class SpawnFloorTile extends Tile {
    public SpawnFloorTile(Sprite sprite) {
        super(sprite);
    }
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x<<4, y<<4, Sprite.spawn_floor);
    }
}
