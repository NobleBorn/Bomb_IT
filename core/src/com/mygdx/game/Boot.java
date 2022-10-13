package com.mygdx.game;


import Controllers.PanelController;
import Controllers.PlayerController;
import Models.*;
//import Views.GameScreenView;
import Views.GameOverView;
import Views.MenuScreenView;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Boot implements Screen {
    final Main game;
    public static Boot INSTANCE;
    private int widthScreen, heightScreen;
    private OrthographicCamera orthographicCamera;
    private Drawer drawer;
    private Texture img;
    private SpriteBatch batch;
    private Map map;
    private PlayerController playerOneController;
    private PlayerController playerTwoController;

    private PanelController panelController;
    private float timeSeconds = 0f;
    private float period = 10f;

    public enum State{
        Running, Paused
    }

    private State state = State.Running;

    public Boot(final Main game) {
        this.game = game;
        //INSTANCE = this;
        create();
    }

    public void create() {
        this.map = new Map();
        img = new Texture(Gdx.files.internal("karta.jpg"));
        Player playerOne = map.getPlayers().get(0);
        Player playerTwo = map.getPlayers().get(1);

        this.panelController = new PanelController(this, playerOne, playerTwo);

        this.playerOneController = new PlayerController(playerOne, Input.Keys.DPAD_UP, Input.Keys.DPAD_DOWN,
                Input.Keys.DPAD_RIGHT, Input.Keys.DPAD_LEFT, Input.Keys.SHIFT_RIGHT);
        this.playerTwoController = new PlayerController(playerTwo, Input.Keys.W, Input.Keys.S,
                Input.Keys.D, Input.Keys.A, Input.Keys.SHIFT_LEFT);

        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        this.batch = new SpriteBatch();
        MovementListener walkListener = new MovementListener(map);
        playerOne.observable.addSubscriber(walkListener);
        playerTwo.observable.addSubscriber(walkListener);
        //this.loop = new GameLoop(map);
        //setScreen(new GameScreen());
        this.drawer = new Drawer(batch, map, playerOne, playerTwo);
        //drawer.setupMap();
    }
    /*@Override
    public void render(){
        //super.render();
        Gdx.gl.glClearColor(0.1f, 1, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0,0,960,960);
        batch.end();
        drawer.setupMap();
        orthographicCamera.update();
        playerOneController.update();
        playerTwoController.update();
        //screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }*/

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        switch(state){
            case Running:
                timeSeconds += Gdx.graphics.getDeltaTime();
                if(timeSeconds > period){
                    this.game.setScreen(new GameOverView(game));
                }
                else{
                    draw();
                    update();
                }
                break;
            case Paused:
                //panelController.render();
                break;
        }
    }

    public float getTimeSeconds() {
        return timeSeconds;
    }

    public void draw(){
        Gdx.gl.glClearColor(98/255f, 61/255f, 3/255f, 0.9f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0,0,960,960);
        batch.end();
        drawer.setupMap();
    }

    public void update(){
        orthographicCamera.update();
        playerOneController.update();
        playerTwoController.update();
        panelController.render();
    }

    @Override
    public void resize(int width, int height) {
        //super.resize(width, height);
    }

    @Override
    public void dispose(){
        //super.dispose();
        batch.dispose();
        panelController.dispose();
    }

    @Override
    public void pause() {
        //super.pause();
        state = State.Paused;
    }

    @Override
    public void resume() {
        //super.resume();
        state = State.Running;
    }

    @Override
    public void hide() {

    }

}
