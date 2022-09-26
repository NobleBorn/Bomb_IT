package Models;

import Models.Position;

public class Wall extends Entity{

    private boolean isDestroyable;
    private Position position;

    public Wall(boolean isDestroyable, Position position){
        this.isDestroyable = isDestroyable;
        this.position = position;
    }

    public boolean isDestroyable() {
        return isDestroyable;
    }
}
