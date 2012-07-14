package com.linkmongrel.games.coonalicious;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen implements Screen {
	Game game;
	ScoreloopInterface scoreloop;

	OrthographicCamera guiCam;
	SpriteBatch batcher;
	Rectangle soundBounds;
	Rectangle playBounds;
	Rectangle highscoresBounds;
	Rectangle helpBounds;
	Vector3 touchPoint;

	public MainMenuScreen(Game game, ScoreloopInterface scoreloop) {
		this.game = game;
		this.scoreloop = scoreloop;

		guiCam = new OrthographicCamera(Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
		guiCam.position.set(Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, 0);
		batcher = new SpriteBatch();
		soundBounds = new Rectangle(0, 0, 64, 64);
		playBounds = new Rectangle((Gdx.graphics.getHeight() / 4) * 3, Gdx.graphics.getWidth() / 2, (Gdx.graphics.getHeight() / 5), Gdx.graphics.getWidth() / 10);
//		highscoresBounds = new Rectangle(160 - 150, 200 - 18, 300, 36);
//		helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
		touchPoint = new Vector3();
	}

	public void update(float deltaTime) {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

			if (OverlapTester.pointInRectangle(playBounds, touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				game.setScreen(new GameScreen(game, scoreloop));
				return;
			}
//			if (OverlapTester.pointInRectangle(highscoresBounds, touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new HighscoresScreen(game));
//				return;
//			}
//			if (OverlapTester.pointInRectangle(helpBounds, touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new HelpScreen(game));
//				return;
//			}
			if (OverlapTester.pointInRectangle(soundBounds, touchPoint.x, touchPoint.y)) {
				Assets.playSound(Assets.clickSound);
				Settings.soundEnabled = !Settings.soundEnabled;
				if (Settings.soundEnabled)
					Assets.music.play();
				else
					Assets.music.pause();
//				scoreloop.OpenScoreloop();
			}
		}
	}

	public void draw(float deltaTime) {
		GLCommon gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		batcher.setProjectionMatrix(guiCam.combined);

		batcher.disableBlending();
		batcher.begin();
		batcher.draw(Assets.splashRegion, 0, 0, Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
		batcher.end();

		batcher.enableBlending();
		batcher.begin();
//		batcher.draw(Assets.logo, 160 - 274 / 2, 480 - 10 - 142, 274, 142);
//		batcher.draw(Assets.mainMenu, 10, 200 - 110 / 2, 300, 110);
		batcher.draw(Settings.soundEnabled ? Assets.soundOn : Assets.soundOff, 0, 0, 64, 64);
		batcher.end();
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
		Settings.save();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
