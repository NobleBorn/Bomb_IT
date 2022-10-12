package Views;

import Controllers.GameOverController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Boot;
import com.mygdx.game.Main;

public class GameOverView implements Screen {
    final Main game;
    private GameOverController gameOverController;
    private boolean mainMenu = false;
    private boolean exit = false;


    public GameOverView(final Main game){
        this.game = game;
        game.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(game.stage);
        gameOverController = new GameOverController(this, this.game);
    }

    public void setMainMenu(boolean mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.end();

        if (mainMenu)
            game.setScreen(new MenuScreenView(this.game));
        else if (exit)
            Gdx.app.exit();

        game.stage.act();
        game.stage.draw();

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

    }
}
