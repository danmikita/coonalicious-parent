package com.linkmongrel.games.coonalicious;

public class Rikki extends DynamicGameObject {
	public static final int RIKKI_STATE_RUNNING = 1;
	public static final int RIKKI_STATE_EAT = 2;
	public static final float RIKKI_MOVE_VELOCITY = 20;
	public static final float RIKKI_WIDTH = 2;
	public static final float RIKKI_HEIGHT = 2;
	public static final int RIKKI_STATE_STANDING = 0;

	int state;
	float stateTime;

	public Rikki(float x, float y) {
		super(x, y, RIKKI_WIDTH, RIKKI_HEIGHT);
		stateTime = 0;
	}

	public void update(float deltaTime) {
		velocity.add(World.gravity.x * deltaTime, 0);
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.x = position.x - bounds.width / 2;
		bounds.y = position.y - bounds.height / 2;

		if (position.x < 0)
			position.x = World.WORLD_WIDTH;
		if (position.x > World.WORLD_WIDTH)
			position.x = 0;

		stateTime += deltaTime;
	}

	public void eat() {
		state = RIKKI_STATE_EAT;
		stateTime = 0;
	}

	public void run() {
		state = RIKKI_STATE_RUNNING;
		stateTime = 0;
	}

}
