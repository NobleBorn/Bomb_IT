package com.mygdx.game;

import com.mygdx.game.Views.MenuScreenView;
import com.badlogic.gdx.*;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Main extends Game {
	private SpriteBatch batch;
	private BitmapFont font;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();

		this.setScreen(new MenuScreenView(this));
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}


	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}


	@Override
	public void render() {
		super.render();

	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		font.dispose();
	}
}