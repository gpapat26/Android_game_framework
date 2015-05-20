package com.georgepapatheodorou.spacejumper.simpleandroidgdf;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.content.SharedPreferences.Editor;

public class GameMainActivity extends Activity{
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 450;
	public static GameView sGame;
	public static AssetManager assets;
	
	private static SharedPreferences prefs;
	private static final String highScoreKey = "highScoreKey";
	private static int highScore;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		prefs = getPreferences(Activity.MODE_PRIVATE);
		highScore = retrieveHighScore(); //Access only on start up.
		assets=getAssets();
		sGame= new GameView(this, GAME_WIDTH, GAME_HEIGHT);
		setContentView(sGame);	
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}


	public static void setHighScore(int highScore){
		GameMainActivity.highScore = highScore; //1 update in memory
		
		Editor editor =prefs.edit(); //2 update in hard disk
		editor.putInt(highScoreKey, highScore);
		editor.commit();
	}
	
	private int retrieveHighScore(){
		return  prefs.getInt(highScoreKey,0);
	}
	
	public static int getHighScore(){
		return highScore;
	}
	
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
	
	
	
	

}
