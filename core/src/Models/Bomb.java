package Models;

public class Bomb extends Entity{

    private int bombLength;
    private IExplodable bombManager;
    private IBombListener player;
    private int points;

    public Bomb(Position position, int length, IExplodable bombManager, IBombListener player){
        super(position);
        this.bombLength = length;
        this.bombManager = bombManager;
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
        BombExplosion explosion = new BombExplosion(position, bombLength, bombManager);
        points = explosion.getWallsDestroyed();
        player.addScore(getWallsDestroyedFromExplosion());
        bombManager.removeBombFromWorld(this);
    }
}
