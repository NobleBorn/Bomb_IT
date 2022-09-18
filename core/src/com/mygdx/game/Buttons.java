package com.mygdx.game;

//A button class for the common attributes of a button
public class Buttons {
    private int button_width;
    private int button_height;
    private int button_x;
    private int button_y;

    public Buttons(int width, int height, int x_pos, int y_pos){
        this.button_width = width;
        this.button_height = height;
        this.button_x = x_pos;
        this.button_y = y_pos;

    }

    public int getButton_width() {
        return button_width;
    }

    public int getButton_height() {
        return button_height;
    }

    public int getButton_x() {
        return button_x;
    }

    public int getButton_y() {
        return button_y;
    }
}
