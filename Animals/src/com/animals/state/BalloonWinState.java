package com.animals.state;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.model.Balloon;
import com.animals.model.Cloud;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.simpleandroidgdf.R;
import com.animals.util.Painter;
import com.animals.util.UIButton;


public class BalloonWinState extends State{
	
	public  int targetCovered;
//	private String playerScore;
	private UIButton back;
	private int languageCode;
	private Cloud cloud , cloud2;
	private UIButton replay;
	private int currentState;

	public BalloonWinState(int targetCovered,int currentState) {
		languageCode = GameMainActivity.getLanguageCode();
		this.targetCovered = targetCovered;
		this.currentState = currentState;
		//this.playerScore = targetCovered+"";
		
		if(targetCovered> GameMainActivity.getHighScore()){
			GameMainActivity.setHighScore(targetCovered);
		}
		init();
	}

	@Override
	public void init() {
		Assets.loadGalleryImage("grass_sky");
		back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);
		cloud = new Cloud(100, 100);
		cloud2 = new Cloud(500, 50);
		replay = new UIButton((GameMainActivity.GAME_WIDTH/2)-50, (GameMainActivity.GAME_HEIGHT/2)-50, (GameMainActivity.GAME_WIDTH/2)+50,  (GameMainActivity.GAME_HEIGHT/2)+50, Assets.replay, Assets.replayDown);
		streamMusic("audience_clapping_whistling_and_cheering");	
	}

	private void streamMusic(String fileName) {
		Assets.playMusic2(fileName+".mp3",false);
		
	}

	@Override
	public void update(float delta) {
		cloud.update(delta*0.01f);
		cloud2.update(delta*0.01f);
		
		
	}

	@Override
	public void render(Painter g) {
		
		g.drawImage(Assets.galleryBitmap, 0, 0);
		renderSun(g);
		//g.drawImage(Assets.balloon_blue_pop,GameMainActivity.GAME_WIDTH/2-130, GameMainActivity.GAME_HEIGHT/2-130);
		
			
		//g.setFont(Typeface.DEFAULT, 70);
		//g.setColor(Color.GREEN);
		//g.drawString("Score : "+targetCovered, (GameMainActivity.GAME_WIDTH/2 )-150, (GameMainActivity.GAME_HEIGHT/2) +50);
		g.drawRectTextAligned("Score : "+targetCovered, GameMainActivity.lowerHalfScreen, 70, Typeface.DEFAULT, Align.CENTER, Color.GREEN, true, 0);
		//g.setFont(Typeface.DEFAULT_BOLD, 100);
		//g.setColor(Color.GREEN);
		//g.drawString("You Win", (GameMainActivity.GAME_WIDTH/2)-200, (GameMainActivity.GAME_HEIGHT/2) -100);
		g.drawRectTextAligned("You Win", GameMainActivity.upperHalfScreen, 100, Typeface.DEFAULT_BOLD, Align.CENTER, Color.GREEN, true, 0);

		if(languageCode ==1){
			g.drawRectTextAligned(GameMainActivity.sGame.getContext().getString(R.string.win), GameMainActivity.upperHalfScreen, 100, Typeface.DEFAULT_BOLD, Align.CENTER, Color.GREEN, true, 0);

		}
		else if(languageCode ==2){
			g.drawRectTextAligned(GameMainActivity.sGame.getContext().getString(R.string.win_gr), GameMainActivity.upperHalfScreen, 100, Typeface.DEFAULT_BOLD, Align.CENTER, Color.GREEN, true, 0);

		}
		renderClouds(g);
		back.render(g);
		replay.render(g);
		
		
	}
	
	private void renderSun(Painter g) {
		g.setColor(Color.rgb(255, 165, 0));
		g.fillOval(715, -85, 170, 170);
		g.setColor(Color.YELLOW);
		g.fillOval(725, -75, 150, 150);
		
	}
	
	private void renderClouds(Painter g) {
		cloud.render(g, Assets.cloud1);
		cloud2.render(g, Assets.cloud2);
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {						
			back.onTouchDown(scaledX, scaledY);
			replay.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			 if (back.isPressed(scaledX, scaledY)) {
		    	   back.cancel();		    		
					GameMainActivity.sGame.setCurrentState(new MainMenuState());
					return true;
		       }
			 if (replay.isPressed(scaledX, scaledY)) {
				 replay.cancel();		    		
					GameMainActivity.sGame.setCurrentState(new BalloonPopState(currentState));
					return true;
		       }
			 
			 

		}


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
