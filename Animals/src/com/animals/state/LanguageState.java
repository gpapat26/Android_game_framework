package com.animals.state;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.UIButton;


public class LanguageState extends State {
	
	private static UIButton greek_button;
	
	
	private static UIButton english_button;
	
	
	public  LanguageState() {
		init();
	}

	@Override
	public void init() {
		//Assets.onPause();
		greek_button = new UIButton((int)GameMainActivity.GAME_WIDTH/2  - 100 - 50, (int)GameMainActivity.GAME_HEIGHT/2-50, (int)GameMainActivity.GAME_WIDTH/2  - 100 + 100 -50, (int)GameMainActivity.GAME_HEIGHT/2 + -50+ 100, Assets.greek, Assets.greek_down);
		english_button = new UIButton((int)GameMainActivity.GAME_WIDTH/2  + 100 -50 , (int)GameMainActivity.GAME_HEIGHT/2-50, (int)GameMainActivity.GAME_WIDTH/2  + 100 + 100-50, (int)GameMainActivity.GAME_HEIGHT/2 + - 50+ 100, Assets.english, Assets.english_down);		
	    Assets.loadGalleryImage("cartoon-rural-scene-farm-animals-24447502_2");
	
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		//g.setColor(Color.rgb(255, 145, 0));
		//g.fillRect(0, 0, GameMainActivity.GAME_WIDTH, GameMainActivity.GAME_HEIGHT);
		g.drawImage(Assets.galleryBitmap, 0, 0);
		greek_button.render(g);
		english_button.render(g);
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			greek_button.onTouchDown(scaledX, scaledY);
			english_button.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			if (greek_button.isPressed(scaledX, scaledY)) {
				
				greek_button.cancel();
				GameMainActivity.setLanguageCode(GameMainActivity.GREEK_CODE);
				setCurrentState(new StartState());
				
			} else {
				greek_button.cancel();
			}
			
			if (english_button.isPressed(scaledX, scaledY)) {
				
				english_button.cancel();
				GameMainActivity.setLanguageCode(GameMainActivity.ENGLISH_CODE);
				setCurrentState(new StartState());
				
			} else {
				english_button.cancel();
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
