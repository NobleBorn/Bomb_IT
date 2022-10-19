package Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;

public class TileViewImage implements IDrawable{
    private final Texture permWallTexture;
    private final Texture tempWallTexture;

    /**
     * Constructor
     * Creates texture for permanent wall and soft wall when called
     */
    public TileViewImage(){
        this.permWallTexture = new Texture(Gdx.files.internal("wallperm.jpg"));
        this.tempWallTexture = new Texture(Gdx.files.internal("walltemp.jpg"));
    }

    /**
     *
     * @return current texture of the permanent wall
     */
    public Texture getPermWallTexture() {
        return permWallTexture;
    }

    /**
     *
     * @return current texture of the soft wall
     */
    public Texture getTempWallTexture() {
        return tempWallTexture;
    }

    /**
     *
     * @param sb - an instance of spritebatch to draw, it is expected that draw.begin() and draw.end() is implemented
     */
    @Override
    public void draw(SpriteBatch sb) {

    }
}
