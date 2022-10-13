package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bomb extends Entity implements Runnable{

    private int bombLength;
    private CollisionChecker cc;

    static AtomicInteger nextID = new AtomicInteger();
    private int id;

    public Bomb(Position position, int length, CollisionChecker cc){
        super(position);
        this.bombLength = length;
        this.cc = cc;
        /* bomb får id, måste koppla det till spelaren
        id = nextID.incrementAndGet();

         */
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
        return new Bomb(new Position(position), this.bombLength, cc);
    }
}
