package Controllers;

import Views.GameOverView;
import Views.MenuScreenView;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.Main;

public class GameOverController {
    private GameOverView gameOverView;
    final Main game;

    Text_Button menu_button = new Text_Button("Main menu", 2, 1, 7, 3);
    Text_Button exit_button = new Text_Button("Exit", 2, 1, 7, 4.9f);

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
        game.stage.addActor(menu_button.getButton());

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
        game.stage.addActor(exit_button.getButton());
    }
}
