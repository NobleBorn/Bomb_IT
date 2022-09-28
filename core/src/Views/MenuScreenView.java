package Views;
import Controllers.MenuScreenController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.*;

public class MenuScreenView implements Screen {
    final Main game;

    private MenuScreenController menuController;



    public MenuScreenView(final Main game, MenuScreenController controller){
        this.game = game;
        game.batch = new SpriteBatch();
        this.menuController = controller;
        menuController.getPlay_button().create();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        menuController.getCamera().update();
        game.batch.setProjectionMatrix(menuController.getCamera().combined);

        game.batch.begin();
        game.batch.end();

        menuController.getStage().act();
        menuController.getStage().draw();
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
