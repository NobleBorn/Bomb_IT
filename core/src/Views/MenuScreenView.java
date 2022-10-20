package Views;
import Controllers.MenuScreenController;
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
    final Main game;

    private Stage stage;
    private OrthographicCamera camera;
    private MenuScreenController menuController;
    private Texture menuImg;
    private boolean startClicked = false;
    private Music game_music;
    private Sound click_sound;

    /**
     * Constructor
     *
     * @param game - an instance of Main class {@link Main}
     */
    public MenuScreenView(final Main game){
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 960, 960);

        game.setBatch(new SpriteBatch());

        menuImg = new Texture(Gdx.files.internal("mainMenu1.png"));

        game_music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        game_music.setLooping(true);
        click_sound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        menuController = new MenuScreenController(this);

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
    public Music getGame_music() {
        return game_music;
    }

    /**
     *
     * @return current click_sound
     */
    public Sound getClick_sound() {
        return click_sound;
    }

    /**
     *
     * @param click_sound - click_sound to set (a path to the sound in assets)
     */
    public void setClick_sound(Sound click_sound) {
        this.click_sound = click_sound;
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
            this.game.setScreen(new Boot(game));
    }

    @Override
    public void resize(int width, int height) {

    }

    /**
     * Plays the game music
     */
    @Override
    public void show() {
        game_music.play();
    }

    @Override
    public void hide() {
    }

    /**
     * Disposes of music and sound
     */
    @Override
    public void dispose() {
        game_music.dispose();
        click_sound.dispose();

    }


}
