package com.mygdx.game;

import Models.*;
import Views.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Drawer {

    private final Map map;
    private final SpriteBatch sb;
    private final Texture sprPermWall;
    private final Texture sprTempWall;
    private final Texture bombImage;
    private final PlayerView playerOneView;
    private final PlayerView playerTwoView;
    private final Array<IDrawable> toDraw = new Array<>();

    private Object Wall;

    public Drawer(SpriteBatch batch, Map map, Player player1, Player player2) {
        this.sb = batch;
        this.map = map;

        sprPermWall = new TileViewImage().getPermWallTexture();
        sprTempWall = new TileViewImage().getTempWallTexture();
        playerOneView = new PlayerView(player1, "spelare.png");
        playerTwoView = new PlayerView(player2, "spelare2.png");
        bombImage = new Texture("bombImage.png");

        prepareToDraws();
    }
    private void prepareToDraws(){
        for (Wall wall: map.getPermWalls()){
            toDraw.add(new permWallView(wall.getPosition(), sprPermWall));
        }
        for (SoftWall softWall: map.getSoftWalls()){
            toDraw.add(new softWallView(softWall.getPosition(), sprTempWall));
        }
        for (Bomb bomb: map.getBombs()){
            toDraw.add(new BombView(bomb, bombImage));

        }
        toDraw.add(playerOneView);
        toDraw.add(playerTwoView);
    }

    public void setupMap() {
        prepareToDraws();

        sb.begin();
        for (IDrawable drawable: toDraw){
            drawable.draw(sb);
        }
        sb.end();
        toDraw.clear();
    }

}
