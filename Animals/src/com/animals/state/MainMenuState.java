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
	private UIButton balloon;

	public  MainMenuState() {
		init();
	}
	@Override
	public void init() {
		//Assets.galleryBitmap = null;	
		//Assets.onPause();
		//carouzelButton = new UIButton(316, 227, 484, 286, Assets.carouzel_up1, Assets.carouzel_down1);
		carouzelButton = new UIButton(250, 200, 350, 300, Assets.carouzel_up1, Assets.carouzel_down1);
		//back = new UIButton(705, 355, 795, 445, Assets.back , Assets.back_down);	
		//back = new UIButton(450, 200, 550, 300, Assets.home , Assets.home_down);		
		
		balloon = new UIButton(450, 200, 550, 300, Assets.balloons_button , Assets.balloons_button_down);
		
		back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);	
		Assets.loadGalleryImage("farm1");
		
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
			balloon.render(g);
		}
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			carouzelButton.onTouchDown(scaledX, scaledY);
			back.onTouchDown(scaledX, scaledY);
			balloon.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			
			if (back.isPressed(scaledX, scaledY)) {
		    	   back.cancel();
		    		//Assets.loadGalleryImage("crab");
					GameMainActivity.sGame.setCurrentState(new StartState());
					return true;
		       }
			else{
				back.cancel();
			}
			if (carouzelButton.isPressed(scaledX, scaledY)) {
			
				carouzelButton.cancel();					
				setCurrentState(new CarouzelState());
				return true;
			}else{
				carouzelButton.cancel();
			}
			
		
			if (balloon.isPressed(scaledX, scaledY)) {			
				balloon.cancel();					
				setCurrentState(new SelectBalloonWinState());	
				return true;
			}
			else{
				balloon.cancel();
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
