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
        this.direction = Direction.UP;
        this.score = 0;
        this.alive = true;
        this.bombLength = 1;
        this.observable = new MoveObservable();
    }

    public void walk(Direction newDirection) {
        this.direction = newDirection;
        nextPosition = newPositionHandler();

        if (cc.isNextTileFree(nextPosition)){
            observable.notifySubscribers(position, nextPosition);
            position = nextPosition;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public int getScore() {
        return score;
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

    CollisionChecker isWallHit = new CollisionChecker();
    private Wall wall;
    private BombExplosion bombex;

    public collectPoints() {
        // make the players collect 10 points when wall is destroyed
        //skriv ut på spelplanen

        if (isWallHit.bombCollision(wall, bombex)) {
            score = score + 10;
            //updatera
        }
    }

    public
    // när tiden är slut vinner spelaren med mest poäng

    public void terminate(){
        alive = false;
    }

    @Override
    protected Entity copyThis() {
        return new Player(new Position(position), cc);
    }
}
