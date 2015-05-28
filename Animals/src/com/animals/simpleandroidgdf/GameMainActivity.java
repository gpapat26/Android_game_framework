package com.animals.simpleandroidgdf;

import com.animals.state.MainMenuState;
import com.animals.state.StartState;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;

public class GameMainActivity extends Activity{
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 450;
	public static GameView sGame;
	public static AssetManager assets;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		assets=getAssets();
		sGame= new GameView(this, GAME_WIDTH, GAME_HEIGHT);
		setContentView(sGame);	
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
	@Override
	public void onBackPressed() {
		if(sGame.currentState instanceof MainMenuState)
			{
				
				sGame.setCurrentState(new StartState());
			}
	}
	
	
	

}
