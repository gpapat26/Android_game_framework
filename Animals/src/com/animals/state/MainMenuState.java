package com.animals.state;

import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class MainMenuState extends State {

	
	private UIButton carouzel;

	public  MainMenuState() {
		init();
	}
	@Override
	public void init() {
		Assets.loadGalleryImage("crab");
		carouzel = new UIButton(316, 227, 484, 286, Assets.carouzel_up, Assets.carouzel_down);		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {		
		g.drawImage(Assets.galleryBitmap, 0, 0);
		carouzel.render(g);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			carouzel.onTouchDown(scaledX, scaledY);
		
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			if (carouzel.isPressed(scaledX, scaledY)) {
				
				carouzel.cancel();				
				setCurrentState(new CarouzelState());
				
			} else {
				carouzel.cancel();
			}
		}

		return true;
	}

}
