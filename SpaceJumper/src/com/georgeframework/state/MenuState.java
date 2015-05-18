package com.georgeframework.state;

import android.graphics.Rect;
import android.media.session.PlaybackState;
import android.util.Log;
import android.view.MotionEvent;

import com.georgeframework.simpleandroidgdf.Assets;
import com.georgegramework.util.Painter;
import com.georgegramework.util.UIButton;

public class MenuState extends State {
	
	private Rect playRect;
	private Rect scoreRect;
	
	//Declare booleans to determine whether a button is pressed down
	private boolean playDown = false;
	private boolean scoreDown = false;
	
	private UIButton playButton , scoreButton;

	@Override
	public void init() {
		//playRect = new Rect(316,227,484,286);
		//scoreRect = new Rect(316,300,484,359);
		playButton = new UIButton(316, 227, 484, 286, Assets.start, Assets.startDown);
		scoreButton = new UIButton(316,300,484,359,Assets.score,Assets.scoreDown);

	}

	@Override
	public void update(float delta) {
		

	}

	@Override
	public void render(Painter g) {
//		g.drawImage(Assets.welcome, 0, 0);
//		
//		if(playDown){
//			g.drawImage(Assets.startDown, playRect.left, playRect.top);
//		}else{
//			g.drawImage(Assets.start, playRect.left, playRect.top);
//		}
//		
//		
//		if(scoreDown){
//			g.drawImage(Assets.scoreDown, scoreRect.left, scoreRect.top);
//		}else{
//			g.drawImage(Assets.score, scoreRect.left, scoreRect.top);
//		}	
		
		g.drawImage(Assets.welcome, 0, 0);
		playButton.render(g);
		scoreButton.render(g);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {
		
		Log.d("Menu state", "something is presesed!");
		
		if(e.getAction() == MotionEvent.ACTION_DOWN){
			
			Log.d("Menu state", "ACTION DOWN is presesed!");
			playButton.onTouchDown(scaledx, scaledY);
			scoreButton.onTouchDown(scaledx, scaledY);
		}
		
		if(e.getAction() == MotionEvent.ACTION_UP){
			Log.d("Menu state", "ACTION UP is presesed!");
			
			if(playButton.isPressed(scaledx, scaledY)){
				//playButton.cancel();
				Log.d("Menu state", "play button is presesed!");
				setCurrentState(new PlayState());
			}else 
				if(scoreButton.isPressed(scaledx, scaledY)){
					scoreButton.cancel();
					Log.d("Menu state", "score button is presesed!");
				}
				else{
					playButton.cancel();
					scoreButton.cancel();
				}
		}
		return true;
	}
	
	

//	@Override
//	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {	
//		Log.d("MenuState","Some thing is pressed!");
//		
//		if(e.getAction() == MotionEvent.ACTION_DOWN){
//			Log.d("MenuState","ACTION DOWN");
//			if(playRect.contains(scaledx,scaledY)){
//				Log.d("MenuState","ACTION DOWN play Rectangle");
//				playDown = true;
//				scoreDown = false;
//			}else if(scoreRect.contains(scaledx,scaledY)){
//				Log.d("MenuState","ACTION DOWN score Rectangle");
//				scoreDown = true;
//				playDown = false;
//			}
//			
//		}
//		if(e.getAction() == MotionEvent.ACTION_UP){
//			Log.d("MenuState","ACTION UP");
//			if(playDown && playRect.contains(scaledx, scaledx))
//			{
//				playDown = false;
//				Log.d("MenuState","Play button pressed");
//			}
//			else if(scoreDown && scoreRect.contains(scaledx, scaledY)){
//				scoreDown = false;
//				Log.d("MenuState", "Score Button pressed");
//			}
//			else{
//				Log.d("MenuState","ACTION UP but staying idle");
//				scoreDown = false;
//				playDown = false;
//			}
//		}
//		return true;
//		
//	}

}
