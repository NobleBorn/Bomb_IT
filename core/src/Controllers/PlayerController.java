package Controllers;

import com.badlogic.gdx.Gdx;
import Models.*;
import Views.*;
import com.badlogic.gdx.Input;

public class PlayerController {
    Player player;
    private final int keyUp, keyLeft, keyDown, keyRight, keyDropBomb;
    private float time = 0f;

    public PlayerController(Player player, int up, int down, int right, int left, int dropBomb){
        this.player = player;
        this.keyUp = up;
        this.keyLeft = left;
        this.keyDown = down;
        this.keyRight = right;
        this.keyDropBomb = dropBomb;
    }

    public void update(){
        if (player.isAlive()) {
            time += Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(keyUp)) {
                tryWalk(Direction.UP);
            } else

                if (Gdx.input.isKeyPressed(keyDown)) {
                    tryWalk(Direction.DOWN);

                } else

                    if (Gdx.input.isKeyPressed(keyRight)) {
                        tryWalk(Direction.RIGHT);

                    } else

                        if (Gdx.input.isKeyPressed(keyLeft)) {
                            tryWalk(Direction.LEFT);

                        } else


                            if (Gdx.input.isKeyJustPressed(keyDropBomb)) {
                                player.dropBomb();
                            }
        }
    }

    private void tryWalk(Direction dir) {
        if (time > 0.15) {
            player.setWalking(true);
            player.walk(dir);
            time = 0;
        }
    }

}
