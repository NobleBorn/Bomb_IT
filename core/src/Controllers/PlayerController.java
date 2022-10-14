package Controllers;

import com.badlogic.gdx.Gdx;
import Models.*;
import Views.*;
import com.badlogic.gdx.Input;

public class PlayerController {
    Player player;
    private final int keyUp, keyLeft, keyDown, keyRight;
    private float time = 0f;

    public PlayerController(Player player, int up, int down, int right, int left){
        this.player = player;
        this.keyUp = up;
        this.keyLeft = left;
        this.keyDown = down;
        this.keyRight = right;
    }

    public void update(){
        time += Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(keyUp)) {
            tryWalk(Direction.UP);
        }

        if (Gdx.input.isKeyPressed(keyDown)) {
            tryWalk(Direction.DOWN);

        }

        if (Gdx.input.isKeyPressed(keyRight)) {
            tryWalk(Direction.RIGHT);

        }

        if (Gdx.input.isKeyPressed(keyLeft)) {
            tryWalk(Direction.LEFT);

        }
    }

    private void tryWalk(Direction down) {
        if (time > 0.2){
            player.walk(down);
            time = 0;
        }


    }

}
