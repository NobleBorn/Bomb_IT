package Models;

import java.util.ArrayList;
import java.util.List;

public class BombExplosion{

    private List<BombExplosionSquare> bombExplosionSquares = new ArrayList<>(1);

    public BombExplosion(Position position, int length){
        createBombExplosionSquares(position, length);
    }

    private Wall permWall;
    private void createBombExplosionSquares(Position position, int length) {

        int tailLength = (length-1)/2;

        bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX(), position.getY())));
        for (int i = 1; i <= tailLength; i++) {

            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX() + i, position.getY())));
            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX() - i, position.getY())));
            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX(), position.getY() + i)));
            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX(), position.getY() - i)));

            }

        //lägg till hänsyn för väggar typ if(inte destroyable)
        for(BombExplosionSquare b : bombExplosionSquares){
            if((b.getPosition() == permWall.getPosition()) && !(permWall.isDestroyable())){
                bombExplosionSquares.remove(b);

            }
        }

    }



    public List<BombExplosionSquare> getBombExplosionSquares() {
        return bombExplosionSquares;
    }
}
