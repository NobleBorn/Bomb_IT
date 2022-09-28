package Models;

public class BombExplosionSquare extends Entity{

    private Position position;

    public BombExplosionSquare(Position position){
        super(position);
    }

    public Position getPosition() {
        return position;
    }
}
