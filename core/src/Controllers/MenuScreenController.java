package Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import Views.*;

public class MenuScreenController {
    private MenuScreenView menuScreenView;

    Text_Button play_button = new Text_Button("Play", 2,1, 7, 3.3f);
    Text_Button option_button = new Text_Button("Option", 2,1, 7, 4.2f);
    Text_Button exit_button = new Text_Button("Exit", 2,1, 7, 5.1f);

    Image_Button music_button = new Image_Button("volume_on.png", "volume_off.png",1,
            0.8f, 0.3f, 6.2f);
    Image_Button sound_button = new Image_Button("sound_on.png", "sound_off.png",1,
            0.8f, 1, 6.2f);

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
