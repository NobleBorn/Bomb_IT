package com.mygdx.game.Views;

import com.mygdx.game.Models.Bomb;
import com.mygdx.game.Models.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Represents the view of the bomb {@link Bomb} and is a drawable object {@link IDrawable}
 */
public class BombView implements IDrawable{
    private final Bomb bomb;
    private final Texture bombImage;

    /**
     * Constructor
     *
     * @param bomb - an instance of the bomb {@link Bomb}
     * @param bombImage - a bomb texture
     */
    public BombView(Bomb bomb, Texture bombImage){
        this.bomb = bomb;
        this.bombImage = bombImage;
    }

    private Texture getBombImage(){
        return bombImage;
    }

    /**
     *
     * @param sb - an instance of spritebatch to draw, it is expected that draw.begin() and draw.end() is implemented
     */
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(getBombImage(), (bomb.getPosition().getY()* Tile.tileSize)+4, (bomb.getPosition().getX()*Tile.tileSize)+1);
    }

}


