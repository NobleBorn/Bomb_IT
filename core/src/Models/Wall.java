package Models;

import Models.Position;

/**
 * The class represents a wall object of the supertype {@link Models.Entity} on the map.
 */
public class Wall extends Entity{

    private final boolean isDestroyable;

    /**
     * Class constructor.
     * @param isDestroyable an unchangeable {@link Boolean} that differentiates between destroyable and undestroyable walls.
     * @param position a {@link Models.Position} that specifies which {@link Models.Tile} the wall belongs to.
     */
    public Wall(boolean isDestroyable, Position position){
        super(position);
        this.isDestroyable = isDestroyable;
    }

    /**
     * @return returns true if the wall is initialized as destroyable, false otherwise.
     */
    public boolean isDestroyable() {
        return isDestroyable;
    }

    /**
     * Offers a way to create a deep-copy of the wall.
     * @return returns a deep-copy of the wall with a new {@link Models.Position} object but same coordinates.
     */
    @Override
    protected Entity copyThis() {
        return new Wall(this.isDestroyable, new Position(this.position));
    }
}
