package Views;
import Controllers.MenuScreenController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.*;

public class MenuScreenView implements Screen {
    final Main game;

    private Stage stage;
    private OrthographicCamera camera;
    private MenuScreenController menuController;
    private Texture menuImg;
    private boolean startClicked = false;
    private Music game_music;
    private Sound click_sound;


    public MenuScreenView(final Main game){
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 960, 960);

        game.batch = new SpriteBatch();

        menuImg = new Texture(Gdx.files.internal("mainMenu.png"));

        game_music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        game_music.setLooping(true);
        click_sound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        menuController = new MenuScreenController(this);

    }

    public Stage getStage() {
        return stage;
    }

    public Music getGame_music() {
        return game_music;
    }

    public Sound getClick_sound() {
        return click_sound;
    }

    public void setClick_sound(Sound click_sound) {
        this.click_sound = click_sound;
    }

    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(menuImg,0,0,960,960);
        game.batch.end();

        if (startClicked)
            this.game.setScreen(new Boot(game));

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

    @Override
    public void dispose() {
        game_music.dispose();
        click_sound.dispose();

    }


}
