package Models;

import java.util.List;

public class CollisionChecker {

    public boolean playerNextTileFree(Position newPosition, Map map){

        //skapa metod walk hos player
        //skapa variabel newPosition som räknar ut nästa position
        //skicka den positionen till denna funktion
        //om true, uppdatera spelarens positon till newPosition, annars gör inget

        Tile[][] tiles = map.getTiles();
        int x = newPosition.getX();
        int y = newPosition.getY();
        return !tiles[x][y].isTileEmpty(); //returns whether tile is empty or not
    }

    public void bombCollision(Entity o1, BombExplosion bombExplosion){
        if (o1 instanceof Player || o1 instanceof Wall || o1 instanceof Powerups) { //could be replaced with if (o1 instance of Destroyable)
            if (o1 instanceof Wall && !((Wall) o1).isDestroyable()){ //if o1 is a permanent wall
                return;
            }
            List<BombExplosionSquare> bombExplosionSquares = bombExplosion.getBombExplosionSquares();
            for (int i = 0; i < bombExplosionSquares.size(); i++) {
                if (bombExplosionSquares.get(i).getPosition() == o1.getPosition()){
                    o1.terminate(o1); //better solution?
                }
            }
        }
    }
}
