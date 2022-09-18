package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen implements Screen {
    final Main game;
    //Stage handles the viewport and distributes input events.
    private Stage stage;

    private OrthographicCamera camera;

    //Instantiating two text_button objects
    Text_button play_button = new Text_button("Play", 2,1, 5, 4);
    Text_button exit_button = new Text_button("Exit", 2,1, 5, 6);

    public MainMenuScreen(final Main game) {
        this.game = game;
        //Stage covers the entire screen and enable event capture.
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // This will make sure the camera always shows us an area of our game world
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 900, 600);

        game.batch = new SpriteBatch();

        //Creates the buttons
        play_button.create();
        exit_button.create();

        //Inputlistener for the buttons to execute the action upon clicking the button
        play_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(play_button.getButton());

        exit_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(exit_button.getButton());

    }

    @Override
    public void render(float delta) {
        // Tell the camera to update its matrices.
        camera.update();
        // Tell the SpriteBatch to render in the coordinate system specified by the camera
        game.batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(0, 0, 0.2f, 1);

        game.batch.begin();
        game.batch.end();

        stage.act();
        stage.draw();
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

    }
}

