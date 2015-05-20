package com.jamescho.game.state;

import android.view.MotionEvent;

import com.jamescho.ellio.Assets;
import com.jamescho.ellio.GameMainActivity;
import com.jamescho.framework.util.Painter;
import com.jamescho.framework.util.UIButton;

public class MenuState extends State {

	private UIButton playButton, scoreButton, googleButton;

	@Override
	public void init() {
		playButton = new UIButton(316, 227, 484, 286, Assets.start,
				Assets.startDown);
		scoreButton = new UIButton(316, 300, 484, 359, Assets.score,
				Assets.scoreDown);
		googleButton = new UIButton(10, 10, 160, 54, Assets.signIn, Assets.signInDown);
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.welcome, 0, 0);
		playButton.render(g);

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
			scoreButton.onTouchDown(scaledX, scaledY);
			googleButton.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			if (playButton.isPressed(scaledX, scaledY)) {
				playButton.cancel();
				setCurrentState(new PlayState());
			} else if (scoreButton.isPressed(scaledX, scaledY)) {
				scoreButton.cancel();
				if (GameMainActivity.isSignedIntoGoogle()) {
					GameMainActivity.showLeaderboard();
				} else {
					setCurrentState(new ScoreState());
				}
			} else if (googleButton.isPressed(scaledX, scaledY)) {
				googleButton.cancel();
				GameMainActivity.onGoogleButtonPress();
			} else {
				playButton.cancel();
				scoreButton.cancel();
				googleButton.cancel();
			}
		}

		return true;
	}

}
