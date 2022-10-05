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

    private Wall wall;
    private void createBombExplosionSquares(Position position, int length) {

        int tailLength = (length-1)/2;

        bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX(), position.getY())));
        for (int i = 1; i <= tailLength; i++) {

            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX() + i, position.getY())));
            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX() - i, position.getY())));
            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX(), position.getY() + i)));
            bombExplosionSquares.add(new BombExplosionSquare(new Position(position.getX(), position.getY() - i)));

        }

        int var = 4;
        for(int n = 0; n <= bombExplosionSquares.size(); n++){
            if((bombExplosionSquares.get(n).getPosition() == wall.getPosition()) && !(wall.isDestroyable())){
                int var2 = 0;
                while(n+var2*var<bombExplosionSquares.size()){
                    bombExplosionSquares.remove(bombExplosionSquares.get(n+var*var2));
                    var2++;
                }
                var--;
            }
        }

    }



    public List<BombExplosionSquare> getBombExplosionSquares() {
        return bombExplosionSquares;
    }
}
