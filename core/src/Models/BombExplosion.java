package Models;

import java.util.ArrayList;
import java.util.List;

public class BombExplosion { //if extend Entity, BombExplosion and its center BombExplosionSquare will cause collision with each other

    private List<BombExplosionSquare> bombExplosionSquares = new ArrayList<>(1);
    private Position position;

    public BombExplosion(Position position, int length){
        this.position = position;
        createBombExplosionSquares(position, length);
    }

    private void createBombExplosionSquares(Position position, int length) {
        //lägg till hänsyn för väggar
        for (int i = (-length); i < length; i++){
            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX()+i, position.getY())));
            if (i != 0) {
                bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX(), position.getY()+i)));
            }

        }
    }

    public List<BombExplosionSquare> getBombExplosionSquares() {
        return bombExplosionSquares;
    }
}
