package com.mygdx.game;

import Models.*;
import Views.PlayerView;
import Views.TileViewImage;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Drawer {

    private Map map;
    private SpriteBatch sb;
    private final Texture sprPermWall;
    private final Texture sprTempWall;
    private final PlayerView playerOneView;
    private final PlayerView playerTwoView;
    private final Player playerOne;
    private final Player playerTwo;
    private Tile tile;
    private Tile[][] tilesMatrix;
    private Direction playerOneOld, playerOneNew, playerTwoOld, playerTwoNew;

    public Drawer(SpriteBatch batch, Map map, Player playerOne, Player playerTwo) {
        this.sb = batch;
        this.map = map;
        sprPermWall = new TileViewImage().getWallTexture(false);
        sprTempWall = new TileViewImage().getWallTexture(true);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        playerTwoView = new PlayerView(this.playerTwo);
        playerOneView = new PlayerView(this.playerOne);
    }

    public void setupMap() {
        this.tilesMatrix = map.getMapMatrix();
        sb.begin();
        for(int i = 0; i < tilesMatrix.length; i++){
            for (int j = 0; j < tilesMatrix.length; j++){
                tile = tilesMatrix[i][j];
                if (!tile.isTileEmpty()){

                    if ((tile.getEntities().get(0) instanceof Wall)){
                        drawWall(i, j);

                    } else if (tile.getEntities().get(0) instanceof Player){
                        drawPlayer(i, j);
                    }
                }
            }
        }
        sb.end();
    }

    private void drawPlayer(int i, int j) {
        if (i == playerOne.getPosition().getX() && j == playerOne.getPosition().getY()){
            sb.draw(playerOneView.getImage(playerOne.getDirection()), j *Tile.getTileSize(), i *Tile.getTileSize());
        }
        else if (i == playerTwo.getPosition().getX() && j == playerTwo.getPosition().getY()){
            sb.draw(playerTwoView.getImage(playerTwo.getDirection()), j *Tile.getTileSize(), i *Tile.getTileSize());
        }

    }
    private void drawWall(int i, int j) {
        if (!((Wall) tile.getEntities().get(0)).isDestroyable()) {
            sb.draw(sprPermWall, (j *Tile.getTileSize()), i*Tile.getTileSize());
        }
        else{
            sb.draw(sprTempWall, j *Tile.getTileSize(), i *Tile.getTileSize());
        }
    }

    /*private void parseMapObjects(MapObjects mapObjects) {
        for(MapObject mapObject : mapObjects) {
            if(mapObject instanceof PolygonMapObject) {
                createStaticBody((PolygonMapObject) mapObject);
            }
        }
    }
    private void createStaticBody(PolygonMapObject polygonMapObject) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = gameScreen.getWorld().createBody(bodyDef);
        Shape shape = createPolygonShape(polygonMapObject);
        body.createFixture(shape, 1000);
        shape.dispose();
    }

    private Shape createPolygonShape(PolygonMapObject polygonMapObject) {
        float[] vertices = polygonMapObject.getPolygon().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for(int i = 0; i < vertices.length / 2; i++) {
            Vector2 current = new Vector2(vertices[i * 2] / PPM, vertices[i * 2 + 1] / PPM);
            worldVertices[i] = current;

        }

        PolygonShape shape = new PolygonShape();
        shape.set(worldVertices);
        return shape;
    }*/
}
