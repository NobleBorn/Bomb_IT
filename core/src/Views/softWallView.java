package Views;

import Models.Position;
import Models.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class softWallView implements IDrawable{
    private Position position;
    private final Texture tempWallTexture;

    public softWallView(Position pos, Texture softWallTexture){
        this.position = pos;
        this.tempWallTexture = softWallTexture;
    }
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(getSoftWallTexture(), position.getY()* Tile.tileSize, position.getX()* Tile.tileSize);
    }
    public Position getPosition(){
        return position;
    }
    private Texture getSoftWallTexture() {
        return tempWallTexture;
    }

}
