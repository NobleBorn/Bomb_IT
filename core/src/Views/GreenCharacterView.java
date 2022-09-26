package Views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GreenCharacterView extends ApplicationAdapter {

    SpriteBatch batch;
    Sprite sprite;
    Texture image;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("greenCharacter64.png"));
    }

    @Override
    public void render () {
        batch.begin();
        batch.draw(sprite, 0, 0);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        image.dispose();
    }
}
