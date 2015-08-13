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
	private UIButton purhaceButton;
	private UIButton specialThanksButton;

	public  MainMenuState() {
		init();
	}
	@Override
	public void init() {
	
		carouzelButton = new UIButton(250, 200, 350, 300, Assets.carouzel_up1, Assets.carouzel_down1);
				
		balloon = new UIButton(450, 200, 550, 300, Assets.balloons_button , Assets.balloons_button_down);
		
		back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);	
		
		purhaceButton = new UIButton(5, 355, 105, 445, Assets.buyItemUp, Assets.buyItemDown);
		
		specialThanksButton = new UIButton((GameMainActivity.GAME_WIDTH/2)-150, 350, (GameMainActivity.GAME_WIDTH/2), 445, Assets.special_thanks_up, Assets.special_thanks_down);
		
		Assets.loadGalleryImage("farm1");
		Assets.onResume();	
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
			purhaceButton.render(g);
			specialThanksButton.render(g);
		}
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			carouzelButton.onTouchDown(scaledX, scaledY);
			back.onTouchDown(scaledX, scaledY);
			balloon.onTouchDown(scaledX, scaledY);
			purhaceButton.onTouchDown(scaledX, scaledY);
			specialThanksButton.onTouchDown(scaledX, scaledY);
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
			
			if (purhaceButton.isPressed(scaledX, scaledY)) {			
				purhaceButton.cancel();					
				setCurrentState(new PurchaseState());	
				return true;
			}
			else{
				purhaceButton.cancel();
			}
							
			if (specialThanksButton.isPressed(scaledX, scaledY)) {
				specialThanksButton.cancel();
		    		//Assets.loadGalleryImage("crab");
					GameMainActivity.sGame.setCurrentState(new SpecialThanksState());
					return true;
		       }
			else{
				specialThanksButton.cancel();
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
