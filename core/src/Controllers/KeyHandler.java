package Controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyHandler implements InputProcessor {
    public boolean upPressed, downPressed, rightPressed, leftPressed, dropBombPressed;


    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.DPAD_UP)
            upPressed = true;
        if (keycode == Input.Keys.DPAD_DOWN)
            downPressed = true;
        if (keycode == Input.Keys.DPAD_RIGHT)
            rightPressed = true;
        if (keycode == Input.Keys.DPAD_LEFT)
            leftPressed = true;

        if(keycode == Input.Keys.SHIFT_RIGHT)
            dropBombPressed = true;

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.DPAD_UP)
            upPressed = false;
        if (keycode == Input.Keys.DPAD_DOWN)
            downPressed = false;
        if (keycode == Input.Keys.DPAD_RIGHT)
            rightPressed = false;
        if (keycode == Input.Keys.DPAD_LEFT)
            leftPressed = false;

        if(keycode == Input.Keys.SHIFT_RIGHT)
            dropBombPressed = false;

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
