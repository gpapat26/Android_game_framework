package com.animals.state;


import android.graphics.Color;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;


public class LanguageState extends State {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		g.setColor(Color.rgb(255, 145, 0));
		g.fillRect(0, 0, GameMainActivity.GAME_WIDTH, GameMainActivity.GAME_HEIGHT);			
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {
		// TODO Auto-generated method stub
		return false;
	}

}
