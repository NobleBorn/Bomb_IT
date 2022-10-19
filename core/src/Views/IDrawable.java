package Views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Classes that implements IDrawable must implement draw method which will be used to draw a texture
 */
public interface IDrawable {
    /**
     *
     * @param sb - an instance of spritebatch to draw, it is expected that draw.begin() and draw.end()
     * is already implemented 
     */
    void draw(SpriteBatch sb);
}
