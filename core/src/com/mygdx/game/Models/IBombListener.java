package com.mygdx.game.Models;

/**
 * An interface that listens to bomb's explosion events {@link Bomb}
 */
public interface IBombListener {

    /**
     * @param wallsDestroyed - number of the soft walls destroyed {@link SoftWall} after explosion
     */
    void addScore(int wallsDestroyed);
}
