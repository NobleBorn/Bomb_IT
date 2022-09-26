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

    private void createPermWalls(){}
    private void createDestWalls(){}
    private void createPowerUps(){}

}