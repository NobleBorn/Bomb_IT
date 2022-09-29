package Models;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    private Position position;
    List<Entity> entities = new ArrayList<>(1);

    public Tile(int x, int y){
        this.position = new Position(x, y);
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
}
