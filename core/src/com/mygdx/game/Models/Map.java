package com.mygdx.game.Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 *
 * The class represents a map that contains tiles, see {@link Tile} and entities, see {@link Entity}
 */
public class Map implements EventListener, IExplodable, IPlayable {

    private final int size = 20;
    private final Tile[][] tiles;
    private String[][] maps = new String[size][size];
    private List<Player> playerObjList = new ArrayList<>();
    private List<Wall> wallObjList = new ArrayList<>();
    private List<SoftWall> softWallObjList = new ArrayList<>();
    private List<Bomb> bombObjList = new ArrayList<>();
    private List<Boolean> wallsDestroyed = new ArrayList<>(2);

    /**
     * Class constructor.
     */
    public Map(){
        tiles = createTiles();
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

    private void addObjects(){

        readTextMap();

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                String decider = maps[i][j];
                switch (decider) {
                    case "1":
                        Wall wall = new Wall(new Position(i, j));
                        tiles[i][j].addEntity(wall);
                        wallObjList.add(wall);
                        break;
                    case "2":
                        SoftWall softWall = new SoftWall(new Position(i, j), softWallObjList);
                        tiles[i][j].addEntity(softWall);
                        softWallObjList.add(softWall);
                        break;
                    case "3":
                        Player player = new Player(new Position(i, j), this, playerObjList);
                        tiles[i][j].addEntity(player);
                        playerObjList.add(player);
                        break;
                }
            }
        }
    }

    private void readTextMap() {
        try {
            List<String> rows = new ArrayList<>();

            BufferedReader bf = new BufferedReader(new FileReader("../assets/test.txt"));

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

    /**
     * Offers a way for a player to request to move if the position the player is trying to move to is available.
     * @param newPos the {@link Position} that the player is trying to move to.
     * @param player the {@link Player} object that is trying to move.
     * @return returns true if the {@link Player} is moved successfully, false otherwise.
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

    /**
     *
     * @param player - an instance of the player {@link Player} that drops the bomb {@link Bomb}
     */
    @Override
    public void dropBomb(Player player) {
        Bomb bomb = new Bomb(player.getPosition(), player.getBombLength(), this,player);
        tryAddBombToWorld(player.getPosition(), bomb);
    }

    /**
     * Offers a way for objects to try adding an {@link Entity} to the world.
     * @param pos the {@link Position} that the {@link Entity} is trying to be added at.
     * @param bomb the {@link Entity} that is trying to be added.
     * @return returns true if the {@link Entity} is added successfully to a {@link Tile}, false otherwise.
     */
    @Override
    public boolean tryAddBombToWorld(Position pos, Bomb bomb) {
        tiles[pos.getX()][pos.getY()].addEntity(bomb);
        bombObjList.add(bomb);
        return false;
    }

    /**
     * Offers a way for objects to try removing an {@link Entity} from the world.
     * @param position the {@link Entity} that is trying to be removed.
     * @return returns true if the {@link Entity} is removed successfully, false otherwise.
     */
    @Override
    public List<Boolean> tryToKillEntity(Position position) {
        wallsDestroyed.clear();
        if (!tiles[position.getX()][position.getY()].isTileEmpty()){
            Entity entity = tiles[position.getX()][position.getY()].getEntities().get(0);
            if (entity instanceof IDestroyable){
                tiles[position.getX()][position.getY()].removeEntity();
                ((IDestroyable) entity).terminate();
                wallsDestroyed.add(true);
                wallsDestroyed.add(true);
            }
            wallsDestroyed.add(true);
            wallsDestroyed.add(false);
        }
        wallsDestroyed.add(false);
        wallsDestroyed.add(false);
        return wallsDestroyed;
    }

    /**
     *
     * @param bomb - an instance of the bomb {@link Bomb}
     * @return true
     */
    @Override
    public boolean removeBombFromWorld(Bomb bomb) {
        tiles[bomb.getPosition().getX()][bomb.getPosition().getY()].removeEntity();
        bombObjList.remove(bomb);
        return true;
    }



}