package com.mygdx.game.Controllers;

import com.mygdx.game.Views.GameOverView;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Main;

/**
 * A class that creates text buttons {@link Text_Button} for game over screen {@link GameOverView}
 * And controls the button events
 */
public class GameOverController {
    Text_Button menu_button = new Text_Button.TextButtonBuilder(7, 3.7f)
            .buttonSize(2, 1).
            buttonName("Main Menu")
            .createTextButton();

    Buttons exit_button = new Text_Button.TextButtonBuilder(7, 4.5f)
            .buttonSize(2, 1).
            buttonName("Exit")
            .createTextButton();

    /**
     * Constructor
     * Creates buttons and handles button' events
     * @param gameOverView - an instance of gameOverView class {@link GameOverView}
     */
    public GameOverController(final GameOverView gameOverView) {
        menu_button.create();
        exit_button.create();

        handlesButtonEvents(gameOverView);
    }

    /**
     *
     * @param gameOverView - an instance of gameOverView {@link GameOverView}
     */
    private void handlesButtonEvents(final GameOverView gameOverView) {
        menu_button.getButton().addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gameOverView.setMainMenu(true);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        gameOverView.getStage().addActor(menu_button.getButton());

        exit_button.getButton().addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                gameOverView.setExit(true);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        gameOverView.getStage().addActor(exit_button.getButton());
    }
}
