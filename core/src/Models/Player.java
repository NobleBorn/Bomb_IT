package Models;

/**
 * The class represents a player as a subclass of {@link Models.Entity} and a navigable entity.
 */
public class Player extends Entity implements Destroyable{
    private Direction direction;
    private Position nextPosition;
    private int score;
    private boolean alive;
    private int bombLength;
    private INavigable navigation;
    public MoveObservable observable;
    private Bomb bomb;

    /**
     * Class constructor
     * @param position the initial {@link Models.Position} of a player at the time of creating it.
     * @param navigation a {@link Models.INavigable} for the player to be able to request navigation commands from the {@link Models.Map}.
     */
    public Player(Position position, INavigable navigation){
        super(position);
        this.navigation = navigation;
        this.direction = Direction.UP;
        this.score = 0;
        this.alive = true;
        this.bombLength = 1;
        this.observable = new MoveObservable();
    }


    /**
     * Methods offers a way for the player to move one {@link Models.Tile} on the map, if possible, and change its position. Note that the player's {@link Models.Direction} will be changed regardless of the result of the attempt of moving the {@link Models.Player}.
     * @param newDirection the direction that the player is trying to move in.
     */
    public void walk(Direction newDirection) {
        this.direction = newDirection;
        nextPosition = newPositionHandler();

        if (navigation.tryMove(nextPosition, this)){
            position = nextPosition;
        }
        //if (cc.isNextTileFree(nextPosition)){
        //    observable.notifySubscribers(position, nextPosition);

        //}
    }

    /**
     * @return returns the current {@link Models.Direction} of a player. Direction is right by default.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return returns a player's current score
     */
    public int getScore() {
        return score;
    }

    public boolean isAlive() {
        return alive;
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

    /**
     * Creates a {@link Models.Bomb} at the current {@link Models.Position}.
     */
    public void dropBomb(){
        //add so you cannot drop infinite bombs
        //should bomb be placed a tile behind the player?
        this.bomb = new Bomb(getPosition(), bombLength, navigation);
        addScore();
    }

    private void addScore() {
        score = bomb.getWallsDestroyedFromExplosion() * 10;
    }

    public void terminate(){
        alive = false;
    }

    /**
     * Offers a way to create a deep-copy of the player.
     * @return returns a deep-copy of the player with a new {@link Models.Position} object but same coordinates, and the same {@link Models.CollisionChecker} object.
     */
    @Override
    protected Entity copyThis() {
        return new Player(new Position(position), navigation);
    }
}
