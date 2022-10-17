package Models;

import java.util.ArrayList;
import java.util.List;

public class BombExplosion {

    private List<Position> bombExplosionPositions = new ArrayList<>(1);
    private Position position;
    private INavigable navigation;
    private final int bombLength;

    public BombExplosion(Position position, int length, INavigable navigation){
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

    private int wallsDestroyed;

    private void bombContact() {
        wallsDestroyed = 0;
        navigation.tryToKillEntity(bombExplosionPositions.get(0));
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= bombLength; j++){
                if (navigation.tryToKillEntity(bombExplosionPositions.get(i*bombLength+j))){
                    wallsDestroyed ++;
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
