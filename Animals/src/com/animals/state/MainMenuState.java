package com.animals.state;

import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class MainMenuState extends State {

	
	private UIButton carouzelButton;
	private UIButton back;

	public  MainMenuState() {
		init();
	}
	@Override
	public void init() {
		//Assets.galleryBitmap = null;	
		Assets.onPause();
		carouzelButton = new UIButton(316, 227, 484, 286, Assets.carouzel_up, Assets.carouzel_down);
		back = new UIButton(605, 355, 695, 445, Assets.back , Assets.back_down);
		Assets.loadGalleryImage("crab");
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {
		if(Assets.galleryBitmap!= null){
			g.drawImage(Assets.galleryBitmap, 0, 0);
			carouzelButton.render(g);
			back.render(g);
		}
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			carouzelButton.onTouchDown(scaledX, scaledY);
			back.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			 if (back.isPressed(scaledX, scaledY)) {
		    	   back.cancel();
		    		Assets.loadGalleryImage("crab");
					GameMainActivity.sGame.setCurrentState(new StartState());
					return true;
		       }
			if (carouzelButton.isPressed(scaledX, scaledY)) {
				
				carouzelButton.cancel();					
				setCurrentState(new CarouzelState());
				
			} else {
				carouzelButton.cancel();
			}
		}

		return true;
	}


	@Override
	public void onPause() {
		Log.d("MainMenuState", "OnPause is called");
		Assets.onPause();	
	}

}
