package Controllers;

import Models.Player;
import Views.PanelView;
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

/**
 * A class that shows player {@link Player }information such as points, shows game timer
 * Creates pause and resume button see {@link Controllers.Text_Button}
 */
public class PanelController {
    Text_Button pause_button = new Text_Button("Pause", 2,1, 9.5f, 7);
    Text_Button resume_button = new Text_Button("Resume", 2,1, 9.5f, 8);


    Image_Button music_button = new Image_Button("volume_on.png", "volume_off.png",1,
            0.8f, 1, 7);
    Image_Button sound_button = new Image_Button("sound_on.png", "sound_off.png",1,
            0.8f, 2.7f, 7);

    /**
     * Constructor
     *
     * @param boot - an instance of the boot class {@link Boot}
     * @param panelView - an instance of panelView {@link PanelView}
     */
    public PanelController(final Boot boot, PanelView panelView){
        pause_button.create();
        resume_button.create();

        handlesButtonEvents(boot, panelView);
    }

    /**
     *
     * @param boot - an instance of boot {@link Boot}
     * @param panelView - an instance of panelView {@link PanelView}
     */
    private void handlesButtonEvents(final Boot boot, PanelView panelView) {
        pause_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                boot.pause();
                boot.gameMusic.pause();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        panelView.getStage().addActor(pause_button.getButton());

        resume_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                boot.resume();
                boot.gameMusic.pause();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        panelView.getStage().addActor(resume_button.getButton());
    }
}
