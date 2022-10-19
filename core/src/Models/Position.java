package Models;

/**
 * The class is a general class used to represent x- and y-coordinates of a tile and/or objects in the tile, on the map.
 * @see Models.Tile
 */
public class Position {
    private final int x;
    private final int y;
    /**
     * Class constructor.
     * @param x an integer that specifies the x-coordinate for the position.
     * @param y an integer that specifies the y-coordinate for the position.
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * Class constructor.
     * @param pos a position to replicate the x- and y-coordinates of.
     */
    public Position(Position pos){
        this.x = pos.getX();
        this.y = pos.getY();
    }

    /**
     *
     * @return current x position
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return current y position
     */
    public int getY() {
        return y;
    }
}
