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

    public boolean bombCollision(BombExplosion bombExplosion) {

        Tile[][] tiles = map.getTiles();
        List<Position> explosionSquares = bombExplosion.getBombExplosionPositions();

        for (int i = 0; i <= bombExplosion.getBombExplosionPositions().size(); i++) {
            if (!(tiles[explosionSquares.get(i).getX()][explosionSquares.get(i).getY()].isTileEmpty())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBombSpawn(Position bombPosition){
        Tile[][] tiles = map.getTiles();
        Entity entity = tiles[bombPosition.getX()][bombPosition.getY()].entities.get(0);
        return bombPosition == entity.getPosition() && !(entity instanceof SoftWall);
    }
}
