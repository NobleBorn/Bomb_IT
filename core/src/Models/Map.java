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

public class Map implements EventListener, INavigable{

    private final CollisionChecker collision;
    private final int size = 20;
    private final int y = size;
    private final int x = size;
    private final Tile[][] tiles;
    private String[][] maps = new String[size][size];
    private List<Player> playerObjList = new ArrayList<>();

    public Map(){
        this.collision = new CollisionChecker(this);
        tiles = createTiles();
        loadWalls();
        addObjects();
    }

    private Tile[][] createTiles() {
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

    private void addObjects(){

        try {
            List<String> rows = new ArrayList<String>();
            BufferedReader bf = new BufferedReader(new FileReader("/Users/maxlevin/Documents/TDA367/Bomb_IT/assets/test.txt"));
            String line = bf.readLine();
            while (line != null) {
                rows.add(line);
                line = bf.readLine();
            }
            bf.close();

            int s = 0;
            for (int i=rows.size()-1;i>=0;i--) {
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
                        tiles[i][j].addEntity(new Wall(new Position(i, j)));
                        break;
                    case "2":
                        tiles[i][j].addEntity(new SoftWall(new Position(i, j)));
                        break;
                    case "3":
                        tiles[i][j].addEntity(new Player(new Position(i, j), this));
                        playerObjList.add((Player)tiles[i][j].getEntities().get(0));
                        break;
                }
            }
        }
    }
    public List<Player> getPlayers(){
        return playerObjList;
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

    public Tile[][] getMapMatrix() {
        Tile[][] returnTiles  = new Tile[size][size];
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                returnTiles[i][j] = new Tile(tiles[i][j]);
            }
        }
        return returnTiles;

    }

    @Override
    public boolean tryMove(Position newPos, Player player) {
        Position currPos = player.getPosition();
        if (tiles[newPos.getX()][newPos.getY()].isTileEmpty()){
            tiles[currPos.getX()][currPos.getY()].removeEntity();
            tiles[newPos.getX()][newPos.getY()].addEntity(player);
            return true;
        }
        return false;
    }

    @Override
    public boolean addEntityToWorld(Position pos, Entity ent) {
        if (tiles[pos.getX()][pos.getY()].isTileEmpty()){
            tiles[pos.getX()][pos.getY()].addEntity(ent);
            return true;
        }
        return false;
    }

    @Override
    public boolean tryToKillEntity(Entity ent) {
        if (!tiles[ent.getPosition().getX()][ent.getPosition().getY()].isTileEmpty()){
            tiles[ent.getPosition().getX()][ent.getPosition().getY()].removeEntity();
            return true;
        }
        return false;
    }


}