package Models;

import java.util.ArrayList;
import java.util.List;

public class BombExplosion{

    private List<BombExplosionSquare> bombExplosionSquares = new ArrayList<>(1);

    public BombExplosion(Position position, int length){
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
