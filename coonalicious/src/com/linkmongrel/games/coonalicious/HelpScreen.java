package com.linkmongrel.games.coonalicious;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class HelpScreen implements Screen {
	Game game;
	ScoreloopInterface scoreloop;

	OrthographicCamera guiCam;
	SpriteBatch batcher;
	Texture helpImage;
	TextureRegion helpRegion;

	public HelpScreen(Game game, ScoreloopInterface scoreloop) {
		this.game = game;
		this.scoreloop = scoreloop;

		guiCam = new OrthographicCamera(Gdx.graphics.getHeight(),
				Gdx.graphics.getWidth());
		guiCam.position.set(Gdx.graphics.getHeight() / 2,
				Gdx.graphics.getWidth() / 2, 0);
		batcher = new SpriteBatch();
		helpImage = Assets.loadTexture("data/help1.png");
		helpRegion = new TextureRegion(helpImage, 0, 0, 480, 320);
	}

	public void update(float deltaTime) {
		if (Gdx.input.justTouched()) {
			Assets.playSound(Assets.clickSound);
			game.setScreen(new HelpScreen2(game, scoreloop));
			return;
		}
	}

	public void draw(float deltaTime) {
		GLCommon gl = Gdx.gl;
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		guiCam.update();

		batcher.disableBlending();
		batcher.begin();
		batcher.draw(helpRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batcher.end();

		gl.glDisable(GL10.GL_BLEND);
	}

	@Override
	public void render(float delta) {
		update(delta);
		draw(delta);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
		helpImage.dispose();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
