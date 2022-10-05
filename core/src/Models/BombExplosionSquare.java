package Models;

public class BombExplosionSquare extends Entity{

    private Position position;
    private CollisionChecker cc;

    public BombExplosionSquare(Position position, CollisionChecker cc){

        super(position);
        cc.bombCollision(this);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    protected Entity copyThis() {
        return new BombExplosionSquare(new Position(position) ,cc);
    }
}
