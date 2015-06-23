package com.animals.state;

import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;


public class Score extends State {
	
	private String highScore;

	public Score(){		
		init();
	}
	
	public void init() {
		highScore = GameMainActivity.getHighScore()+" ";

	}

	@Override
	public void update(float delta) {	

	}

	@Override
	public void render(Painter g) {
		g.setColor(Color.rgb(53, 165, 253));
		g.fillRect(0, 0, GameMainActivity.GAME_WIDTH, GameMainActivity.GAME_HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(Typeface.DEFAULT_BOLD, 50);
		g.drawString("The All-Time High Score", 120, 175);
		
		g.setFont(Typeface.DEFAULT_BOLD, 70);
		if(highScore!=null){
			g.drawString(highScore, 370, 260);
		}
		else{
			g.drawString("No high Score submitted!", 370, 260);
		}		
		
		g.setFont(Typeface.DEFAULT_BOLD, 50);
		
		g.drawString("Touch the Screen", 220, 350);

	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {
		if(e.getAction() == MotionEvent.ACTION_UP){
			setCurrentState(new StartState());
		}
		return true;
	}
	
	@Override
	public void onPause() {
		Log.d("MainMenuState", "OnPause is called");
		Assets.onPause();	
	}
	
	@Override
	public void onResume() {
		Log.d("StartState", "OnResume is called");
		Assets.onResume();		
	}

}
