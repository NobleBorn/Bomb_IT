package com.mygdx.game;

import Views.MenuScreenView;
import com.badlogic.gdx.*;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import Controllers.MenuScreenController;

//Help from Libgdx website, wiki and tutorials
public class Main extends Game {
	public SpriteBatch batch;
	public BitmapFont font;

	@Override
	public void create() {
		// The SpriteBatch object is used to render objects onto the screen
		batch = new SpriteBatch();
		// BitmapFont object is used, along with a SpriteBatch, to render text onto the screen
		font = new BitmapFont();
		// Set the Screen of the Game to a MainMenuScreen object, with a Main instance as its first and only parameter
		this.setScreen(new MenuScreenView(this));
	}

	@Override
	public void render() {
		// super.render makes it possible to render the screen that is in the create method
		super.render();

	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}