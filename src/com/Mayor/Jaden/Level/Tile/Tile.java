package com.Mayor.Jaden.Level.Tile;

import com.Mayor.Jaden.Level.Tile.Spawn_level.*;
import com.Mayor.Jaden.UI.Screen;
import com.Mayor.Jaden.UI.Sprite;
public class Tile {
    public int x, y;
    public Sprite sprite;
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
    public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
    public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
    public static Tile spawn_wall1 = new SpawnWall1Tile(Sprite.spawn_wall1);
    public static Tile spawn_wall2 = new SpawnWall2Tile(Sprite.spawn_wall2);
    public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
    public static Tile spawn_sky = new SpawnSkyTile(Sprite.spawn_sky);

    public static final int fill_spawn_grass = 0xff00ff21;
    public static final int fill_spawn_water = 0; //unsused
    public static final int fill_spawn_hedge = 0;//unsused
    public static final int fill_spawn_sky = 0;//unsused
    public static final int fill_spawn_wall1 = 0xff808080;
    public static final int fill_spawn_wall2 = 0xff404040;
    public static final int fill_spawn_floor = 0xff564106;

    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen){

    }
    public boolean solid(){
        return false;
    }

}
