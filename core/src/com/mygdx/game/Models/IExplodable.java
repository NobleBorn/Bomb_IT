package com.mygdx.game.Models;

import java.util.List;

/**
 * An interface that handles the bomb's {@link Bomb} events and the explosion {@link BombExplosion} events
 */
public interface IExplodable {

    /**
     *
     * @param pos - position of the current bomb in type {@link Position}
     * @param ent - an instance of the bomb {@link Bomb}
     * @return ture if bomb is successfully added to the map and false otherwise
     */
    boolean tryAddBombToWorld(Position pos, Bomb ent);

    /**
     *
     * @param position - position of the entity {@link Entity} in explosion area that is to be removed from the map
     * @return a list of boolean for ture if removed successfully and false otherwise
     */
    List<Boolean> tryToKillEntity(Position position);

    /**
     *
     * @param bomb - an instance of the bomb {@link Bomb}
     * @return true if bomb is successfully removed from the map and false otherwise
     */
    boolean removeBombFromWorld(Bomb bomb);
}
