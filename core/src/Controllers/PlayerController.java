package Controllers;

import com.badlogic.gdx.Gdx;
import Models.*;
import Views.*;
import com.badlogic.gdx.Input;

public class PlayerController {
    Player player;
    private final int keyUp, keyLeft, keyDown, keyRight, keyDropBomb;
    private float time = 0f;

    /**
     * Constructor
     *
     * @param player - an instance of the player class for the player
     * @param up - a key code for the player's up direction
     * @param down - a key code for the player's down direction
     * @param right - a key code for the player's right direction
     * @param left - a key code for the player's left direction
     * @param dropBomb - a key code for the player to drop a bomb
     */
    public PlayerController(Player player, int up, int down, int right, int left, int dropBomb){
        this.player = player;
        this.keyUp = up;
        this.keyLeft = left;
        this.keyDown = down;
        this.keyRight = right;
        this.keyDropBomb = dropBomb;
    }

    /**
     * Depending on the key input sends the correct direction to tryWalk method
     * Or calls the dropBomb method for the player
     */
    public void update(){
        if (player.isAlive()) {
            time += Gdx.graphics.getDeltaTime();
            if(Gdx.input.isKeyPressed(keyUp))
                tryWalk(Direction.UP);

            if(Gdx.input.isKeyPressed(keyDown))
                tryWalk(Direction.DOWN);

            if(Gdx.input.isKeyPressed(keyRight))
                tryWalk(Direction.RIGHT);

            if (Gdx.input.isKeyPressed(keyLeft))
                tryWalk(Direction.LEFT);

            if (Gdx.input.isKeyPressed(keyDropBomb))
                player.dropBomb();
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
