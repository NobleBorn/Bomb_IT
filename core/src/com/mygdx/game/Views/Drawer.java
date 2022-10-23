package com.mygdx.game.Views;

import com.mygdx.game.Models.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

class Drawer {

    private final Map map;
    private final SpriteBatch sb;
    private final Texture sprPermWall;
    private final Texture sprTempWall;
    private final Texture bombImage;
    private final PlayerView playerOneView;
    private final PlayerView playerTwoView;
    private final Array<IDrawable> toDraw = new Array<>();

    public Drawer(SpriteBatch batch, Map map, PlayerView playerOneView, PlayerView playerTwoView) {
        this.sb = batch;
        this.map = map;

        this.playerOneView = playerOneView;
        this.playerTwoView = playerTwoView;
        sprPermWall = new Texture(Gdx.files.internal("wallperm.jpg"));
        sprTempWall = new Texture(Gdx.files.internal("walltemp.jpg"));
        bombImage = new Texture("bombImage.png");

        prepareToDraws();
    }

    private void prepareToDraws(){
        for (Wall wall: map.getPermWalls()){
            toDraw.add(new PermWallView(wall.getPosition(), sprPermWall));
        }
        for (SoftWall softWall: map.getSoftWalls()){
            toDraw.add(new SoftWallView(softWall.getPosition(), sprTempWall));
        }
        for (Bomb bomb: map.getBombs()){
            toDraw.add(new BombView(bomb, bombImage));
        }
        toDraw.add(playerOneView);
        toDraw.add(playerTwoView);
    }

    protected void setupMap() {
        prepareToDraws();

        sb.begin();
        for (IDrawable drawable: toDraw){
            drawable.draw(sb);
        }
        sb.end();
        toDraw.clear();
    }

}
