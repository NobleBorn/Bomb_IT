package Views;

import Controllers.GameOverController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Main;

/**
 * Game Over screen
 */
public class GameOverView extends ScreenAdapter {
    final Main game;
    private GameOverController gameOverController;
    private Texture gameOverImgOne;
    private Texture gameOverImgTwo;
    private BitmapFont font;
    private boolean mainMenu = false;
    private boolean exit = false;
    private int winner_num;

    /**
     * Constructor
     *
     * @param game - an instance of Main class
     * @param winnerNum - A number that shows which player has won the game
     */
    public GameOverView(final Main game, int winnerNum){
        this.game = game;
        this.winner_num = winnerNum;
        game.setStage(new Stage(new ScreenViewport()));
        Gdx.input.setInputProcessor(game.getStage());
        gameOverImgOne = new Texture(Gdx.files.internal("playerOne.png"));
        gameOverImgTwo = new Texture(Gdx.files.internal("playerTwo.png"));
        font = new BitmapFont();

        font.setColor(Color.BLACK);
        font.getData().setScale(1.4f);
        gameOverController = new GameOverController(this, this.game);
    }

    /**
     *
     * @param mainMenu - set the new value of the boolean variable
     */
    public void setMainMenu(boolean mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     *
     * @param exit - set the new value of the boolean variable
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }

    /**
     * Updates the Game Over screen
     * @param delta - the game's delta time
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        game.getBatch().begin();
        if(winner_num == 1){
            game.getBatch().draw(gameOverImgOne,0,0,960,960);
            font.draw(game.getBatch(),"Player One Won!", col_width*2.9f, row_height*5.5f);
        }
        else{
            game.getBatch().draw(gameOverImgTwo,0,0,960,960);
            font.draw(game.getBatch(),"Player Two Won!", col_width*2.9f, row_height*5.5f);
        }
        game.getBatch().end();

        setScreen();

        game.getStage().act();
        game.getStage().draw();

    }

    private void setScreen() {
        if (mainMenu)
            game.setScreen(new MenuScreenView(game));
        else if (exit){
            Gdx.app.exit();
            System.exit(0);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {

    }

    /**
     * Disposes of images
     */
    @Override
    public void dispose() {
        gameOverImgOne.dispose();
        gameOverImgTwo.dispose();
    }
}
