package Models;

public class Player extends Entity{
    private Enum direction;
    private PlayerHelper playerHelper;
    private int score;
    private boolean alive;
    private int bombLength;

    public Player(Position position){
        super(position);
        this.direction = Models.Direction.DOWN;
        this.score = 0;
        this.alive = true;
        this.bombLength = 1;

    }

    public void walk(Direction newDirection) {
        direction = newDirection;
        Position newPosition = newPositionHandler();

        playerHelper = new PlayerHelper(newPosition);
        if (playerHelper.callCollisionChecker()){
            position = newPosition;
        }
        /*
        CollisionChecker collisionChecker = new CollisionChecker();
        if (collisionChecker.playerNextTileFree(newPosition, map)){ //player shouldn't need to know about the map
            position = newPosition;
        }
         */
    }

    private Position newPositionHandler() { //possible improvement?
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
        Bomb bomb = new Bomb(getPosition(), bombLength);

    }

    public void terminate(){
        alive = false;
    }
}
