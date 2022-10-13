package Controllers;

import com.badlogic.gdx.Gdx;
import Models.*;
import Views.*;
import com.badlogic.gdx.Input;

public class PlayerController {
    Direction direction;
    KeyHandler keyH;
    Player player;
    private final int keyUp, keyLeft, keyDown, keyRight, keyDropBomb;
    private float time = 0f;

    public PlayerController(Player player, int up, int down, int right, int left, int dropBomb){
        this.player = player;
        //this.playerView = playerView;
        this.keyH = new KeyHandler();
        this.keyUp = up;
        this.keyLeft = left;
        this.keyDown = down;
        this.keyRight = right;
        this.keyDropBomb = dropBomb;
    }

    public void update(){
        if (player.isAlive()) {
            //Gdx.input.setInputProcessor(keyH);
            time += Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(keyUp)) {
                //player.setUpPressed(true);
                tryWalk(Direction.UP);
            } else
                //player.setUpPressed(false);

                if (Gdx.input.isKeyPressed(keyDown)) {
                    //player.setDownPressed(true);
                    tryWalk(Direction.DOWN);

                } else
                    //player.setDownPressed(false);

                    if (Gdx.input.isKeyPressed(keyRight)) {
                        //player.setRightPressed(true);
                        tryWalk(Direction.RIGHT);

                    } else
                        //player.setRightPressed(false);

                        if (Gdx.input.isKeyPressed(keyLeft)) {
                            //player.setLeftPressed(true);
                            tryWalk(Direction.LEFT);

                        } else
                            //player.setLeftPressed(false);


                            if (Gdx.input.isKeyPressed(keyDropBomb)) {
                                player.dropBomb();
                            }
        }
    }

    private void tryWalk(Direction up) {
        if (time > 0.15) {
            player.walk(up);
            time = 0;
        }
    }

}
