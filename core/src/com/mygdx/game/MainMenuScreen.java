package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen implements Screen {
    final Main game;
    //Stage handles the viewport and distributes input events.
    private Stage stage;

    private OrthographicCamera camera;

    //Instantiating text_button objects
    Text_button play_button = new Text_button("Play", 2,0.6f, 7, 3.7f);
    Text_button option_button = new Text_button("Option", 2,0.6f, 7, 4.9f);
    Text_button exit_button = new Text_button("Exit", 2,0.6f, 7, 6.1f);

    //Instantiating image_button objects
    Image_button music_button = new Image_button("music_on.png", "music_off.png",1.5f,
            1.4f, 1, 7);
    Image_button sound_button = new Image_button("sound_on.png", "sound_off.png",1.5f,
            1.4f, 2.7f, 7);

    private Music game_music;
    private Sound click_sound;


    /**
     * Constructor - sets the camera, a new stage, creates the buttons and takes in the button's input
     *
     * @param game
     */
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
        option_button.create();

        music_button.create();
        sound_button.create();

        game_music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        game_music.setLooping(true);

        //Inputlistener for the buttons to execute the action upon clicking the button
        play_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                click_sound.play();
                game.setScreen(new GameScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(play_button.getButton());

        option_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                click_sound.play();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(option_button.getButton());

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

        music_button.getButton().addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(music_button.getButton().isChecked())
                    game_music.pause();
                else
                    game_music.play();
                return false;
            }
        });
        stage.addActor(music_button.getButton());

        sound_button.getButton().addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(sound_button.getButton().isChecked()){
                    click_sound.dispose();
                }
                else
                    click_sound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
                return false;
            }
        });
        stage.addActor(sound_button.getButton());

    }

    /**
     *
     * @param delta
     */
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
        game_music.play();
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

    /**
     * Disposes of the garbage after application is closed
     */
    @Override
    public void dispose() {
        game_music.dispose();
        click_sound.dispose();

    }
}

