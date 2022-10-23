package com.mygdx.game.Views;
import com.mygdx.game.Controllers.MenuScreenController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.*;

/**
 * Represents Main menu screen
 */
public class MenuScreenView extends ScreenAdapter {
    private final Main game;
    private final Stage stage;
    private final OrthographicCamera camera;
    private final Texture menuImg;
    private boolean startClicked = false;
    private final Music gameMusic;
    private Sound clickSound;

    /**
     * Constructor
     *
     * @param game - an instance of Main class {@link Main}
     */
    public MenuScreenView(Main game){
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 960, 960);

        game.setBatch(new SpriteBatch());

        menuImg = new Texture(Gdx.files.internal("mainMenu1.png"));

        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        gameMusic.setLooping(true);
        gameMusic.play();
        clickSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        new MenuScreenController(this);

    }

    /**
     *
     * @return current stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     *
     * @return current game_music
     */
    public Music getGameMusic() {
        return gameMusic;
    }

    /**
     *
     * @return current click_sound
     */
    public Sound getClickSound() {
        return clickSound;
    }

    /**
     *
     * @param clickSound - click_sound to set (a path to the sound in assets)
     */
    public void setClickSound(Sound clickSound) {
        this.clickSound = clickSound;
    }

    /**
     *
     * @param startClicked - startClicked to set (true or false)
     */
    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    /**
     * Updates the Main Menu screen
     * @param delta - the game's delta time
     */
    @Override
    public void render(float delta) {
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        game.getBatch().draw(menuImg,0,0,960,960);
        game.getBatch().end();

        setScreen();

        stage.act();
        stage.draw();
    }

    private void setScreen() {
        if (startClicked)
            this.game.setScreen(new GameScreen(game));
    }

    /**
     * Disposes of music and sound
     */
    @Override
    public void dispose() {
        gameMusic.dispose();
        clickSound.dispose();
    }


}
