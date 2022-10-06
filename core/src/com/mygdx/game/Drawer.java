package com.mygdx.game;

import Models.*;
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

    public Drawer(SpriteBatch batch, Map map, Player player1, Player player2) {
        this.sb = batch;
        this.map = map;
        this.player1 = player1;
        this.player2 = player2;
        sprPermWall = new TileViewImage().getWallTexture(false);
        sprTempWall = new TileViewImage().getWallTexture(true);
        playerOneView = new PlayerView(this.player1);
        playerTwoView = new PlayerView(this.player2);
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

        Tile[][] tilesMatrix = map.getMapMatrix();
        sb.begin();
        for(int i = 0; i < tilesMatrix.length; i++){
            for (int j = 0; j < tilesMatrix.length; j++){
                tile = tilesMatrix[i][j];
                //sb.draw(background, j*Tile.getTileSize(), i*Tile.getTileSize());
                if (!tile.isTileEmpty()){

                    if ((tile.entities.get(0) instanceof Wall)){
                        drawWall(i, j);

                    }
                    else if (tile.entities.get(0) instanceof Player){
                        drawPlayer(i, j);
                    }
                }
            }
        }
        sb.end();
    }

    private void drawPlayer(int i, int j) {
        //entityToCast = (Player) tile.entities.get(0);
        /*playerOneView.setupPlayerImage();
        sb.draw(playerOneView.getImage(player1.getDirection()), j *Tile.getTileSize(), i *Tile.getTileSize());
        playerTwoView.setupPlayerImage();
        sb.draw(playerTwoView.getImage(player2.getDirection()), j *Tile.getTileSize(), i *Tile.getTileSize());*/
        if (i == player1.getPosition().getX() && j == player1.getPosition().getY()){
            playerOneView.setupPlayerImage();
            sb.draw(playerOneView.getImage(player1.getDirection(), 1), j *Tile.getTileSize(), i *Tile.getTileSize());
        }
        else if (i == player2.getPosition().getX() && j == player2.getPosition().getY()){
            playerTwoView.setupPlayerImage();
            sb.draw(playerTwoView.getImage(player2.getDirection(), 2), j *Tile.getTileSize(), i *Tile.getTileSize());
        }
        //sb.draw(sprPermWall, j *Tile.getTileSize(), i *Tile.getTileSize());

    }

    public SpriteBatch getSb() {
        return sb;
    }

    private void drawWall(int i, int j) {
        if (!(((Wall) tile.entities.get(0)).isDestroyable())) {
            sb.draw(sprPermWall, (j *Tile.getTileSize()), i *Tile.getTileSize());
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