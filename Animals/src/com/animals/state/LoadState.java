package com.animals.state;

import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.util.Painter;

public class LoadState extends State {

	
	public  LoadState() {
		init();
	}
	
	@Override
	public void init() {
		Assets.load();
		Assets.loadGalleryImage("welcome_screen");
	}

	@Override
	public void update(float delta) {
		setCurrentState(new StartState());

	}

	@Override
	public void render(Painter g) {	
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {		
		return false;
	}

}
