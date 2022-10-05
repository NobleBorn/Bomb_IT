package Models;

public class BombExplosionSquare extends Entity{

    private Position position;

    public BombExplosionSquare(Position position){
        super(position);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    protected Entity copyThis() {
        return new BombExplosionSquare(new Position(position));
    }
}
