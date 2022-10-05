package Models;

public class Player extends Entity{
    private Enum direction;
    private Position nextPosition;
    private PlayerHelper playerHelper;
    private int score;
    private boolean alive;
    private int bombLength;
    private CollisionChecker cc;

    public MoveObservable observable;

    public Player(Position position, CollisionChecker cc){
        super(position);
        this.cc = cc;
        this.direction = Models.Direction.DOWN;
        this.score = 0;
        this.alive = true;
        this.bombLength = 1;
        this.observable = new MoveObservable();
    }

    public void walk(Direction newDirection) {
        direction = newDirection;
        nextPosition = newPositionHandler();

        if (cc.isNextTileFree(nextPosition)){
            observable.notifySubscribers(position, nextPosition);
            position = nextPosition;
        }
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
        Bomb bomb = new Bomb(getPosition(), bombLength, cc);

    }

    public void terminate(){
        alive = false;
    }
}
