package com.mygdx.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Represent image button as a subclass to buttons {@link Buttons}
 */
public class Image_Button extends Buttons{
    private ImageButton button;
    private String path1;
    private String path2;

    /**
     * Constructor
     *
     * @param image_path1 - the path to the first image shown when button is not pressed
     * @param image_path2 - the path to the second image shown when button is pressed
     * @param width - the width of the button
     * @param height -  the height of the button
     * @param x_pos -  the x position of the button
     * @param y_pos -  the y position of the button
     */
    public Image_Button(String image_path1, String image_path2, float width, float height, float x_pos, float y_pos){
        super(width, height, x_pos, y_pos);
        this.path1 = image_path1;
        this.path2 = image_path2;
    }

    /**
     * @return current button
     */
    @Override
    public ImageButton getButton() {
        return button;
    }

    /**
     * Creates the new button instance with skin and sets its size, style and position
     */
    @Override
    public void create(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        Skin mySkin = new Skin(Gdx.files.internal("skin2/starsoldierui/star-soldier-ui.json"));

        button = new ImageButton(mySkin);
        button.setSize(col_width*this.getButton_width(),row_height*this.getButton_height());
        if(this.path1 != null)
            button.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(
                    Gdx.files.internal(this.path1))));
        if(this.path2 != null)
            button.getStyle().imageChecked = new TextureRegionDrawable(new TextureRegion(new Texture
                    (Gdx.files.internal(this.path2))));
        button.setPosition(col_width*this.getButton_x(),Gdx.graphics.getHeight()-row_height*this.getButton_y());

    }
    /**
     * Builder design pattern
     * */
    public static class ImageButtonBuilder {
        private float nestedWidth = 1;
        private float nestedHeight = 1;
        private float nestedX_pos;
        private float nestedY_pos;
        private String nestedPath1;
        private String nestedPath2;

        /**
         * @param x_pos - button's x position
         * @param y_pos - button's y position
         */
        public ImageButtonBuilder(float x_pos, float y_pos){
            this.nestedX_pos = x_pos;
            this.nestedY_pos = y_pos;

        }

        /**
         * @param path1 - the path to the first png for the image
         * */
        public ImageButtonBuilder buttonPath1(String path1){
            this.nestedPath1 = path1;
            return this;
        }

        /**
         * @param width - the width of the button
         * @param height - the height of the button
         * */
        public ImageButtonBuilder buttonSize(float width, float height){
            this.nestedWidth = width;
            this.nestedHeight = height;
            return this;
        }

        /**
         * @param path2 - the path to the second png for the image
         * */
        public ImageButtonBuilder buttonPath2(String path2){
            this.nestedPath2 = path2;
            return this;
        }

        /**
         * Creates the build image button
         * */
        public Image_Button createImageButton()
        {
            return new Image_Button(
                    nestedPath1, nestedPath2, nestedWidth, nestedHeight, nestedX_pos, nestedY_pos);
        }


    }
}
