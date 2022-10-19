package Views;

import Controllers.PanelController;
import Controllers.PlayerController;
import Models.Bomb;
import Models.Map;
import Models.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Main;

public class GameScreen extends ScreenAdapter {
    final Main game;
    private OrthographicCamera orthographicCamera;
    private Drawer drawer;
    private Texture img;
    private SpriteBatch batch;
    private Map map;
    private Player playerOne;
    private Player playerTwo;
    private PlayerController playerOneController;
    private PlayerController playerTwoController;
    private Bomb bomb;

    private PanelController panelController;
    private float timeSeconds = 181f;
    private float period = 600f;
    private FitViewport viewPort;
    public Music gameMusic;

    private enum State{
        Running, Paused
    }

    private State state = State.Running;

    public GameScreen(final Main game) {
        this.game = game;
        create();
    }

    private void create() {
        this.map = new Map();
        img = new Texture(Gdx.files.internal("pixelMap.png"));
        playerOne = map.getPlayers().get(0);
        playerTwo = map.getPlayers().get(1);

        this.panelController = new PanelController(this, playerOne, playerTwo);

        this.playerOneController = new PlayerController(playerOne, Input.Keys.DPAD_UP, Input.Keys.DPAD_DOWN,
                Input.Keys.DPAD_RIGHT, Input.Keys.DPAD_LEFT, Input.Keys.SHIFT_RIGHT);
        this.playerTwoController = new PlayerController(playerTwo, Input.Keys.W, Input.Keys.S,
                Input.Keys.D, Input.Keys.A, Input.Keys.SHIFT_LEFT);

        int widthScreen = Gdx.graphics.getWidth();
        int heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        this.viewPort = new FitViewport(1280, heightScreen, orthographicCamera);
        this.batch = new SpriteBatch();
        this.drawer = new Drawer(batch, map, playerOne, playerTwo);
        this.gameMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        this.gameMusic.setLooping(true);
        gameMusic.play();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        int num;
        switch(state){
            case Running:
                timeSeconds -= Gdx.graphics.getDeltaTime();
                if(timeSeconds <= 0 || !playerOne.isAlive() || !playerTwo.isAlive()){
                    if(playerTwo.isAlive())
                        num = 2;
                    else
                        num = 1;
                    this.game.setScreen(new GameOverView(game, num));
                }
                else{
                    draw();
                    update();
                }
                break;
            case Paused:
                break;
        }
        batch.setProjectionMatrix(orthographicCamera.combined);
    }

    public float getTimeSeconds() {
        return timeSeconds;
    }

    public void draw(){
        Gdx.gl.glClearColor(24/255f, 92/255f, 22/255f, 0.9f);
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
        panelController.update();
    }

    @Override
    public void resize(int width, int height) {
        this.viewPort.update(width, height);
    }

    @Override
    public void dispose(){
        batch.dispose();
        panelController.dispose();
    }

    @Override
    public void pause() {
        state = State.Paused;
    }

    @Override
    public void resume() {
        state = State.Running;
    }

    @Override
    public void hide() {
    }

}