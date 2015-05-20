package com.jamescho.ellio;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;

public class GameMainActivity extends BaseGameActivity {

	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 450;
	public static GameView sGame;
	public static AssetManager assets;

	private static SharedPreferences prefs;
	private static final String highScoreKey = "highScoreKey";	
	private static int highScore;

	public static GameMainActivity instance;

	// Google Play Games
	// INSERT YOUR OWN LEADERBOARD_ID HERE! OTHER WISE IT WILL NOT WORK!
	private static final String LEADERBOARD_ID = "THIS_VALUE_NEEDS_TO_BE_CHANGED";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		prefs = getPreferences(Activity.MODE_PRIVATE);
		highScore = retrieveHighScore();
		assets = getAssets();
		sGame = new GameView(this, GAME_WIDTH, GAME_HEIGHT);
		setContentView(sGame);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Assets.onResume();
		// Assets.playMusic("music.mp3", true);
		if (sGame.getCurrentState() != null) {
			sGame.getCurrentState().onResume();
		}
	}

	@Override
	protected void onPause() {
		Assets.onPause();
		super.onPause();
		if (sGame.getCurrentState() != null) {
			sGame.getCurrentState().onPause();
		}
	}

	public static void setHighScore(int highScore) {
		GameMainActivity.highScore = highScore;
		Editor editor = prefs.edit();
		editor.putInt(highScoreKey, highScore);
		editor.commit();

		if (isSignedIntoGoogle()) {
			Games.Leaderboards.submitScore(instance.getApiClient(),
					LEADERBOARD_ID, highScore);
		}
	}

	private int retrieveHighScore() {
		return prefs.getInt(highScoreKey, 0);
	}

	public static int getHighScore() {
		return highScore;
	}

	// Google Play Games Methods

	// Can optionally implement some kind of action when sign in fails.
	@Override
	public void onSignInFailed() {
	}

	// When Sign In is successful, we submit the current local high score to the server
	@Override
	public void onSignInSucceeded() {
		Games.Leaderboards.submitScore(instance.getApiClient(), LEADERBOARD_ID,
				highScore);
	}

	// Static Methods for Other Game Classes to Access
	
	// This allows us to determine from other classes whether the user is
	// currently signed in.
	public static boolean isSignedIntoGoogle() {
		return instance.isSignedIn();
	}

	// This method will open a new Activity (ON TOP of GameMainActivity)
	// That shows the global leaderboard.
	public static void showLeaderboard() {
		instance.startActivityForResult(Games.Leaderboards
				.getLeaderboardIntent(instance.getApiClient(), LEADERBOARD_ID),
				0);
	}
	
	// This method is called when the Google Sign In/Sign Out Button is pressed.
	public static void onGoogleButtonPress() {
		if (isSignedIntoGoogle()) {
			instance.signOut();
		} else {
			instance.beginUserInitiatedSignIn();
		}
	}

}
