package Controllers;

import com.badlogic.gdx.Gdx;
import Models.*;
import Views.*;

public class PlayerController {
    KeyHandler keyH;
    Player player;
    PlayerView playerView;

    public PlayerController(Player player, PlayerView playerView){
        this.player = player;
        this.playerView = playerView;
        this.keyH = new KeyHandler();
    }

    public void update(){
        Gdx.input.setInputProcessor(keyH);
        if (keyH.upPressed && !keyH.rightPressed && !keyH.leftPressed) {
            player.setUpPressed(true);
        }
        else
            player.setUpPressed(false);

        if (keyH.downPressed && !keyH.rightPressed && !keyH.leftPressed) {
            player.setDownPressed(true);
        }
        else
            player.setDownPressed(false);

        if (keyH.rightPressed) {
            player.setRightPressed(true);
        }
        else
            player.setRightPressed(false);

        if (keyH.leftPressed) {
            player.setLeftPressed(true);
        }
        else{
            player.setLeftPressed(false);

        }
    }

}
