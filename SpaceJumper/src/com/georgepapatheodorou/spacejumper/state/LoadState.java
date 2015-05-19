package com.georgepapatheodorou.spacejumper.state;

import android.view.MotionEvent;

import com.georgepapatheodorou.spacejumper.simpleandroidgdf.Assets;
import com.georgepapatheodorou.spacejumper.util.Painter;

public class LoadState extends State {

	@Override
	public void init() {
		Assets.load();

	}

	@Override
	public void update(float delta) {
		setCurrentState(new MenuState());

	}

	@Override
	public void render(Painter g) {	
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {		
		return false;
	}

}
