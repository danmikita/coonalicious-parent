package com.linkmongrel.games.coonalicious;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Coonalicious extends Game {
	boolean firstTimeCreate = true;

	@Override
	public void create() {
		Settings.load();
		Assets.load();
		setScreen(new MainMenuScreen(this));
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
