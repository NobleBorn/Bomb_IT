package Models;

public class Bomb extends Entity{

    private int bombLength;
    private INavigable navigation;
    BombExplosion bombExplosion;
    int points;

    public Bomb(Position position, int length, INavigable navigation){
        super(position);
        this.bombLength = length;
        this.navigation = navigation;
    }

    protected void detonate(){
        bombExplosion = new BombExplosion(position, bombLength, navigation);
        points = bombExplosion.getWallsDestroyed();
    }

    public int getWallsDestroyedFromExplosion() {
        return points;
    }


    @Override
    protected Entity copyThis() {
        return new Bomb(new Position(position), this.bombLength, navigation);
    }

}
