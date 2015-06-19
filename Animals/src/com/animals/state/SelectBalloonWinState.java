package com.animals.state;

import android.util.Log;
import android.view.MotionEvent;

import com.animals.model.Balloon;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class SelectBalloonWinState extends State {
	
	
	private UIButton balloon1;
	private UIButton balloon2;
	private UIButton back;

	
	private static final int BALLOON_HEIGHT = 130;
	private static final int BALLOON_WIDTH = 130;
	
	public SelectBalloonWinState(){
		init();
	}
	
	@Override
	public void init() {
		Assets.loadGalleryImage("grass_sky");	
		balloon1 = new UIButton(GameMainActivity.GAME_WIDTH/2 - 100 , GameMainActivity.GAME_HEIGHT/2, GameMainActivity.GAME_WIDTH/2 - 100 +BALLOON_WIDTH , GameMainActivity.GAME_HEIGHT/2 +BALLOON_HEIGHT, Assets.balloon_blue , Assets.balloon_blue_pop);
		balloon2 = new UIButton(GameMainActivity.GAME_WIDTH/2 + 100 , GameMainActivity.GAME_HEIGHT/2, GameMainActivity.GAME_WIDTH/2 + 100 +BALLOON_WIDTH , GameMainActivity.GAME_HEIGHT/2 +BALLOON_HEIGHT, Assets.balloon_yellow , Assets.balloon_yellow_pop);
		back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);
	
		balloon1.render(g);
		balloon2.render(g);
	
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
				Assets.playBalloonPop();	
			    back.onTouchDown(scaledX, scaledY);
			    balloon1.onTouchDown(scaledX, scaledY);
			    balloon2.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			 if (back.isPressed(scaledX, scaledY)) {
		    	   back.cancel();		    		
					GameMainActivity.sGame.setCurrentState(new MainMenuState());
					return true;
		       }
			 if (balloon1.isPressed(scaledX, scaledY)) {
				 balloon1.cancel();			 
					GameMainActivity.sGame.setCurrentState(new BalloonPopState(10));
					return true;
		       }
			 
			 if (balloon2.isPressed(scaledX, scaledY)) {
				 balloon2.cancel();		    		
					GameMainActivity.sGame.setCurrentState(new BalloonPopState(20));
					return true;
		       }

		}

		return true;
	}

}
