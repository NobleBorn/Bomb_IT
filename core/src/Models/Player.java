package Models;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Player extends Entity {
    private Direction direction;
    private Position nextPosition;
    private int score;
    private boolean alive;
    private int bombLength;
    private CollisionChecker cc;
    private int id;

    public MoveObservable observable;

    public Player(Position position, CollisionChecker cc) {
        super(position);
        this.cc = cc;
        this.direction = Direction.UP;
        this.score = 0;
        this.alive = true;
        this.bombLength = 1;
        this.observable = new MoveObservable();
        this.id = 2;
    }

    public void walk(Direction newDirection) {
        this.direction = newDirection;
        nextPosition = newPositionHandler();

        if (cc.isNextTileFree(nextPosition)) {
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
        if (direction == Direction.UP) {
            newPosition = new Position(position.getX() + 1, position.getY());
        } else if (direction == Direction.RIGHT) {
            newPosition = new Position(position.getX(), position.getY() + 1);
        } else if (direction == Direction.DOWN) {
            newPosition = new Position(position.getX() - 1, position.getY());
        } else {
            newPosition = new Position(position.getX(), position.getY() - 1);
        }
        return newPosition;


        public void dropBomb () {
            Bomb bomb = new Bomb(getPosition(), bombLength, cc);
        }


        public void terminate () {
            alive = false;
        }

        @Override
        protected Entity copyThis () {
            return new Player(new Position(position), cc);
        }
    }
}


