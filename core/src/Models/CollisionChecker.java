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


    //Det utkommenterade gör istället att vi returnar en lista med positioner ist för true/false, om vi ist vill ha positioner
    public boolean bombCollision(BombExplosion bombExplosion) {

        Tile[][] tiles = map.getTiles();
        List<BombExplosionSquare> explosionSquares = bombExplosion.getBombExplosionSquares();

        //List<Position> collisionPositions = new ArrayList<>(1);

        for (int i = 0; i <= bombExplosion.getBombExplosionSquares().size(); i++) {
            if (!(tiles[explosionSquares.get(i).getPosition().getX()][explosionSquares.get(i).getPosition().getY()].isTileEmpty())) {
                return true;
                //collisionPositions.add(new Position(explosionSquares.get(i).getPosition().getX(),explosionSquares.get(i).getPosition().getY()));
            }
        }
        return false;
        //return collisionPositions;
    }
}
