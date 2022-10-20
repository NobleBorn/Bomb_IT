package Models;

/**
 * The class represents a wall object of the supertype {@link Models.Entity} on the map.
 */
public class Wall extends Entity{

    /**
     *
     * @param position - position of the wall on the map {@link Map}
     */
    public Wall(Position position){
        super(position);
    }

}
