package com.Mayor.Jaden.Level;

public class TileCoordinate {
    private int x, y;
    private final int TITLE_SIZE = 16;
    public TileCoordinate(int x, int y){
        this.x = x * TITLE_SIZE;
        this.y = y * TITLE_SIZE;
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }
    public int[] xy(){
        int[] r = new int[2];
        r[0] = x;
        r[1] = y;
        return r;
    }
}