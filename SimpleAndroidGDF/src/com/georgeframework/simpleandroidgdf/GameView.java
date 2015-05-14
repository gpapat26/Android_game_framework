package com.georgeframework.simpleandroidgdf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.georgeframework.state.*;
import com.georgegramework.util.InputHandler;
import com.georgegramework.util.Painter;

public class GameView extends SurfaceView{
    
	private Bitmap gameImage;
	private Rect gameImageSrc;
	private Rect gameImageDst;
	private Canvas gameCanvas;
	private Painter graphics;
	
	private Thread gameThread;
	private  volatile boolean running = false;
	private volatile State currentState;
	private InputHandler inputHandler;
	
	
	
	public GameView(Context context , int gameWidth,int gameHeight) {
		super(context);
		
		gameImage = Bitmap.createBitmap(gameWidth, gameHeight, Bitmap.Config.RGB_565);
		
		gameImageSrc = new Rect(0,0,gameImage.getWidth(),gameImage.getHeight());
		
		gameImageDst = new Rect();
		
		gameCanvas = new Canvas(gameImage);
		
		graphics = new Painter(gameCanvas);
		
		SurfaceHolder holder = getHolder();
		holder.addCallback(new Callback(){

			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				//Log.d("Game View", "Surface Created");
				initInput();
				if(currentState == null){
					setCurrentState(new LoadState());
				}
			}

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				Log.d("Game View", "Surface destroyed");
				
			}
			
		});
		
	}
	
	public GameView(Context context) {
		super(context);
		
	}

	public void setCurrentState(State newState) {		
		System.gc();
		newState.init();
		currentState = newState;
		inputHandler.setCurrentState(currentState);
	}
	
	private void initInput(){
		if(inputHandler == null){
			inputHandler = new InputHandler();
		}
		setOnTouchListener(inputHandler);
	}

}
