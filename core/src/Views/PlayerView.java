package Views;

import Controllers.*;
import Models.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class PlayerView {
    public TextureRegion up1, up2, down1, down2, right1, right2, left1, left2;
    public TextureRegion uppe1, uppe2, ner1, ner2, hoger1, hoger2, vanster1, vanster2;
    Texture playerImages;
    Texture player2Images;
    SpriteBatch batch;
    Player player;
    PlayerController playerController;
    int spriteCounter = 0;
    int standCounter;
    int spriteNum = 1;
    int spriteNum2 = 1;
    Animation<TextureRegion> walkAnimation;
    float stateTime;


    public PlayerView(Player player){
        playerImages = new Texture("spelare.png");
        player2Images = new Texture("spelare2.png");
        addSprites();
    }

    private void addSprites() {
        down1 =  new TextureRegion(playerImages, 0,0,48,48);
        down2 = new TextureRegion(playerImages, 48,0,48,48);

        left1 = new TextureRegion(playerImages, 96,0,48,48);
        left2 = new TextureRegion(playerImages, 144,0,48,48);

        right1 = new TextureRegion(playerImages, 192,0,48,48);
        right2 = new TextureRegion(playerImages, 240,0,48,48);

        up1 = new TextureRegion(playerImages, 288,0,48,48);
        up2 = new TextureRegion(playerImages, 336,0,48,48);

        ner1 =  new TextureRegion(player2Images, 0,0,48,48);
        ner2 = new TextureRegion(player2Images, 48,0,48,48);

        vanster1 = new TextureRegion(player2Images, 96,0,48,48);
        vanster2 = new TextureRegion(player2Images, 144,0,48,48);

        hoger1 = new TextureRegion(player2Images, 192,0,48,48);
        hoger2 = new TextureRegion(player2Images, 240,0,48,48);

        uppe1 = new TextureRegion(player2Images, 288,0,48,48);
        uppe2 = new TextureRegion(player2Images, 336,0,48,48);

    }

    public TextureRegion getImage(Direction direction, int n){
        TextureRegion image = null;
        if (n == 1){
            image = getTextureRegion(direction, image, spriteNum, up1, up2, down1, down2, right1, right2, left1, left2);
        }
        else{
            image = getTextureRegion(direction, image, spriteNum2, uppe1, uppe2, ner1, ner2, hoger1, hoger2, vanster1, vanster2);
        }
        return image;
    }

    private TextureRegion getTextureRegion(Direction direction, TextureRegion image, int spriteNum2, TextureRegion uppe1,
                                           TextureRegion uppe2, TextureRegion ner1, TextureRegion ner2, TextureRegion hoger1,
                                           TextureRegion hoger2, TextureRegion vanster1, TextureRegion vanster2) {
        switch (direction){
            case UP:
                if (spriteNum2 == 1){
                    image = uppe1;
                }
                if (spriteNum2 == 2){
                    image = uppe2;
                }
                break;
            case DOWN:
                if (spriteNum2 == 1)
                    image = ner1;
                if (spriteNum2 == 2)
                    image = ner2;
                break;
            case RIGHT:
                if (spriteNum2 == 1)
                    image = hoger1;
                if (spriteNum2 == 2)
                    image = hoger2;
                break;
            case LEFT:
                if (spriteNum2 == 1)
                    image = vanster1;
                if (spriteNum2 == 2)
                    image = vanster2;
                break;
        }
        return image;
    }


    public void setupPlayerImage() {
        if (spriteCounter > 15){
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

            if (spriteNum2 == 1 && (Gdx.input.isKeyPressed(Input.Keys.W) ||
                    Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D)
                    || Gdx.input.isKeyPressed(Input.Keys.A))){
                spriteNum2 = 2;
            }
            else if (spriteNum2 == 2 && (Gdx.input.isKeyPressed(Input.Keys.W) ||
                    Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D)
                    || Gdx.input.isKeyPressed(Input.Keys.A))){
                spriteNum2 = 1;
            }

            spriteCounter = 0;
        }
        else {
            standCounter++;
            if (standCounter == 20){
                spriteNum = 1;
                spriteNum2 = 1;
                standCounter = 0;
            }
        }
        spriteCounter++;
    }
}
