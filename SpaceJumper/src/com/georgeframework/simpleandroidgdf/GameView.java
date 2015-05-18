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

public class GameView extends SurfaceView implements Runnable{
    
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
		//we create a bitmap with our pre- defined dimentions
		gameImage = Bitmap.createBitmap(gameWidth, gameHeight, Bitmap.Config.RGB_565);
		//we create a Rect with our dimentions
		gameImageSrc = new Rect(0,0,gameImage.getWidth(),gameImage.getHeight());
		//The screen though may have its own dimentions
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
				initGame();
			}

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				Log.d("Game View", "Surface destroyed");
				pauseGame();
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
	
	private void initGame(){
		running = true;
		gameThread = new Thread(this,"Game Thread");
		gameThread.start();
	}
	
	private void pauseGame(){
		running = false;
		while(gameThread.isAlive()){
			try {
				gameThread.join();
				Log.d("Game View", "Game paused");
				break;
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		long updateDurationMillis = 0;
		long sleepDurationMillis = 0;
		
		while(running){
			long beforeUpdateRender = System.nanoTime();
			long deltaMillis = sleepDurationMillis + updateDurationMillis;
			updateAndRender(deltaMillis);
			updateDurationMillis = (System.nanoTime() - beforeUpdateRender) /1000000L;
			
			sleepDurationMillis = Math.max(2, 17 - updateDurationMillis);
			
			try{
				Thread.sleep(sleepDurationMillis);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	private void updateAndRender(long delta){
		currentState.update(delta/1000f);
		currentState.render(graphics);
		renderGameImage();
	}

	private void renderGameImage(){
		Canvas screen = getHolder().lockCanvas();
		if(screen != null){
			screen.getClipBounds(gameImageDst); // updates Dst Rectangle boundaries with the actual screen dimentions
			screen.drawBitmap(gameImage, gameImageSrc, gameImageDst, null); // scalles the size of Src to Dst
			
			getHolder().unlockCanvasAndPost(screen);
		}
	}

}
