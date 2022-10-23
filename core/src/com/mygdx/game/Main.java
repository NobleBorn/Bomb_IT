package com.mygdx.game;

import com.mygdx.game.Views.MenuScreenView;
import com.badlogic.gdx.*;

public class Main extends Game {

	@Override
	public void create() {
		this.setScreen(new MenuScreenView(this));
	}

	@Override
	public void render() {
		super.render();
	}
}