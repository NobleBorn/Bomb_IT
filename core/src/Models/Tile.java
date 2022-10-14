package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represents a place for entities to exist and be manipulated.
 */
public class Tile {
    private Position position;
    public List<Entity> entities = new ArrayList<>(1);
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
     * Class constructor that takes in a tile object and copies its content.
     * @param otherTile a separate tile to replicate.
     */
    public Tile(Tile otherTile){
        this.position = new Position(otherTile.position);
        this.entities = copyEntities(otherTile.entities);
    }

    /**
     * Add an entity to the objects in the tile.
     * @param e the entity to be added to the tile's objects.
     */
    public void addEntity(Entity e){
        entities.add(e);
    }
    /**
     * Remove an entity from the objects in the tile.
     */
    public void removeEntity() {
        if (entities.size() > 0) {
            entities.remove(0);
        }
    }

    /**
     * Checks if the tile contains any objects.
     * @return returns true if the tile has no objects in it, false otherwise.
     */
    public boolean isTileEmpty(){
        return entities.size() == 0;
    }

    /**
     * Methods offers a way to get a deep-copy of the objects on the tile. Requires entities to be a subclass of {@link Models.Entity}.
     * @return returns a deep-copy of the tile's entity array.
     */
    public List<Entity> getEntities(){
        List<Entity> entitiesReturn = new ArrayList<>();
        for (Entity ent: entities){
            entitiesReturn.add(ent.copyThis());
        }
        return entitiesReturn;
    }

    private List<Entity> copyEntities(List<Entity> otherEntities) {
        for(Entity ent: otherEntities){
            addEntity(ent.copyThis());
        }
        return entities;
    }
}
