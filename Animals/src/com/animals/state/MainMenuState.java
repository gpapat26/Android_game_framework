package com.animals.state;

import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.util.Painter;

public class MainMenuState extends State {

	
	public  MainMenuState() {
		init();
	}
	@Override
	public void init() {
		Assets.load("crab");
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {		
		g.drawImage(Assets.galleryBitmap, 0, 0);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {
		// TODO Auto-generated method stub
		return false;
	}

}
