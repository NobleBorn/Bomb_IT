package Views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * An interface that represents all drawable entities {@link Models.Entity} on the map {@link Models.Map}
 */
public interface IDrawable {
    /**
     *
     * @param sb - an instance of spritebatch to draw, it is expected that draw.begin() and draw.end() is implemented
     */
    void draw(SpriteBatch sb);
}
