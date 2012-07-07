package com.linkmongrel.games.coonalicious;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WorldRenderer {
	static final float FRUSTUM_WIDTH = 15;
	static final float FRUSTUM_HEIGHT = 10;
	World world;
	OrthographicCamera cam;
	SpriteBatch batch;
	TextureRegion background;

	public WorldRenderer(SpriteBatch batch, World world) {
		this.world = world;
		this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		this.cam.position.set(FRUSTUM_WIDTH / 2, FRUSTUM_HEIGHT / 2, 0);
		this.batch = batch;
	}

	public void render() {
		if (world.rikki.position.y > cam.position.y)
			cam.position.y = world.rikki.position.y;
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		renderBackground();
		renderObjects();
	}

	public void renderBackground() {
		batch.disableBlending();
		batch.begin();
		batch.draw(Assets.backgroundRegion, cam.position.x - FRUSTUM_WIDTH / 2, cam.position.y
				- FRUSTUM_HEIGHT / 2, FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
		batch.end();
	}

	public void renderObjects() {
		batch.enableBlending();
		batch.begin();
		renderRikki();
		renderFood();
		batch.end();
	}

	private void renderRikki() {
//		TextureRegion keyFrame;
//		switch (world.rikki.state) {
		// case Bob.BOB_STATE_FALL:
		// keyFrame = Assets.bobFall.getKeyFrame(world.bob.stateTime,
		// Animation.ANIMATION_LOOPING);
		// break;
		// case Bob.BOB_STATE_JUMP:
		// keyFrame = Assets.bobJump.getKeyFrame(world.bob.stateTime,
		// Animation.ANIMATION_LOOPING);
		// break;
//		case Rikki.RIKKI_STATE_EAT:
//			if (world.rikki.stateTime < 1)
//				keyFrame = Assets.rikkiEat.getKeyFrame(world.rikki.stateTime,
//						Animation.ANIMATION_LOOPING);
//			else
//				keyFrame = Assets.rikkiRunning.getKeyFrame(world.rikki.stateTime,
//						Animation.ANIMATION_LOOPING);
//			break;
//		case Rikki.RIKKI_STATE_RUNNING:
//			keyFrame = Assets.rikkiRunning.getKeyFrame(world.rikki.stateTime,
//					Animation.ANIMATION_LOOPING);
//		case Rikki.RIKKI_STATE_STANDING:
//			keyFrame = Assets.rikkiStanding.getKeyFrame(world.rikki.stateTime,
//					Animation.ANIMATION_LOOPING);
//		default:
//			keyFrame = Assets.rikkiRunning.getKeyFrame(world.rikki.stateTime,
//					Animation.ANIMATION_LOOPING);
//		}
		switch (world.rikki.fatness) {
		case Rikki.SKINNIEST:
			batch.draw(Assets.skinniest, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
			break;
		case Rikki.SKINNIER:
			batch.draw(Assets.skinnier, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
			break;
		case Rikki.SKINNY:
			batch.draw(Assets.skinny, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
			break;
		case Rikki.NEUTRAL:
			batch.draw(Assets.neutral, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
			break;
		case Rikki.FAT:
			batch.draw(Assets.fat, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
			break;
		case Rikki.FATTER:
			batch.draw(Assets.fatter, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
			break;
		case Rikki.FATTEST:
			batch.draw(Assets.fattest, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
			break;
		default:
			batch.draw(Assets.neutral, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
		}

		// float side = world.bob.velocity.x < 0 ? -1 : 1;
		// if (side < 0)
		// batch.draw(keyFrame, world.bob.position.x + 0.5f,
		// world.bob.position.y - 0.5f, side * 2, 2);
		// else
//		batch.draw(keyFrame, world.rikki.position.x - 0.5f, world.rikki.position.y - 0.5f, 2.32f, 2);
	}

	private void renderFood() {
		int len = world.food.size();
		for (int i = 0; i < len; i++) {
			Food food = world.food.get(i);
			
			switch (food.type) {
			case Food.CAKE:
				batch.draw(Assets.cake, food.position.x - 0.5f, food.position.y - 0.5f, 1.45f, 1.25f);
				break;
			case Food.HAMBURGER:
				batch.draw(Assets.burger, food.position.x - 0.5f, food.position.y - 0.5f, 1.69f, 1);
				break;
			case Food.FRIES:
				batch.draw(Assets.fries, food.position.x - 0.5f, food.position.y - 0.5f, 1.25f, 1.48f);
				break;
			case Food.ICECREAM:
				batch.draw(Assets.icecream, food.position.x - 0.5f, food.position.y - 0.5f, 1, 1.9f);
				break;
			case Food.COOKIE:
				batch.draw(Assets.cookie, food.position.x - 0.5f, food.position.y - 0.5f, 1, 1.08f);
				break;
			case Food.BACON:
				batch.draw(Assets.bacon, food.position.x - 0.5f, food.position.y - 0.5f, 1, 1);
				break;
			case Food.DRUMSTICK:
				batch.draw(Assets.drumstick, food.position.x - 0.5f, food.position.y - 0.5f, 1.64f, 1.5f);
				break;
			case Food.SODA:
				batch.draw(Assets.soda, food.position.x - 0.5f, food.position.y - 0.5f, 0.75f, 1.17f);
				break;
			case Food.CHEESE:
				batch.draw(Assets.cheese, food.position.x - 0.5f, food.position.y - 0.5f, 1.11f, 1);
				break;
			case Food.EGG:
				batch.draw(Assets.egg, food.position.x - 0.5f, food.position.y - 0.5f, 0.5f, 0.63f);
				break;
			case Food.CHICKEN:
				batch.draw(Assets.chicken, food.position.x - 0.5f, food.position.y - 0.5f, 1.69f, 0.75f);
				break;
			case Food.FISH:
				batch.draw(Assets.fish, food.position.x - 0.5f, food.position.y - 0.5f, 1, 1.93f);
				break;
			case Food.BANANA:
				batch.draw(Assets.banana, food.position.x - 0.5f, food.position.y - 0.5f, 1.5f, 1);
				break;
			case Food.APPLE:
				batch.draw(Assets.apple, food.position.x - 0.5f, food.position.y - 0.5f, 1, 1.167f);
				break;
			case Food.EGGPLANT:
				batch.draw(Assets.eggplant, food.position.x - 0.5f, food.position.y - 0.5f, 1.5f, 1.78f);
				break;
			case Food.TOMATO:
				batch.draw(Assets.tomato, food.position.x - 0.5f, food.position.y - 0.5f, 1.06f, 1);
				break;
			case Food.CARROT:
				batch.draw(Assets.carrot, food.position.x - 0.5f, food.position.y - 0.5f, 0.5f, 1.23f);
				break;
			case Food.BROCCOLI:
				batch.draw(Assets.broccoli, food.position.x - 0.5f, food.position.y - 0.5f, 1.178f, 1);
				break;
			case Food.CELERY:
				batch.draw(Assets.celery, food.position.x - 0.5f, food.position.y - 0.5f, 1.09f, 1);
				break;
			case Food.TOFU:
				batch.draw(Assets.tofu, food.position.x - 0.5f, food.position.y - 0.5f, 0.59f, 0.5f);
				break;
			default:
				batch.draw(Assets.carrot, food.position.x - 0.5f, food.position.y - 0.5f, 0.5f, 1.23f);
			}
		}
	}
}
