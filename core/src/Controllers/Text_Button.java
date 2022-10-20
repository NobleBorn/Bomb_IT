package Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Represent text button as a subclass to buttons {@link Buttons}
 */
public class Text_Button extends Buttons{
    private String name;
    private TextButton button;


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
    @Override
    public TextButton getButton() {
        return button;
    }

    /**
     * Creates the new button instance with skin and sets the size and position
     */
    @Override
    public void create(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        Skin mySkin = new Skin(Gdx.files.internal("skin2/starsoldierui/star-soldier-ui.json"));

        button = new TextButton(this.name, mySkin);

        button.setSize(col_width*this.getButton_width(),row_height*this.getButton_height());
        button.setPosition(col_width*this.getButton_x(),Gdx.graphics.getHeight()-row_height*this.getButton_y());

    }

    /**
     * Builder design pattern
     * */
    public static class TextButtonBuilder {
        private float nestedWidth = 1;
        private float nestedHeight = 1;
        private float nestedX_pos;
        private float nestedY_pos;
        private String nestedName;

        /**
         *
         * @param x_pos - button's x position
         * @param y_pos - button's y position
         */
        public TextButtonBuilder(float x_pos, float y_pos){
            this.nestedX_pos = x_pos;
            this.nestedY_pos = y_pos;

        }

        /**
         * @param Name - the name that will display on the button
         * @return - the name on the button
         */
        public TextButtonBuilder buttonName(String Name){
            this.nestedName = Name;
            return this;
        }

        /**
         * @param width - the width of the button
         * @param height - the height of the button
         * */
        public TextButtonBuilder buttonSize(float width, float height){
            this.nestedWidth = width;
            this.nestedHeight = height;
            return this;
        }

        /**
         * Creates the build text button
         * */
        public Text_Button createTextButton()
        {
            return new Text_Button(
                    nestedName, nestedWidth, nestedHeight, nestedX_pos, nestedY_pos);
        }


    }
}

