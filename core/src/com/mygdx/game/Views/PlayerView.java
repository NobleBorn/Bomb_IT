package com.mygdx.game.Views;

import com.mygdx.game.Models.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Models.Direction;
import com.mygdx.game.Models.Player;
import com.mygdx.game.Models.Tile;

/**
 * Represents the view of the player {@link Player} which is a drawable object {@link IDrawable}
 */
public class PlayerView implements IDrawable{
    Texture playerImages;
    Player player;
    private final TextureRegion[][] playerTexture2D;
    private float timer = 0f;
    private boolean isKeyDown = false;
    private Direction previousDir;
    private Animation<TextureRegion> animationRight, animationLeft, animationUp, animationDown;
    private TextureRegion image;
    private Array<TextureRegion> walkFrames = new Array<>(2);

    /**
     * Constructor
     *
     * @param player - an instance of the player {@link Player}
     * @param imagesFileName - image path for the player
     */
    public PlayerView(Player player, String imagesFileName){
        int row = 1;
        int col = 8;

        playerImages = new Texture(imagesFileName);
        this.playerTexture2D = TextureRegion.split(playerImages,
                playerImages.getWidth() / col, playerImages.getHeight() / row);

        this.player = player;
        this.previousDir = player.getDirection();

        addSprites();
        changeTextureRegion(this.player.getDirection());
    }

    private void addSprites() {

        float updateFrames = 1/60f;

        setupWalkFrames(0, 2);
        this.animationDown = new Animation<>(updateFrames, walkFrames);
        walkFrames.clear();

        setupWalkFrames(2, 4);
        this.animationLeft = new Animation<>(updateFrames, walkFrames);
        walkFrames.clear();

        setupWalkFrames(4, 6);
        this.animationRight = new Animation<>(updateFrames, walkFrames);
        walkFrames.clear();

        setupWalkFrames(6, 8);
        this.animationUp = new Animation<>(updateFrames, walkFrames);
        walkFrames.clear();

        this.animationDown.setPlayMode(Animation.PlayMode.LOOP);
        this.animationUp.setPlayMode(Animation.PlayMode.LOOP);
        this.animationLeft.setPlayMode(Animation.PlayMode.LOOP);
        this.animationRight.setPlayMode(Animation.PlayMode.LOOP);
    }

    private void setupWalkFrames(int start, int finish){
        for (int i = start; i < finish; i++)
            walkFrames.add(playerTexture2D[0][i]);

    }

    /**
     *
     * @return current player image for the corresponding direction {@link Direction}
     */
    public TextureRegion getImage(){
        if (isKeyDown){
            changeTextureRegion(player.getDirection());
        }
        return this.image;
    }

    private void changeTextureRegion(Direction direction) {
        switch (direction){
            case UP:
                this.image = animationUp.getKeyFrame(timer, true);
                break;

            case DOWN:
                this.image = animationDown.getKeyFrame(timer, true);
                break;

            case RIGHT:
                this.image = animationRight.getKeyFrame(timer, true);
                break;

            case LEFT:
                this.image = animationLeft.getKeyFrame(timer, true);
                break;
        }
        setIsKeyDown(false);
        if (previousDir == direction){
            timer += Gdx.graphics.getDeltaTime();
        }
        else{
            timer = 0f;
        }
        previousDir = direction;
    }

    /**
     * Changes the value of the boolean isKeyDown responsible for changing the animation image.
     * @param isKeyDown a boolean describing the current state of the movement keys for the player.
     */
    public void setIsKeyDown(boolean isKeyDown){
        this.isKeyDown = isKeyDown;
    }
    /**
     *
     * @param sb - an instance of spritebatch to draw, it is expected that draw.begin() and draw.end() is implemented
     */
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(getImage(), player.getPosition().getY()* Tile.tileSize, player.getPosition().getX()* Tile.tileSize);
    }
}
