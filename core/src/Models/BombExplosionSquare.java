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
}
