package Views;

import Controllers.*;
import Models.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class PlayerView extends Game {
    public TextureRegion up1, up2, down1, down2, right1, right2, left1, left2;
    Texture playerImages;
    SpriteBatch batch;
    Player player;
    PlayerController playerController;
    KeyHandler keyH;
    int spriteCounter = 0;
    int standCounter;
    int spriteNum = 1;


    public PlayerView(Player player){
        this.player = player;
        playerController =  new PlayerController(player, this);
        keyH = new KeyHandler();
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        playerImages = new Texture("player.png");
        addSprites();
    }

    private void addSprites() {
        down1 =  new TextureRegion(playerImages, 0,0,16,16);
        down2 = new TextureRegion(playerImages, 16,0,16,16);

        left1 = new TextureRegion(playerImages, 32,0,16,16);
        left2 = new TextureRegion(playerImages, 48,0,16,16);

        right1 = new TextureRegion(playerImages, 64,0,16,16);
        right2 = new TextureRegion(playerImages, 80,0,16,16);

        up1 = new TextureRegion(playerImages, 96,0,16,16);
        up2 = new TextureRegion(playerImages, 112,0,16,16);

    }

    public void draw(){
        TextureRegion image = null;

        switch (player.getDirection()){
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
        batch.draw(image, player.getPosition().x, player.getPosition().y, 48, 48);
    }

    @Override
    public void render() {
        batch.begin();
        draw();
        batch.end();
        spriteCounter++;
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
    }

    @Override
    public void dispose() {
        playerImages.dispose();
    }
}
