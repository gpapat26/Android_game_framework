package com.animals.state;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.model.Cloud;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.simpleandroidgdf.R;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class BalloonLooseState extends State{
	
	private UIButton back;
	private int playerScore;
	private  int balloonsPopped;
	private int languageCode;
	private Cloud cloud , cloud2;
	private int currentState;
	private UIButton replay;
	
	private  int balloonTarget;

	public BalloonLooseState(int balloonsPopped,int balloonTarget, int currentState) {
		languageCode = GameMainActivity.getLanguageCode();
		playerScore = GameMainActivity.getHighScore();
		this.currentState = currentState;
		Log.d("BalloonLooseState", "Score retrieved is "+playerScore + "while balloons popped is"+balloonsPopped);
		
		if(playerScore < balloonsPopped){
			GameMainActivity.setHighScore(balloonsPopped);
		}
		init();
		
		this.balloonsPopped = balloonsPopped;
		this.balloonTarget = balloonTarget;
	}

	@Override
	public void init() {
		Assets.loadGalleryImage("nightMoon");
		back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);
		cloud = new Cloud(100, 100);
		cloud2 = new Cloud(500, 50);
		replay = new UIButton((GameMainActivity.GAME_WIDTH/2)-50, (GameMainActivity.GAME_HEIGHT/2)-50, (GameMainActivity.GAME_WIDTH/2)+50,  (GameMainActivity.GAME_HEIGHT/2)+50, Assets.replay, Assets.replayDown);

	}

	@Override
	public void update(float delta) {
		cloud.update(delta*0.001f);
		cloud2.update(delta*0.001f);
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);			
		//g.drawImage(Assets.balloon_blue_pop,(GameMainActivity.GAME_WIDTH/2)-130, (GameMainActivity.GAME_HEIGHT/2)-130);
		renderClouds(g);
			
		//g.setFont(Typeface.DEFAULT, 70);
		//g.setColor(Color.RED);
		//g.drawString("You Loose", 30, (GameMainActivity.GAME_HEIGHT/2)+50);	
		//g.drawString("Score : "+balloonsPopped+"", (GameMainActivity.GAME_WIDTH/2)+10, (GameMainActivity.GAME_HEIGHT/2)+50);
		//g.drawString("Score : "+balloonsPopped, (GameMainActivity.GAME_WIDTH/2 )-150, (GameMainActivity.GAME_HEIGHT/2) +50);
		g.drawRectTextAligned("Score : "+balloonsPopped, GameMainActivity.lowerHalfScreen, 70, Typeface.DEFAULT, Align.CENTER, Color.RED, true, 0);

		//g.setFont(Typeface.DEFAULT_BOLD, 100);
		//g.drawString("You Loose", (GameMainActivity.GAME_WIDTH/2)-200, (GameMainActivity.GAME_HEIGHT/2) -100);
		if(languageCode ==1){
			g.drawRectTextAligned(GameMainActivity.sGame.getContext().getString(R.string.loose), GameMainActivity.upperHalfScreen, 100, Typeface.DEFAULT_BOLD, Align.CENTER, Color.RED, true, 0);

		}
		else if(languageCode ==2){
			g.drawRectTextAligned(GameMainActivity.sGame.getContext().getString(R.string.loose_gr), GameMainActivity.upperHalfScreen, 100, Typeface.DEFAULT_BOLD, Align.CENTER, Color.RED, true, 0);

		}
		//g.drawRectTextAligned("You loose", GameMainActivity.upperHalfScreen, 100, Typeface.DEFAULT_BOLD, Align.CENTER, Color.RED, true, 0);
		//GameMainActivity.sGame.getContext().getString(R.string.loose)
		back.render(g);
		
	}
	
	private void renderClouds(Painter g) {
		cloud.render(g, Assets.cloud1);
		cloud2.render(g, Assets.cloud2);
		replay.render(g);
		
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
