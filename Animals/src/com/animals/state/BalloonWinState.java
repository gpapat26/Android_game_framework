package com.animals.state;

import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.model.Balloon;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class BalloonWinState extends State{
	
	public  int targetCovered;
//	private String playerScore;
	private UIButton back;

	public BalloonWinState(int targetCovered) {
		
		this.targetCovered = targetCovered;
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
		
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);			
		g.drawImage(Assets.balloon_blue_pop,GameMainActivity.GAME_WIDTH/2-130, GameMainActivity.GAME_HEIGHT/2-130);
		
			
		g.setFont(Typeface.DEFAULT, 70);
		g.setColor(Color.GREEN);
		
		g.drawString("Score : "+targetCovered, (GameMainActivity.GAME_WIDTH/2 )-150, (GameMainActivity.GAME_HEIGHT/2) +50);
		g.setFont(Typeface.DEFAULT_BOLD, 100);
		g.setColor(Color.GREEN);
		g.drawString("You Win", (GameMainActivity.GAME_WIDTH/2)-200, (GameMainActivity.GAME_HEIGHT/2) -100);	
		back.render(g);
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {						
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
