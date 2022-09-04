package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen implements Screen {
    final Main game;

    private OrthographicCamera camera;
    private Texture menuImage;
    private SpriteBatch batch;

    public MainMenuScreen(final Main game) {
        this.game = game;

        // load the images
        menuImage = new Texture(Gdx.files.internal("menuScreen.png"));

        // This will make sure the camera always shows us an area of our game world
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 900, 600);

        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {

        // Tell the camera to update its matrices.
        camera.update();
        // Tell the SpriteBatch to render in the coordinate system specified by the camera
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(menuImage, 0, 0);
        // game.font.draw is how text is rendered to the screen
        game.font.draw(game.batch, "Welcome to Bomb_IT!!! ", 400, 450);
        game.font.draw(game.batch, "Click play to begin!", 400, 400);
        game.batch.end();

        // If the screen has been touched
        if (Gdx.input.isTouched()) {
            // Transform the touch/mouse coordinates to our camera’s coordinate system
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            // If the touch is over play button change the screen
            if ((touchPos.x > 400 && touchPos.x < 500) && ((touchPos.y > 200 && touchPos.y < 350))){
                game.setScreen(new GameScreen(game));
                dispose();
            }

        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        menuImage.dispose();
    }
}

