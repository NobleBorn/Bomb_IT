package com.mygdx.game.Views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Controllers.GameOverController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Main;
import com.mygdx.game.Models.Player;

/**
 * Represents Game Over screen
 */
public class GameOverView extends ScreenAdapter {
    private final Main game;
    private final Texture gameOverImgOne;
    private final Texture gameOverImgTwo;
    private final BitmapFont font;
    private final Stage stage;
    private final SpriteBatch batch;
    private boolean mainMenu = false;
    private boolean exit = false;
    private final int winnerNum;

    /**
     * Constructor
     *
     * @param game - an instance of Main class {@link Main}
     * @param winnerNum - A number that shows which player {@link Player} has won the game
     */
    protected GameOverView(Main game, int winnerNum){
        this.game = game;
        this.winnerNum = winnerNum;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        gameOverImgOne = new Texture(Gdx.files.internal("playerOne1.png"));
        gameOverImgTwo = new Texture(Gdx.files.internal("playerTwo2.png"));
        font = new BitmapFont();

        font.setColor(Color.BLACK);
        font.getData().setScale(1.4f);
        new GameOverController(this);
    }

    /**
     *
     * @param mainMenu - sets the new boolean value of the variable "mainMenu"
     */
    public void setMainMenu(boolean mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     *
     * @param exit - sets the new boolean value of the variable "exit"
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

        batch.begin();
        if(winnerNum == 1){
            renderWinner(gameOverImgOne, "Bob");
        }
        else{
            renderWinner(gameOverImgTwo, "Gandalf");
        }
        batch.end();

        setScreen();

        stage.act();
        stage.draw();

    }

    public Stage getStage() {
        return stage;
    }

    private void setScreen() {
        if (mainMenu)
            game.setScreen(new MenuScreenView(game));
        else if (exit){
            Gdx.app.exit();
            System.exit(0);
        }
    }

    private void renderWinner(Texture winnerTex, String winnerName){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;
        batch.draw(winnerTex,0,0,1280,960);
        font.draw(batch,winnerName+" won!", col_width*2.9f, row_height*5.5f);
    }

    /**
     * Disposes of garbage
     */
    @Override
    public void dispose() {
        gameOverImgOne.dispose();
        gameOverImgTwo.dispose();
        stage.dispose();
        batch.dispose();
        font.dispose();
    }
}
