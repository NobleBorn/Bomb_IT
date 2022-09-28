package Controllers;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.*;
import Views.*;
import Models.*;

public class MenuScreenController implements Screen {
    final Main game;

    private MenuScreenView menuScreenView;

    private Stage stage;
    private OrthographicCamera camera;

    Text_button play_button = new Text_button("Play", 2,1, 7, 3);

    public MenuScreenController(final Main game){
        this.game = game;
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 900, 600);

        menuScreenView = new MenuScreenView(game, this);

        this.play_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new Boot(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        this.stage.addActor(play_button.getButton());

    }

    public Text_button getPlay_button() {
        return play_button;
    }

    public Stage getStage() {
        return stage;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    @Override
    public void render(float delta) {
        menuScreenView.render(delta);
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
