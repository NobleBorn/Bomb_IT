package Views;

import Controllers.*;
import Models.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class PlayerView {
    public TextureRegion up1, up2, down1, down2, right1, right2, left1, left2;
    Texture playerImages;
    SpriteBatch batch;
    Player player;
    PlayerController playerController;
    KeyHandler keyH;
    int spriteCounter = 0;
    int standCounter;
    int spriteNum = 1;


    public PlayerView(){
        keyH = new KeyHandler();
        playerImages = new Texture("player.png");
        addSprites();
    }

    private void addSprites() {
        down1 =  new TextureRegion(playerImages, 0,0,64,64);
        down2 = new TextureRegion(playerImages, 64,0,64,64);

        left1 = new TextureRegion(playerImages, 128,0,64,64);
        left2 = new TextureRegion(playerImages, 192,0,64,64);

        right1 = new TextureRegion(playerImages, 256,0,64,64);
        right2 = new TextureRegion(playerImages, 320,0,64,64);

        up1 = new TextureRegion(playerImages, 384,0,64,64);
        up2 = new TextureRegion(playerImages, 448,0,64,64);

    }

    public TextureRegion getImage(Direction direction){
        TextureRegion image = null;

        switch (direction){
            case UP:
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case DOWN:
                if (spriteNum == 1)
                    image = down1;
                if (spriteNum == 2)
                    image = down2;
                break;
            case RIGHT:
                if (spriteNum == 1)
                    image = right1;
                if (spriteNum == 2)
                    image = right2;
                break;
            case LEFT:
                if (spriteNum == 1)
                    image = left1;
                if (spriteNum == 2)
                    image = left2;
                break;
        }
        //batch.draw(image, player.getPosition().x, player.getPosition().y, 48, 48);
        return image;
    }


    public void setupPlayerImage() {
        /* batch.begin();
        draw();
        batch.end(); */
        if (spriteCounter > 12){
            if (spriteNum == 1 && (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) ||
                    Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) || Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)
                    || Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))){
                spriteNum = 2;
            }
            else if (spriteNum == 2 && (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) ||
                    Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) || Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)
                    || Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))){
                spriteNum = 1;
            }

            spriteCounter = 0;
        }
        else {
            standCounter++;
            if (standCounter == 20){
                spriteNum = 1;
                standCounter = 0;
            }
        }
        spriteCounter++;
    }
}
