package com.Mayor.Jaden.Level.Tile;

import com.Mayor.Jaden.UI.Screen;
import com.Mayor.Jaden.UI.Sprite;

public class VoidTile extends Tile{
    public VoidTile(Sprite sprite) {
        super(sprite);
    }
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x<<4, y<<4, Sprite.voidSprite);
    }
}
