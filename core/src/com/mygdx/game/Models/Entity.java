package com.mygdx.game.Models;

/**
 * The abstract class represents all objects with a position on the map.
 */
public abstract class Entity {
    protected Position position;

    /**
     * Class constructor
     * @param position a position of the type {@link Position} to assign to the object of the supertype Entity.
     */
    Entity(Position position){
        this.position = position;
    }

    /**
     * @return returns the position of the entity in the type {@link Position}.
     */
    public Position getPosition(){
        return position;
    }

}
