package com.georgepapatheodorou.spacejumper.state;

import android.view.MotionEvent;

import com.georgepapatheodorou.spacejumper.simpleandroidgdf.GameMainActivity;
import com.georgepapatheodorou.spacejumper.util.Painter;

public abstract class State {

	public void setCurrentState(State newState){
		GameMainActivity.sGame.setCurrentState(newState);
	}
	
	public abstract void init();
	public abstract void update(float delta);
	public abstract void render(Painter g);
	public abstract boolean onTouch(MotionEvent e, int scaledx,int scaledY);
	
}
