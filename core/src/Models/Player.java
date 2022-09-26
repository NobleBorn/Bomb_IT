package Models;

public class Player extends Entity{
    public boolean getPosition;
    private Enum direction;
    private Position position;

    public Player(){
        this.position = new Position(0, 0);
        this.direction = Models.Direction.UP;
    }

    public Direction getDirection(){
        return (Direction) direction;
    }

    public void Walk(){
    }
}
