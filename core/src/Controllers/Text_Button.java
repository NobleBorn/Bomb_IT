package Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Text_Button extends Buttons{
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
    public Text_Button(String text_button, float width, float height, float x_pos, float y_pos) {
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
    @Override
    public void create(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        //Skin used for the buttons
        Skin mySkin = new Skin(Gdx.files.internal("skin2/starsoldierui/star-soldier-ui.json"));

        //Creating the new object button
        button = new TextButton(this.name, mySkin);
        button.setSize(col_width*this.getButton_width(),row_height*this.getButton_height());
        button.setPosition(col_width*this.getButton_x(),Gdx.graphics.getHeight()-row_height*this.getButton_y());

    }

    public static class TextButtonBuilder {
        private int nestedWidth;
        private int nestedHeight;
        private int nestedX_pos;
        private int nestedY_pos;
        private String nestedName;

        public TextButtonBuilder(String newName, int newWidth, int newHeight, int newX, int newY){
            this.nestedName = newName;
            this.nestedWidth = newWidth;
            this.nestedHeight = newHeight;
            this.nestedX_pos = newX;
            this.nestedY_pos = newY;
        }


    }
}

