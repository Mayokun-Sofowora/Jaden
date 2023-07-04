package com.Mayor.Jaden.UI;

import com.Mayor.Jaden.Level.SpawnLevel;

public class Sprite {
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite spawn_floor = new Sprite(16, 1, 2, SpriteSheet.spawn_level);
    public static Sprite spawn_grass = new Sprite(16, 0,  2, SpriteSheet.spawn_level);
    public static Sprite spawn_wall1 = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
    public static Sprite spawn_water = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
    public static Sprite spawn_sky = new Sprite(16, 1, 1, SpriteSheet.spawn_level);
    public static Sprite spawn_wall2 = new Sprite(16, 2, 1, SpriteSheet.spawn_level);
    public static Sprite spawn_hedge = new Sprite(16, 1, 0, SpriteSheet.spawn_level);

    public static Sprite grass = new Sprite(16, 4, 0, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);

    public static Sprite voidSprite = new Sprite(16, 0x37eaf4);

    public static Sprite player_down_l = new Sprite(16, 0, 2, SpriteSheet.tiles);
    public static Sprite player_down = new Sprite(16, 1, 2, SpriteSheet.tiles);
    public static Sprite player_down_r = new Sprite(16, 2, 2, SpriteSheet.tiles);
    public static Sprite player_up_l = new Sprite(16, 3, 2, SpriteSheet.tiles);
    public static Sprite player_up = new Sprite(16, 4, 2, SpriteSheet.tiles);
    public static Sprite player_up_r = new Sprite(16, 5, 2, SpriteSheet.tiles);
    public static Sprite player_side = new Sprite(16, 8, 2, SpriteSheet.tiles);
    public static Sprite player_side_r = new Sprite(16, 9, 2, SpriteSheet.tiles);

    public Sprite(int size, int x, int y, SpriteSheet sheet){
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color){
        SIZE = size;
        pixels = new int[SIZE*SIZE];
        setColor(color);
    }

    private void setColor(int color){
        for(int i =0; i < SIZE*SIZE; i++){
            pixels[i] = color;
        }
    }

    private void load(){
        for(int y = 0; y < SIZE; y++) {
            for(int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
}
