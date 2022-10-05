package Models;

import Models.Position;

public class Wall extends Entity{

    private final boolean isDestroyable;

    public Wall(Position position, boolean isDestroyable){
        super(position);
        this.isDestroyable = isDestroyable;
    }

    public boolean isDestroyable() {
        return isDestroyable;
    }

    @Override
    protected Entity copyThis() {
        return new Wall(this.isDestroyable, new Position(this.position));
    }
}
