package com.mygdx.game.Models;

import java.util.List;

/**
 * The class represents a soft wall as a subclass of {@link Entity} which is destroyable {@link IDestroyable}
 */
public class SoftWall extends Wall implements IDestroyable { //marker interface
    private List<SoftWall> objArray;

    /**
     * Constructor
     *
     * @param position - position of the soft wall on the mao in type {@link Position}
     * @param objArray - a list of soft walls in the map {@link Map}
     */
    public SoftWall(Position position, List<SoftWall> objArray) {
        super(position);
        this.objArray = objArray;
    }


    /**
     * Removes the soft wall object from the map
     */
    @Override
    public void terminate() {
        objArray.remove(this);

    }


}
