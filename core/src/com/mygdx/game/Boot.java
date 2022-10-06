package com.mygdx.game;


import Controllers.PlayerController;
import Models.*;
//import Views.GameScreenView;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Boot extends Game {

    public static Boot INSTANCE;
    private int widthScreen, heightScreen;
    private OrthographicCamera orthographicCamera;
    private Drawer drawer;
    private SpriteBatch batch;
    private Map map;
    private PlayerController playerOneController;
    private PlayerController playerTwoController;


    public Boot() {
        INSTANCE = this;
    }

    @Override
    public void create() {
        this.map = new Map();
        Player playerOne = map.getPlayers().get(0);
        Player playerTwo = map.getPlayers().get(1);

        this.playerOneController = new PlayerController(playerOne, Input.Keys.W, Input.Keys.A, Input.Keys.S, Input.Keys.D);
        this.playerTwoController = new PlayerController(playerTwo, Input.Keys.UP, Input.Keys.LEFT, Input.Keys.DOWN, Input.Keys.RIGHT);

        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        //this.orthographicCamera = new OrthographicCamera();
        //this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        this.batch = new SpriteBatch();
        MovementListener walkListener = new MovementListener(map);
        //MovementListener walkListener2 = new MovementListener(map);
        playerOne.observable.addSubscriber(walkListener);
        playerTwo.observable.addSubscriber(walkListener);
        //this.loop = new GameLoop(map);
        //setScreen(new GameScreen());
        this.drawer = new Drawer(batch, map, playerOne, playerTwo);
        drawer.setupMap();
    }
    @Override
    public void render(){
        Gdx.gl.glClearColor(0.07f, 0.3f, 0.05f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        super.render();
        drawer.setupMap();
        //orthographicCamera.update();
        playerOneController.update();
        playerTwoController.update();

        //screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose(){
        super.dispose();
        batch.dispose();
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
