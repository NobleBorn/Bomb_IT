package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Bomb class that contains bomb esplosion, see {@link BombExplosion}
 */
public class Bomb extends Entity{

    private int bombLength;
    private IExplodable navigation;
    private BombExplosion explosion;

    /**
     * Constructor
     *
     * @param position - position of the bomb
     * @param length - the length of the bomb
     * @param navigation - an instance of the IExplodable
     */
    public Bomb(Position position, int length, IExplodable navigation){
        super(position);
        this.bombLength = length;
        this.navigation = navigation;
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
