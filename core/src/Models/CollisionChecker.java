package Models;


import java.util.List;

public class CollisionChecker {

    private Map map;

    public CollisionChecker(Map map){
        this.map = map;
    }

    public boolean isNextTileFree(Position newPosition){

        Tile[][] tiles = map.getTiles();
        int x = newPosition.getX();
        int y = newPosition.getY();
        return tiles[x][y].isTileEmpty(); //returns whether tile is empty or not
    }

    public void bombCollision(BombExplosionSquare bombExplosion){

    }

    public void checkCollision(){

    }
}
