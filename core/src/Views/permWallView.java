package Views;

import Models.Position;
import Models.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Represents the view of the permanent wall {@link Models.Wall} which is a drawable object {@link IDrawable}
 */
public class permWallView implements IDrawable{
    private final Position position;
    private final Texture permWallTexture;

    /**
     * Constructor
     *
     * @param pos - position of the permanent wall on the map in type {@link Position}
     * @param permWallTexture - a texture of the permanent wall
     */
    public permWallView(Position pos, Texture permWallTexture){
        this.position = pos;
        this.permWallTexture = permWallTexture;
    }

    /**
     *
     * @param sb - an instance of spritebatch to draw, it is expected that draw.begin() and draw.end() is implemented
     */
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(getPermWallTexture(), position.getY()* Tile.tileSize, position.getX()*Tile.tileSize);
    }

    /**
     *
     * @return current position of the permanent wall
     */
    public Position getPosition(){
        return position;
    }


    private Texture getPermWallTexture(){
        return permWallTexture;
    }
}
