package com.animals.state;

import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.UIButton;



public class StartState extends State {

	
	private UIButton playButton ;
	
	public  StartState() {		
		init();
	}
	
	@Override
	public void init() {
		playButton = new UIButton(316, 227, 484, 286, Assets.start, Assets.startDown);
		Assets.loadGalleryImage("welcome screen");
		Assets.onResume();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);
		playButton.render(g);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {

		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			playButton.onTouchDown(scaledX, scaledY);
		
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			if (playButton.isPressed(scaledX, scaledY)) {
				playButton.cancel();
				
				setCurrentState(new MainMenuState());
					
			} else {
				playButton.cancel();
			}
		}

		return true;
	}

	@Override
	public void onResume() {
		Log.d("StartState", "OnResume is called");
		Assets.onResume();		
	}

	@Override
	public void onPause() {
		Log.d("StartState", "OnPause is called");
		Assets.onPause();		
	}

}
