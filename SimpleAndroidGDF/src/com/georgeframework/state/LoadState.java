package com.georgeframework.state;

import android.view.MotionEvent;

import com.georgeframework.simpleandroidgdf.Assets;
import com.georgegramework.util.Painter;

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
