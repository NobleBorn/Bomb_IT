package Views;

import Models.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


public class PlayerView implements IDrawable{
    Texture playerImages;
    Player player;
    private final TextureRegion[][] playerTexture2D;
    private float timer = 0f;
    private Direction previousDir;
    private Animation<TextureRegion> animationRight, animationLeft, animationUp, animationDown;
    private TextureRegion image;

    private Array<TextureRegion> walkFrames = new Array<>(2);

    /**
     * Constructor
     *
     * @param player - an instance of the player to get direction and position
     * @param imagesFileName - the path to the image file
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
    }

    private void setupWalkFrames(int start, int finish){
        for (int i = start; i < finish; i++)
            walkFrames.add(playerTexture2D[0][i]);

    }

    /**
     *
     * @return current player image for the current direction
     */
    public TextureRegion getImage(){
        if (player.isWalking()){
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
        player.setWalking(false);
        if (previousDir == direction){
            timer += Gdx.graphics.getDeltaTime();
        }
        else{
            timer = 0f;
        }
        previousDir = direction;
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
