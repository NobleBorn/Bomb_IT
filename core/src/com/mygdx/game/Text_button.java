package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

//Help from libgdx.wordpres
//Text_button is a button
public class Text_button extends Buttons{
    private String name;
    private Button button;

    //A text_button beside the common attributes also has  a text
    public Text_button(String text_button, int width, int height, int x_pos, int y_pos) {
        super(width, height, x_pos, y_pos);
        this.name = text_button;
    }

    public String getName() {
        return name;
    }

    public Button getButton() {
        return button;
    }

    public void create(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        //Skin used for the buttons
        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        //Creating the new object button
        button = new TextButton(this.name, mySkin, "small");
        button.setSize(col_width*this.getButton_width(),row_height);
        button.setPosition(col_width*this.getButton_x(),Gdx.graphics.getHeight()-row_height*this.getButton_y());

    }
}
