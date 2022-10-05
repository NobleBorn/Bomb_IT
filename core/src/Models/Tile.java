package Models;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    private Position position;
    public List<Entity> entities = new ArrayList<>(1); //doesn't necessarily need to be a list
    //public Entity entity;

    public Tile(int x, int y) {
        this.position = new Position(x, y);
    }


    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

    public boolean isTileEmpty() {
        return entities.size() != 0;
    }

    /*
    public void addEntity(Entity e){ entity = e; }
    public void removeEntity(Entity e){ entity = null; }
    public boolean isTileEmpty(){ return !(entity == null); }

     */
}
