package com.mygdx.game;

//A button class for the common attributes of a button
public class Buttons {
    private float button_width;
    private float button_height;
    private float button_x;
    private float button_y;

    public Buttons(float width, float height, float x_pos, float y_pos){
        this.button_width = width;
        this.button_height = height;
        this.button_x = x_pos;
        this.button_y = y_pos;

    }

    public float getButton_width() {
        return button_width;
    }

    public float getButton_height() {
        return button_height;
    }

    public float getButton_x() {
        return button_x;
    }

    public float getButton_y() {
        return button_y;
    }
}
