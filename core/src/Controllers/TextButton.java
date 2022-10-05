package Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TextButton extends Buttons{
    private String name;
    private Button button;

    /**
     * Constructor.
     *
     * @param text_button - the name that will display on the button
     * @param width - the width of the button
     * @param height -  the height of the button
     * @param x_pos -  the x position of the button
     * @param y_pos -  the y position of the button
     *
     */
    public TextButton(String text_button, float width, float height, float x_pos, float y_pos) {
        super(width, height, x_pos, y_pos);
        this.name = text_button;
    }

    /**
     * @return the name of the button
     */
    public String getName() {
        return name;
    }

    /**
     * @return the button itself
     */
    public Button getButton() {
        return button;
    }

    /**
     * Creates the new button instance and sets the size and position
     */
    public void create(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        //Skin used for the buttons
        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        //Creating the new object button
        button = new com.badlogic.gdx.scenes.scene2d.ui.TextButton(this.name, mySkin, "small");
        button.setSize(col_width*this.getButton_width(),row_height);
        button.setPosition(col_width*this.getButton_x(),Gdx.graphics.getHeight()-row_height*this.getButton_y());

    }
}
