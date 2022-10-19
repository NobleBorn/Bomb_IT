package Views;

import Models.Position;
import Models.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class softWallView implements IDrawable{
    private Position position;
    private final Texture tempWallTexture;

    /**
     * Constructor
     *
     * @param pos - position of the permanent wall in map
     * @param softWallTexture - texture of the permanent wall
     */
    public softWallView(Position pos, Texture softWallTexture){
        this.position = pos;
        this.tempWallTexture = softWallTexture;
    }

    /**
     *
     * @param sb - an instance of spritebatch to draw, it is expected that draw.begin() and draw.end() is implemented
     */
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(getSoftWallTexture(), position.getY()* Tile.tileSize, position.getX()* Tile.tileSize);
    }

    /**
     *
     * @return current position of the soft wall
     */
    public Position getPosition(){
        return position;
    }

    private Texture getSoftWallTexture() {
        return tempWallTexture;
    }

}
