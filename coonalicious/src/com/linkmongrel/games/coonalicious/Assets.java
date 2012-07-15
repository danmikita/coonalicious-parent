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
	public static TextureRegion pause;
	public static BitmapFont font;
	public static Animation rikkiRunning;
	public static Animation rikkiEat;
	public static Animation rikkiStanding;

	public static Music music;
	public static Sound jumpSound;
	public static Sound highJumpSound;
	public static Sound hitSound;
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
	public static AtlasRegion fish;
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
	
	public static AtlasRegion soundOff;
	public static AtlasRegion soundOn;
	public static AtlasRegion play;
	public static AtlasRegion quit;
	public static AtlasRegion resume;
	public static AtlasRegion ready;
	public static AtlasRegion scoreloop;

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
		
		soundOff = myTextures.findRegion("sound_off");
		soundOn = myTextures.findRegion("sound_on");
		quit = myTextures.findRegion("quit");
		resume = myTextures.findRegion("resume");
		ready = myTextures.findRegion("ready");
		play = myTextures.findRegion("play");
		scoreloop = myTextures.findRegion("SL_badge");
		
		skinniest = myTextures.findRegion("skinniest_rikki_neutral_open");
		skinnier = myTextures.findRegion("skinnier_rikki_neutral_open");
		skinny = myTextures.findRegion("skinny_rikki_neutral_open");
		neutral = myTextures.findRegion("rikki_neutral_open");
		fat = myTextures.findRegion("fat_rikki_neutral_closed");
		fatter = myTextures.findRegion("fatter_rikki_neutral_closed");
		fattest = myTextures.findRegion("fattest_rikki_neutral_closed");

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
		clickSound = Gdx.audio.newSound(Gdx.files.internal("data/click.ogg"));
	}

	public static void playSound(Sound sound) {
		if (Settings.soundEnabled)
			sound.play(1);
	}
}
