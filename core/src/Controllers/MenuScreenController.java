package Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import Views.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

/**
 * A class that creates buttons for the Main menu screen, see {@link Controllers.Text_Button} and
 * see {@link Controllers.Image_Button} and controls the button events
 *
 */
public class MenuScreenController {
    private MenuScreenView menuScreenView;
    ArrayList<Buttons> create = new ArrayList<>();

    Text_Button play_button = new Text_Button.TextButtonBuilder(7, 3.3f)
            .buttonSize(2, 1)
            .buttonName("Play")
            .createTextButton();

    Buttons option_button = new Text_Button.TextButtonBuilder(7,4.2f)
            .buttonSize(2, 1)
            .buttonName("Option")
            .createTextButton();

    Buttons exit_button = new Text_Button.TextButtonBuilder( 7,5.1f)
            .buttonSize(2, 1)
            .buttonName("Exit")
            .createTextButton();



    Image_Button music_button = new Image_Button.ImageButtonBuilder( 0.3f, 6.2f)
            .buttonSize(1, 0.8f)
            .buttonPath1("volume_on.png")
            .buttonPath2("volume_off.png")
            .createImageButton();

    Buttons sound_button = new Image_Button.ImageButtonBuilder( 1, 6.2f)
            .buttonSize(1, 0.8f)
            .buttonPath1("sound_on.png")
            .buttonPath2("sound_off.png")
            .createImageButton();


    /**
     * Constructor
     * Creates the buttons and handle button inputs
     *
     * @param menuScreenView - an instance of the MenuScreenView see {@link MenuScreenView}
     */
    public MenuScreenController(final MenuScreenView menuScreenView){
        this.menuScreenView = menuScreenView;

        create.add(play_button);
        create.add(option_button);
        create.add(exit_button);
        create.add(music_button);
        create.add(sound_button);

        for (Buttons buttons : create)
            buttons.create();


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

        option_button.getButton().addListener(new ClickListener() {
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
                System.exit(0);
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
