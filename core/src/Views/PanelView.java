package Views;

import Controllers.Image_Button;
import Controllers.PanelController;
import Controllers.Text_Button;
import Models.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Boot;

public class PanelView {
    private Boot boot;
    private Stage stage;
    private SpriteBatch batch;
    private BitmapFont font;
    private ShapeRenderer shapeRenderer;

    private Player player1;
    private Player player2;



    /**
     * Constructor
     *
     * @param boot - an instance of the boot class {@link Boot}
     * @param player1 - an instance of the player class for player one {@link Player}
     * @param player2 - an instance of the player class for player two {@link Player}
     */
    public PanelView(final Boot boot, Player player1, Player player2){
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(1.2f);

        shapeRenderer = new ShapeRenderer();
        this.boot = boot;
        this.player1 = player1;
        this.player2 = player2;

        PanelController panelController = new PanelController(boot, this);

    }

    /**
     * Draws the stage, text areas and the text fonts
     */
    public void update(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        drawTextArea(row_height, col_width);
        batch.begin();
        drawFonts(row_height, col_width);
        batch.end();

        stage.act();
        stage.draw();
    }

    public Stage getStage() {
        return stage;
    }

    private void drawFonts(int row_height, int col_width) {
        font.draw(batch,"Timer: " + (int)boot.getTimeSeconds()/60 + " : " + (int)boot.getTimeSeconds()%60, col_width *9.7f, row_height *7.5f);
        font.draw(batch,"Player 1 points: " + player1.getScore(), col_width *9.7f, row_height *6.5f);
        font.draw(batch,"Player 2 points: " + player2.getScore(), col_width *9.7f, row_height *5.5f);
    }

    private void drawTextArea(int row_height, int col_width) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.rect(col_width *9.4f, row_height *7.2f, 230, 50);
        shapeRenderer.rect(col_width *9.4f, row_height *6.2f, 230, 50);
        shapeRenderer.rect(col_width *9.4f, row_height *5.2f, 230, 50);
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
