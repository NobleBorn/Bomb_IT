package Views;

import Models.*;
import Controllers.*;
import Views.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Main;

public class GameScreenView implements Screen {
    final Main game;

    private Stage stage;
    private SpriteBatch batch;
    private Texture img;
    private OrthographicCamera camera;
    private Position playerPosition;
    private Player player;
    private PlayerView playerView;
    private PlayerController playerController;

    public GameScreenView(Main game){
        this.game = game;
        batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 960, 720);

        img = new Texture(Gdx.files.internal("sand.png"));

        this.playerPosition = new Position(0, 0);

        player = new Player(playerPosition);
        playerController = new PlayerController(player, playerView);
        playerView = new PlayerView(player);
        playerView.create();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        playerController.update();
        //player.update();

        batch.begin();
        batch.draw(img, 0, 0, 48,48);
        batch.end();

        playerView.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        playerView.dispose();

    }
}
