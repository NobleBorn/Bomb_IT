package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class GamePanel extends Game {
    final int OriginalTileSize = 16; // 16x16 tile
    final int scale = 3;

    final int tileSize = OriginalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 20;
    final int maxScreenRow = 15;
    final int screenWidth = tileSize * maxScreenCol; // 960 pixels
    final int screenHeight = tileSize * maxScreenRow; // 720 pixels

    @Override
    public void create() {

    }

    @Override
    public void render() {
        super.render();
    }


}
