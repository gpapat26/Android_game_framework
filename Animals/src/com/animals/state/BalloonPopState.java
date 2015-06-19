package com.animals.state;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.model.Balloon;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.RandomNumberGenerator;
import com.animals.util.UIButton;

public class BalloonPopState extends State {

	private UIButton back;

	// private Balloon balloon_black;
	// private Balloon balloon_blue;
	// private Balloon balloon_green;
	// private Balloon balloon_grey;
	// private Balloon balloon_orange;
	// private Balloon balloon_pink;
	// private Balloon balloon_red;
	// private Balloon balloon_yellow;

	// private boolean black;
	// private boolean blue;
	// private boolean green;
	// private boolean grey;
	// private boolean orange;
	// private boolean pink;
	// private boolean red;
	// private boolean yellow;

	private ArrayList<Balloon> balloons;

	private static final int BALLOON_HEIGHT = 130;
	private static final int BALLOON_WIDTH = 130;

	private int reverseCounterBalloonCreator;
	private int reversePopCounter;
	private int expectedToPop;

	private boolean gameLost = false;

	private int balloonYSpeed = 1;

	public BalloonPopState(int numberOfBalloons) {
		this.reverseCounterBalloonCreator = numberOfBalloons;
		this.reversePopCounter = numberOfBalloons;
		this.expectedToPop = numberOfBalloons;		
		
		init();
		
	}

	@Override
	public void init() {

		balloons = new ArrayList<Balloon>();

		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				gameLost = true;
			}
		}, 1 * 60 * 1000);

		// int counter = reverseCounterBalloonCreator;
		if (expectedToPop == 10) {
			Log.d("BalloonPopState", "expected 10");
			
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_black,
					Assets.balloon_black_pop, false, false));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_blue,
					Assets.balloon_blue_pop, false, false));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_green,
					Assets.balloon_green_pop, false, false));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_grey,
					Assets.balloon_grey_pop, false, false));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_orange,
					Assets.balloon_orange_pop, false, false));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_pink,
					Assets.balloon_pink_pop, false, false));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_yellow,
					Assets.balloon_yellow_pop, false, gameLost));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_red,
					Assets.balloon_red_pop, false, false));

		}
		
		else if (expectedToPop == 20){
			Log.d("BalloonPopState", "expected 20");
			for (int i = 0; i < 2; i++) {
			
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_blue,
						Assets.balloon_blue_pop, false, false));
			

			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_green,
						Assets.balloon_green_pop, false, false));
			
			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_grey,
						Assets.balloon_grey_pop, false, false));
			

			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_orange,
						Assets.balloon_orange_pop, false, false));
		

			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_pink,
						Assets.balloon_pink_pop, false, false));
			
			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_yellow,
						Assets.balloon_yellow_pop, false, false));
		

			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_red,
						Assets.balloon_red_pop, false, false));
		

			}
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_clown,
					Assets.balloon_clown_pop, true, true));
		

		
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_hippo,
					Assets.balloon_green_pop, false,true));
			
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
					GameMainActivity.GAME_WIDTH), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_girraffe,
					Assets.balloon_green_pop, false,true));
			
		}

		
		
		Assets.loadGalleryImage("farm1");
		back = new UIButton(705, 355, 795, 445, Assets.home, Assets.home_down);

	}

	@Override
	public void update(float delta) {
		updateBalloons(delta);
		if (reversePopCounter == 0) {
			
			GameMainActivity.sGame.setCurrentState(new BalloonWinState(
					expectedToPop));
			balloons.clear();
		}
		if (gameLost) {
		
			GameMainActivity.sGame.setCurrentState(new BalloonLooseState(
					expectedToPop - reversePopCounter, expectedToPop));
			balloons.clear();
		}

	}

	private void updateBalloons(float delta) {
		for (int i = 0; i < balloons.size(); i++) {
			Balloon b = balloons.get(i);
			b.update(delta, balloonYSpeed);
		}

	}

	@Override
	public void render(Painter g) {
		renderScore(g);
		g.drawImage(Assets.galleryBitmap, 0, 0);
		back.render(g);
		renderBalloons(g);
		renderScore( g);
		
	}
	
	private void renderScore(Painter g) {		
		g.setColor(Color.BLACK);
		g.setFont(Typeface.SANS_SERIF, 40);
		g.drawString("Score:"+(expectedToPop - reversePopCounter), 20, 30);	
	}
	

	private void renderBalloons(Painter g) {
		for (Balloon balloon : balloons) {
			balloon.render(g);
		}
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");

		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			for (int i = 0; i < balloons.size(); i++) {
				Balloon balloon = balloons.get(i);

				if (balloon.isVisible()) {
					if (!balloon.isPopped()) {
						if (balloon.getRect().contains(scaledX, scaledY)) {
							if (balloon.isClown()) {
								Assets.playClownPop();
								reversePopCounter =0;
							} else if(!balloon.isAnimal()){
								Assets.playBalloonPop();
								reversePopCounter--;
							}
							else{
								Assets.playBalloonPop(); // < Have to change this!!
								reversePopCounter = reversePopCounter +2;
							}
							balloon.onUserTouch();
						}
					}
				}
			}
			back.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			if (back.isPressed(scaledX, scaledY)) {
				back.cancel();			
				GameMainActivity.sGame.setCurrentState(new MainMenuState());
				balloons.clear();
				return true;
			}

		}

		return true;
	}

}
