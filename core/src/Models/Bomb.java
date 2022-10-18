package Models;

public class Bomb extends Entity{

    private int bombLength;
    private IExplodable navigation;
    private BombExplosion explosion;
    int points;

    public Bomb(Position position, int length, IExplodable navigation){
        super(position);
        this.bombLength = length;
        this.navigation = navigation;
        bombStart();
    }

    protected void detonate(){
        bombExplosion = new BombExplosion(position, bombLength, navigation);
        points = bombExplosion.getWallsDestroyed();
    }

    public int getWallsDestroyedFromExplosion() {
        return points;
    }


    private void bombStart(){
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                detonate();
            }
        }, 2000);
    }

    protected void detonate(){
        BombExplosion explosion = new BombExplosion(position, bombLength, navigation);
        navigation.removeBombFromWorld(this);
    }
}
