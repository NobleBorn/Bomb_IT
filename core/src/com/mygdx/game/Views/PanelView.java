package com.mygdx.game.Views;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Controllers.PanelController;
import com.mygdx.game.Models.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Views.GameScreen;

/**
 * Represents view for the side panel that shows player {@link Player } information such as points, shows game timer
 */
public class PanelView {
    private final GameScreen gameScreen;
    private final Stage stage;
    private final SpriteBatch batch;
    private final BitmapFont font;
    private final ShapeRenderer shapeRenderer;
    private final Player player1;
    private final Player player2;



    /**
     * Constructor
     *
     * @param gameScreen - an instance of the boot class {@link GameScreen}
     * @param player1 - an instance of the player class for player one {@link Player}
     * @param player2 - an instance of the player class for player two {@link Player}
     */
    protected PanelView(GameScreen gameScreen, Player player1, Player player2){
        this.stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(this.stage);
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(1.2f);

        shapeRenderer = new ShapeRenderer();
        this.gameScreen = gameScreen;
        this.player1 = player1;
        this.player2 = player2;

        new PanelController(gameScreen, this);

    }

    /**
     * Draws the stage, text areas and the text fonts
     */
    public void update(){
        int rowHeight = Gdx.graphics.getWidth() / 12;
        int colWidth = Gdx.graphics.getWidth() / 12;

        drawTextArea(rowHeight, colWidth);
        batch.begin();
        drawFonts(rowHeight, colWidth);
        batch.end();

        stage.act();
        stage.draw();
    }

    public Stage getStage() {
        return stage;
    }

    private void drawFonts(int rowHeight, int colWidth) {
        font.draw(batch,"Timer: " + (int)gameScreen.getTimeSeconds()/60 + " : " + (int)gameScreen.getTimeSeconds()%60, colWidth *9.7f, rowHeight *7.5f);
        font.draw(batch,"Bob points: " + player1.getScore(), 0.8f*Gdx.graphics.getWidth(), rowHeight *6.5f);
        font.draw(batch,"Gandalf points: " + player2.getScore(), 0.8f*Gdx.graphics.getWidth(), rowHeight *5.5f);
    }

    private void drawTextArea(int rowHeight, int colWidth) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.rect(colWidth *9.4f, rowHeight *7.2f, 230, 50);
        shapeRenderer.rect(colWidth *9.4f, rowHeight *6.2f, 230, 50);
        shapeRenderer.rect(colWidth *9.4f, rowHeight *5.2f, 230, 50);
        shapeRenderer.end();
    }

    /**
     * Disposes the stage and font
     */
    public void dispose(){
        stage.dispose();
        font.dispose();
    }
}
