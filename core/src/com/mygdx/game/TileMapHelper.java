package com.mygdx.game;

import Models.Map;
import Models.Position;
import Models.Tile;
import Models.Wall;
import Views.TileViewImage;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TileMapHelper {

    private Map map;
    private SpriteBatch sb;

    public TileMapHelper(SpriteBatch batch) {
        this.sb = batch;
        this.map = new Map();
    }

    public void setupMap() {
        Tile tile;
        //int counter = 0;
        //Sprite sprPermWall = new Sprite(new TileViewImage().getWallTexture(false));
        Texture sprPermWall = new TileViewImage().getWallTexture(false);
        Texture sprTempWall = new TileViewImage().getWallTexture(true);

        Tile[][] tilesMatrix = map.getMapMatrix();
        sb.begin();
        for(int i = 0; i < tilesMatrix.length; i++){
            for (int j = 0; j < tilesMatrix.length; j++){
                tile = tilesMatrix[i][j];
                if (!tile.isTileEmpty()){
                    if ((tile.entities.get(0) instanceof Wall)){
                        if (!(((Wall) tile.entities.get(0)).isDestroyable())) {
                            sb.draw(sprPermWall, j*Tile.getTileSize(), i*Tile.getTileSize());
                        }
                        else{
                            sb.draw(sprTempWall, j*Tile.getTileSize(), i*Tile.getTileSize());
                        }
                        continue;
                    }
                }
            }
        }
        sb.end();
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
