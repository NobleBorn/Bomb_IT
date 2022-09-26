package com.mygdx.game;

public class Map {

    private int y;
    private int x;

    public Map(){
        setMapSize(20);
        loadWalls();
    }

    private void setMapSize(int Size){
        y = Size;
        x = Size;
    }

    private void loadWalls(){
        createPermWalls();
        createDestWalls();
        createPowerUps();
    }

    public int[] getSize(){
        int[] coordinates = new int[2];

        coordinates[0] = x;
        coordinates[1] = y;

        return coordinates;
    }

    private void createPermWalls(){
        grid = new Object[HEIGHT][WIDTH];
        for (int i = 0; i < WIDTH; i++) {
    for (int j = 0; j < HEIGHT; j++) {
        grid[j][i] = null;
    }
        }
    }
    private void createDestWalls(){}
    private void createPowerUps(){}

}