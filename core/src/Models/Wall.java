package Models;

import Models.Position;

public class Wall extends Entity{

    private final boolean isDestroyable;

    public Wall(boolean isDestroyable, Position position){
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
