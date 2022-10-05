package Models;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity implements Runnable{

    private int bombLength;
    private CollisionChecker cc;

    public Bomb(Position position, int length, CollisionChecker cc){
        super(position);
        this.bombLength = length;
        run();

    }

    private void detonate(){
        BombExplosion bombExplosion = new BombExplosion(position, bombLength, cc);

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
        return new Bomb(new Position(position), this.bombLength);
    }
}
