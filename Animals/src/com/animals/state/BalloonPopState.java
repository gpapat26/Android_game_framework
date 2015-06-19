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

	private long startTime;
	
	private ArrayList<Balloon> balloons;

	private static final int BALLOON_HEIGHT = 130;
	private static final int BALLOON_WIDTH = 130;

	
	private int reversePopCounter;
	private int expectedToPop;
	private boolean gameLost = false;
	private float balloonYSpeed = 1;
	
	private int targetScore ;

	private int currentScore ;
	private int state;
	private int seconds;

	private static int WIN_SCORE = 10000;

	public BalloonPopState(int state) {
		
		if(state ==1 ){
			
			this.reversePopCounter = 20;
			this.expectedToPop = 20;
			this.state = state;
			this.targetScore = 20;
			this.seconds =60;
		}
		else if(state == 2){
			
			this.reversePopCounter = 100;
			this.expectedToPop = 100;
			this.state = state;
			this.targetScore = 100;
			this.seconds =30;
		}			
		init();		
	}
	

	@Override
	public void init() {
		
		createOneMinuteInterval();
		
		recalculateStartTime();
		
		balloons = new ArrayList<Balloon>();

		if (state ==1) {
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
		
		else if (state ==2){
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
	
	private void createOneMinuteInterval(){
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Log.d("BalloonPopState", "timer");
				
				if(state == 1 ){
					
					if(currentScore<targetScore){
						gameLost = true;
					}
					else{
						gameLost = false;
					}
				}
				
				else if(state ==2){
					if(currentScore<targetScore){
						gameLost = true;
					}
					else{
						Log.d("BalloonPopState", "didnt loose!!");
						gameLost = false;
						targetScore= targetScore+100;
						balloonYSpeed = balloonYSpeed+0.5f;
						recalculateStartTime();
						createOneMinuteInterval();
					}
				}
				
			}
		}, 1 * seconds * 1000);
		
	}
	
	public int calculateSecondsPassed(long tStart){
					
		long tEnd = System.currentTimeMillis();		
		
		long tDelta = tEnd - tStart;
		
		double elapsedSeconds = tDelta / 1000.0;
		
		return (int)elapsedSeconds;
	}
	
	public void recalculateStartTime(){	
		startTime = System.currentTimeMillis();			
	}

	@Override
	public void update(float delta) {
		updateBalloons(delta);
		
		if(state ==1){
			if (reversePopCounter == 0) {
				
				GameMainActivity.sGame.setCurrentState(new BalloonWinState(expectedToPop));
				balloons.clear();
			}
			if (gameLost) {
			
				GameMainActivity.sGame.setCurrentState(new BalloonLooseState(
						currentScore, expectedToPop));
				balloons.clear();
			}			
		}
		
		if(state ==2){
			
			if (gameLost) {					
				GameMainActivity.sGame.setCurrentState(new BalloonLooseState(
						expectedToPop - reversePopCounter, expectedToPop));
				balloons.clear();
			}
			if(currentScore >= WIN_SCORE ){
				GameMainActivity.sGame.setCurrentState(new  BalloonWinState(
						currentScore));
				balloons.clear();
			}
			
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
		renderTime(g);				
	}
	



	private void renderTime(Painter g) {
		 calculateSecondsPassed(startTime);
		 g.setColor(Color.BLACK);
		 g.setFont(Typeface.SANS_SERIF, 40);
		 g.drawString(calculateSecondsPassed(startTime)+"", GameMainActivity.GAME_WIDTH-60, 30);			
	}

	private void renderScore(Painter g) {		
		g.setColor(Color.BLACK);
		g.setFont(Typeface.SANS_SERIF, 40);
		g.drawString("Score:"+(currentScore)+":"+targetScore, 20, 30);	
	}
	

	private void renderBalloons(Painter g) {
		if(balloons != null)
		for (Balloon balloon : balloons) {
			if(balloon != null)
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
								reversePopCounter =expectedToPop;
							} else if(!balloon.isAnimal()){
								Assets.playBalloonPop();
								reversePopCounter--;
							}
							else{
								Assets.playBalloonPop(); // < Have to change this!!
								reversePopCounter = reversePopCounter -5;
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
				//balloons.clear();
				return true;
			}

		}
		currentScore = expectedToPop - reversePopCounter;
		return true;
	}

}
