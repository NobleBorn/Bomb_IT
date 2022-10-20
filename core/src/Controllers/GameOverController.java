package Controllers;

import Views.GameOverView;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Main;

/**
 * A class that creates text buttons {@link Controllers.Text_Button} for game over screen {@link GameOverView}
 * And controls the button events
 */
public class GameOverController {
    private GameOverView gameOverView;
    final Main game;

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
     * @param game - an instance of Main {@link Main}
     */
    public GameOverController(final GameOverView gameOverView, Main game) {
        this.gameOverView = gameOverView;
        this.game = game;
        menu_button.create();
        exit_button.create();

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
        game.getStage().addActor(menu_button.getButton());

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
        game.getStage().addActor(exit_button.getButton());
    }
}
