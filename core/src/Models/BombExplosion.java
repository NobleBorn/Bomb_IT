package Models;

import java.util.ArrayList;
import java.util.List;

public class BombExplosion {

    protected List<Position> bombExplosionPositions = new ArrayList<>();
    private Position position;
    private IExplodable navigation;
    private final int bombLength;

    /**
     * Constructor
     *
     * @param position - position of the bomb
     * @param length - length of the explosion
     * @param navigation - an instance of the IExplodable interface
     */
    public BombExplosion(Position position, int length, IExplodable navigation){
        this.position = position;
        this.bombLength = length;
        this.navigation = navigation;
        createBombExplosionPositions(position, length);
        bombContact();
    }

    /**
     * Creates an explosion area the length of the bomblength for each direction
     *
     * @param position - position of the bomb
     * @param length - length of the bomb
     */
    private void createBombExplosionPositions(Position position, int length) {
        
        bombExplosionPositions.add(new Position(position.getX(), position.getY()));
        for (int i = 1; i <= length; i++) {
            bombExplosionPositions.add(new Position(position.getX() + i, position.getY()));
        }
        for (int i = 1; i <= length; i++) {
            bombExplosionPositions.add(new Position(position.getX(), position.getY() + i));
        }
        for (int i = 1; i <= length; i++) {
            bombExplosionPositions.add(new Position(position.getX() - i, position.getY()));
        }
        for (int i = 1; i <= length; i++) {
            bombExplosionPositions.add(new Position(position.getX(), position.getY() - i));
        }
    }

    /**
     * In contact with an explosion area, try to kill the entity (if entity is destroyable then true) and stops
     * further explosion in that direction
     */
    private void bombContact() {
        navigation.tryToKillEntity(bombExplosionPositions.get(0));
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= bombLength; j++){
                if (navigation.tryToKillEntity(bombExplosionPositions.get(i*bombLength+j))){
                    break;
                }
            }
        }
    }
}
