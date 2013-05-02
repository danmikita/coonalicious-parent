package com.linkmongrel.games.coonalicious;

public class Food extends DynamicGameObject {
	public static final float FOOD_WIDTH = 1;
	public static final float FOOD_HEIGHT = 1;
	public static final int FOOD_STATE_NORMAL = 0;
	public static final int FOOD_STATE_MISSED = 1;
	public static final float FOOD_PULVERIZE_TIME = 0.2f * 4;
	public static final float FOOD_VELOCITY = -6;
	public static final int CAKE = 20;
	public static final int HAMBURGER = 19;
	public static final int FRIES = 18;
	public static final int ICECREAM = 17;
	public static final int COOKIE = 16;
	public static final int BACON = 15;
	public static final int DRUMSTICK = 14;
	public static final int SODA = 13;
	public static final int CHEESE = 12;
	public static final int EGG = 11;
	public static final int CHICKEN = 10;
	public static final int FISH = 9;
	public static final int BANANA = 8;
	public static final int APPLE = 7;
	public static final int EGGPLANT = 6;
	public static final int TOMATO = 5;
	public static final int CARROT = 4;
	public static final int BROCCOLI = 3;
	public static final int CELERY = 2;
	public static final int TOFU = 1;


// Hello Jeff!
// BAM!
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
