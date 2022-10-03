package Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ImageButton extends Buttons{
    private com.badlogic.gdx.scenes.scene2d.ui.ImageButton button;
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
    public ImageButton(String image_path1, String image_path2, float width, float height, float x_pos, float y_pos){
        super(width, height, x_pos, y_pos);
        this.path1 = image_path1;
        this.path2 = image_path2;
    }

    /**
     * @return the button itself
     */
    public com.badlogic.gdx.scenes.scene2d.ui.ImageButton getButton() {
        return button;
    }

    /**
     * Creates the new button instance and sets its size, style and position
     */
    public void create(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        button = new com.badlogic.gdx.scenes.scene2d.ui.ImageButton(mySkin);
        button.setSize(col_width*this.getButton_width(),(row_height*this.getButton_height()));
        button.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(
                Gdx.files.internal(this.path1))));
        button.getStyle().imageChecked = new TextureRegionDrawable(new TextureRegion(new Texture
                (Gdx.files.internal(this.path2))));
        button.setPosition(col_width*this.getButton_x(),Gdx.graphics.getHeight()-row_height*this.getButton_y());

    }
}
