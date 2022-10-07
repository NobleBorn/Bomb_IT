package Models;

public class Player extends Entity{
    private Direction direction;
    private Position nextPosition;
    private int score;
    private boolean alive;
    private int bombLength;
    private CollisionChecker cc;

    public MoveObservable observable;

    public Player(Position position, CollisionChecker cc){
        super(position);
        this.cc = cc;
        this.direction = Direction.RIGHT;
        this.score = 0;
        this.alive = true;
        this.bombLength = 1;
        this.observable = new MoveObservable();
    }
    public boolean isAlive(){
        return alive;
    }
    public void walk(Direction newDirection) {
        //if (!(direction == newDirection)){
            direction = newDirection;
          //  return;
        //}
        nextPosition = newPositionHandler();

        if (cc.isNextTileFree(nextPosition)){
            observable.notifySubscribers(position, nextPosition);
            position = nextPosition;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    private Position newPositionHandler() { //possible improvement?
        Position newPosition;
        if (direction == Direction.UP){
            newPosition = new Position(position.getX()+1, position.getY());
        }
        else if (direction == Direction.RIGHT){
            newPosition = new Position(position.getX(), position.getY()+1);
        }
        else if (direction == Direction.DOWN){
            newPosition = new Position(position.getX()-1, position.getY());
        }
        else{
            newPosition = new Position(position.getX(), position.getY()-1);
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

    @Override
    protected Entity copyThis() {
        return new Player(new Position(position), cc);
    }
}
