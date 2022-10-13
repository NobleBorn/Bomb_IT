package Controllers;

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

import java.awt.*;

public class PanelController {
    private Boot boot;
    private Stage stage;
    private SpriteBatch batch;
    private BitmapFont font;
    private ShapeRenderer shapeRenderer;

    private Player player1;
    private Player player2;

    Text_Button pause_button = new Text_Button("Pause", 2,1, 9.5f, 6);
    Text_Button resume_button = new Text_Button("Resume", 2,1, 9.5f, 7);


    Image_Button music_button = new Image_Button("volume_on.png", "volume_off.png",1,
            0.8f, 1, 7);
    Image_Button sound_button = new Image_Button("sound_on.png", "sound_off.png",1,
            0.8f, 2.7f, 7);

    public PanelController(final Boot boot, Player player1, Player player2){
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
        pause_button.create();
        resume_button.create();

        pause_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                boot.pause();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(pause_button.getButton());

        resume_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                boot.resume();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(resume_button.getButton());
    }

    public void render(){
        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(148/255f,92/255f,43/255f,0.8f);
        shapeRenderer.rect(col_width*9.4f, row_height*7.2f, 230, 50);
        shapeRenderer.rect(col_width*9.4f, row_height*5.2f, 230, 50);
        shapeRenderer.rect(col_width*9.4f, row_height*3.2f, 230, 50);
        shapeRenderer.end();
        batch.begin();
        font.draw(batch,"Timer: " + (int)boot.getTimeSeconds(), col_width*9.7f, row_height*7.5f);
        font.draw(batch,"Player 1 points: " + player1.getScore(), col_width*9.7f, row_height*5.5f);
        font.draw(batch,"Player 2 points: " + player2.getScore(), col_width*9.7f, row_height*3.5f);
        batch.end();
        stage.act();
        stage.draw();
    }

    public void dispose(){
        stage.dispose();
        font.dispose();
    }

}
