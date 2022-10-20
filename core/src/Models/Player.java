package Models;

import java.util.List;

/**
 * The class represents a player as a subclass of {@link Models.Entity} which is destroyable {@link IDestroyable}
 * And listens to bomb's explosoin events {@link IBombListener}
 */
public class Player extends Entity implements IDestroyable,IBombListener{
    private boolean isWalking = false;
    private Direction direction;
    private int score;
    private boolean alive;
    private int bombLength;
    private IPlayable playerAction;
    private List<Player> objList;
    private boolean isBombActive = false;

    /**
     * Class constructor
     * @param position the initial {@link Models.Position} of a player at the time of creating it.
     */
    public Player(Position position, IPlayable playerAction, List<Player> objList){
        super(position);
        this.playerAction = playerAction;
        this.direction = Direction.UP;
        this.score = 0;
        this.alive = true;
        this.bombLength = 1;
        this.objList = objList;
    }

    public boolean isWalking(){
        return isWalking;
    }
    public void setWalking(boolean isWalking){
        this.isWalking = isWalking;
    }

    /**
     * Methods offers a way for the player to move one {@link Models.Tile} on the map, if possible, and change its position. Note that the player's {@link Models.Direction} will be changed regardless of the result of the attempt of moving the {@link Models.Player}.
     * @param newDirection the direction that the player is trying to move in.
     */
    public void walk(Direction newDirection) {
        this.direction = newDirection;
        Position nextPosition = newPositionHandler();

        if (playerAction.tryMove(nextPosition, this)){
            position = nextPosition;
        }
    }

    /**
     * @return returns the current {@link Models.Direction} of a player. Direction is right by default.
     */
    public Direction getDirection() {
        return direction;
    }
    protected int getBombLength(){
        return bombLength;
    }

    /**
     * @return returns a player's current score
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return current status of player's life
     */
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
    public void dropBomb() {
        if(!isBombActive) {
            playerAction.dropBomb(this);
            isBombActive = true;
        }
    }

    /**
     *
     * @param wallsDestroyed - number of the soft walls destroyed {@link SoftWall} after explosion
     */
    @Override
    public void addScore(int wallsDestroyed) {
        score += wallsDestroyed;
        isBombActive = false;
    }

    /**
     * Sets "alive" variable to false
     * Removes player's object from the map
     */
    public void terminate(){
        alive = false;
        objList.remove(this);
    }

}
