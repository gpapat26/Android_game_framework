package com.animals.state;

import android.view.MotionEvent;

import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;


public abstract class State {

	public void setCurrentState(State newState){
		GameMainActivity.sGame.setCurrentState(newState);
	}
	
	public abstract void init();
	public abstract void update(float delta);
	public abstract void render(Painter g);
	public abstract boolean onTouch(MotionEvent e, int scaledx,int scaledY);
	
	public void onResume(){};
	public void onPause(){};
	
}
