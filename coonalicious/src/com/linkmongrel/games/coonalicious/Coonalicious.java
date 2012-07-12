package com.linkmongrel.games.coonalicious;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Coonalicious extends Game {
	boolean firstTimeCreate = true;
	
	public ScoreloopInterface scoreloop;
	
	public Coonalicious(ScoreloopInterface scoreloop) {
		this.scoreloop = scoreloop;
	}

	@Override
	public void create() {
		Settings.load();
		Assets.load();
		setScreen(new MainMenuScreen(this, scoreloop));
	}

	/**
	 * {@link Game#dispose()} only calls {@link Screen#hide()} so you need to
	 * override {@link Game#dispose()} in order to call {@link Screen#dispose()}
	 * on each of your screens which still need to dispose of their resources.
	 * SuperJumper doesn't actually have such resources so this is only to
	 * complete the example.
	 */
	@Override
	public void dispose() {
		super.dispose();

		getScreen().dispose();
	}
}
