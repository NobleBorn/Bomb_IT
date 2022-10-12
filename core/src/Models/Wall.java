package Models;

import Models.Position;

/**
 * The class represents a wall object of the supertype {@link Models.Entity} on the map.
 */
public class Wall extends Entity{

    public Wall(Position position){
        super(position);
    }

    /**
     * Offers a way to create a deep-copy of the wall.
     * @return returns a deep-copy of the wall with a new {@link Models.Position} object but same coordinates.
     */
    @Override
    protected Entity copyThis() {
        return new Wall(new Position(this.position));
    }
}
