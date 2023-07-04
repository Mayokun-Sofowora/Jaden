package com.Mayor.Jaden.Level.Tile;

import com.Mayor.Jaden.UI.Screen;
import com.Mayor.Jaden.UI.Sprite;

public class GrassTile extends Tile{

    public GrassTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x<<4, y<<4, Sprite.grass);
    }
}
