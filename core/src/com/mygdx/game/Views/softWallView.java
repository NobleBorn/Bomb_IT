package com.mygdx.game.Views;

import com.mygdx.game.Models.Position;
import com.mygdx.game.Models.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Models.SoftWall;

/**
 * Represents the view of the soft wall {@link SoftWall} which is a drawable object {@link IDrawable}
 */
public class softWallView implements IDrawable{
    private final Position position;
    private final Texture tempWallTexture;

    /**
     * Constructor
     *
     * @param pos - position of the soft wall on the map in type {@link Position}
     * @param softWallTexture - a texture of the soft wall
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
