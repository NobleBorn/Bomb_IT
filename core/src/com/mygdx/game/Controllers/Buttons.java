package com.mygdx.game.Controllers;

import com.badlogic.gdx.scenes.scene2d.ui.Button;


/**
 * An abstract button class for the common attributes of a button
 * */
public abstract class Buttons {
    private float button_width;
    private float button_height;
    private float button_x;
    private float button_y;

    /**
     * Constructor.
     *
     * @param width - the width of the button
     * @param height -  the height of the button
     * @param x_pos -  the x position of the button
     * @param y_pos -  the y position of the button
     *
     */
    public Buttons(float width, float height, float x_pos, float y_pos){
        this.button_width = width;
        this.button_height = height;
        this.button_x = x_pos;
        this.button_y = y_pos;
    }

    /**
     * @return the width of the button
     */
    public float getButton_width() {
        return button_width;
    }

    /**
     * @return the height of the button
     */
    public float getButton_height() {
        return button_height;
    }

    /**
     * @return the x position of the button
     */
    public float getButton_x() {
        return button_x;
    }

    /**
     * @return the y position of the button
     */
    public float getButton_y() {
        return button_y;
    }

    public abstract Button getButton();

    public abstract void create();
}

