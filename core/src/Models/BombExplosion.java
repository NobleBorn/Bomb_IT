package Models;

import java.util.ArrayList;
import java.util.List;

public class BombExplosion {

    protected List<Position> bombExplosionPositions = new ArrayList<>();
    private Position position;
    private IExplodable navigation;
    private final int bombLength;
    private int wallsDestroyed;
    private List<Boolean> isWallDestroyable;

    public BombExplosion(Position position, int length, IExplodable navigation){
        this.position = position;
        this.bombLength = length;
        this.navigation = navigation;
        createBombExplosionPositions(position, length);
        bombContact();
    }

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

    private void bombContact() {
        wallsDestroyed = 0;
        navigation.tryToKillEntity(bombExplosionPositions.get(0));
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= bombLength; j++){
                isWallDestroyable = navigation.tryToKillEntity(bombExplosionPositions.get(i*bombLength+j));
                if (isWallDestroyable.get(1)){
                    wallsDestroyed++;
                    break;
                } else if(isWallDestroyable.get(0)){
                    break;
                }
            }
        }
    }

    public int getWallsDestroyed() {
        return wallsDestroyed;
    }

    public List<Position> getBombExplosionPositions() {
        return bombExplosionPositions;
    }

}
