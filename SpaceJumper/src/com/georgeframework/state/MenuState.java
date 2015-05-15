package com.georgeframework.state;

import android.graphics.Rect;
import android.view.MotionEvent;

import com.georgeframework.simpleandroidgdf.Assets;
import com.georgegramework.util.Painter;

public class MenuState extends State {
	
	private Rect playRect;
	private Rect scoreRect;
	
	//Declare booleans to determine whether a button is pressed down
	private boolean playDown = false;
	private boolean scoreDown = false;
	
	

	@Override
	public void init() {
		playRect = new Rect(316,227,484,286);
		scoreRect = new Rect(316,300,484,359);

	}

	@Override
	public void update(float delta) {
		

	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.welcome, 0, 0);
		
		if(playDown){
			g.drawImage(Assets.startDown, playRect.left, playRect.top);
		}else{
			g.drawImage(Assets.start, playRect.left, playRect.top);
		}
		
		
		if(scoreDown){
			g.drawImage(Assets.scoreDown, scoreRect.left, scoreRect.top);
		}else{
			g.drawImage(Assets.score, scoreRect.left, scoreRect.top);
		}					
	}
	
	

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {		
		return false;
	}

}
