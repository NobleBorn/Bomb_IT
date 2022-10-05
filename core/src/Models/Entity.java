package Models;

public class Entity {
    protected Position position;

    Entity(Position position){
        this.position = position;

    }

    public Position getPosition(){
        return position;
    }

    public void terminate(Entity self){
        self = null; //does this work?
    }
}
