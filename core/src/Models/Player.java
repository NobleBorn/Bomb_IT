package Models;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Player {
    private Position position;
    private int health = 100;

    // private Bomb bomb;

    public Player(Position position){//, Bomb bomb){
        this.position = position;
    }

    /**
     *
     * @param dt delta time given by the graphical representation of the game
     * @param newPosition the new position that the player is trying to move to
     * @param validPositions the array with all available positions on the map (can be surrounding available positions instead of all)
     */
    public void update(float dt, Position newPosition, Position[] validPositions){
        if (Arrays.asList(validPositions).contains(newPosition)) {
            updatePosition(newPosition);
        }
        //System.out.printf("%.2f%.2f", validPositions[0].getX(), validPositions[0].getY());
    }
    private void updatePosition(Position newPosition){
        position = newPosition;
    }
    public void dropBomb(){
        //Bomb bomb = new Bomb(position);
        //bomb.drop();
    }
    public Position getPosition(){
        return new Position(position.getX(), position.getY());
    }
}
