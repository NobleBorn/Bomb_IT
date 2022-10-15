package Controllers;

import com.badlogic.gdx.Gdx;
import Models.*;

public class PlayerController {
    Player player;
    private final int keyUp, keyLeft, keyDown, keyRight;
    private float time = 0f;

    /**
     * Constructor
     *
     * @param player - an instance of the player class for the player
     * @param up - a key event for the player's up direction
     * @param down - a key event for the player's down direction
     * @param right - a key event for the player's right direction
     * @param left - a key event for the player's left direction
     */
    public PlayerController(Player player, int up, int down, int right, int left){
        this.player = player;
        this.keyUp = up;
        this.keyLeft = left;
        this.keyDown = down;
        this.keyRight = right;
    }

    /**
     * Depending on the key input sends the correct direction
     */
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
