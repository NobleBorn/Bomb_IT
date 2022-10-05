package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Map {

    private int y;
    private int x;
    private final int size = 20;
    private Tile[][] tiles = new Tile[20][20];
    private String[][] maps = new String[size][size];

    public Map(){
        setMapSize(size);
        tiles = createTiles(size);
        loadWalls();
        test();
    }

    private void setMapSize(int Size){
        y = Size;
        x = Size;
    }

    private Tile[][] createTiles(int Size) {
        Tile[][] tiles = new Tile[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                tiles[i][j] = new Tile(i, j);
            }
        }
        return tiles;
    }

    public Tile[][] getTiles(){
        return tiles;
    }

    private void loadWalls(){
        createPowerUps();
    }
    public void test(){

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
            for (String str : rows) {
                String[] stringSplit = str.split(",");
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
        int s = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                if (tiles[i][j].isTileEmpty()) {
                    Entity entity = tiles[i][j].entities.get(0);
                    if (entity instanceof Wall) {
                        if (i == s) {
                            System.out.print(entity.getPosition().getX() + " " +
                                    entity.getPosition().getY() + " " +
                                    ((Wall) entity).isDestroyable() + ", ");
                        }
                    }
                    else if(entity instanceof Player){
                        System.out.print("Player, ");
                    }
                } else {
                    System.out.print("Empty tile, ");
                }
            }
            System.out.println("\n");
            s++;
        }
    }

    public int[] getSize(){
        int[] coordinates = new int[2];

        coordinates[0] = x;
        coordinates[1] = y;

        return coordinates;
    }

    private void createPowerUps(){}

    public boolean isPlayerNextTileFree(Position newPosition) {
        CollisionChecker collisionChecker = new CollisionChecker();
        return collisionChecker.playerNextTileFree(newPosition, this);
    }
}