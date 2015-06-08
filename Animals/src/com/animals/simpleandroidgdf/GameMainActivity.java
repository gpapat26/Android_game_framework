package com.animals.simpleandroidgdf;

import com.animals.state.CarouzelState;
import com.animals.state.LanguageState;
import com.animals.state.MainMenuState;
import com.animals.state.StartState;
import com.animals.state.State;





import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class GameMainActivity extends Activity{
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 450;
	public static GameView sGame;
	public static AssetManager assets;
	private Boolean exit = false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		assets=getAssets();
		Log.d("Activity", "Activity is onCreate status");
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
		else if(sGame.currentState instanceof CarouzelState){
			Assets.loadGalleryImage("crab");
			sGame.setCurrentState(new MainMenuState());
		}
		else if(sGame.currentState instanceof LanguageState){
			
			sGame.setCurrentState(new StartState());
		}
		else if(sGame.currentState instanceof StartState){
			
			if (exit) {
	            finish(); // finish activity          
	            return;
	        } else {
	            Toast.makeText(this, R.string.exit,
	                    Toast.LENGTH_SHORT).show();
	            exit = true;
	            new Handler().postDelayed(new Runnable() {
	                @Override
	                public void run() {
	                    exit = false;
	                }
	            }, 3 * 1000);

	        }
			
		}
	}
	
	@TargetApi(Build.VERSION_CODES.KITKAT)
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
	        super.onWindowFocusChanged(hasFocus);
	    if (hasFocus) {
	    	getWindow().getDecorView().setSystemUiVisibility(
	                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
	                | View.SYSTEM_UI_FLAG_FULLSCREEN
	                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
	}
	
	@Override
	protected void onResume(){
		Log.d("Activity", "OnResume be4 Super is called");
		super.onResume();
		if(sGame != null){
			Log.d("Activity", "OnResume is called");		
			sGame.onResume();
		}
	}
	
	@Override
	protected void onPause(){
		
		super.onPause();
		if(sGame != null){			
			sGame.onPause();
		}
	}
	
	
	
	
	

}
