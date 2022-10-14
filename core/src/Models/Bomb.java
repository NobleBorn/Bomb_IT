package Models;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity implements Runnable{

    private int bombLength;
    private INavigable navigation;
    BombExplosion bombExplosion;
    //private int playerID;

    public Bomb(Position position, int length, INavigable navigation){
        super(position);
        this.bombLength = length;
        this.navigation = navigation;
        //this.playerID = playerID;
        run();
    }

    private void detonate(){
        this.bombExplosion = new BombExplosion(position, bombLength, navigation);
    }

    public int getWallsDestroyedFromExplosion() {
        return bombExplosion.getWallsDestroyed();
    }


    @Override
    public void run(){
        boolean run = true;
        while(run){
            try{
                Thread.sleep(3000);
                detonate();
                run = false;
            } catch (InterruptedException e){
                e.printStackTrace();
                run = false;
            }
        }
    }


    @Override
    protected Entity copyThis() {
        return new Bomb(new Position(position), this.bombLength, navigation);
    }
}
