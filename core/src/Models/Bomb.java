package Models;

public class Bomb extends Entity{

    private int bombLength;
    private INavigable navigation;

    public Bomb(Position position, int length, INavigable navigation){
        super(position);
        this.bombLength = length;
        this.navigation = navigation;
        bombStart();
    }

    @Override
    protected Entity copyThis() {
        return new Bomb(new Position(position), this.bombLength, navigation);
    }

    private void bombStart(){
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                detonate();
            }
        }, 2000);
    }

    private void detonate(){ new BombExplosion(position, bombLength, navigation);
    }
}
