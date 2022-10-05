package Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;

public class TileViewImage {
    private final Texture permWall;
    private final Texture tempWall;
    public TileViewImage(){
        this.permWall = new Texture(Gdx.files.internal("PermWall.jpg"));
        this.tempWall = new Texture(Gdx.files.internal("tempWall.jpg"));
    }
    public Texture getWallTexture(boolean isDestroyable){
        if(isDestroyable){
            return tempWall;
        }
        else {
            return permWall;
        }
    }
}
