package com.mygdx.game.Models;

/**
 * Represents the bomb entity {@link Entity} and manages bomb's events
 */
public class Bomb extends Entity{

    private int bombLength;
    private IExplodable bombManager;
    private IBombListener player;
    private int points;

    /**
     * Constructor
     *
     * @param position - position of the player {@link Player} that drops the bomb in type {@link Position}
     * @param length - length of the bomb's explosion
     * @param bombManager - an instance of the IExplodable {@link IExplodable}
     * @param player - an instance of the IBombListener {@link IBombListener}
     */
    public Bomb(Position position, int length, IExplodable bombManager, IBombListener player){
        super(position);
        this.bombLength = length;
        this.bombManager = bombManager;
        this.player = player;
        bombStart();
    }

    /**
     *
     * @return current points for the number of soft walls destroyed after bomb's explosion
     */
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

    /**
     * Starts a bomb explosion,
     * Gets the number of walls destroyed {@link SoftWall}
     * Updates player's score {@link Player}
     * Calls the remove method to remove the bomb object from the map
     */
    protected void detonate(){
        BombExplosion explosion = new BombExplosion(position, bombLength, bombManager);
        points = explosion.getWallsDestroyed();
        player.addScore(getWallsDestroyedFromExplosion());
        bombManager.removeBombFromWorld(this);
    }
}
