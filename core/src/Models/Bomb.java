package Models;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity{

    private int bombLength;
    private IExplodable navigation;
    private BombExplosion explosion;

    public Bomb(Position position, int length, IExplodable navigation){
        super(position);
        this.bombLength = length;
        this.navigation = navigation;
        bombStart();
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
