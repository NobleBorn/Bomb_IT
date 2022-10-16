package com.mygdx.game;

import Models.*;
import Views.BombView;
import Views.PlayerView;
import Views.TileViewImage;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drawer {

    private Map map;
    private SpriteBatch sb;
    private final Texture sprPermWall;
    private final Texture sprTempWall;
    private final PlayerView playerOneView;
    private final PlayerView playerTwoView;
    private Player player1;
    private Player player2;
    private Tile tile;

    private final BombView bombView;
    private Bomb bomb;

    private Object Wall;

    public Drawer(SpriteBatch batch, Map map, Player player1, Player player2) {
        this.sb = batch;
        this.map = map;
        this.player1 = player1;
        this.player2 = player2;
        sprPermWall = new TileViewImage().getPermWallTexture();
        sprTempWall = new TileViewImage().getTempWallTexture();
        playerOneView = new PlayerView(this.player1, "spelare.png");
        playerTwoView = new PlayerView(this.player2, "spelare2.png");
        bombView = new BombView(this.bomb);
    }


    public void setupMap() {
        Tile[][] tilesMatrix = map.getMapMatrix();
        sb.begin();
        for(int i = 0; i < tilesMatrix.length; i++){
            for (int j = 0; j < tilesMatrix.length; j++){
                tile = tilesMatrix[i][j];
                if (!tilesMatrix[i][j].isTileEmpty()) {

                    if ((tile.getEntities().get(0) instanceof Wall)) {
                        drawWall(i, j);
                    } else if (tile.getEntities().get(0) instanceof Player) {
                        drawPlayer(i, j);
                    } else if (tile.getEntities().get(0) instanceof Bomb) {
                        drawBomb(i, j);
                    }
                }
            }
        }
        sb.end();
    }

    private void drawPlayer(int i, int j) {
        if (i == player1.getPosition().getX() && j == player1.getPosition().getY()) {
            if (player1.isAlive()) {
                sb.draw(playerOneView.getImage(), j * Tile.tileSize, i * Tile.tileSize);
            }
        }
        if (i == player2.getPosition().getX() && j == player2.getPosition().getY()) {
            if (player2.isAlive()) {
                sb.draw(playerTwoView.getImage(), j * Tile.tileSize, i * Tile.tileSize);
            }
        }
    }

    private void drawWall(int i, int j) {
        if (tile.getEntities().get(0) instanceof SoftWall) {
            sb.draw(sprTempWall, j *Tile.tileSize, i *Tile.tileSize);
        }
        else{
            sb.draw(sprPermWall, j *Tile.tileSize, i *Tile.tileSize);
        }
    }

    private void drawBomb(int i, int j){
        sb.draw(bombView.getBombImage(), j *Tile.tileSize, i *Tile.tileSize);
    }
}
