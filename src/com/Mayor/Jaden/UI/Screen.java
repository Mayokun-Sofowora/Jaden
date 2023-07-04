package com.Mayor.Jaden.UI;

import com.Mayor.Jaden.Level.Tile.Tile;

import java.util.Arrays;
import java.util.Random;

public class Screen {
    public final int width, height;
    public int[] pixels;
    public int xOffset, yOffset;
    public final int MAP_SIZE = 64;
    //public final int MASK_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private final Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++){
            tiles[i]= random.nextInt(0xffffff);
        }
    }

    public void clear(){
        Arrays.fill(pixels, 0);
    }

/*    public void render(int xOffset,int yOffset) {
        for (int y = 0; y < height; y++) {
            int Y = y + yOffset;
            if(Y < 0 || Y >= height)continue;
            for (int x = 0; x < width; x++) {
                int X = x + xOffset;
                if(X < 0 || X >= width)continue;
                //int tileIndex = ((xx >> 4) & MASK_SIZE_MASK) + ((yy >> 4) & MASK_SIZE_MASK) * MAP_SIZE;//shifting/ dividing 2^n times shifted.
                pixels[X + Y * width] = Sprite.grass.pixels[(x&15) + (y&15) * Sprite.grass.SIZE];
            }
        }
    }*/

    public void renderTile(int X_pos, int Y_pos, Sprite sprite){
        X_pos -= xOffset;
        Y_pos -= yOffset;
        for(int y = 0; y < sprite.SIZE; y++){
            int Y_abs = y + Y_pos;
            for(int x = 0; x < sprite.SIZE; x++) {
                int X_abs = x + X_pos;
                if (X_abs < -sprite.SIZE || X_abs >= width || Y_abs < 0 || Y_abs >= height) break;
                if(X_abs < 0) X_abs = 0;
                pixels[X_abs + Y_abs * width] = sprite.pixels[x + y * sprite.SIZE];
            }
        }
    }

    public void renderPlayer(int X_pos, int Y_pos, Sprite sprite, int flip){
        X_pos -= xOffset;
        Y_pos -= yOffset;
        for(int y = 0; y < 16; y++){
            int Y_abs = y + Y_pos;
            int Y_sprite = y;
            if(flip == 2 || flip == 3) Y_sprite = 15 - y;
            for(int x = 0; x < 16; x++) {
                int X_abs = x + X_pos;
                int X_sprite = x;
                if(flip == 1 || flip == 3)X_sprite = 15 - x;
                if (X_abs < -16 || X_abs >= width || Y_abs < 0 || Y_abs >= height) break;
                if(X_abs < 0) X_abs = 0;
                int fill = sprite.pixels[X_sprite + Y_sprite * 16];
                if(fill != 0xffff7f27 ) //remove sprite invisible bg color   //if pink -0xffff00ff
                    pixels[X_abs + Y_abs * width] = fill;
            }
        }
    }

    public void setOffset(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }


}