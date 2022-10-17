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
    public TileViewImage(){
        this.permWallTexture = new Texture(Gdx.files.internal("wallperm.jpg"));
        this.tempWallTexture = new Texture(Gdx.files.internal("walltemp.jpg"));
    }

    public Texture getPermWallTexture() {
        return permWallTexture;
    }

    public Texture getTempWallTexture() {
        return tempWallTexture;
    }

    @Override
    public void draw(SpriteBatch sb) {

    }
}
