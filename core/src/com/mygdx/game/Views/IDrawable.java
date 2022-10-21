package com.mygdx.game.Views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Models.Entity;
import com.mygdx.game.Models.Map;

/**
 * An interface that represents all drawable entities {@link Entity} on the map {@link Map}
 */
public interface IDrawable {
    /**
     *
     * @param sb - an instance of spritebatch to draw, it is expected that draw.begin() and draw.end() is implemented
     */
    void draw(SpriteBatch sb);
}
