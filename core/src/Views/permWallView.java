package Views;

import Models.Position;
import Models.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class permWallView implements IDrawable{
    private Position position;
    private final Texture permWallTexture;

    public permWallView(Position pos, Texture permWallTexture){
        this.position = pos;
        this.permWallTexture = permWallTexture;
    }
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(getPermWallTexture(), position.getY()* Tile.tileSize, position.getX()*Tile.tileSize);
    }
    public Position getPosition(){
        return position;
    }
    private Texture getPermWallTexture(){
        return permWallTexture;
    }
}
