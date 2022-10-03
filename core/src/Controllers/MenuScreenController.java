package Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.game.*;
import Views.*;

public class MenuScreenController {
    private MenuScreenView menuScreenView;

    TextButton play_button = new TextButton("Play", 2,1, 7, 3);
    TextButton option_button = new TextButton("Option", 2,0.6f, 7, 4.9f);
    TextButton exit_button = new TextButton("Exit", 2,0.6f, 7, 6.1f);

    ImageButton music_button = new ImageButton("music_on.png", "music_off.png",1.5f,
            1.4f, 1, 7);
    ImageButton sound_button = new ImageButton("sound_on.png", "sound_off.png",1.5f,
            1.4f, 2.7f, 7);

    public MenuScreenController(final MenuScreenView menuScreenView){
        this.menuScreenView = menuScreenView;
        play_button.create();
        option_button.create();
        exit_button.create();

        music_button.create();
        sound_button.create();

        play_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                menuScreenView.getGame_music().stop();
                menuScreenView.getClick_sound().stop();
                menuScreenView.setStartClicked(true);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        menuScreenView.getStage().addActor(play_button.getButton());

        option_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                menuScreenView.getClick_sound().play();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        menuScreenView.getStage().addActor(option_button.getButton());

       exit_button.getButton().addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        menuScreenView.getStage().addActor(exit_button.getButton());

        music_button.getButton().addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(music_button.getButton().isChecked())
                    menuScreenView.getGame_music().pause();
                else
                    menuScreenView.getGame_music().play();
                return false;
            }
        });
        menuScreenView.getStage().addActor(music_button.getButton());

        sound_button.getButton().addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                if(sound_button.getButton().isChecked()){
                    menuScreenView.getClick_sound().dispose();
                }
                else
                    menuScreenView.setClick_sound(Gdx.audio.newSound(Gdx.files.internal("drop.wav")));
                return false;
            }
        });
        menuScreenView.getStage().addActor(sound_button.getButton());




    }
}
