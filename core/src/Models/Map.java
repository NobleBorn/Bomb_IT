package Models;

import Models.Position;
import com.sun.tools.javac.util.ArrayUtils;

public class Map {

    private int y;
    private int x;
    private final int size = 20;
    private Tile[][] tiles;

    public Map(){
        setMapSize(size);
        createTiles(size);
        loadWalls();
    }

    private void setMapSize(int Size){
        y = Size;
        x = Size;
    }

    private void createTiles(int Size) {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                tiles[i][j] = new Tile(i, j);
            }
        }
    }

    public Tile[][] getTiles(){
        return tiles;
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
        Position[] positions = new Position[(size*size)];
        for (int i = 0; i < 20; i++){
            positions[i] = new Position(i, 0);
        }

        for (int i = 1; i < 20; i++){
            positions[(i*20)+1] = new Position(0, i);
        }

    }
    private void createDestWalls(){}
    private void createPowerUps(){}

}