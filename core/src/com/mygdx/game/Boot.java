package com.mygdx.game;


import Models.Direction;
import Models.Map;
import Models.Player;
import Views.TileViewImage;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Boot extends Game {

    public static Boot INSTANCE;
    private int widthScreen, heightScreen;
    private OrthographicCamera orthographicCamera;
    private TileMapHelper tileMapHelper;
    private SpriteBatch batch;


    public Boot() {
        INSTANCE = this;
    }

    @Override
    public void create() {
        //this.map = new Map();
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        this.batch = new SpriteBatch();
        //this.loop = new GameLoop(map);
        setScreen(new GameScreen(orthographicCamera));
        this.tileMapHelper = new TileMapHelper(batch);
        tileMapHelper.setupMap();
    }
    @Override
    public void render(){
        //super.render();
        tileMapHelper.setupMap();
        orthographicCamera.update();
        //screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

}
