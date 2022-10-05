package Models;

public abstract class Entity {
    protected Position position;

    Entity(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }
    protected abstract Entity copyThis();
}
