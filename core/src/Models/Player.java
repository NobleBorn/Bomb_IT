package Models;

public class Player extends Entity{
    private Enum direction;
    private Position nextPosition;
    private PlayerHelper playerHelper;
    private int score;
    private boolean alive;
    private int bombLength;

    public MoveObservable observable;

    public Player(Position position){
        super(position);
        this.direction = Models.Direction.DOWN;
        this.score = 0;
        this.alive = true;
        this.bombLength = 1;
        this.observable = new MoveObservable();
    }

    public void walk(Direction newDirection) {
        nextPosition = newPositionHandler();

        playerHelper = new PlayerHelper(nextPosition);
        if (playerHelper.isNextTileFree()){
            position = nextPosition;
        }

        observable.notifySubscribers(position, nextPosition); //right now position is overwritten with nextPosition

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
        //should bomb be placed a tile behind the player?
        Bomb bomb = new Bomb(getPosition(), bombLength);

    }

    public void terminate(){
        alive = false;
    }


    public Position getNextPosition() {
        return nextPosition;
    }
}
