package com.linkmongrel.games.coonalicious;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class World {
	public interface WorldListener {
		public void eat();

		public void highJump();

		public void hit();

		public void coin();
	}

	public static final float WORLD_WIDTH = 15;
	public static final float WORLD_HEIGHT = 10;
	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_NEXT_LEVEL = 1;
	public static final int WORLD_STATE_GAME_OVER = 2;
	public static final Vector2 gravity = new Vector2(0, -12);

	public final Rikki rikki;
	public final List<Food> food;
	public final List<Clouds> clouds;
	public final WorldListener listener;
	public final Random rand;
	public float timer = 0;
	public float halfASecond = 0;

	public int score;
	public int clock;
	public int state;
	public boolean drop = true;

	public World(WorldListener listener) {
		this.rikki = new Rikki(7, 1);
		this.food = new ArrayList<Food>();
		this.clouds = new ArrayList<Clouds>();
		this.listener = listener;
		rand = new Random();

		this.score = 0;
		this.state = WORLD_STATE_RUNNING;
	}

	public void update(float deltaTime, float accelX) {
		timer += deltaTime;
		halfASecond += deltaTime;
		if (halfASecond > 0.5f) {
			drop = true;
			halfASecond = 0;
		}
		clock = (int) timer;
		updateRikki(deltaTime, accelX);
		addNewFood(deltaTime);
		updateFood(deltaTime);
		checkCollisions();
		checkGameOver();
	}

	private void addNewFood(float deltaTime) {
		int health = rand.nextInt(100);
		int item = rand.nextInt(10000);
		float x = rand.nextFloat() * (WORLD_WIDTH - Food.FOOD_WIDTH)
				+ Food.FOOD_WIDTH / 2;
		if (drop) {
			Food food = new Food(Food.FISH, x, WORLD_HEIGHT);
			// Unhealthy Food
			if (health >= 50) {
				if (item > 9700)
					food = new Food(Food.CAKE, x, WORLD_HEIGHT);
				else if (item > 9400)
					food = new Food(Food.HAMBURGER, x, WORLD_HEIGHT);
				else if (item > 8700)
					food = new Food(Food.FRIES, x, WORLD_HEIGHT);
				else if (item > 7800)
					food = new Food(Food.ICECREAM, x, WORLD_HEIGHT);
				else if (item > 6700)
					food = new Food(Food.COOKIE, x, WORLD_HEIGHT);
				else if (item > 5400)
					food = new Food(Food.BACON, x, WORLD_HEIGHT);
				else if (item > 3900)
					food = new Food(Food.DRUMSTICK, x, WORLD_HEIGHT);
				else if (item > 2200)
					food = new Food(Food.SODA, x, WORLD_HEIGHT);
				else if (item > 1600)
					food = new Food(Food.CHEESE, x, WORLD_HEIGHT);
				else if (item > 1000)
					food = new Food(Food.EGG, x, WORLD_HEIGHT);
			}

			// Healthy Food
			if (health <= 49) {
				if (item > 9700)
					food = new Food(Food.TOFU, x, WORLD_HEIGHT);
				else if (item > 9400)
					food = new Food(Food.CELERY, x, WORLD_HEIGHT);
				else if (item > 8700)
					food = new Food(Food.BROCCOLI, x, WORLD_HEIGHT);
				else if (item > 7800)
					food = new Food(Food.CARROT, x, WORLD_HEIGHT);
				else if (item > 6700)
					food = new Food(Food.TOMATO, x, WORLD_HEIGHT);
				else if (item > 5400)
					food = new Food(Food.EGGPLANT, x, WORLD_HEIGHT);
				else if (item > 3900)
					food = new Food(Food.APPLE, x, WORLD_HEIGHT);
				else if (item > 2200)
					food = new Food(Food.BANANA, x, WORLD_HEIGHT);
				else if (item > 1600)
					food = new Food(Food.FISH, x, WORLD_HEIGHT);
				else if (item > 1000)
					food = new Food(Food.CHICKEN, x, WORLD_HEIGHT);
			}

			this.food.add(food);
			drop = false;
		}
	}

	private void updateRikki(float deltaTime, float accelX) {
		if(score <= -75) {
			rikki.fatness = Rikki.SKINNIEST;
		} else if(score <= -50) {
			rikki.fatness = Rikki.SKINNIER;
		} else if(score <= -25) {
			rikki.fatness = Rikki.SKINNY;
		} else if(score >= 75) {
			rikki.fatness = Rikki.FATTEST;
		} else if(score >= 50) {
			rikki.fatness = Rikki.FATTER;
		} else if(score >= 25) {
			rikki.fatness = Rikki.FAT;
		} else {
			rikki.fatness = Rikki.NEUTRAL;
		}
		
		rikki.velocity.x = -accelX / 10 * Rikki.RIKKI_MOVE_VELOCITY;
		rikki.update(deltaTime);
	}

	private void updateFood(float deltaTime) {
		int len = food.size();
		for (int i = 0; i < len; i++) {
			Food food = this.food.get(i);
			food.update(deltaTime);
			if (food.state == Food.FOOD_STATE_MISSED) {
				this.food.remove(food);
				len = this.food.size();
			}
		}
	}

	// private void updateClouds (float deltaTime) {
	// int len = clouds.size();
	// for (int i = 0; i < len; i++) {
	// Clouds squirrel = clouds.get(i);
	// squirrel.update(deltaTime);
	// }
	// }

	private void checkCollisions() {
		checkFoodCollisions();
	}

	private void checkFoodCollisions() {
		int len = this.food.size();
		for (int i = 0; i < len; i++) {
			Food food = this.food.get(i);
			if (rikki.position.y > food.position.y) {
				if (OverlapTester.overlapRectangles(rikki.bounds, food.bounds)) {
//					rikki.eat();
					listener.eat();
					food.eat();
					score += food.type;
					break;
				}
			}
		}
	}

	private void checkGameOver() {
		if (score >= 100 || score <= -100) {
			state = WORLD_STATE_GAME_OVER;
		}
	}
}
