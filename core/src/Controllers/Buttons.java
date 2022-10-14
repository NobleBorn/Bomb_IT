package Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//A button class for the common attributes of a button
public class Buttons {
    private float button_width;
    private float button_height;
    private float button_x;
    private float button_y;
    private Button button;

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

    public Button getButton() {
        return button;
    }

    public void create(){

    }
}

