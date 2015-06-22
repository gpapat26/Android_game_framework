package com.animals.state;

import android.provider.Contacts.Intents.UI;
import android.util.Log;
import android.view.MotionEvent;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.UIButton;




public class StartState extends State {

	
	private UIButton playButton ;
	private UIButton languageButton;
	private UIButton scoreButton, googleButton;
	
	
	public  StartState() {		
		init();
	}
	
	@Override
	public void init() {
		playButton = new UIButton(316, 227, 484, 286, Assets.start, Assets.startDown);
		languageButton = new UIButton(170, 10, 320, 54, Assets.language, Assets.language_down);
		scoreButton = new UIButton(316,300,484,359,Assets.score,Assets.scoreDown);
		googleButton = new UIButton(10, 10, 160, 54, Assets.signIn, Assets.signInDown);
		
		Assets.loadGalleryImage("welcome_screen");
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
		languageButton.render(g);
		
		if (GameMainActivity.isSignedIntoGoogle()) {
			scoreButton.render(g, Assets.score2, Assets.scoreDown2);
			googleButton.render(g, Assets.signOut, Assets.signOutDown);
		} else {
			scoreButton.render(g);
			googleButton.render(g);
		}
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {

		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			playButton.onTouchDown(scaledX, scaledY);
			languageButton.onTouchDown(scaledX, scaledY);
			scoreButton.onTouchDown(scaledX, scaledY);
			googleButton.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			if (playButton.isPressed(scaledX, scaledY)) {
				playButton.cancel();				
				setCurrentState(new MainMenuState());
					
			
			} else if (scoreButton.isPressed(scaledX, scaledY)) {
				scoreButton.cancel();
				if (GameMainActivity.isSignedIntoGoogle()) {
					GameMainActivity.showLeaderboard();
				} else {
					setCurrentState(new Score());
				}
			} else if (googleButton.isPressed(scaledX, scaledY)) {
				googleButton.cancel();
				GameMainActivity.onGoogleButtonPress();
				
			}
			
			else {
				playButton.cancel();
			}
			
			if (languageButton.isPressed(scaledX, scaledY)) {
				languageButton.cancel();
				
				setCurrentState(new LanguageState());
					
			} else {
				languageButton.cancel();
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
