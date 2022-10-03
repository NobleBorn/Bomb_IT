package Models;

import Models.Position;
import com.sun.tools.javac.util.ArrayUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class Map implements EventListener{

    private int y;
    private int x;
    private final int size = 20;
    private Tile[][] tiles = new Tile[20][20];
    private String[][] maps = new String[size][size];

    public Map(){
        setMapSize(size);
        createTiles(size);
        loadWalls();
        addObjects();
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
        createPowerUps();
    }

    private void addObjects(){

        try {
            List<String> rows = new ArrayList<String>();
            BufferedReader bf = new BufferedReader(new FileReader("test.txt"));
            String line = bf.readLine();
            while (line != null) {
                rows.add(line);
                line = bf.readLine();
            }
            bf.close();

            int s = 0;
            for (int i=rows.size()-1;i>=0;i--) {
            //for (String row: rows){
                String[] stringSplit = (rows.get(i).split(","));
                maps[s] = stringSplit;
                s++;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                String decider = maps[i][j];
                switch (decider) {
                    case "1":
                        tiles[i][j].addEntity(new Wall(false, new Position(i, j)));
                        break;
                    case "2":
                        tiles[i][j].addEntity(new Wall(true, new Position(i, j)));
                        break;
                    case "3":
                        tiles[i][j].addEntity(new Player(new Position(i, j)));
                        break;
                }
            }
        }
    }

    public int[] getSize(){
        int[] coordinates = new int[2];

        coordinates[0] = x;
        coordinates[1] = y;

        return coordinates;
    }

    public int createPowerUps(){
        return 0;
    }

    public boolean isPlayerNextTileFree(Position newPosition) {
        CollisionChecker collisionChecker = new CollisionChecker();
        return collisionChecker.playerNextTileFree(newPosition, this);
    }

    public Tile[][] getMapMatrix() {
        Tile[][] returnTiles  = new Tile[size][size];
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                returnTiles[i][j] = new Tile(tiles[i][j]);
            }
        }
        return returnTiles;
    }
}