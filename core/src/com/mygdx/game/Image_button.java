package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Image_button extends Buttons{
    private ImageButton button;
    private String path1;
    private String path2;

    public Image_button(String image_path1, String image_path2, float width, float height, float x_pos, float y_pos){
        super(width, height, x_pos, y_pos);
        this.path1 = image_path1;
        this.path2 = image_path2;
    }

    public ImageButton getButton() {
        return button;
    }

    public void create(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        button = new ImageButton(mySkin);
        button.setSize(col_width*this.getButton_width(),(row_height*this.getButton_height()));
        button.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(
                Gdx.files.internal(this.path1))));
        button.getStyle().imageChecked = new TextureRegionDrawable(new TextureRegion(new Texture
                (Gdx.files.internal(this.path2))));
        button.setPosition(col_width*this.getButton_x(),Gdx.graphics.getHeight()-row_height*this.getButton_y());

    }
}
