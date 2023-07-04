package com.Mayor.Jaden.Level;

import com.Mayor.Jaden.Entity.Entity;
import com.Mayor.Jaden.Level.Tile.Tile;
import com.Mayor.Jaden.UI.Screen;

import java.util.ArrayList;
import java.util.List;

public class Level {
    protected int width, height;
    protected int[] tilesInt;
    protected int[] tiles;
    protected int tile_size;
    private List<Entity> entities = new ArrayList<Entity>();

    public static Level spawn = new SpawnLevel("/levels/spawn.png");

    public Level(int width, int height){
        this.width = width;
        this.height = height;
        tilesInt = new int [width * height];
        generateLevel();
    }
    public Level(String path){
        loadLevel(path);
        generateLevel();
    }
    protected void loadLevel(String path) {
    }
    protected void generateLevel(){
        for(int y = 0; y < 64; y++){
            for(int x = 0; x < 64; x++){
                getTile(x, y);
            }
            tile_size = 16;
        }
    }
    public void update() {
        for(int i = 0; i < entities.size();i++){
            entities.get(i).update();
        }
    }
    public void render(int xScroll,int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4; //diving by 16 or shifting right 4 times
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;
        for(int y = y0; y < y1; y++){
            for(int x = x0; x < x1; x++){
                getTile(x, y).render(x, y, screen);
            }
        }
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).render(screen);
        }
    }
    public void add(Entity e){
        entities.add(e);
    }
    private void time(){
    }

    //Grass = 0x00ff00
    //Flower = 0xffff00
    //Rock = 0x7f7f00
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if(tiles[x + y * width] == Tile.fill_spawn_floor) return Tile.spawn_floor;
        if(tiles[x + y * width] == Tile.fill_spawn_grass) return Tile.spawn_grass;
        if(tiles[x + y * width] == Tile.fill_spawn_hedge) return Tile.spawn_hedge;
        if(tiles[x + y * width] == Tile.fill_spawn_sky) return Tile.spawn_sky;
        if(tiles[x + y * width] == Tile.fill_spawn_water) return Tile.spawn_water;
        if(tiles[x + y * width] == Tile.fill_spawn_wall1) return Tile.spawn_wall1;
        if(tiles[x + y * width] == Tile.fill_spawn_wall2) return Tile.spawn_wall2;
        return Tile.voidTile;
    }
}