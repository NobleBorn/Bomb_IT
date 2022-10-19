package Models;

public class Bomb extends Entity{

    private int bombLength;
    private IExplodable navigation;
    private BombExplosion explosion;
    private IBombListener player;
    int points;

    public Bomb(Position position, int length, IExplodable navigation, IBombListener player){
        super(position);
        this.bombLength = length;
        this.navigation = navigation;
        this.player = player;
        bombStart();
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
        points = explosion.getWallsDestroyed();
        player.addScore(getWallsDestroyedFromExplosion());
        navigation.removeBombFromWorld(this);
    }
}
