package Models;

public class Player extends Entity{
    private Enum direction;
    private Position position;

    public Player(){
        this.position = new Position(0, 0);
        this.direction = Models.Direction.DOWN;
    }

    public void walk(Direction newDirection) {
        direction = newDirection;
        Position newPosition = newPositionHandler();

        CollisionChecker collisionChecker = new CollisionChecker();
        if (collisionChecker.playerNextTileFree(newPosition, map)){ //player shouldn't need to know about the map
            position = newPosition;
        }
    }

    private Position newPositionHandler() {
        Position newPosition;
        if (direction == Direction.UP){
            newPosition = new Position(position.getX(), position.getY()+1);
        }
        else if (direction == Direction.RIGHT){
            newPosition = new Position(position.getX()+1, position.getY());
        }
        else if (direction == Direction.DOWN){
            newPosition = new Position(position.getX(), position.getY()-1);
        }
        else{
            newPosition = new Position(position.getX()-1, position.getY()+1);
        }
        return newPosition;
    }

    public void dropBomb(){
        //add so you cannot drop infinite bombs
        Bomb bomb = new Bomb(getPosition());
        bomb.drop();
    }
    public Position getPosition(){
        return new Position(position.getX(), position.getY());
    }
}
