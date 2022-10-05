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
}
