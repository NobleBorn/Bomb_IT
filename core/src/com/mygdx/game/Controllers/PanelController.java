package com.mygdx.game.Controllers;

import com.mygdx.game.Views.PanelView;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Views.GameScreen;

/**
 * A class that creates pause and resume button see {@link Text_Button} for the side panel
 */
public class PanelController {
    private Text_Button pause_button = new Text_Button.TextButtonBuilder(9.5f, 7f)
            .buttonSize(2, 1)
            .buttonName("Pause")
            .createTextButton();

    private Text_Button resume_button = new Text_Button.TextButtonBuilder(9.5f, 8f)
            .buttonSize(2, 1)
            .buttonName("Resume")
            .createTextButton();


    /**
     * Constructor
     *
     * @param gameScreen - an instance of the gameScreen class {@link GameScreen}
     * @param panelView - an instance of panelView {@link PanelView}
     */
    public PanelController(final GameScreen gameScreen, PanelView panelView){
        pause_button.create();
        resume_button.create();

        handlesButtonEvents(gameScreen, panelView);
    }

    /**
     *
     * @param gameScreen - an instance of boot {@link GameScreen}
     * @param panelView - an instance of panelView {@link PanelView}
     */
    private void handlesButtonEvents(final GameScreen gameScreen, PanelView panelView) {
        pause_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gameScreen.pause();
                gameScreen.gameMusic.pause();
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
                gameScreen.resume();
                gameScreen.gameMusic.play();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        panelView.getStage().addActor(resume_button.getButton());
    }
}
