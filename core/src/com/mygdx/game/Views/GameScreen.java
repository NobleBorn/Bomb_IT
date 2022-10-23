package com.mygdx.game.Views;


import com.mygdx.game.Controllers.PanelController;
import com.mygdx.game.Controllers.PlayerController;
import com.mygdx.game.Main;
import com.mygdx.game.Views.GameOverView;
import com.mygdx.game.Views.PanelView;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Models.Bomb;
import com.mygdx.game.Models.Map;
import com.mygdx.game.Models.Player;

/**
 * Represents the Game screen
 */
public class GameScreen implements Screen {
    private final Main game;
    private OrthographicCamera orthographicCamera;
    private Drawer drawer;
    private Texture img;
    private SpriteBatch batch;
    private Player playerOne;
    private Player playerTwo;
    private PlayerController playerOneController;
    private PlayerController playerTwoController;

    private float timeSeconds = 181f;
    private PanelView panelView;
    private FitViewport viewPort;
    public Music gameMusic;
    private State state = State.RUNNING;

    private enum State{
        RUNNING, PAUSED
    }

    /**
     * Constructor
     *
     * @param game - an instance of the main {@link Main}
     */
    protected GameScreen(final Main game) {
        this.game = game;
        Map map = new Map();
        create(map);
    }

    private void create(Map map) {
        img = new Texture(Gdx.files.internal("pixelMap1.png"));
        playerOne = map.getPlayers().get(0);
        playerTwo = map.getPlayers().get(1);

        PlayerView playerOneView = new PlayerView(playerOne, "spelare.png");
        PlayerView playerTwoView = new PlayerView(playerTwo, "spelare2.png");

        this.panelView = new PanelView(this, playerOne, playerTwo);

        this.playerOneController = new PlayerController(playerOne, playerOneView, Input.Keys.DPAD_UP, Input.Keys.DPAD_DOWN,
                Input.Keys.DPAD_RIGHT, Input.Keys.DPAD_LEFT, Input.Keys.SHIFT_RIGHT);
        this.playerTwoController = new PlayerController(playerTwo, playerTwoView, Input.Keys.W, Input.Keys.S,
                Input.Keys.D, Input.Keys.A, Input.Keys.SHIFT_LEFT);

        int widthScreen = Gdx.graphics.getWidth();
        int heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        this.viewPort = new FitViewport(0, 0, orthographicCamera);
        this.batch = new SpriteBatch();
        this.drawer = new Drawer(batch, map, playerOneView, playerTwoView);
        this.gameMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        this.gameMusic.setLooping(true);
        this.gameMusic.play();
    }

    @Override
    public void show() {
    }

    /**
     * Renders game screen draw and updates
     * @param delta - game's delta time
     */
    @Override
    public void render(float delta) {
        int num;
        switch(state){
            case RUNNING:
                timeSeconds -= Gdx.graphics.getDeltaTime();
                if(!playerOne.isAlive() || !playerTwo.isAlive()){
                    if(playerTwo.isAlive())
                        num = 2;
                    else
                        num = 1;
                    this.game.setScreen(new GameOverView(game, num));
                }
                else if (timeSeconds <= 0 ){
                    this.game.setScreen(new GameOverView(game, playerTwo.getScore() > playerOne.getScore()? 2: 1)); //chooses winner depending on score
                }
                else{
                    draw();
                    update();
                }
                break;
            case PAUSED:
                break;
        }
        batch.setProjectionMatrix(orthographicCamera.combined);
    }

    public float getTimeSeconds() {
        return timeSeconds;
    }

    /**
     * Draws the game screen background
     */
    public void draw(){
        Gdx.gl.glClearColor(24/255f, 92/255f, 22/255f, 0.9f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0,0,960,960);
        batch.end();
        drawer.setupMap();
    }

    /**
     * Updates the controls and camera
     */
    public void update(){
        orthographicCamera.update();
        playerOneController.update();
        playerTwoController.update();
        panelView.update();
    }

    @Override
    public void resize(int width, int height) {
        orthographicCamera.setToOrtho(false, width, height);
        this.viewPort.setWorldSize(width, height);
        this.viewPort.update(width, height);
        panelView.getStage().getViewport().update(width, height);
    }

    /**
     * Disposes of the garbage
     */
    @Override
    public void dispose(){
        batch.dispose();
        panelView.dispose();
        game.dispose();
    }

    @Override
    public void pause() {
        state = State.PAUSED;
    }

    @Override
    public void resume() {
        state = State.RUNNING;
    }

    @Override
    public void hide() {
    }

}
