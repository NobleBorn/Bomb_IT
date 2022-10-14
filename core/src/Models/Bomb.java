package Models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class Bomb extends Entity{

    private int bombLength;
    private INavigable navigation;
    private Timer timer;

    public Bomb(Position position, int length, INavigable navigation){
        super(position);
        this.bombLength = length;
        this.navigation = navigation;
        timer();

    }

    private void detonate(){
        BombExplosion bombExplosion = new BombExplosion(position, bombLength, navigation);
    }

    /*
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

     */


    @Override
    protected Entity copyThis() {
        return new Bomb(new Position(position), this.bombLength, navigation);
    }

    private void timer(){
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                detonate();
            }
        }, 2000);
    }
}
