package Controllers;

import com.badlogic.gdx.Gdx;
import Models.*;
import Views.*;
import com.badlogic.gdx.Input;

public class PlayerController {
    KeyHandler keyH;
    Player player;
    private final int keyUp, keyLeft, keyDown, keyRight;
    PlayerView playerView;

    public PlayerController(Player player, int keyUp, int keyLeft, int keyDown, int keyRight){
        this.player = player;
        //this.playerView = playerView;
        this.keyH = new KeyHandler();
        this.keyUp = keyUp;
        this.keyLeft = keyLeft;
        this.keyDown = keyDown;
        this.keyRight = keyRight;
    }

    public void update(){
        //Gdx.input.setInputProcessor(keyH);
        if (Gdx.input.isKeyJustPressed(keyUp)){
            //player.setUpPressed(true);
            player.walk(Direction.UP);
        }
        else
            //player.setUpPressed(false);

        if (Gdx.input.isKeyJustPressed(keyDown)) {
            //player.setDownPressed(true);
            player.walk(Direction.DOWN);

        }
        else
            //player.setDownPressed(false);

        if (Gdx.input.isKeyJustPressed(keyRight)) {
            //player.setRightPressed(true);
            player.walk(Direction.RIGHT);
        }
        else
            //player.setRightPressed(false);

        if (Gdx.input.isKeyJustPressed(keyLeft)){
            //player.setLeftPressed(true);
            player.walk(Direction.LEFT);

        }
        else{
            //player.setLeftPressed(false);

        }
    }

}
