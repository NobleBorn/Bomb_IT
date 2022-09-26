package com.mygdx.game;

public class Wall {

    private boolean isDestroyable;
    private int x;
    private int y;

    public Wall(boolean a, int x, int y){
        this.isDestroyable = a;
        this.x = x;
        this.y = x;
    }
}
