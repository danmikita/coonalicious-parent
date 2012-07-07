package com.linkmongrel.games.coonalicious;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture background;
	public static TextureRegion backgroundRegion;
	public static Texture splash;
	public static TextureRegion splashRegion;

	public static Texture items;
	public static TextureAtlas myTextures;
	public static TextureRegion mainMenu;
	public static TextureRegion pauseMenu;
	public static TextureRegion ready;
	public static TextureRegion gameOver;
	public static TextureRegion highScoresRegion;
	public static TextureRegion logo;
	public static TextureRegion soundOn;
	public static TextureRegion soundOff;
	public static TextureRegion arrow;
	public static TextureRegion pause;
	public static TextureRegion spring;
	public static TextureRegion castle;
	public static Animation coinAnim;
	public static Animation bobJump;
	public static Animation bobFall;
	public static TextureRegion bobHit;
	public static Animation squirrelFly;
	public static TextureRegion platform;
	public static Animation brakingPlatform;
	public static BitmapFont font;
	public static Animation rikkiRunning;
	public static Animation rikkiEat;
	public static Animation rikkiStanding;
	public static AtlasRegion fish;

	public static Music music;
	public static Sound jumpSound;
	public static Sound highJumpSound;
	public static Sound hitSound;
	public static Sound coinSound;
	public static Sound clickSound;
	public static AtlasRegion cake;
	public static AtlasRegion burger;
	public static AtlasRegion fries;
	public static AtlasRegion icecream;
	public static AtlasRegion cookie;
	public static AtlasRegion bacon;
	public static AtlasRegion drumstick;
	public static AtlasRegion soda;
	public static AtlasRegion cheese;
	public static AtlasRegion egg;
	public static AtlasRegion chicken;
	public static AtlasRegion banana;
	public static AtlasRegion apple;
	public static AtlasRegion eggplant;
	public static AtlasRegion tomato;
	public static AtlasRegion carrot;
	public static AtlasRegion broccoli;
	public static AtlasRegion celery;
	public static AtlasRegion tofu;
	public static AtlasRegion skinniest;
	public static AtlasRegion skinnier;
	public static AtlasRegion skinny;
	public static AtlasRegion fat;
	public static AtlasRegion fatter;
	public static AtlasRegion fattest;
	public static AtlasRegion neutral;

	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load() {
		background = loadTexture("data/background.png");
		backgroundRegion = new TextureRegion(background, 0, 0, 480, 320);
		splash = loadTexture("data/splash.png");
		splashRegion = new TextureRegion(splash, 0, 0, 480, 320);

		items = loadTexture("data/items.png");
		mainMenu = new TextureRegion(items, 0, 224, 300, 110);
		pauseMenu = new TextureRegion(items, 224, 128, 192, 96);
		ready = new TextureRegion(items, 320, 224, 192, 32);
		gameOver = new TextureRegion(items, 352, 256, 160, 96);
		highScoresRegion = new TextureRegion(Assets.items, 0, 257, 300, 110 / 3);
		logo = new TextureRegion(items, 0, 352, 274, 142);
		soundOff = new TextureRegion(items, 0, 0, 64, 64);
		soundOn = new TextureRegion(items, 64, 0, 64, 64);
		arrow = new TextureRegion(items, 0, 64, 64, 64);
		pause = new TextureRegion(items, 64, 64, 64, 64);

		myTextures = new TextureAtlas("data/packed.txt");
//		rikkiStanding = new Animation(0.1f,
//				myTextures.findRegion("raccoon_standingdown_mouthclosed_eyes open"),
//				myTextures.findRegion("raccoon_standingdown_mouthclosed_eyes open"),
//				myTextures.findRegion("raccoon_standingdown_mouthclosed_eyes open"),
//				myTextures.findRegion("raccoon_standingdown_mouthclosed_eyes open"));
//		rikkiRunning = new Animation(0.1f,
//				myTextures.findRegion("raccoon_standingdown_mouthclosed_eyes open"),
//				myTextures.findRegion("raccoon_rightpawallup_mouthclosed_eyesopen"),
//				myTextures.findRegion("raccoon_standingdown_mouthclosed_eyes open"),
//				myTextures.findRegion("raccoon_leftpawallup_mouthclosed_eyesopen"));
//		rikkiEat = new Animation(0.1f,
//				myTextures.findRegion("raccoon_standing_mouthopen_eyesopen"),
//				myTextures.findRegion("raccoon_hisrightpawup_mouthopen"),
//				myTextures.findRegion("raccoon_standing_mouthopen_eyesopen"),
//				myTextures.findRegion("raccoon_leftpawallup_mouthclosed_eyesopen"));
		
		skinniest = myTextures.findRegion("skinniest_raccoon");
		skinnier = myTextures.findRegion("skinnymid_raccoon");
		skinny = myTextures.findRegion("thin_raccoon");
		neutral = myTextures.findRegion("raccoon_standingdown_mouthclosed_eyesopen");
		fat = myTextures.findRegion("chubby_raccoon");
		fatter = myTextures.findRegion("fattestmid_raccoon");
		fattest = myTextures.findRegion("fattest_raccoon");

		cake = myTextures.findRegion("cake");
		burger = myTextures.findRegion("burger");
		fries = myTextures.findRegion("frenchfries");
		icecream = myTextures.findRegion("icecream");
		cookie = myTextures.findRegion("cookie");
		bacon = myTextures.findRegion("bacon");
		drumstick = myTextures.findRegion("drumstick");
		soda = myTextures.findRegion("soda");
		cheese = myTextures.findRegion("cheese");
		egg = myTextures.findRegion("egg");
		chicken = myTextures.findRegion("chicken");
		fish = myTextures.findRegion("fish");
		banana = myTextures.findRegion("banana");
		apple = myTextures.findRegion("apple");
		eggplant = myTextures.findRegion("eggplant");
		tomato = myTextures.findRegion("tomato");
		carrot = myTextures.findRegion("carrot");
		broccoli = myTextures.findRegion("broccoli");
		celery = myTextures.findRegion("celery");
		tofu = myTextures.findRegion("tofu");

		font = new BitmapFont(Gdx.files.internal("data/font.fnt"),
				Gdx.files.internal("data/font.png"), false);

		music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
		music.setLooping(true);
		music.setVolume(0.5f);
		if (Settings.soundEnabled)
			music.play();
		jumpSound = Gdx.audio.newSound(Gdx.files.internal("data/jump.ogg"));
		highJumpSound = Gdx.audio.newSound(Gdx.files.internal("data/highjump.ogg"));
		hitSound = Gdx.audio.newSound(Gdx.files.internal("data/hit.ogg"));
		coinSound = Gdx.audio.newSound(Gdx.files.internal("data/coin.ogg"));
		clickSound = Gdx.audio.newSound(Gdx.files.internal("data/click.ogg"));
	}

	public static void playSound(Sound sound) {
		if (Settings.soundEnabled)
			sound.play(1);
	}
}
