package Views;

import Controllers.GameOverController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Boot;
import com.mygdx.game.Main;

public class GameOverView implements Screen {
    final Main game;
    private GameOverController gameOverController;
    private Texture gameOverImgOne;
    private Texture gameOverImgTwo;
    private BitmapFont font;
    private boolean mainMenu = false;
    private boolean exit = false;
    private int num;


    public GameOverView(final Main game, int num){
        this.game = game;
        this.num = num;
        game.setStage(new Stage(new ScreenViewport()));
        Gdx.input.setInputProcessor(game.getStage());
        gameOverImgOne = new Texture(Gdx.files.internal("playerOne.png"));
        gameOverImgTwo = new Texture(Gdx.files.internal("playerTwo.png"));
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(1.4f);
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
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        game.getBatch().begin();
        if(num == 1){
            game.getBatch().draw(gameOverImgOne,0,0,960,960);
            font.draw(game.getBatch(),"Player One Won!", col_width*2.9f, row_height*5.5f);
        }
        else{
            game.getBatch().draw(gameOverImgTwo,0,0,960,960);
            font.draw(game.getBatch(),"Player Two Won!", col_width*2.9f, row_height*5.5f);
        }
        game.getBatch().end();

        if (mainMenu)
            game.setScreen(new MenuScreenView(game));
        else if (exit)
            Gdx.app.exit();

        game.getStage().act();
        game.getStage().draw();

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
        gameOverImgOne.dispose();
        gameOverImgTwo.dispose();
    }
}
