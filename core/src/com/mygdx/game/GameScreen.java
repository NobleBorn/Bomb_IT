package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import static com.mygdx.game.Constants.PPM;


public class GameScreen extends ScreenAdapter {
    //final Main game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;
    private Boot boot;

    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private Drawer drawer;

    public GameScreen(){
        //this.game = game;
        camera = new OrthographicCamera();
         /* camera.setToOrtho(false, boot.getWidthScreen(), boot.getHeightScreen());
        this.batch = new SpriteBatch();
        this.world = new World(new Vector2(0,0), false);
        this.box2DDebugRenderer = new Box2DDebugRenderer();

        this.drawer = new Drawer(this);
        this.orthogonalTiledMapRenderer = drawer.setupMap(); */
    }

     /* private void update() {
        world.step(1 / 60f, 6, 2);
        cameraUpdate();

        batch.setProjectionMatrix(camera.combined);
        orthogonalTiledMapRenderer.setView(camera);

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {  //ESC closes game
            Gdx.app.exit();
        }
    }

    private void cameraUpdate(){
        camera.position.set(new Vector3(640, 640, 0));
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        orthogonalTiledMapRenderer.render();

        batch.begin();

        //render objects

        batch.end();
        box2DDebugRenderer.render(world, camera.combined.scl(PPM));


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public World getWorld() {
        return world;
    } */

}
