package com.mygdx.game.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represents a place for entities to exist and be manipulated.
 */
public class Tile {
    private Position position;
    private List<Entity> entities = new ArrayList<>(1);
    public static final int tileSize = 48;

    /**
     * Class constructor that takes in relative position coordinates to specify the tile's position on a certain coordinate system.
     * @param x an integer that specifies the x-coordinate for the tile.
     * @param y an integer that specifies the y-coordinate for the tile.
     */
    public Tile(int x, int y){
        this.position = new Position(x, y);
    }


    /**
     * Add an entity to the objects in the tile.
     * @param e the entity to be added to the tile's objects.
     */
    protected void addEntity(Entity e){
        entities.add(e);
    }
    /**
     * Remove an entity from the objects in the tile.
     */
    protected void removeEntity() {
        entities.clear();
    }

    /**
     * Checks if the tile contains any objects.
     * @return returns true if the tile has no objects in it, false otherwise.
     */
    protected boolean isTileEmpty(){
        return entities.size() == 0;
    }
    protected void removePlayer(Player player){
        entities.remove(player);
    }

    /**
     * Methods offers a way to get a deep-copy of the objects on the tile. Requires entities to be a subclass of {@link Entity}.
     * @return returns entities array with {@link Entity} objects.
     */
    protected List<Entity> getEntities(){
        return entities;
    }
}
