package com.animals.state;

import java.util.ArrayList;

import android.util.Log;
import android.view.MotionEvent;

import com.animals.model.Balloon;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.RandomNumberGenerator;
import com.animals.util.UIButton;

public class BalloonPopState extends State{
	
	private UIButton back;
	
//	private Balloon balloon_black;
//	private Balloon balloon_blue;
//	private Balloon balloon_green;
//	private Balloon balloon_grey;
//	private Balloon balloon_orange;	
//	private Balloon balloon_pink;
//	private Balloon balloon_red;
//	private Balloon balloon_yellow;
	
	
//	private boolean black;
//	private boolean blue;
//	private boolean green;
//	private boolean grey;
//	private boolean orange;
//	private boolean pink;
//	private boolean red;
//	private boolean yellow;
	
	private ArrayList<Balloon> balloons;
	
	private static final int BALLOON_HEIGHT = 130;
	private static final int BALLOON_WIDTH = 130;
	
	
	private int balloonYSpeed = 3;
	
	 public BalloonPopState() {
		init();
	}

	@Override
	public void init() {
		balloons = new ArrayList<Balloon>();
		
//		balloon_black = new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_black,Assets.balloon_black_pop);
//		balloon_blue = new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_blue,Assets.balloon_blue_pop);
//		balloon_green = new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_green,Assets.balloon_green_pop);
//		balloon_grey= new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_grey,Assets.balloon_grey_pop);
//		balloon_orange = new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_orange,Assets.balloon_orange_pop);
//		balloon_pink= new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_pink,Assets.balloon_pink_pop);
//		balloon_yellow= new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_yellow,Assets.balloon_yellow_pop);
		
		for(int i =0; i<RandomNumberGenerator.getRandIntBetween(1,3);i++){
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_black,Assets.balloon_black_pop, false))	;
		}
		
		for(int i =0; i<RandomNumberGenerator.getRandIntBetween(1,3);i++){
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_blue,Assets.balloon_blue_pop, false))	;
		}
		
		for(int i =0; i<RandomNumberGenerator.getRandIntBetween(1,3);i++){
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_green,Assets.balloon_green_pop, false))	;
		}
		
		for(int i =0; i<RandomNumberGenerator.getRandIntBetween(1,3);i++){
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_grey,Assets.balloon_grey_pop, false))	;
		}
		
		for(int i =0; i<RandomNumberGenerator.getRandIntBetween(1,3);i++){
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_orange,Assets.balloon_orange_pop, false))	;
		}
		
		for(int i =0; i<RandomNumberGenerator.getRandIntBetween(1,3);i++){
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_pink,Assets.balloon_pink_pop, false))	;
		}
		
		for(int i =0; i<RandomNumberGenerator.getRandIntBetween(1,3);i++){
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_yellow,Assets.balloon_yellow_pop, false))	;
		}
		
		for(int i =0; i<RandomNumberGenerator.getRandIntBetween(1,3);i++){
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_red,Assets.balloon_red_pop, false))	;
		}
		
		
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_clown,Assets.balloon_clown_pop, true))	;
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_hippo,Assets.balloon_green_pop, false))	;
			balloons.add(new Balloon(RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH), RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_HEIGHT), BALLOON_WIDTH, BALLOON_HEIGHT,Assets.balloon_girraffe,Assets.balloon_green_pop, false))	;

		
//		balloons.add(balloon_blue)	;
//		balloons.add(balloon_green)	;
//		balloons.add(balloon_grey)	;
//		balloons.add(balloon_orange)	;
//		balloons.add(balloon_pink)	;
//		balloons.add(balloon_yellow)	;
		Assets.loadGalleryImage("farm1");	
		back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);	
		
//		balloon_black = new UIButton(700, 400, 820, 600, Assets.balloon_black , Assets.balloon_black_pop);
//		balloon_blue = new UIButton(500, 200, 620, 400, Assets.balloon_blue , Assets.balloon_blue_pop);
//		balloon_green = new UIButton(705, 355, 795, 445, Assets.balloon_green , Assets.balloon_green_pop);
//		balloon_grey = new UIButton(705, 355, 795, 445, Assets.balloon_grey , Assets.balloon_grey_pop);
//		balloon_orange = new UIButton(705, 355, 795, 445, Assets.balloon_orange , Assets.balloon_orange_pop);
//		balloon_pink = new UIButton(705, 355, 795, 445, Assets.balloon_pink , Assets.balloon_pink_pop);
//		balloon_red = new UIButton(705, 355, 795, 445, Assets.balloon_red , Assets.balloon_red_pop);
//		balloon_yellow = new UIButton(705, 355, 795, 445, Assets.balloon_yellow , Assets.balloon_yellow_pop);
	}

	@Override
	public void update(float delta) {
		updateBalloons(delta);
		
	}

	private void updateBalloons(float delta) {
		for(int i =0; i<balloons.size();i++){
			balloons.get(i).update(delta,balloonYSpeed);		
		}
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);
		back.render(g);
	    renderBalloons(g);	
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
				for(int i =0; i<balloons.size();i++){
					Balloon balloon = balloons.get(i);
				
					if(balloon.isVisible())	{
						if (!balloon.isPopped()){
							if (balloon.getRect().contains(scaledX, scaledY)){
								if(balloon.isClown()){
									Assets.playClownPop();									
								}
								else{
									Assets.playBalloonPop();
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
					return true;
		       }

		}

		return true;
	}

}
