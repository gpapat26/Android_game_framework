package com.georgepapatheodorou.spacejumper.simpleandroidgdf;

import android.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.content.SharedPreferences.Editor;

import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;


public class GameMainActivity extends BaseGameActivity{
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 450;
	public static GameView sGame;
	public static AssetManager assets;
	
	private static SharedPreferences prefs;
	private static final String highScoreKey = "highScoreKey";
	private static int highScore;
	
	//private static final String LEADERBOARD_ID = "CgkIvKPCpKwREAIQAQ"; //Test LeaderBoard
	private static final String LEADERBOARD_ID = "CgkIkt6rpcgPEAIQAA"; //production LeaderBoard
	
	public static GameMainActivity instance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		instance = this;
		prefs = getPreferences(Activity.MODE_PRIVATE);
		highScore = retrieveHighScore(); //Access only on start up.
		assets=getAssets();
		sGame= new GameView(this, GAME_WIDTH, GAME_HEIGHT);
		setContentView(sGame);	
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	
	}


//	public static void setHighScore(int highScore){
//		GameMainActivity.highScore = highScore; //1 update in memory
//		
//		Editor editor =prefs.edit(); //2 update in hard disk
//		editor.putInt(highScoreKey, highScore);
//		editor.commit();
//	}
	
//	private int retrieveHighScore(){
//		return  prefs.getInt(highScoreKey,0);
//	}
//	
//	public static int getHighScore(){
//		return highScore;
//	}
	
	@Override
	protected void onResume(){
		super.onResume();
		if(sGame != null){
			Assets.onResume();
			sGame.onResume();
		}
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		if(sGame != null){
			Assets.onPause();
			sGame.onPause();
		}
	}


	public static void setHighScore(int highScore) {
		GameMainActivity.highScore = highScore;
		Editor editor = prefs.edit();
		editor.putInt(highScoreKey, highScore);
		editor.commit();

		if (isSignedIntoGoogle()) {
			Games.Leaderboards.submitScore(instance.getApiClient(),LEADERBOARD_ID, highScore);
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
