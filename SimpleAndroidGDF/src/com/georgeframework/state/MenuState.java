package com.georgeframework.state;

import android.view.MotionEvent;

import com.georgeframework.simpleandroidgdf.Assets;
import com.georgegramework.util.Painter;

public class MenuState extends State {

	@Override
	public void init() {
		

	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.welcome, 0, 0);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {		
		return false;
	}

}
