package Models;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    private Position position;
    public List<Entity> entities = new ArrayList<>();
    private static final int tileSize = 64;

    public Tile(int x, int y){
        this.position = new Position(x, y);
    }
    public Tile(Tile other){
        this.position = new Position(other.position);
        this.entities = copyEntities(other.entities);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }
    public void removeEntity(Entity e){
        entities.remove(e);
    }
    public boolean isTileEmpty(){
        return entities.size() == 0;
    }
    public static int getTileSize(){
        return tileSize;
    }
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
