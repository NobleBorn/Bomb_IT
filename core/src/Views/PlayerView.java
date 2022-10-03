package Views;

import Controllers.PlayerController;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class PlayerView extends ApplicationAdapter {
    final HashMap<String, TextureRegion> player_sprites = new HashMap<String, TextureRegion>();
    Texture playerImages;
    Array<TextureRegion> regions = new Array<>();
    PlayerController playerController;
    SpriteBatch batch;

    public PlayerView(PlayerController playerController){
        this.playerController = playerController;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        playerImages = new Texture("player.png");
        addSprites();
    }

    public Array<TextureRegion> getRegions() {
        return regions;
    }

    private void addSprites() {
        player_sprites.put("down1", new TextureRegion(playerImages, 0,0,16,16));
        player_sprites.put("down2", new TextureRegion(playerImages, 16,0,16,16));

        player_sprites.put("left1", new TextureRegion(playerImages, 32,0,16,16));
        player_sprites.put("left2", new TextureRegion(playerImages, 48,0,16,16));

        player_sprites.put("right1", new TextureRegion(playerImages, 64,0,16,16));
        player_sprites.put("right2", new TextureRegion(playerImages, 80,0,16,16));

        player_sprites.put("up1", new TextureRegion(playerImages, 96,0,16,16));
        player_sprites.put("up2", new TextureRegion(playerImages, 112,0,16,16));

    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(regions.get(0), 50, 50);
        batch.draw(regions.get(1), 100, 100);
        batch.draw(regions.get(2), 150, 50);
        batch.draw(regions.get(3), 100, 150);
        batch.end();
    }

    @Override
    public void dispose() {
        playerImages.dispose();

    }
}
