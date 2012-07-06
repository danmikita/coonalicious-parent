package com.linkmongrel.games.coonalicious;

public class Food extends DynamicGameObject {
	public static final float FOOD_WIDTH = 1;
	public static final float FOOD_HEIGHT = 1;
	public static final int FOOD_STATE_NORMAL = 0;
	public static final int FOOD_STATE_MISSED = 1;
	public static final float FOOD_PULVERIZE_TIME = 0.2f * 4;
	public static final float FOOD_VELOCITY = -6;
	public static final int CAKE = 10;
	public static final int HAMBURGER = 9;
	public static final int FRIES = 8;
	public static final int ICECREAM = 7;
	public static final int COOKIE = 6;
	public static final int BACON = 5;
	public static final int DRUMSTICK = 4;
	public static final int SODA = 3;
	public static final int CHEESE = 2;
	public static final int EGG = 1;
	public static final int CHICKEN = -1;
	public static final int FISH = -2;
	public static final int BANANA = -3;
	public static final int APPLE = -4;
	public static final int EGGPLANT = -5;
	public static final int TOMATO = -6;
	public static final int CARROT = -7;
	public static final int BROCCOLI = -8;
	public static final int CELERY = -9;
	public static final int TOFU = -10;

	int type;
	int state;
	float stateTime;
	private boolean bounce = false;
	private int bounceCount = 0;

	public Food(int type, float x, float y) {
		super(x, y, FOOD_WIDTH, FOOD_HEIGHT);
		this.type = type;
		this.state = FOOD_STATE_NORMAL;
		this.stateTime = 0;
		velocity.y = FOOD_VELOCITY;
	}

	public void update(float deltaTime) {
		if (!bounce) {
			if (position.y <= 0.5f) {
				bounce = true;
				bounce(deltaTime);
			} else {
				position.add(0, velocity.y * deltaTime);
				bounds.x = position.x - FOOD_WIDTH / 2;
				bounds.y = position.y - FOOD_HEIGHT / 2;
			}
		} else {
			bounce(deltaTime);
			bounceCount++;
		}
		stateTime += deltaTime;
	}

	private void bounce(float deltaTime) {
		if (bounceCount < 40)
			position.add(0, (-velocity.y - (bounceCount/4)) * deltaTime);
		else {
			if (position.y <= 0.5f)
				eat();
			else
				position.add(0, velocity.y * deltaTime);
		}
	}

	public void eat() {
		state = FOOD_STATE_MISSED;
		stateTime = 0;
		velocity.y = 0;
	}
}
