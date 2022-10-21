package com.mygdx.game.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the bomb's explosion {@link Bomb} and manages the explosion events
 */
class BombExplosion {

    private List<Position> bombExplosionPositions = new ArrayList<>();
    private final Position position;
    private final IExplodable bombManager;
    private final int bombLength;
    private int wallsDestroyed;

    /**
     * Constructor
     *
     * @param position - position of the bomb {@link Bomb} from where the explosion happens
     * @param length - length of the explosion for each direction
     * @param bombManager - an instance of IExplodable {@link IExplodable}
     */
    public BombExplosion(Position position, int length, IExplodable bombManager){
        this.position = position;
        this.bombLength = length;
        this.bombManager = bombManager;
        createBombExplosionPositions(length);
        bombContact();
    }

    /**
     * Creates an explosion area of the length of bomb's explosion {@link Bomb}
     *
     * @param length - length of the explosion for each direction
     */
    private void createBombExplosionPositions(int length) {
        
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
     * In contact with explosion try to kill the entity {@link Entity} (true if entity is destroyable false otherwise)
     * For every soft wall {@link SoftWall} destroyed add 1 to "wallsDestroyed" variable
     */
    private void bombContact() {
        wallsDestroyed = 0;
        bombManager.tryToKillEntity(bombExplosionPositions.get(0));
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= bombLength; j++){
                List<Boolean> isWallDestroyable = bombManager.tryToKillEntity(bombExplosionPositions.get(i * bombLength + j));
                if (isWallDestroyable.get(1)){
                    wallsDestroyed++;
                    break;
                } else if(isWallDestroyable.get(0)){
                    break;
                }
            }
        }
    }

    /**
     *
     * @return current number of destroyed soft walls {@link SoftWall}
     */
    public int getWallsDestroyed() {
        return wallsDestroyed;
    }


}
