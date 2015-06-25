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
	
	private Timer timer; 
	
	private int animalBonus=5;

	
	private int reversePopCounter;
	private int expectedToPop;
	private boolean gameLost = false;
	private float balloonYSpeed = 1;
	
	private int targetScore ;

	private int currentScore ;
	private int state;
	private int seconds;
	private int stage=0;


	private static int WIN_SCORE = 10000;

	public BalloonPopState(int state) {
		
		this.state = state;
		
		if(this.state ==1 ){
			
			this.reversePopCounter = 20;
			this.expectedToPop = 20;
			
			this.targetScore = 20;
			this.seconds =60;
		}
		else if(this.state == 2){
			
			this.reversePopCounter = 100;
			this.expectedToPop = 100;
		
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
			
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_black,
					Assets.balloon_black_pop, false, false, 0,0));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_blue,
					Assets.balloon_blue_pop, false, false, 0,0));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_green,
					Assets.balloon_green_pop, false, false, 0,0));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_grey,
					Assets.balloon_grey_pop, false, false, 0,0));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_orange,
					Assets.balloon_orange_pop, false, false, 0,0));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_pink,
					Assets.balloon_pink_pop, false, false, 0,0));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_yellow,
					Assets.balloon_yellow_pop, false, gameLost, 0,0));

			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_red,
					Assets.balloon_red_pop, false, false, 0,0));

		}
		
		else if (state ==2){
			Log.d("BalloonPopState", "expected 20");
			for (int i = 0; i < 2; i++) {
			
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
						GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_blue,
						Assets.balloon_blue_pop, false, false, stage,null));
			

			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_green,
						Assets.balloon_green_pop, false, false, stage,null));
			
			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_grey,
						Assets.balloon_grey_pop, false, false,  stage,null));
			

			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0,
						GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_orange,
						Assets.balloon_orange_pop, false, false,  stage,null));
		

			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
						GameMainActivity.GAME_WIDTH), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_pink,
						Assets.balloon_pink_pop, false, false, stage,null));
			
			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
						GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_yellow,
						Assets.balloon_yellow_pop, false, false, stage,null));
		

			}

			for (int i = 0; i < 2; i++) {
				balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
						GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
						.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
						BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_red,
						Assets.balloon_red_pop, false, false, stage,null));	
			}
			
			
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_clown,
					Assets.balloon_clown_pop, true, true, stage,0));			
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_clown,
					Assets.balloon_clown_pop, true, true,stage,2));			
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_clown,
					Assets.balloon_clown_pop, true, true,stage,3));
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_clown,
					Assets.balloon_clown_pop, true, true,stage,4));
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_clown,
					Assets.balloon_clown_pop, true, true,stage,5));
		

		
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_hippo,
					Assets.balloon_green_pop, false,true ,stage,null));
			
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(50,
					GameMainActivity.GAME_WIDTH-50), RandomNumberGenerator
					.getRandIntBetween(GameMainActivity.GAME_HEIGHT,2*GameMainActivity.GAME_HEIGHT),
					BALLOON_WIDTH, BALLOON_HEIGHT, Assets.balloon_girraffe,
					Assets.balloon_green_pop, false,true,  stage,null));
		}

		
		
		Assets.loadGalleryImage("farm1");
		back = new UIButton(705, 355, 795, 445, Assets.home, Assets.home_down);

	}
	
	private void createOneMinuteInterval(){
		
		timer = new Timer();

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
						animalBonus = animalBonus+2;
						stage = stage+1;
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
				 timer.cancel();
		         timer.purge();
				balloons.clear();
			}
			if (gameLost) {
			
				GameMainActivity.sGame.setCurrentState(new BalloonLooseState(
						currentScore, expectedToPop));
				 timer.cancel();
		         timer.purge();
				balloons.clear();
			}			
		}
		
		if(state ==2){
			
			if (gameLost) {					
				GameMainActivity.sGame.setCurrentState(new BalloonLooseState(
						expectedToPop - reversePopCounter, expectedToPop));
				 timer.cancel();
		         timer.purge();
				balloons.clear();
			}
			if(currentScore >= WIN_SCORE ){
				GameMainActivity.sGame.setCurrentState(new  BalloonWinState(
						currentScore));
				 timer.cancel();
		         timer.purge();
				balloons.clear();
			}
			
		}		
	}

	private void updateBalloons(float delta) {
	
		for (int i = 0; i < balloons.size(); i++) {
			Balloon b = balloons.get(i);
			
			b.setStage(stage);
			
			if (b.isClown()){
				if(stage>=b.getClownNo()){
					
					b.update(delta, balloonYSpeed);
				}
				else{
					// Dont do anything , dont update
				}
			
			}
			else{
				b.update(delta, balloonYSpeed);
			}
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
		//g.drawRectTextAligned("Score:"+(currentScore)+":"+targetScore, r, textSize, typeFace, align, color);
	}
	

	private void renderBalloons(Painter g) {
		if(balloons != null)
		for (Balloon balloon : balloons) {
			if(balloon != null){
				if (balloon.isClown()){
					if(stage>=balloon.getClownNo()){
						  balloon.render(g);				
					}
					else{
						// Dont do anything , render
					}
				}
				else{
					 balloon.render(g);	
				}
				
			}
			
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
								//reversePopCounter =expectedToPop;
								reversePopCounter=reversePopCounter+20;
							} else if(!balloon.isAnimal()){
								Assets.playBalloonPop();
								
								reversePopCounter= reversePopCounter-2;
							}
							else{
								Assets.playAnimalPop(); // < Have to change this!!
								reversePopCounter = reversePopCounter -animalBonus;
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
				 timer.cancel();
		         timer.purge();
				//balloons.clear();
				return true;
			}

		}
		currentScore = expectedToPop - reversePopCounter;
		return true;
	}
	
	@Override
	public void onPause() {
		Log.d("MainMenuState", "OnPause is called");
		Assets.onPause();	
	}
	
	@Override
	public void onResume() {
		Log.d("StartState", "OnResume is called");
		Assets.onResume();		
	}

}
