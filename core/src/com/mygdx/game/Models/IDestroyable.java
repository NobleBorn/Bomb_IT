package com.mygdx.game.Models;

/**
 * An interface that removes entities {@link Entity} from the map, classes that implements the interface are destroyable
 */
public interface IDestroyable {

    /**
     * A method to remove the object from the map
     */
    void terminate();
}
