package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * The class represents a map that contains tiles, see {@link Models.Tile} and entities, see {@link Models.Entity}
 */
public class Map implements EventListener, IExplodable, IPlayable {

    private final int size = 20;
    private final int y = size;
    private final int x = size;
    private final Tile[][] tiles;
    private Player player;
    private Wall wall;
    private SoftWall softWall;
    private String[][] maps = new String[size][size];
    private List<Player> playerObjList = new ArrayList<>();
    private List<Wall> wallObjList = new ArrayList<>();
    private List<SoftWall> softWallObjList = new ArrayList<>();
    private List<Bomb> bombObjList = new ArrayList<>();


    /**
     * Class constructor.
     */
    public Map(){
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

    private void loadWalls(){
        //createPowerUps();
    }

    private void addObjects(){

        try {
            List<String> rows = new ArrayList<>();
            BufferedReader bf = new BufferedReader(new FileReader("/Users/nobleborn/Desktop/Project/assets/test.txt"));

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
                        wall = new Wall(new Position(i, j));
                        tiles[i][j].addEntity(wall);
                        wallObjList.add(wall);
                        break;
                    case "2":
                        softWall = new SoftWall(new Position(i, j), softWallObjList);
                        tiles[i][j].addEntity(softWall);
                        softWallObjList.add(softWall);
                        break;
                    case "3":
                        player = new Player(new Position(i, j), this, playerObjList);
                        tiles[i][j].addEntity(player);
                        playerObjList.add(player);
                        break;
                }
            }
        }
    }
    public List<Player> getPlayers(){
        return playerObjList;
    }
    public List<Wall> getPermWalls(){
        return wallObjList;
    }
    public List<SoftWall> getSoftWalls(){
        return softWallObjList;
    }
    public List<Bomb> getBombs(){
        return bombObjList;
    }
    public int[] getSize(){
        int[] coordinates = new int[2];

        coordinates[0] = x;
        coordinates[1] = y;

        return coordinates;
    }

    /**
     * Offers a way for a player to request to move if the position the player is trying to move to is available.
     * @param newPos the {@link Models.Position} that the player is trying to move to.
     * @param player the {@link Models.Player} object that is trying to move.
     * @return returns true if the {@link Models.Player} is moved successfully, false otherwise.
     */
    @Override
    public boolean tryMove(Position newPos, Player player) {
        Position currPos = player.getPosition();
        if (tiles[newPos.getX()][newPos.getY()].isTileEmpty()){
            tiles[currPos.getX()][currPos.getY()].removePlayer(player);
            tiles[newPos.getX()][newPos.getY()].addEntity(player);
            return true;
        }
        return false;
    }

    @Override
    public void dropBomb(Player player) {
        Bomb bomb = new Bomb(player.getPosition(), player.getBombLength(), this);
        tryAddBombToWorld(player.getPosition(), bomb);
    }

    /**
     * Offers a way for objects to try adding an {@link Models.Entity} to the world.
     * @param pos the {@link Models.Position} that the {@link Models.Entity} is trying to be added at.
     * @param ent the {@link Models.Entity} that is trying to be added.
     * @return returns true if the {@link Models.Entity} is added successfully to a {@link Models.Tile}, false otherwise.
     */
    @Override
    public boolean tryAddBombToWorld(Position pos, Bomb bomb) {
        tiles[pos.getX()][pos.getY()].addEntity(bomb);
        bombObjList.add(bomb);
        return false;
    }

    /**
     * Offers a way for objects to try removing an {@link Models.Entity} from the world.
     * @param position the {@link Models.Entity} that is trying to be removed.
     * @return returns true if the {@link Models.Entity} is removed successfully, false otherwise.
     */
    @Override
    public boolean tryToKillEntity(Position position) {
        if (!tiles[position.getX()][position.getY()].isTileEmpty()){
            Entity entity = tiles[position.getX()][position.getY()].getEntities().get(0);
            if (entity instanceof Destroyable){
                tiles[position.getX()][position.getY()].removeEntity();
                ((Destroyable) entity).terminate();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean removeBombFromWorld(Bomb bomb) {
        tiles[bomb.getPosition().getX()][bomb.getPosition().getY()].removeEntity();
        bombObjList.remove(bomb);
        return true;
    }


}