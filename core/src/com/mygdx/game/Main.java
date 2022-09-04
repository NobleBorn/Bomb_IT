package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
	// SpriteBatch is a class that is used to draw 2D images, like a texture
	SpriteBatch batch;
	// A Texture represents a loaded image that is stored
	Texture mapImage;

	// Create method loads the images
	@Override
	public void create () {
		batch = new SpriteBatch();
		mapImage = new Texture(Gdx.files.internal("map.png"));
	}

	// Render method renders the images
	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		batch.begin();
		// Draw/render the map from position (x,y)
		batch.draw(mapImage, 0, 0);
		batch.end();
	}

	// Dispose of the resources after the application is closed
	@Override
	public void dispose () {
		batch.dispose();
		mapImage.dispose();
	}
}
