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
    private Player playerOne;
    private Player playerTwo;
    private Tile tile;
    private Tile[][] tilesMatrix;
    private Player entityToCast;

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
        //int counter = 0;
        //Sprite sprPermWall = new Sprite(new TileViewImage().getWallTexture(false));
        /*float pad = 1/100f * Gdx.graphics.getWidth();
        Skin skin = new Skin();
        ImageButton pause = new ImageButton( skin, "menu-button-pause" );
        ImageButton volume = new ImageButton( skin, "menu-button-volume" );
        TextButton about = new TextButton( "about", skin, "menu-button" );
        TextButton help = new TextButton( "help", skin, "menu-button" );

        Table menu = new Table( skin );
        menu.setBackground( "background" );
        menu.add( pause ).padRight( pad );
        menu.add( volume ).padRight( pad );
        menu.add( about ).fill().padRight( pad );
        menu.add( help ).fill();*/
        //Texture background = new Texture("backgroundImagePath");
        this.tilesMatrix = map.getTiles();
        sb.begin();
        for(int i = 0; i < tilesMatrix.length; i++){
            for (int j = 0; j < tilesMatrix.length; j++){
                tile = tilesMatrix[i][j];
                //sb.draw(background, j*Tile.getTileSize(), i*Tile.getTileSize());
                if (!tile.isTileEmpty()){

                    if ((tile.entities.get(0) instanceof Wall)){
                        drawWall(i, j);

                    } else if (tile.entities.get(0) instanceof Player){
                        drawPlayer(i, j);
                    }
                }
            }
        }
        sb.end();
    }

    private void drawPlayer(int i, int j) {
        /* if (tile.entities.get(0).getPosition().getX() == playerOne.getPosition().getX() && tile.entities.get(0).getPosition().getY() == playerOne.getPosition().getY()){
            playerOneView.setupPlayerImage();
            //entityToCast = (Player)tile.entities.get(0);
            //System.out.println(entityToCast.getDirection());
            sb.draw(playerOneView.getImage(playerOne.getDirection()), j *Tile.getTileSize(), i *Tile.getTileSize());
        }
        else if (tile.entities.get(0).getPosition().getX() == playerTwo.getPosition().getX() && tile.entities.get(0).getPosition().getY() == playerTwo.getPosition().getY()){
            playerTwoView.setupPlayerImage();
            sb.draw(playerTwoView.getImage(playerTwo.getDirection()), j *Tile.getTileSize(), i *Tile.getTileSize());
            //sb.draw(sprPermWall, j *Tile.getTileSize(), i *Tile.getTileSize());
        } */

        playerOneView.setupPlayerImage();
        sb.draw(playerOneView.getImage(playerOne.getDirection()), j *Tile.getTileSize(), i *Tile.getTileSize());
        playerTwoView.setupPlayerImage();
        sb.draw(playerTwoView.getImage(playerTwo.getDirection()), j *Tile.getTileSize(), i *Tile.getTileSize());
    }
    private void drawWall(int i, int j) {
        if (!(((Wall) tile.entities.get(0)).isDestroyable())) {
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
